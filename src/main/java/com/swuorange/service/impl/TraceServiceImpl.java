package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.TraceMapper;
import com.swuorange.dto.ProductDTO;
import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;
import com.swuorange.service.TraceService;


@Service
@Transactional
public class TraceServiceImpl implements TraceService{
	
	@Autowired
	private TraceMapper traceMapper;

	@Override
	public List<TraceDTO> queryTraces(Integer companyinfoId) {
		return traceMapper.queryTraces(companyinfoId);
	}

	@Override
	public String querySearchName(String account) {
		return traceMapper.querySearchName(account);
	}

	@Override
	public Integer queryVarietyId(String variety) {
		return traceMapper.queryVarietyId(variety);
	}

	@Override
	public Integer querySubbaseId(String subbaseName) {
		return traceMapper.querySubbaseId(subbaseName);
	}

	@Override
	public Integer queryUserId(String account) {
		return traceMapper.queryUserId(account);
	}

	@Override
	public String queryLastCode() {
		return traceMapper.queryLastCode();
	}

	@Override
	public List<TraceDTO> queryTraceBlur(String bacthId) {
		return traceMapper.queryTraceBlur(bacthId);
	}

	@Override
	public ProductDTO queryProductMsg(String traceSource) {
		return traceMapper.queryProductMsg(traceSource);
	}

	@Override
	public List<TraceCheckDTO> queryTraceCheck() {
		return traceMapper.queryTraceCheck();
	}

}
