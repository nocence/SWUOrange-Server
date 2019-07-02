package com.swuorange.service;

import com.swuorange.dto.RegUser;

import com.swuorange.dto.UserDTO;
import com.swuorange.po.User;

public interface UserService {
	
	public RegUser queryUserName(RegUser regUser);
	
	public User queryUser(UserDTO userDTO);

	public UserDTO queryRoleName(Integer userId);

}
