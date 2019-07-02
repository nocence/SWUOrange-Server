package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.swuorange.dto.AdminCompanyDTO;

@Mapper
public interface AdminCompanyMapper {

	public List<AdminCompanyDTO> getCompanyListByState(Integer state);

	public AdminCompanyDTO queryCompanyById(Integer companyInfoId);

	public void updateCompanyById(@Param("companyInfoId") Integer companyInfoId,@Param("state") Integer state);

	public Integer queryUserId(Integer companyInfoId);

	public void updateUserRole(@Param("userId") Integer userId,@Param("role") int role);
	
}
