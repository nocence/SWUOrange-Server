package com.swuorange.dto;

public class VarietyDTO {
	
	
	//品种id
	private Integer varietyId;
	//品种名字
	private String variety;
	//类型名字id
	private Integer productId;
	//介绍
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
	
	@Override
	public String toString() {
		return "VarietyDTO [varietyId=" + varietyId + ", variety=" + variety + ", productId=" + productId
				+ ", introduction=" + introduction + "]";
	}
	

	
	
	
	
}
