package com.swuorange.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

/*
 * 
* @Description: 该类的描述 返回前端的实体类信息
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月9日 上午11:53:29
 */
public class BaseDTO implements Serializable {
	
	//基地id
	private Integer baseId;
	//基地名字
    private String baseName;
   
    //基地负责人
    private String  staffName;
    
    private Integer baseHeaderId;
    //所属公司
    private String companyName;
    //添加时间
    
    @JsonFormat(timezone="GMT+8",pattern="yyyy年MM月dd日 HH:mm:ss")
    private Timestamp addTime;
    //联系电话
    private String phone;
    
    //基地地址
    private String baseAddress;
    

	public Integer getBaseHeaderId() {
		return baseHeaderId;
	}

	public void setBaseHeaderId(Integer baseHeaderId) {
		this.baseHeaderId = baseHeaderId;
	}

	public Integer getBaseId() {
		return baseId;
	}

	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}

	public String getBaseName() {
		return baseName;
	}

	public void setBaseName(String baseName) {
		this.baseName = baseName;
	}

	public String getBaseAddress() {
		return baseAddress;
	}

	public void setBaseAddress(String baseAddress) {
		this.baseAddress = baseAddress;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
    
}
