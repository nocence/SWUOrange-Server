package com.swuorange.service;

import java.util.List;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Staff;
import com.swuorange.util.PagerHelper;



public interface StaffService {
	
	
	public List<Staff> findAllStaffs(Staff staff);
	Integer countStaff(Staff staff);
	public int updateStaff(Staff staff);	
	List<Staff> queryStaffList(PagerHelper pageHelper);	
	Staff queryStaff(Staff staff);
	Staff queryStaffByName(Staff staff);
	public Integer delStaff(Staff staff);
	
	Integer delStaffsById(List list);
	
}
