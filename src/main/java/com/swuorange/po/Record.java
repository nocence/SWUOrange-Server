package com.swuorange.po;

/**
*@Description: 用于向前端传递信息的中间实体类
*
*@version: v1.0.0
*@author: Yiming
*@date: 2019年3月15日 下午3:07:01 
*/
public class Record {
	
	//生产记录编号
	private Integer recordId;
	
	//产品批次号
	private String batchNum;
	
	//生产场地Id和名称
	private Integer subbaseId;
	
	private String subbaseName;
	
	//产品名称及其Id
	private Integer varietyId;
	
	private String variety;
	
	//产品类型Id及其名称
	private Integer productId;
	
	private String productType;
	//操作简要
	private String operate;
	
	//操作详细信息
	private String operateDetail;
	
	//操作者Id及姓名
	private Integer userId;
	
	private String realName;
	
	//操作时间
	private String doTime;
	
	//分页数据
	private Integer nowPage;
	
	//条件查询的开始时间和结束时间
	private String startTime;
	private String endTime;

	public Integer getRecordId() {
		return recordId;
	}

	public void setRecordId(Integer recordId) {
		this.recordId = recordId;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
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

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getOperate() {
		return operate;
	}

	public void setOperate(String operate) {
		this.operate = operate;
	}

	public String getOperateDetail() {
		return operateDetail;
	}

	public void setOperateDetail(String operateDetail) {
		this.operateDetail = operateDetail;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getDoTime() {
		return doTime;
	}

	public void setDoTime(String doTime) {
		this.doTime = doTime;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "Rcords [recordId=" + recordId + ", batchNum=" + batchNum + ", subbaseId=" + subbaseId + ", subbaseName="
				+ subbaseName + ", varietyId=" + varietyId + ", variety=" + variety + ", productId=" + productId
				+ ", productType=" + productType + ", operate=" + operate + ", operateDetail=" + operateDetail
				+ ", userId=" + userId + ", realName=" + realName + ", doTime=" + doTime + ", nowPage=" + nowPage + "]";
	}
}
