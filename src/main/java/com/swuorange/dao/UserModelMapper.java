package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.dto.RegUser;

@Mapper
public interface UserModelMapper {
	
	//注册时,查询用户名是否存在
	public RegUser queryUserName(RegUser regUser);
	
}
