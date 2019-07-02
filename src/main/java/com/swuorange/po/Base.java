package com.swuorange.po;

import java.io.Serializable;
import java.sql.Timestamp;

public class Base implements Serializable {
	
	private Integer baseId;

    private String baseName;

    private String baseAddress;

    private Integer baseHeaderId;

    private Integer companyinfoId;
    
    private Timestamp addTime;
    
    private String phone;

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

	public Integer getBaseHeaderId() {
		return baseHeaderId;
	}

	public void setBaseHeaderId(Integer baseHeaderId) {
		this.baseHeaderId = baseHeaderId;
	}

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
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
