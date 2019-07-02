package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swuorange.common.Page;
import com.swuorange.common.PageConstance;
import com.swuorange.dao.BatchMapper;
import com.swuorange.po.Batch;
import com.swuorange.po.User;
import com.swuorange.service.BatchService;
import com.swuorange.util.PageUtil;

@Service
public class BatchServiceImpl implements BatchService{
	
	@Autowired
	private BatchMapper batchMapper;

	
	@Override
	public Integer totalInfoBySubbseId(User user,Batch batch) {
		return batchMapper.totalInfoBySubbseId(user,batch);
	}

	@Override
	public List<Batch> queryListBySubbseId(User user,Integer nowPage,Batch batch) {
		Integer total = batchMapper.totalInfoBySubbseId(user,batch);
		Page page = PageUtil.getPage(PageConstance.DATA_PER_PAGE, total, nowPage);
		List<Batch> listBySubbseId = batchMapper.queryListBySubbseId(page, user,batch);
		return listBySubbseId;
	}

	
	@Override
	public Integer totalInfoByCompanyinfoId(User user,Batch batch) {
		return batchMapper.totalInfoByCompanyinfoId(user,batch);
	}

	@Override
	public List<Batch> queryListByCompanyinfoId(User user,Integer nowPage,Batch batch) {
		Integer total = batchMapper.totalInfoByCompanyinfoId(user,batch);
		Page page = PageUtil.getPage(PageConstance.DATA_PER_PAGE, total, nowPage);
		List<Batch> listByCompanyinfoId = batchMapper.queryListByCompanyinfoId(page, user,batch);
		return listByCompanyinfoId;
	}

	@Override
	public List<Batch> allproductName(Batch batch) {
		return batchMapper.allproductName(batch);
	}

	@Override
	public List<Batch> allproductType() {
		return batchMapper.allproductType();
	}

	@Override
	public List<Batch> allsubbaseNameByuserId(User user) {
		return batchMapper.allsubbaseNameByuserId(user);
	}

	@Override
	public List<Batch> allsubbaseNameByCompanyinfoId(User user) {
		return batchMapper.allsubbaseNameByCompanyinfoId(user);
	}


}
