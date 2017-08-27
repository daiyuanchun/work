package com.sdcj.domain;

import java.io.Serializable;

public class Experience implements Serializable{
private String cname;//	CNAME	VARCHAR2(100 BYTE)
private String firm;//	FIRM	VARCHAR2(100 BYTE)
private String pname;//	PNAME	VARCHAR2(100 BYTE)
private String sname;//	SNAME	VARCHAR2(100 BYTE)
private String field;//	FIELD	VARCHAR2(100 BYTE)
private int price;//	PRICE	NUMBER(6,0)
private int last;//	LAST	NUMBER(6,0)
private int sumPrice;//	SUMPRICE	NUMBER(6,0)
private String time;//	TIME	VARCHAR2(100 BYTE)

public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getFirm() {
	return firm;
}
public void setFirm(String firm) {
	this.firm = firm;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getLast() {
	return last;
}
public void setLast(int last) {
	this.last = last;
}
public int getSumPrice() {
	return sumPrice;
}
public void setSumPrice(int sumPrice) {
	this.sumPrice = sumPrice;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
	
	
}

