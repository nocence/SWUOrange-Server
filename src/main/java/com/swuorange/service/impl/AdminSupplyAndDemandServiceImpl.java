package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.AdminSupplyAndDemandMapper;
import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Remarks;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.service.AdminSupplyAndDemandService;
import com.swuorange.service.SupplyService;

@Service
@Transactional
public class AdminSupplyAndDemandServiceImpl implements AdminSupplyAndDemandService {

	@Autowired
	private AdminSupplyAndDemandMapper adminSupplyAndDemandMapper;

	@Override
	public List<DemandDTO> getBuyList(DemandSearchDTO search, PageBean<DemandDTO> page) {
		// 首先查询出总条数,计算总页数,查询的时候传入
		Integer count = adminSupplyAndDemandMapper.queryBuyTotalCount(search);
		// 设置总条数-后台会自动计算总页数
		page.setTotalRow(count);
		search.setStart((page.getNowPage() - 1) * page.getPageRow());
		search.setPagRow(page.getPageRow());
		// 根据前端的页面传回来的条件查询所需要的数据
		System.out.println(search);
		return adminSupplyAndDemandMapper.queryBuyBy(search);
	}

	@Override
	public void checkBuy(Remarks remarks) {
		adminSupplyAndDemandMapper.updateBuy(remarks);

	}

	@Override
	public List<SupplyInfoDTO> getSupplyInfoList(SupplySearchDTO search, PageBean<SupplyInfoDTO> page) {
		Integer count = adminSupplyAndDemandMapper.querySupplyTotalCount(search);
		page.setTotalRow(count);
		search.setStart((page.getNowPage() - 1) * page.getPageRow());
		search.setPageRow(page.getPageRow());
		// 根据前端的页面传回来的条件查询所需要的数据
		System.out.println(search);
		return adminSupplyAndDemandMapper.querySupplyBy(search);
	}

	@Override
	public void checkSupply(Remarks remarks) {
		adminSupplyAndDemandMapper.updateSupply(remarks);
	}

}
