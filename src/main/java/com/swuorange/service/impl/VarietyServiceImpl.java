package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.VarietyMapper;
import com.swuorange.dto.VarietyDTO;
import com.swuorange.service.VarietyService;



@Service
public class VarietyServiceImpl implements VarietyService{

	@Autowired
	public VarietyMapper varietyMapper;
	
	@Override
	public List<VarietyDTO> query() {
		
		return varietyMapper.query();
	}

}
