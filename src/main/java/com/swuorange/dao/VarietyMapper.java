package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.VarietyDTO;
@Mapper
public interface VarietyMapper {
	public List<VarietyDTO> query();

}
