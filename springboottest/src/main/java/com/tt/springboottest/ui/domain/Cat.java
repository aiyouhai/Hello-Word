package com.tt.springboottest.ui.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cat implements Serializable {

	Map<String, CatItem> catMap = new LinkedHashMap<String, CatItem>();
	private Double toutlePrice;

	public Double getToutlePrice() {
		return toutlePrice;
	}

	public void setToutlePrice(Double toutlePrice) {
		this.toutlePrice = toutlePrice;
	}

	/**
	 * 
	 */
	public void addCat(CatItem catItem) {
		if (catMap.containsKey(catItem.getProduct().getpId())) {
			CatItem catItem2 = catMap.get(catItem.getProduct().getpId());

			int newNum = catItem2.getNum() + catItem.getNum();

			catItem2.setNum(newNum);

		} else {

			catMap.put(catItem.getProduct().getpId(), catItem);
		}
	}

	public void deleteCat(String pId) {
		catMap.remove(pId);

	}

	public void clean() {
		catMap.clear();

	}

	public Collection<CatItem> getCat() {

		return catMap.values();
	}

	public Double toutlePrice() {

		if (catMap.isEmpty() || catMap.values().size() == 0) {
			return 0.0;
		} else {
			Collection<CatItem> values = catMap.values();
			BigDecimal itemPrice = new BigDecimal(0.0);

			for (CatItem catItem : values) {
				BigDecimal bigDecimal = new BigDecimal(catItem.getItemPrice());
				itemPrice = itemPrice.add(bigDecimal);
			}

			return Double.valueOf(itemPrice + "");
		}
	}
}
