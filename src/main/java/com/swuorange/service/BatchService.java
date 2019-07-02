package com.swuorange.service;

import java.util.List;


import com.swuorange.po.Batch;
import com.swuorange.po.User;

public interface BatchService {
	/**
	 *
	 *@Description 生产记录着查询生产批次以及分页
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:14:17
	 *
	 */
	Integer totalInfoBySubbseId(User user,Batch batch);
	List<Batch> queryListBySubbseId(User user,Integer page,Batch batch);
	
	/**
	 *
	 *@Description 企业用户查询生产批次和分页
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:14:52
	 *
	 */
	Integer totalInfoByCompanyinfoId(User user,Batch batch);
	List<Batch> queryListByCompanyinfoId(User user,Integer page,Batch batch);
	
	//产品名
	List<Batch> allproductName(Batch batch);
	
	//产品类型
	List<Batch> allproductType();
	
	//生产基地名
	List<Batch> allsubbaseNameByuserId(User user);
	List<Batch> allsubbaseNameByCompanyinfoId(User user);
}
