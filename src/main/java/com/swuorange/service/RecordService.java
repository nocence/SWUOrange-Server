package com.swuorange.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.swuorange.common.Page;
import com.swuorange.po.Record;
import com.swuorange.po.User;

public interface RecordService {
	Integer allRecordsByUserId(User user,Record record);
	List<Record> listRecordsByUserId(User user,Integer nowPage ,Record record);
	
	Integer allRecordsByCompanyInfoId(User user,Record record);
	List<Record> listRecordsByCompanyInfoId(User user,Integer nowPage ,Record record);
	
	List<Record> allBatchNumByUserId(User user);
	Record byBatchNum(Record record);
}
