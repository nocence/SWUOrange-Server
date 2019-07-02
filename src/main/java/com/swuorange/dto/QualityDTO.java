package com.swuorange.dto;

import java.sql.Timestamp;

public class QualityDTO {
	
	//质量申请表id
	private Integer qualityId;
	//卫生检测照片
	private String iso;
	//农药残留照片
	private String cac;
	//生产记录者id(user,中间表联查)
	private Integer recorderId;
	//批次id
	private Integer batchId;
	//申请人id(当前用户的id)
	private Integer requesterId;
	//审核人(admin id)
	private Integer managerId;
	//申请时间
	private Timestamp applyTime;
	//审批时间
	private Timestamp reviewTime;
	//状态
	private Integer state;
	//质量检测申请名称
	private String requestName;
	public Integer getQualityId() {
		return qualityId;
	}
	public void setQualityId(Integer qualityId) {
		this.qualityId = qualityId;
	}
	
	public String getIso() {
		return iso;
	}
	public void setIso(String iso) {
		this.iso = iso;
	}
	public String getCac() {
		return cac;
	}
	public void setCac(String cac) {
		this.cac = cac;
	}
	
	public Integer getRecorderId() {
		return recorderId;
	}
	public void setRecorderId(Integer recorderId) {
		this.recorderId = recorderId;
	}
	public Integer getBatchId() {
		return batchId;
	}
	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}
	public Integer getRequesterId() {
		return requesterId;
	}
	public void setRequesterId(Integer requesterId) {
		this.requesterId = requesterId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
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
	public String getRequestName() {
		return requestName;
	}
	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	@Override
	public String toString() {
		return "QualityRequestDTO [qualityId=" + qualityId + ", varietyId=" + ", iso=" + iso + ", cac="
				+ cac + ", subbaseId="  + ", recorderId=" + recorderId + ", batchId=" + batchId
				+ ", requesterId=" + requesterId + ", managerId=" + managerId + ", applyTime=" + applyTime
				+ ", reviewTime=" + reviewTime + ", state=" + state + ", requestName=" + requestName + "]";
	}
	
	
	
	
	

}
