package com.swuorange.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.swuorange.dto.BaseDTOsmall;
import com.swuorange.dto.Staff;
import com.swuorange.dto.SubbaseListDTO;
import com.swuorange.po.Subbase;

public interface SubbaseService {
	
	public List<SubbaseListDTO> querySubbases(Integer companyinfoId);
	
	public List<Staff> queryStaffName(Integer companyinfoId);
	
	public List<BaseDTOsmall> queryBaseName(Integer companyinfoId);
	
	public List<Subbase> querySubbasesBlur(String subbaseName,Integer companyinfoId);
	
	public int queryStaffId(String staffName);
	
	public Subbase querySubbaseId(String subbaseName,String subbaseAddress);
	
	public int queryUserId(String productionRecorder);
	
	public int querySssUserId(Integer subbaseId);
	
}
