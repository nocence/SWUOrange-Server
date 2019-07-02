package com.swuorange.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.swuorange.common.Page;
import com.swuorange.po.Record;
import com.swuorange.po.User;
@Mapper
public interface RecordMapper {
	/**
	 * 
	 *@Description 生产记录者查询当前基地的总记录和分页
	 *@return allRecordsByUserId,用于分页计算总条数
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月15日 下午3:23:56
	 *
	 */
	Integer allRecordsByUserId(@Param("user")User user,@Param("record")Record record);
	List<Record> listRecordsByUserId(@Param("page")Page page,@Param("user")User user,@Param("record")Record record);
	
	/**
	 *
	 *@Description 企业用户查询公司名下所有记录和分页 
	 *@return allRecordsByCompanyInfoId，用于分页计算总条数
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月15日 下午3:32:18
	 *
	 */
	Integer allRecordsByCompanyInfoId(@Param("user")User user,@Param("record")Record record);
	List<Record> listRecordsByCompanyInfoId(@Param("page")Page page,@Param("user")User user,@Param("record")Record record);
	
	/**
	 * 
	 *
	 *@Description 生产记录者查询所有能操作的产品批次号
	 *@return 返回所有生产批号集合
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午4:09:01
	 *
	 */
	List<Record> allBatchNumByUserId(User user);
	/**
	 * 
	 *
	 *@Description 根据生产批号查询的信息
	 *@return 返回一个信息对象
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月16日 下午4:08:51
	 *
	 */
	Record byBatchNum(Record record);
}
