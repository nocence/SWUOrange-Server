package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.swuorange.common.Page;
import com.swuorange.po.Batch;
import com.swuorange.po.User;

@Mapper
public interface BatchMapper {
	/**
	 *@Description 生产记录者只能查询当前基地的产品批次
	 *@return Integer 总记录数
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:03:23
	 *
	 */
	Integer totalInfoBySubbseId(@Param("user")User user,@Param("batch")Batch batch);
	/**
	 * 
	 *
	 *@Description 生产记录者查询的分页
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:07:28
	 *
	 */
	List<Batch> queryListBySubbseId(@Param("page")Page page,@Param("user")User user,@Param("batch")Batch batch);
	
	/**
	 * 
	 *
	 *@Description 企业用能查询当前企业下面所有基地的记录
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:08:24
	 *
	 */
	Integer totalInfoByCompanyinfoId(@Param("user")User user,@Param("batch")Batch batch);
	
	/**
	 * 
	 *
	 *@Description 企业用户查询的分页
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月12日 下午5:07:28
	 *
	 */
	List<Batch> queryListByCompanyinfoId(@Param("page")Page page,@Param("user")User user,@Param("batch")Batch batch);
	
	
	//产品名
	List<Batch> allproductName(Batch batch);
	
	//产品类型
	List<Batch> allproductType();
	
	//生产基地名
	List<Batch> allsubbaseNameByuserId(User user);
	List<Batch> allsubbaseNameByCompanyinfoId(User user);
}
