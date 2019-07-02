package com.swuorange.dao;

import com.swuorange.po.Companyinfo;

import org.apache.ibatis.annotations.Mapper;

/**
*@Description: 对公司信息表的增删改查
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月6日 下午4:12:24 
*/
@Mapper
public interface CompanyinfoMapper {
    /**
     *
     *@Description 用户注册时候进行企业验证，将数据插入数据库等待审查
     *@return 返回值描述
     *@version v1.0.0
     *@author YiMing
     *@2019年3月6日 下午4:13:25
     *
     */
	void insertCompanyinfo(Companyinfo companyinfo);
	/**
	 * 
	 *
	 *@Description 超管审查用户的企业验证修改
	 *@return 返回值描述
	 *@version v1.0.0
	 *@author YiMing
	 *@2019年3月6日 下午4:14:09
	 *
	 */
	void updateCompanyinfoById(Companyinfo companyinfo);
}