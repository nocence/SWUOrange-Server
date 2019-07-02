package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swuorange.dao.StaffMapper;
import com.swuorange.dao.UserMapper;
import com.swuorange.dao.UserModelMapper;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.RegUser;
import com.swuorange.dto.Staff;
import com.swuorange.dto.UserDTO;
import com.swuorange.po.User;
import com.swuorange.service.StaffService;
import com.swuorange.service.UserService;
import com.swuorange.util.PagerHelper;

@Service
public class StaffServiceImpl implements StaffService{

	
	
	@Autowired
	public StaffMapper staffMapper;
	


	@Override
	public int updateStaff(Staff staff) {
		
		return staffMapper.updateStaff(staff);
	}

	
	@Override
	public Staff queryStaff(Staff staff) {
		
		return staffMapper.queryStaff(staff);
	}
	
	@Override
	public Staff queryStaffByName(Staff staff) {
		
		return staffMapper.queryStaffByName(staff);
	}


	@Override
	public Integer delStaff(Staff staff) {
		
		return staffMapper.delStaff(staff);
	}



	
	
	 @Override 
	 public List<Staff> findAllStaffs(Staff staff) {
		
	     return staffMapper.queryStaffByCompanyinfoId(staff);
		 
	}


	@Override
	public Integer countStaff(Staff staff) {
		return staffMapper.countStaff(staff);
	}
	 
	@Override
	public List<Staff> queryStaffList(PagerHelper pageHelper) {
		//根据前端的页面传回来的条件查询所需要的数据
		return staffMapper.queryStaffsBy(pageHelper);
	}


	@Override
	public Integer delStaffsById(List list) {
		// TODO Auto-generated method stub
		return staffMapper.delStaffsById(list);
	}	
	
	

}
