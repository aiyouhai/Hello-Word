package com.tt.springboottest.ui.controller;

import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tt.springboottest.ui.domain.SysUser;
import com.tt.springboottest.ui.service.sysuserservice.SysUserService;

@Controller
@RequestMapping("/index")
//@Scope(value = "prototype")
public class LoginController {
	private static final Log logger = LogFactory.getLog(LoginController.class);

	private static HashMap<String, Integer> map = new HashMap<String, Integer>();
	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(value = "/login")
	@ResponseBody
	public String login(String username, String password, String verifyCode, HttpServletResponse response,
			HttpSession session, HttpServletRequest request, Model model) {
		System.out.println(username + ":" + password);
		String ip = request.getRemoteHost();
		if (username == null || password == null) {
			return "用户名或密码为空";
		}
		SysUser sysUser = sysUserService.selectByUserName(username);
		if (sysUser.getIsLocked().equals("1")) {
			return "该用户已被禁用";
		}
		/*
		 * JSONObject json = (JSONObject)
		 * request.getSession().getAttribute("verifyCode"); if
		 * (!json.getString("verifyCode").toUpperCase().equals(verifyCode.toUpperCase())
		 * ) { return "验证码错误"; } if ((System.currentTimeMillis() -
		 * json.getLong("createTime")) > 1000 * 60 * 5) { return "验证码过期"; }
		 */
		// 3.获取一个用户识别信息
		Subject currentUser = SecurityUtils.getSubject();
		System.out.println(currentUser);
		// .判断是否已经身份验证
		System.out.println(currentUser.isAuthenticated());
		try {
			if (!currentUser.isAuthenticated()) {
				// 4.1把用户名和密码封装为 UsernamePasswordToken 对象
				UsernamePasswordToken token = new UsernamePasswordToken(username, password);
				// 4.2设置rememberme
				token.setRememberMe(true);

				if (map.get(ip) != null && map.get(ip) >= 3) {
					sysUser = sysUserService.selectByUserName(username);
					sysUser.setIsLocked("1");
					sysUser.setLockedTime(new Date());
					sysUserService.updateSysUser(sysUser);
					throw new DisabledAccountException("由于密码输入错误次数大于3次，帐号已经禁止登录！");
				}
				// 4.3登录.
				currentUser.login(token);
				map.clear();

			}

		} catch (UnknownAccountException e) {
			throw new AuthorizationException("用户名错误");
		} catch (IncorrectCredentialsException e) {
			if (map.get(ip) == null) {
				map.put(ip, 1);
			} else {
				Integer integer = map.get(ip);
				map.put(ip, ++integer);
			}
			throw new AuthorizationException("密码错误");
		} catch (ShiroException e) {
			return e.getMessage();
		}
		return "登录成功";
	}

	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		// 退出
		subject.logout();
		System.out.println("退出成功");
		return "redirect:/index/login";
	}

	@RequiresRoles(value = { "ROLE_ADMIN" })
	@RequestMapping("/register")
	public String register() {
		/*
		 * Subject currentUser = SecurityUtils.getSubject(); if
		 * (currentUser.hasRole("ROLE_ADMIN")) { return "register"; } else { throw new
		 * AuthorizationException("没有权限"); }
		 */
		return "register";
	}

}
