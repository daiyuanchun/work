package com.sdcj.domain;

import java.io.Serializable;

public class Face implements Serializable{
private String tname;
private String pname;
private String rname;//	RNAME	VARCHAR2(32 BYTE)
private String sname;//	SNAME	VARCHAR2(32 BYTE)
private int price;//	PRICE	NUMBER
private String time;//TIME	VARCHAR2(50 BYTE)
private int last;//	LAST	NUMBER
private int sumprice;//	SUMPRICE	NUMBER
private String address;//	ADDRESS	VARCHAR2(100 BYTE)
private String tel;//TEL	VARCHAR2(100 BYTE)
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
public int getLast() {
	return last;
}
public void setLast(int last) {
	this.last = last;
}
public int getSumprice() {
	return sumprice;
}
public void setSumprice(int sumprice) {
	this.sumprice = sumprice;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}


}
