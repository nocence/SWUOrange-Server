package com.swuorange.service;

import java.util.List;

import com.swuorange.dto.AdminCompanyDTO;

public interface AdminCompanyService {
	//根据状态查询公司信息
	public List<AdminCompanyDTO> getCompanyList(Integer state);

	public AdminCompanyDTO findOneCompany(Integer companyInfoId);

	public void checkCompanyInfo(String type, Integer companyInfoId);

}
