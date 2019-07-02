package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.ProductDTO;
import com.swuorange.dto.TraceCheckDTO;
import com.swuorange.dto.TraceDTO;

@Mapper
public interface TraceMapper {
	
	//查找所有溯源申请
	public List<TraceDTO> queryTraces(Integer companyinfoId);
	
	//查询申请人真实姓名
	public String querySearchName(String account);
	
	//查询产品id
	public Integer queryVarietyId(String variety);
	
	//查找基地id
	public Integer querySubbaseId(String subbaseName);
	
	//查找用户id
	public Integer queryUserId(String account);
	
	//查询溯源申请表最后一行id
	public String queryLastCode();
	
	//根据批号查询溯源申请
	public List<TraceDTO> queryTraceBlur(String bacthId);
	
	//根据溯源码查询产品信息
	public ProductDTO queryProductMsg(String traceSource);
	
	//查询所有溯源请求
	public List<TraceCheckDTO> queryTraceCheck();
	

}
