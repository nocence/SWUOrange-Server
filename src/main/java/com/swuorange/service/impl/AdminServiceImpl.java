package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.AdminMapper;
import com.swuorange.po.Admin;
import com.swuorange.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	public AdminMapper adminMapper;
	/**
	 * 根据用户名查询管理员
	 */
	@Override
	public Admin queryAdminByName(Admin admin) {
		
		return adminMapper.queryAdminByName(admin);
	}
	/**
	 * 新增管理员
	 */
	@Override
	public void addAdmin(Admin admin) {
		adminMapper.addAdmin(admin);
	}
	/**
	 * 根据真实姓名查询管理员
	 */
	@Override
	public Admin queryAdminByRealName(Admin admin) {
		return adminMapper.queryAdminByRealName(admin);
	}
	/**
	 * 查询所有管理员
	 */
	@Override
	public List<Admin> showAllAdmins() {
		return adminMapper.showAllAdmins();
	}
	/**
	 * 根据真实姓名修改管理员部分信息
	 * @return 
	 */
	@Override
	public Integer updateAdminByRealName(Admin admin) {
		return adminMapper.updateAdminByRealName(admin);
	}
	/**
	 * 根据真实姓名删除管理员信息
	 */
	@Override
	public void deleteByRealName(Admin admin) {
		adminMapper.deleteByRealName(admin);
	}

}
