package com.swuorange.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swuorange.data.ResultData;
import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Remarks;
import com.swuorange.dto.Result;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.service.AdminSupplyAndDemandService;

@RequestMapping("admin")
@RestController
public class AdminSupplyAndDemandController {

	@Autowired
	private AdminSupplyAndDemandService adminSupplyAndDemandService;

	@RequestMapping("getBuyList")
	public PageBean<DemandDTO> getBuyList(DemandSearchDTO search) {
		PageBean<DemandDTO> page = new PageBean<DemandDTO>();
		page.setNowPage(search.getNowPage());
		List<DemandDTO> demandDTOList = adminSupplyAndDemandService.getBuyList(search, page);
		page.setList(demandDTOList);
		return page;
	}

	@RequestMapping("checkBuy")
	public Result checkBuy(Remarks remarks) {
		adminSupplyAndDemandService.checkBuy(remarks);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("操作成功");
		return result;

	}

	@RequestMapping("getSupplyInfoList")
	public PageBean<SupplyInfoDTO> getSupplyInfoList(SupplySearchDTO search) {
		System.out.println(search);
		PageBean<SupplyInfoDTO> page = new PageBean<SupplyInfoDTO>();
		page.setNowPage(search.getNowPage());
		List<SupplyInfoDTO> supplyDTOList = adminSupplyAndDemandService.getSupplyInfoList(search, page);
		page.setList(supplyDTOList);
		return page;
	}
	
	@RequestMapping("checkSupply")
	public Result checkSupply(Remarks remarks) {
		System.out.println(remarks);
		adminSupplyAndDemandService.checkSupply(remarks);
		Result result = new Result();
		result.setCode(ResultData.SUCCESS_CODE);
		result.setMsg("操作成功");
		return result;

	}

}
