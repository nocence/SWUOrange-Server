package com.swuorange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.UserRoleMapper;
import com.swuorange.po.UserRole;
import com.swuorange.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService{
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public UserRole queryRoleIdByUserId(UserRole userRole) {
		
		return userRoleMapper.queryRoleIdByUserId(userRole);
	}

}
