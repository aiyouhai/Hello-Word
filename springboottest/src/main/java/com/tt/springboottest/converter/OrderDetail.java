package com.tt.springboottest.converter;

import java.util.Date;

public class OrderDetail {
	private Long productId;

	private String productName;

	/**
	 * 日期类型
	 */
	private Date buyTime;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}

}
