package com.swuorange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.RMMapper;
import com.swuorange.dto.RM;
import com.swuorange.service.RMService;


@Service
@Transactional
public class RMServiceImpl implements RMService {

	
	@Autowired
	private RMMapper rmMapper;
	@Override
	public int emptyRM() {
		return rmMapper.emptyRM();
	}

	@Override
	public int insertRM(RM rm) {
		return rmMapper.insertRM(rm);
	}

	
		
}
