package com.tt.springboottest.ui.service.sysuserservice;

import java.util.List;
import java.util.Map;

import com.tt.springboottest.ui.domain.SysRole;
import com.tt.springboottest.ui.domain.SysUser;

public interface SysUserService {

	List<SysRole> selectRoleByUserId(long id);

	int addUser(SysUser user);

	SysUser selectOneById(long id);

	int updateSysUser(SysUser sysUser);

	int delUser(long id);

	int selectByUserNameOrPassword(String userName, String userPassword);

	int selectByUserNameOrPassword2(String userName, String userPassword, String userEmail);

	SysUser selectUserRolePrivilege(long id);

	List<SysUser> selectPageHelper(int pageNum, int pageSize);

	int selectcount();

	List<SysUser> selectAll();

	List<SysUser> selectUserByTiaoJian(Map<String, Object> params);

	List<SysUser> selectUserByTiaoJian(SysUser user);

	SysUser selectByUserName(String userName);

	void saveUser(SysUser sysUser);
}
