package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.ProductDTO;
import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;

public interface TraceService {
	
	public List<TraceDTO> queryTraces(Integer companyinfoId);
	
	public String querySearchName(String account);
	
	public Integer queryVarietyId(String variety);
	
	public Integer querySubbaseId(String subbaseName);
	
	public Integer queryUserId(String account);
	
	public String queryLastCode();
	
	public List<TraceDTO> queryTraceBlur(String bacthId);
	
	public ProductDTO queryProductMsg(String traceSource);
	
	public List<TraceCheckDTO> queryTraceCheck();

}
