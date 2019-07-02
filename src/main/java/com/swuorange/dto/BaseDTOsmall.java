package com.swuorange.dto;

import java.io.Serializable;

public class BaseDTOsmall implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer baseId;

	private String baseName;

	private Integer companyinfoId;

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

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

	public BaseDTOsmall(){}
	public BaseDTOsmall(Integer baseId, String baseName, Integer companyinfoId) {
		this.baseId = baseId;
		this.baseName = baseName;
		this.companyinfoId = companyinfoId;
	}

	

	
	
	
}
