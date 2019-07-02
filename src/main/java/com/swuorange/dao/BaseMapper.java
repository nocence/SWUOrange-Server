package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.Staff;

@Mapper
public interface BaseMapper {
	
	//查询总得条数
	public Integer queryTotalCount(BaseSearchDTO search);
	
	//根据前端的条件和分页的条件查询满足条件的BaseDTO
	public List<BaseDTO> queryBasesBy(BaseSearchDTO search);

	public List<Staff> queryStuffsLikeName(Staff staff);

}
