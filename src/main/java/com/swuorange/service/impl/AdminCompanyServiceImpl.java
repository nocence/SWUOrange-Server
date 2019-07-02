package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.AdminCompanyMapper;
import com.swuorange.data.CompanyStateData;
import com.swuorange.data.RoleData;
import com.swuorange.dto.AdminCompanyDTO;
import com.swuorange.service.AdminCompanyService;


@Service
@Transactional
public class AdminCompanyServiceImpl implements AdminCompanyService {

	@Autowired
	private AdminCompanyMapper adminCompanyMapper;
	
	
	@Override
	public List<AdminCompanyDTO> getCompanyList(Integer state) {
		
		return adminCompanyMapper.getCompanyListByState(state);
	}


	@Override
	public AdminCompanyDTO findOneCompany(Integer companyInfoId) {
		
		return adminCompanyMapper.queryCompanyById(companyInfoId);
	}


	@Override
	public void checkCompanyInfo(String type, Integer companyInfoId) {
		
		//判断是通过还是拒绝
		//0拒绝  1通过
		if ("0".equals(type)) {
			//如果为拒绝者修改公司表的信息为拒绝
			adminCompanyMapper.updateCompanyById(companyInfoId,CompanyStateData.NOT_ADOPT);
		} else if("1".equals(type)) {
			//通过修改公司的审核状态,在user_role修改角色信息将普通用户升级位企业用户
			Integer userId = adminCompanyMapper.queryUserId(companyInfoId);
			//更新公司表state
			adminCompanyMapper.updateCompanyById(companyInfoId,CompanyStateData.ADOPT);
			//更新角色表的role
			adminCompanyMapper.updateUserRole(userId,RoleData.BUSINESS_USER);
			
		}
		
		
		
		
		
		
		
	}



}
