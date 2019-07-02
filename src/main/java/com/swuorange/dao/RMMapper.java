package com.swuorange.dao;


import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.RM;


@Mapper
public interface RMMapper{
	public int emptyRM();
	public int insertRM(RM rm);
	
}
