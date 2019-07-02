package com.swuorange.po;

import java.io.Serializable;

public class Variety implements Serializable {

	private static final long serialVersionUID = 4949846775601995715L;
	private Integer varietyId;
	private String variety;
	private Integer productId;
	private String introduction;
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
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	

}
