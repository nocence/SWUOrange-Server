package com.swuorange.dao;

import org.apache.ibatis.annotations.Mapper;

import com.swuorange.po.User;
import com.swuorange.dto.UserDTO;

@Mapper
public interface UserMapper {

	// 插入生产记录者
	int insertProductRecorder(User user);

	User queryUserByAccountPassword(UserDTO userDTO);

	UserDTO queryRoleName(Integer id);
}
