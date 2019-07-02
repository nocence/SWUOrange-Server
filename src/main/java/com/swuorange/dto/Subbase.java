package com.swuorange.dto;

import java.io.Serializable;

public class Subbase implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer subbaseId;

    private String subbaseName;

    private String subbaseAddress;

    private String principal;

    private String productionRecorder;

    private Integer baseId;
    
    private Integer companyinfoId;

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

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
        this.subbaseName = subbaseName == null ? null : subbaseName.trim();
    }

    public String getSubbaseAddress() {
        return subbaseAddress;
    }

    public void setSubbaseAddress(String subbaseAddress) {
        this.subbaseAddress = subbaseAddress == null ? null : subbaseAddress.trim();
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

    
    public Subbase(){}

	public Subbase(Integer subbaseId, String subbaseName, String subbaseAddress, String principal,
			String productionRecorder, Integer baseId, Integer companyinfoId) {
		this.subbaseId = subbaseId;
		this.subbaseName = subbaseName;
		this.subbaseAddress = subbaseAddress;
		this.principal = principal;
		this.productionRecorder = productionRecorder;
		this.baseId = baseId;
		this.companyinfoId = companyinfoId;
	}

	
    
    
    
}
