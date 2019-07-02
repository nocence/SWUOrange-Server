package com.swuorange.po;

public class Batch {
	
	private String batchNum;
	
	private Integer productId;
	
	private String productName;
	
	private Integer varietyId;
	
	private String productType;
	
	private Integer productNum;
	
	private String unit;
	
	private Integer subbaseId;
	
	private String subbaseName;
	
	private Integer nowPage;

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getProductNum() {
		return productNum;
	}

	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSubbaseName() {
		return subbaseName;
	}

	public void setSubbaseName(String subbaseName) {
		this.subbaseName = subbaseName;
	}

	public Integer getNowPage() {
		return nowPage;
	}

	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
	}

	public Integer getSubbaseId() {
		return subbaseId;
	}

	public void setSubbaseId(Integer subbaseId) {
		this.subbaseId = subbaseId;
	}

}
