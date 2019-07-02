package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Staff;
import com.swuorange.util.PagerHelper;


@Mapper
public interface StaffMapper {
	List<Staff> queryStaffByCompanyinfoId(Staff staff);
	int countStaff(Staff staff);
	
	
	int updateStaff(Staff staff);
	int delStaff(Staff staff);
	Staff queryStaff(Staff staff);
	
	Staff queryStaffByName(Staff staff);
	//根据前端的条件和分页的条件查询满足条件
	public List<Staff> queryStaffsBy(PagerHelper pageHelper);
	int delStaffsById(List list);
}
