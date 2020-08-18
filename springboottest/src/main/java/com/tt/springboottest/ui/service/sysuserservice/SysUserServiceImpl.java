package com.tt.springboottest.ui.service.sysuserservice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tt.springboottest.ui.dao.SysUserRepository;
import com.tt.springboottest.ui.dao.SysUserRoleRepository;
import com.tt.springboottest.ui.domain.SysRole;
import com.tt.springboottest.ui.domain.SysUser;
import com.tt.springboottest.ui.service.testservice.TestService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private SysUserRoleRepository sysUserRoleRepository;
	@Autowired
	private TestService testServiceImpl;

	@Override
	public List<SysRole> selectRoleByUserId(long id) {
		List<SysRole> roleList = sysUserRepository.selectRoleByUserId(id);
		return roleList;
	}

	@Override
	public int addUser(SysUser user) {
		int sysUser = sysUserRepository.addUser(user);
		return sysUser;
	}

	@Override
	public SysUser selectOneById(long id) {
		SysUser sysUser = sysUserRepository.selectOneById(id);
		return sysUser;
	}

	@Override
	public int updateSysUser(SysUser sysUser) {
		int num = sysUserRepository.updateSysUser(sysUser);
		return num;
	}

	@Override
	public int delUser(long id) {
		int num = sysUserRepository.deleUser(id);
		return num;
	}

	@Override
	public int selectByUserNameOrPassword(String userName, String userPassword) {
		int num = sysUserRepository.selectByUserNameOrPassword(userName, userPassword);
		return num;
	}

	@Override
	public int selectByUserNameOrPassword2(String userName, String userPassword, String userEmail) {
		int num = sysUserRepository.selectByUserNameOrPassword2(userName, userPassword, userEmail);
		return num;
	}

	@Override
	public SysUser selectUserRolePrivilege(long id) {

		SysUser sysUser = sysUserRepository.selectUserRolePrivilege(id);
		return sysUser;
	}

	@Override
	public List<SysUser> selectPageHelper(int pageNum, int pageSize) {
		int finallyPageNum = 0;
		if (pageNum == 0) {
			finallyPageNum = pageNum;
		} else {
			finallyPageNum = pageNum * pageSize;
		}

		List<SysUser> sysUserList = sysUserRepository.selectPageHelper(finallyPageNum, pageSize);

		return sysUserList;
	}

	@Override
	public int selectcount() {

		return sysUserRepository.selectcount();
	}

	@Override
	public List<SysUser> selectAll() {
		String test = testServiceImpl.Test();
		System.out.println(test);
		return sysUserRepository.selectAll();
	}

	@Override
	public List<SysUser> selectUserByTiaoJian(SysUser user) {
		List<SysUser> sysuserList = sysUserRepository.selectUserByTiaoJian(user);
		return sysuserList;
	}

	@Override
	public List<SysUser> selectUserByTiaoJian(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SysUser selectByUserName(String userName) {
		// TODO Auto-generated method stub
		return sysUserRepository.findByUserName(userName);
	}

	@Override
	public void saveUser(SysUser sysUser) {
		sysUserRepository.addUser(sysUser);

	}

}
