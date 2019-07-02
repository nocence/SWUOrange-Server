package com.swuorange.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swuorange.common.Page;
import com.swuorange.common.PageConstance;
import com.swuorange.dao.RecordMapper;
import com.swuorange.po.Record;
import com.swuorange.po.User;
import com.swuorange.service.RecordService;
import com.swuorange.util.PageUtil;

@Service
public class RecordServiceImpl implements RecordService{
	
	@Autowired
	private RecordMapper recordMapper;
	
	@Override
	public Integer allRecordsByUserId(User user, Record record) {
		return recordMapper.allRecordsByUserId(user, record);
	}

	@Override
	public List<Record> listRecordsByUserId(User user,Integer nowPage, Record record) {
		Integer total = recordMapper.allRecordsByUserId(user, record);
		Page page = PageUtil.getPage(PageConstance.DATA_PER_PAGE, total, nowPage);
		return recordMapper.listRecordsByUserId(page, user, record);
	}

	@Override
	public Integer allRecordsByCompanyInfoId(User user, Record record) {
		return recordMapper.allRecordsByCompanyInfoId(user, record);
	}

	@Override
	public List<Record> listRecordsByCompanyInfoId(User user, Integer nowPage,Record record) {
		Integer total = recordMapper.allRecordsByUserId(user, record);
		Page page = PageUtil.getPage(PageConstance.DATA_PER_PAGE, total, nowPage);
		return recordMapper.listRecordsByCompanyInfoId(page, user, record);
	}

	@Override
	public List<Record> allBatchNumByUserId(User user) {
		return recordMapper.allBatchNumByUserId(user);
	}

	@Override
	public Record byBatchNum(Record record) {
		return recordMapper.byBatchNum(record);
	}

}
