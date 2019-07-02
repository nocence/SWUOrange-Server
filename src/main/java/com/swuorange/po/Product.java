package com.swuorange.po;

import java.io.Serializable;

public class Product implements Serializable {

	private static final long serialVersionUID = 2704770066370626286L;

	private Integer productId;

	private String productType;

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
		this.productType = productType == null ? null : productType.trim();
	}
}