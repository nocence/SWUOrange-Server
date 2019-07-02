package com.swuorange.dto;

import java.io.Serializable;

public class BatchDTO implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String batchNum;
	
	private Integer productId;
	
	private Integer varietyId;
	
	private Integer productNum;
	
	private String unit;
	
	private Integer subbaseId;

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
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

	public Integer getSubbaseId() {
		return subbaseId;
	}

	public void setSubbaseId(Integer subbaseId) {
		this.subbaseId = subbaseId;
	}


	
}
