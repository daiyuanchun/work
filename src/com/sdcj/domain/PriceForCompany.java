package com.sdcj.domain;

import java.io.Serializable;

public class PriceForCompany implements Serializable{
	private int id;// ID NUMBER(6,0)
	private String priceBa;// PRICE_BA VARCHAR2(50 BYTE)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPriceBa() {
		return priceBa;
	}
	public void setPriceBa(String priceBa) {
		this.priceBa = priceBa;
	}

}
