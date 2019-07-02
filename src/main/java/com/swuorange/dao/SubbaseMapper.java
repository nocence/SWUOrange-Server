package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.swuorange.dto.BaseDTOsmall;
import com.swuorange.dto.Staff;
import com.swuorange.dto.SubbaseListDTO;
import com.swuorange.po.Subbase;

@Mapper
public interface SubbaseMapper {
	
	//查找二级基地
	public List<SubbaseListDTO> querySubbases(Integer companyinfoId);
	
	//查询staff表员工名字
	public List<Staff> queryStaffName(Integer companyinfoId);
	
	//查询公司旗下所有基地
	public List<BaseDTOsmall> queryBaseName(Integer companyinfoId);
		
	//模糊查询二级基地
	public List<Subbase> querySubbasesBlur(@Param("subbaseName") String subbaseName,@Param("companyinfoId") Integer companyinfoId);
	
	//查询员工id
	public int queryStaffId(String staffName);
	
	//根据场地名称和场地地址查询场地id
	public Subbase querySubbaseId(@Param("subbaseName") String subbaseName,@Param("subbaseAddress") String subbaseAddress);
	
	//根据生产者记录者查询user表中id
	public int queryUserId(String productionRecorder);
	
	//从二级基地关系表中查询userId
	public int querySssUserId(Integer subbaseId);
	

}
