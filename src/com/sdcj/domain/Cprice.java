package com.sdcj.domain;

import java.io.Serializable;


public class Cprice implements Serializable{
private String cname;//	CNAME	VARCHAR2(100 BYTE)
private String post;//	POST	VARCHAR2(100 BYTE)
private int price;//	PRICE	NUMBER(6,0)
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

}
