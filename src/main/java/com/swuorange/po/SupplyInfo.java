package com.swuorange.po;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * 
* @Description: 该类的描述 供应信息表
*
* @version: v1.0.0
* @author: Randy
* @date: 2019年3月14日 上午9:58:13
 */
public class SupplyInfo implements Serializable {

	private static final long serialVersionUID = -1539703153540502184L;

	private Integer supplyId;// 主键
	private Integer varietyId;// 产品品种名称
	private BigDecimal unitPrice;// 期望价格
	private Integer quantity;// 数量
	private Integer orderQuantity;// 起订数量
	private String cutoffTime;// 截止时间
	private String releaseTime;// 添加时间
	private String concat;// 联系人
	private String tel;// 联系电话
	private String details;// 详细说明
	private String title;// 简要标题
	private String location;// 地址
	private String url;// 图片地址
	private Integer state;// 审核状态
	private String remarks;// 备注
	private Integer userId;// 用户id
	

	public Integer getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public Integer getSupplyId() {
		return supplyId;
	}

	public void setSupplyId(Integer supplyId) {
		this.supplyId = supplyId;
	}

	public Integer getVarietyId() {
		return varietyId;
	}

	public void setVarietyId(Integer varietyId) {
		this.varietyId = varietyId;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getCutoffTime() {
		return cutoffTime;
	}

	public void setCutoffTime(String cutoffTime) {
		this.cutoffTime = cutoffTime;
	}

	public String getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(String releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getConcat() {
		return concat;
	}

	public void setConcat(String concat) {
		this.concat = concat == null ? null : concat.trim();
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel == null ? null : tel.trim();
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details == null ? null : details.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location == null ? null : location.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
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
		this.remarks = remarks == null ? null : remarks.trim();
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "SupplyInfo [supplyId=" + supplyId + ", varietyId=" + varietyId + ", unitPrice=" + unitPrice
				+ ", quantity=" + quantity + ", orderQuantity=" + orderQuantity + ", cutoffTime=" + cutoffTime
				+ ", releaseTime=" + releaseTime + ", concat=" + concat + ", tel=" + tel + ", details=" + details
				+ ", title=" + title + ", location=" + location + ", url=" + url + ", state=" + state + ", remarks="
				+ remarks + ", userId=" + userId + "]";
	}
	
	
}