package com.swuorange.dto;

import java.io.Serializable;

public class SubbaseListDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer subbaseId;

    private String subbaseName;

    private String subbaseAddress;

    private String principal;

    private String productionRecorder;

    private Integer baseId;
    
    private String baseName;
  
    private Integer companyinfoId;
    
    private String companyName;

	public Integer getSubbaseId() {
		return subbaseId;
	}

	public void setSubbaseId(Integer subbaseId) {
		this.subbaseId = subbaseId;
	}

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

	public String getPrincipal() {
		return principal;
	}

	public void setPrincipal(String principal) {
		this.principal = principal;
	}

	public String getProductionRecorder() {
		return productionRecorder;
	}

	public void setProductionRecorder(String productionRecorder) {
		this.productionRecorder = productionRecorder;
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

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	
	public SubbaseListDTO(){}
	public SubbaseListDTO(Integer subbaseId, String subbaseName, String subbaseAddress, String principal,
			String productionRecorder, Integer baseId, String baseName, Integer companyinfoId, String companyName) {
		this.subbaseId = subbaseId;
		this.subbaseName = subbaseName;
		this.subbaseAddress = subbaseAddress;
		this.principal = principal;
		this.productionRecorder = productionRecorder;
		this.baseId = baseId;
		this.baseName = baseName;
		this.companyinfoId = companyinfoId;
		this.companyName = companyName;
	}
    
    

}
