package com.tt.springboottest.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tt.springboottest.ui.domain.SysUser;
import com.tt.springboottest.ui.service.sysuserservice.SysUserService;

@Component
public class TestUtils {

	private static SysUserService sysUserServiceImpl;

	@Autowired
	public TestUtils(SysUserService sysUserServiceImpl) {
		this.sysUserServiceImpl = sysUserServiceImpl;
	}

	public static void test() {
		List<SysUser> selectAll = sysUserServiceImpl.selectAll();
		System.out.println(selectAll);
	}
}
