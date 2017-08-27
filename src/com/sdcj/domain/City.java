package com.sdcj.domain;

import java.io.Serializable;


public class City implements Serializable{
private int id;//	ID	NUMBER
private String city;//	CITY	VARCHAR2(32 BYTE)
private int province_id;//	PROVINCE_ID	NUMBER
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getProvince_id() {
	return province_id;
}
public void setProvince_id(int province_id) {
	this.province_id = province_id;
}
}
