package com.swuorange.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
 * 
* @Description: 该类的描述 发布求购信息
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月12日 下午5:38:57
 */

public class BuyingInfo implements Serializable {
	// 主键
	private Integer buyId;
	// 品种
	private Integer productId;
	// 价格
	private Double purchasePrice;
	// 数量
	private Integer quantity;
	// 地址
	private String location;
	// 截止时间
	private String cutoffTime;
	// 发布时间
	private String releaseTime;
	// 电话
	private String tel;
	// 联系人
	private String contact;
	// 详细信息
	private String details;
	// 显示标题
	private String title;
	// 审核信息
	private Integer state;
	// 备注信息
	private String remarks;

	private Integer userId;

	public Integer getBuyId() {
		return buyId;
	}

	public void setBuyId(Integer buyId) {
		this.buyId = buyId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCutoffTime() {
		return cutoffTime;
	}

	public void setCutoffTime(String cutoffTime) {
		this.cutoffTime = cutoffTime;
	}

	public String getTel() {
		return tel;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "BuyingInfo [buyId=" + buyId + ", productId=" + productId + ", purchasePrice=" + purchasePrice
				+ ", quantity=" + quantity + ", location=" + location + ", cutoffTime=" + cutoffTime + ", releaseTime="
				+ releaseTime + ", tel=" + tel + ", contact=" + contact + ", details=" + details + ", title=" + title
				+ ", state=" + state + ", remarks=" + remarks + "]";
	}

}