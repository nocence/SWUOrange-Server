package com.swuorange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swuorange.data.ResultData;
import com.swuorange.dto.AdminCompanyDTO;
import com.swuorange.dto.Result;
import com.swuorange.service.AdminCompanyService;

/*
 * 
* @Description: 该类的描述 后台管理系统的企业审核管理
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月8日 下午4:50:21
 */

@RestController
@RequestMapping("admin")
public class AdminCompanyController {
	/*
	 * 
	* @Description: 该方法 查询所有的需要审核的公司
	*
	* @return
	* @return：返回值描述
	* @version: v1.0.0
	* @author: Randy
	* @date: 2019年3月8日 下午4:54:44
	 */
	
	
	@Autowired
	private AdminCompanyService adminCompanyService;
	
	@RequestMapping("listCompany")
	public List<AdminCompanyDTO> listCompany(Integer state){
		return adminCompanyService.getCompanyList(state);
		
	}
	
	
	@RequestMapping("findOneCompany")
	public Result findOneCompany(Integer companyInfoId){
		Result result = new Result();
		AdminCompanyDTO dto = adminCompanyService.findOneCompany(companyInfoId);
		result.setObj(dto);
		return result;
	}
	
	
	@RequestMapping("checkCompanyInfo")
	public Result checkCompanyInfo(String type,Integer companyInfoId){
		adminCompanyService.checkCompanyInfo(type,companyInfoId);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		return result;
	}
	

}
