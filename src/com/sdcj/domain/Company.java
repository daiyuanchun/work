package com.sdcj.domain;

import java.io.Serializable;


public class Company implements Serializable {
	private String cname;// CNAME VARCHAR2(20 BYTE)
	private String password;// PASSWORD VARCHAR2(20 BYTE)
	private String passMessage;//	PASSMESSAGE	VARCHAR2(20 BYTE)
	private String tel;// TEL VARCHAR2(20 BYTE)
	private String email;// EMAIL VARCHAR2(20 BYTE)
	private String firm;// FIRM VARCHAR2(50 BYTE)
	private String industry;// INDUSTRY VARCHAR2(20 BYTE)
	private String address;// ADDRESS VARCHAR2(50 BYTE)
	private String picture;// PICTURE VARCHAR2(500 BYTE)
	private String introduction;// INTRODUCTION VARCHAR2(500 BYTE)
	private String cimg;// CIMG VARCHAR2(500 BYTE)
	private String rimg;// RIMG VARCHAR2(500 BYTE)
	private String websit;// WEBSIT VARCHAR2(50 BYTE)
	private Field fieldId;// FIELD_ID NUMBER(6,0)
	private PriceForCompany priceId;// PRICE_ID NUMBER(6,0)
	private Province provinceId;// PROVINCE_ID NUMBER(6,0)
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassMessage() {
		return passMessage;
	}
	public void setPassMessage(String passMessage) {
		this.passMessage = passMessage;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirm() {
		return firm;
	}
	public void setFirm(String firm) {
		this.firm = firm;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public String getRimg() {
		return rimg;
	}
	public void setRimg(String rimg) {
		this.rimg = rimg;
	}
	public String getWebsit() {
		return websit;
	}
	public void setWebsit(String websit) {
		this.websit = websit;
	}
	public Field getFieldId() {
		return fieldId;
	}
	public void setFieldId(Field fieldId) {
		this.fieldId = fieldId;
	}
	public PriceForCompany getPriceId() {
		return priceId;
	}
	public void setPriceId(PriceForCompany priceId) {
		this.priceId = priceId;
	}
	public Province getProvinceId() {
		return provinceId;
	}
	public void setProvinceId(Province provinceId) {
		this.provinceId = provinceId;
	}
	
}