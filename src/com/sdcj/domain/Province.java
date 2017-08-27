package com.sdcj.domain;

import java.io.Serializable;

public class Province implements Serializable{
private int id;//	ID	NUMBER
private String province;//	PROVINCE	VARCHAR2(32 BYTE)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
}
