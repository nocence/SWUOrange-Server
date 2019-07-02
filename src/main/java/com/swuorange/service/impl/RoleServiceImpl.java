package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.RoleMapper;
import com.swuorange.po.Role;
import com.swuorange.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	
	@Autowired
	private RoleMapper roleMapper;
	
	@Override
	public List<Role> getRoles() {
		return roleMapper.getRoles();
	}

}
