package com.swuorange.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.SubbaseMapper;
import com.swuorange.dto.BaseDTOsmall;
import com.swuorange.dto.Staff;
import com.swuorange.dto.SubbaseListDTO;
import com.swuorange.po.Subbase;
import com.swuorange.service.SubbaseService;


@Service
@Transactional
public class SubbaseServiceImpl implements SubbaseService{
	
	@Autowired
	private SubbaseMapper subbaseMapper;

	@Override
	public List<SubbaseListDTO> querySubbases(Integer companyinfoId) {
		return subbaseMapper.querySubbases(companyinfoId);
		
	}

	@Override
	public List<Staff> queryStaffName(Integer companyinfoId) {
		return subbaseMapper.queryStaffName(companyinfoId);
	}

	@Override
	public List<BaseDTOsmall> queryBaseName(Integer companyinfoId) {
		return subbaseMapper.queryBaseName(companyinfoId);
	}
	
	@Override
	public List<Subbase> querySubbasesBlur(String subbaseName, Integer companyinfoId) {
		return subbaseMapper.querySubbasesBlur(subbaseName, companyinfoId);
	}

	@Override
	public int queryStaffId(String staffName) {
		return subbaseMapper.queryStaffId(staffName);
	}

	@Override
	public Subbase querySubbaseId(String subbaseName,String subbaseAddress) {
		return subbaseMapper.querySubbaseId(subbaseName, subbaseAddress);
	}

	@Override
	public int queryUserId(String productionRecorder) {
		return subbaseMapper.queryUserId(productionRecorder);
	}

	@Override
	public int querySssUserId(Integer subbaseId) {
		return subbaseMapper.querySssUserId(subbaseId);
	}

	

}
