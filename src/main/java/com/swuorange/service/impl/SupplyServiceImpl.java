package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.SupplyInfoMapper;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.SupplyInfoDTO;
import com.swuorange.dto.SupplySearchDTO;
import com.swuorange.po.Variety;
import com.swuorange.service.SupplyService;

@Service
@Transactional
public class SupplyServiceImpl implements SupplyService {

	@Autowired
	private SupplyInfoMapper supplyInfoMapper;

	@Override
	public List<SupplyInfoDTO> getSupplyList(SupplySearchDTO search, PageBean<SupplyInfoDTO> page) {
		// 首先查询出总条数,计算总页数,查询的时候传入
		Integer count = supplyInfoMapper.queryTotalCount(search);
		// 设置总条数-后台会自动计算总页数
		page.setTotalRow(count);
		search.setStart((page.getNowPage() - 1) * page.getPageRow());
		search.setPageRow(page.getPageRow());
		// 根据前端的页面传回来的条件查询所需要的数据
		return supplyInfoMapper.querySupplyBy(search);
	}

	@Override
	public List<Variety> getVariety(Integer productId) {
		return supplyInfoMapper.getVariety(productId);
	}

}
