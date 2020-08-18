package com.tt.springboottest.ui.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class CatItem implements Serializable {
	private Product product;
	private int num;
	private Double itemPrice;

	public Double getItemPrice() {
		BigDecimal bprice = new BigDecimal(product.getPrice() + "");
		BigDecimal bnum = new BigDecimal(num);
		System.out.println(bprice);
		System.out.println(bnum);
		itemPrice = Double.valueOf((bprice.multiply(bnum)) + "");
		return itemPrice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
