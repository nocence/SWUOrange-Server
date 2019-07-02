package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.dao.BaseMapper;
import com.swuorange.dto.BaseDTO;
import com.swuorange.dto.BaseSearchDTO;
import com.swuorange.dto.PageBean;
import com.swuorange.dto.Staff;
import com.swuorange.service.BaseService;

@Service
@Transactional
public class BaseServiceImpl implements BaseService {

	@Autowired
	private BaseMapper baseMapper;

	@Override
	public List<BaseDTO> queryBaseList(BaseSearchDTO search, PageBean<BaseDTO> page) {

		// 首先查询出总条数,计算总页数,查询的时候传入
		Integer count = baseMapper.queryTotalCount(search);

		// 设置总条数-后台会自动计算总页数
		page.setTotalRow(count);
		search.setStart((page.getNowPage() - 1) * page.getPageRow());
		search.setEnd(page.getPageRow());
		// 根据前端的页面传回来的条件查询所需要的数据
		return baseMapper.queryBasesBy(search);
	}

	@Override
	
	//用于根据名字模糊查询员工
	public List<Staff> getStaffsByLike(Staff staff) {
		return baseMapper.queryStuffsLikeName(staff);
	}
}
