package com.swuorange.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class QualityInfo {
	
	
	//质量申请名称
	private String requestName;
	//产品分类
	private String variety;
	//审核人名字
	private String adminName;
	//申请时间
	@JsonFormat(timezone="GMT+8",pattern="yyyy年MM月dd日 HH:mm:ss")
	private Timestamp applyTime;
	//审批时间
	@JsonFormat(timezone="GMT+8",pattern="yyyy年MM月dd日 HH:mm:ss")
	private Timestamp reviewTime;	
	//状态
	private Integer state;
	//申请人
	private String realName;
	//二级基地的名字
	private String subbaseName;
	//生产记录者的名字;
	private String recorderName;
	
	
	
	
	
	
	
	
	public String getSubbaseName() {
		return subbaseName;
	}
	public void setSubbaseName(String subbaseName) {
		this.subbaseName = subbaseName;
	}
	public String getRecorderName() {
		return recorderName;
	}
	public void setRecorderName(String recorderName) {
		this.recorderName = recorderName;
	}
	
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	public String getVariety() {
		return variety;
	}
	public void setVariety(String variety) {
		this.variety = variety;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Timestamp getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	public Timestamp getReviewTime() {
		return reviewTime;
	}
	public void setReviewTime(Timestamp reviewTime) {
		this.reviewTime = reviewTime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	
	
	
	
	
	

}
