package com.tt.springboottest.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.tt.springboottest.ui.dao.SysUserRepository;
import com.tt.springboottest.ui.domain.SysRole;
import com.tt.springboottest.ui.domain.SysUser;

public class MyShiroRealm extends AuthorizingRealm {
	@Autowired
	private SysUserRepository sysUserRepository;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// 能进入这里说明用户已经通过验证了
		String username = (String) principals.getPrimaryPrincipal();
		SysUser user = sysUserRepository.findByUserName(username);
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		// 获得用户拥有哪些角色
		for (SysRole role : user.getSysRoleList()) {
			simpleAuthorizationInfo.addRole(role.getRoleName());
			/*
			 * 获得角色拥有哪些行为 for (SysPrivilege permission : role.getSysPrivilegeList()) {
			 * simpleAuthorizationInfo.addStringPermission(permission.getPrivilegeName()); }
			 */
		}
		return simpleAuthorizationInfo;
	}

//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// 获取用户输入的账户
		String username = (String) token.getPrincipal();
		// 加这一步的目的是在Post请求的时候会先进认证，然后在到请求
		if (username == null) {
			return null;
		}
		System.out.println(token.getPrincipal());
		// 通过username从数据库中查找 UserInfo 对象
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		SysUser user = sysUserRepository.findByUserName(username);
		if (null == user) {
			return null;
		}
		System.out.println("IsLocked" + user.getIsLocked());
		if (user.getIsLocked().equals("1")) {
			throw new LockedAccountException(username + "账户已被禁用");
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, // 用户名
				user.getUserPassword(), // 密码
				ByteSource.Util.bytes(user.getUserName()), // 密码加入盐值
				this.getName() // realm name
		);
		return simpleAuthenticationInfo;
	}

	/**
	 * 密码重试次数限制 如在 1 个小时内密码最多重试 5 次，如果尝试次数超过 5 次就锁定 1 小时， 1 小时后可再次重试，如果还是重试失败，可以锁定如
	 * 1 天，以此类推，防止密码被暴力破解。 我们通过继承 HashedCredentialsMatcher，且使用 Ehcache 记录重试次数和超时时间
	 * 
	 * @param token
	 * @param info
	 * @return
	 */

}
