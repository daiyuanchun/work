package com.sdcj.domain;

import java.io.Serializable;


public class Area implements Serializable{
private int id;//	ID	NUMBER
private String area;//	AREA	VARCHAR2(32 BYTE)
private int city_id;//	CITY_ID	NUMBER
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}
public int getCity_id() {
	return city_id;
}
public void setCity_id(int city_id) {
	this.city_id = city_id;
}
}
