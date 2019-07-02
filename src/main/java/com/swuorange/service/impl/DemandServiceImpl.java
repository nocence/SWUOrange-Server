package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.DemandMapper;
import com.swuorange.dto.DemandDTO;
import com.swuorange.dto.DemandSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.po.Product;
import com.swuorange.service.DemandService;

@Service
@Transactional
public class DemandServiceImpl implements DemandService {

	@Autowired
	private DemandMapper demandMapper;

	@Override
	public List<Product> getProductType() {

		return demandMapper.getProductType();
	}

	@Override
	public List<DemandDTO> DemandBaseList(DemandSearchDTO search, PageBean<DemandDTO> page) {
		// 首先查询出总条数,计算总页数,查询的时候传入
		Integer count = demandMapper.queryTotalCount(search);

		// 设置总条数-后台会自动计算总页数
		page.setTotalRow(count);
		search.setStart((page.getNowPage() - 1) * page.getPageRow());
		search.setPagRow(page.getPageRow());
		// 根据前端的页面传回来的条件查询所需要的数据
		return demandMapper.queryDemandBy(search);
	}

}
