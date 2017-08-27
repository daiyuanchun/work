package com.sdcj.domain;

import java.io.Serializable;

public class Chat implements Serializable {
	private String tname;// TNAME VARCHAR2(100 BYTE)
	private String pname;// PNAME VARCHAR2(100 BYTE)
	private String rname;// RNAME VARCHAR2(32 BYTE)
	private String sname;// SNAME VARCHAR2(32 BYTE)
	private int price;// PRICE NUMBER
	private int last;// LAST NUMBER
	private int sumprice;// SUMPRICE NUMBER
	private String time;// TIME VARCHAR2(50 BYTE)
	private String qq;// QQ VARCHAR2(32 BYTE)
	private String wechat;// WECHAT VARCHAR2(32 BYTE)
	private int id;// 0表示未审核 1表示已审核
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
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getWechat() {
		return wechat;
	}
	public void setWechat(String wechat) {
		this.wechat = wechat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
}
