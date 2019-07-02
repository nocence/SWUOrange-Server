package com.swuorange.dto;

import java.io.Serializable;

public class SubbaseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer subbaseId;

    private String subbaseName;

    private String subbaseAddress;

    private String principal;

    private String productionRecorder;

    private Integer baseId;
    
    private Integer companyinfoId;
    
    private String subbasePRaccount;
    
    private String subbasePRpwd;
    
    private Integer subbasePCStaffId;
    
    private Integer subbasePRStaffId;
    
    private Integer userId;
    
    private Integer roleId;
    

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

	public Integer getCompanyinfoId() {
		return companyinfoId;
	}

	public void setCompanyinfoId(Integer companyinfoId) {
		this.companyinfoId = companyinfoId;
	}

	public String getSubbasePRaccount() {
		return subbasePRaccount;
	}

	public void setSubbasePRaccount(String subbasePRaccount) {
		this.subbasePRaccount = subbasePRaccount;
	}

	public String getSubbasePRpwd() {
		return subbasePRpwd;
	}

	public void setSubbasePRpwd(String subbasePRpwd) {
		this.subbasePRpwd = subbasePRpwd;
	}
	
	public Integer getSubbasePCStaffId() {
		return subbasePCStaffId;
	}

	public void setSubbasePCStaffId(Integer subbasePCStaffId) {
		this.subbasePCStaffId = subbasePCStaffId;
	}

	public Integer getSubbasePRStaffId() {
		return subbasePRStaffId;
	}

	public void setSubbasePRStaffId(Integer subbasePRStaffId) {
		this.subbasePRStaffId = subbasePRStaffId;
	}
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public SubbaseDTO(){}

	public SubbaseDTO(Integer subbaseId, String subbaseName, String subbaseAddress, String principal,
			String productionRecorder, Integer baseId, Integer companyinfoId, String subbasePRaccount,
			String subbasePRpwd, Integer subbasePCStaffId, Integer subbasePRStaffId, Integer userId, Integer roleId) {
		this.subbaseId = subbaseId;
		this.subbaseName = subbaseName;
		this.subbaseAddress = subbaseAddress;
		this.principal = principal;
		this.productionRecorder = productionRecorder;
		this.baseId = baseId;
		this.companyinfoId = companyinfoId;
		this.subbasePRaccount = subbasePRaccount;
		this.subbasePRpwd = subbasePRpwd;
		this.subbasePCStaffId = subbasePCStaffId;
		this.subbasePRStaffId = subbasePRStaffId;
		this.userId = userId;
		this.roleId = roleId;
	}



}
