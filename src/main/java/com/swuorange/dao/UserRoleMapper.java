package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.UserRole;

@Mapper
public interface UserRoleMapper {
	
	//根据用户id查询角色id用于便利查询判断
	UserRole queryRoleIdByUserId(UserRole userRole);
}
