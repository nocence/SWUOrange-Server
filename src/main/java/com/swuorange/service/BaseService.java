package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Staff;

public interface BaseService {

	List<BaseDTO> queryBaseList(BaseSearchDTO search, PageBean<BaseDTO> page);
	
	List<Staff> getStaffsByLike(Staff staff);
}
