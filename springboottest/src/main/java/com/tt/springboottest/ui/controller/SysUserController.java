package com.tt.springboottest.ui.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tt.springboottest.ui.domain.SysRole;
import com.tt.springboottest.ui.domain.SysUser;
import com.tt.springboottest.ui.service.sysuserservice.SysUserService;
import com.tt.springboottest.util.RedisUtils;

@Controller
@RequestMapping("/sysuser")
public class SysUserController {
	// reedids中的公共key
	private static final String SYSUSER_KEY = "SYSUSER_KEY";
	@Autowired
	private SysUserService sysUserServiceImpl;
	@Autowired
	private RedisUtils redisUtils;

	@RequestMapping(method = RequestMethod.GET, value = "/selectRoleByUserId")
	@ResponseBody
	public List<SysRole> selectRoleByUserId(long id) {
		List<SysRole> roleList = sysUserServiceImpl.selectRoleByUserId(id);
		System.out.println("nginx:8083");
		return roleList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/addUser")
	@ResponseBody
	public String saveUser(SysUser sysUser) {
		sysUserServiceImpl.saveUser(sysUser);
		return "添加童虎成功";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectOneById")
	@ResponseBody
	public SysUser selectOneById(long id, HttpServletRequest request, HttpServletResponse response) {
		String string = redisUtils.get(SYSUSER_KEY + id);
		SysUser sysUser = null;
		if (!StringUtils.isEmpty(string)) {
			sysUser = JSON.parseObject(string, SysUser.class);
			System.out.println("从redis中获取");
		} else {
			sysUser = sysUserServiceImpl.selectOneById(id);
			redisUtils.set(SYSUSER_KEY + id, JSON.toJSONString(sysUser));
		}

		return sysUser;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/selectAll")
	@ResponseBody
	public PageInfo<SysUser> selectAll(HttpServletRequest request, HttpServletResponse response) {
		PageHelper.startPage(1, 10);
		PageInfo<SysUser> pageInfo = new PageInfo<>(sysUserServiceImpl.selectAll());
		return pageInfo;
	}

//更新
	@RequestMapping(method = RequestMethod.GET, value = "/updateuser")
	@ResponseBody
	@Transactional
	public int updateUser(long id) {
		SysUser sysUser = selectOneById(id, null, null);
		sysUser.setUserName(null);
		sysUser.setCreateTime(null);
		sysUser.setHeadimg(null);
		sysUser.setUserEmail(null);
		sysUser.setUserInfo(null);
		sysUser.setUserPassword(null);

		int num = sysUserServiceImpl.updateSysUser(sysUser);
		return num;
	}

	// 条件查询
	@RequestMapping(method = RequestMethod.GET, value = "/selectByUserNameOrPassword")
	@ResponseBody
	@Transactional
	public int selectByUserNameOrPassword(@RequestParam(required = false) String userName,
			@RequestParam(required = false) String userPassword) {
		int roleNum = sysUserServiceImpl.selectByUserNameOrPassword(userName, userPassword);

		return roleNum;
	}

	// 条件查询
	@RequestMapping(method = RequestMethod.GET, value = "/selectByUserNameOrPassword2")
	@ResponseBody
	@Transactional
	public int selectByUserNameOrPassword2(@RequestParam(required = false) String userName,
			@RequestParam(required = false) String userPassword, @RequestParam(required = false) String userEmail) {
		int roleNum = sysUserServiceImpl.selectByUserNameOrPassword2(userName, userPassword, userEmail);

		return roleNum;
	}

	//
	@RequestMapping(method = RequestMethod.GET, value = "/selectUserRolePrivilege")
	@ResponseBody
	@Transactional
	public SysUser selectUserRolePrivilege(long id) {
		SysUser sysUser = sysUserServiceImpl.selectUserRolePrivilege(id);

		return sysUser;
	}
}
