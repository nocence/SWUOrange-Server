package com.swuorange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.dao.UserMapper;
import com.swuorange.dao.UserModelMapper;
import com.swuorange.dto.RegUser;
import com.swuorange.dto.UserDTO;
import com.swuorange.po.User;
import com.swuorange.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	public UserModelMapper userModelMapper;
	@Autowired
	public UserMapper usermapper;
	@Override
	public RegUser queryUserName(RegUser regUser) {
		
		//通过用户名查询用户
		return userModelMapper.queryUserName(regUser);
	}
	@Override
	public User queryUser(UserDTO userDTO) {
		return usermapper.queryUserByAccountPassword(userDTO);
	}
	@Override
	public UserDTO queryRoleName(Integer userId) {
		// TODO Auto-generated method stub
		return usermapper.queryRoleName(userId);
	}
	
	
	

}
