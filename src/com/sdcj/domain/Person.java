package com.sdcj.domain;

import java.io.Serializable;

public class Person implements Serializable{

private String pname;//	PNAME	VARCHAR2(20 BYTE)
private String password;//	PASSWORD	VARCHAR2(20 BYTE)
private String passMessage;//	PASSMESSAGE	VARCHAR2(20 BYTE)
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
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

}