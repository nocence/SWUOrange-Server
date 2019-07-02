package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.Role;

@Mapper
public interface RoleMapper {
	
	public List<Role> getRoles();
	
}
