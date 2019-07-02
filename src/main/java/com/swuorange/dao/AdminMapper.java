package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.Admin;

@Mapper
public interface AdminMapper {
	Admin queryAdminByName(Admin admin);
	
	void addAdmin(Admin admin);
	
	Admin queryAdminByRealName(Admin admin);
	
	List<Admin> showAllAdmins();
	
	Integer updateAdminByRealName(Admin admin);
	
	void deleteByRealName(Admin admin);
	
	
}
