package com.swuorange.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String subbaseName;
	
	private String subbaseAddress;
	
	private String bacthId;
	
	private String variety;
	
	private String companyName;

	public String getSubbaseName() {
		return subbaseName;
	}

	public void setSubbaseName(String subbaseName) {
		this.subbaseName = subbaseName;
	}

	public String getSubbaseAddress() {
		return subbaseAddress;
	}

	public void setSubbaseAddress(String subbaseAddress) {
		this.subbaseAddress = subbaseAddress;
	}

	public String getBacthId() {
		return bacthId;
	}

	public void setBacthId(String bacthId) {
		this.bacthId = bacthId;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	public ProductDTO(){}
	public ProductDTO(String subbaseName, String subbaseAddress, String bacthId, String variety, String companyName) {
		this.subbaseName = subbaseName;
		this.subbaseAddress = subbaseAddress;
		this.bacthId = bacthId;
		this.variety = variety;
		this.companyName = companyName;
	}
	
	

}
