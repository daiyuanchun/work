package com.sdcj.domain;

import java.io.Serializable;

public class Major implements Serializable{
private int id;//	ID	NUMBER
private String major;//	MAJOR	VARCHAR2(32 BYTE)
//	MAJOR_MESSAGE	VARCHAR2(100 BYTE)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}

}
