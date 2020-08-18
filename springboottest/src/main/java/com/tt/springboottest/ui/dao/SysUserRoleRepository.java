package com.tt.springboottest.ui.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SysUserRoleRepository {

	int addUser_Role(@Param("id") long id, @Param("sysRoleId") long sysRoleId);

	int deleRoleByUserId(long id);

	int selectByUserNameOrPassword(@Param("userName") String userName, @Param("userPassword") String userPassword);

}
