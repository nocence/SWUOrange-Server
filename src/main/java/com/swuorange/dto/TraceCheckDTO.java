package com.swuorange.dto;

import java.io.Serializable;

public class TraceCheckDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String applicationCode;
	
	private Integer subbaseId;
	
	private String subbaseName;
	
	private String bacthId;
	
	private Integer varietyId;
	
	private String variety;
	
	private Integer type;
	
	private Integer userId;
	
	private String realname;
	
	private Integer managerId;
	
	private String applyTime;
	
	private String reviewTime;
	
	private String traceSource;
	
	private Integer companyinfoId;
	
	private String companyName;

	public String getApplicationCode() {
		return applicationCode;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
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
		this.subbaseName = subbaseName;
	}

	public String getBacthId() {
		return bacthId;
	}

	public void setBacthId(String bacthId) {
		this.bacthId = bacthId;
	}

	public Integer getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
	}

	public String getVariety() {
		return variety;
	}

	public void setVariety(String variety) {
		this.variety = variety;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getManagerId() {
		return managerId;
	}

	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getReviewTime() {
		return reviewTime;
	}

	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}

	public String getTraceSource() {
		return traceSource;
	}

	public void setTraceSource(String traceSource) {
		this.traceSource = traceSource;
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

	public TraceCheckDTO(){}
	public TraceCheckDTO(String applicationCode, Integer subbaseId, String subbaseName, String bacthId,
			Integer varietyId, String variety, Integer type, Integer userId, String realname, Integer managerId,
			String applyTime, String reviewTime, String traceSource, Integer companyinfoId, String companyName) {
		this.applicationCode = applicationCode;
		this.subbaseId = subbaseId;
		this.subbaseName = subbaseName;
		this.bacthId = bacthId;
		this.varietyId = varietyId;
		this.variety = variety;
		this.type = type;
		this.userId = userId;
		this.realname = realname;
		this.managerId = managerId;
		this.applyTime = applyTime;
		this.reviewTime = reviewTime;
		this.traceSource = traceSource;
		this.companyinfoId = companyinfoId;
		this.companyName = companyName;
	}
	
	

}
