package com.swuorange.service;

import java.util.List;

import com.swuorange.po.Admin;

public interface AdminService {
	
	Admin queryAdminByName(Admin admin);
	
	void addAdmin(Admin admin);
	
	Admin queryAdminByRealName(Admin admin);
	
	List<Admin> showAllAdmins();
	
	Integer updateAdminByRealName(Admin admin);
	
	void deleteByRealName(Admin admin);
}
