package com.sdcj.domain;

import java.io.Serializable;

public class Wteacher implements Serializable{

private String tname;//	TNAME	VARCHAR2(20 BYTE)
private String rname;//	RNAME	VARCHAR2(20 BYTE)
private String password;//	PASSWORD	VARCHAR2(20 BYTE)
private String passmessage;
private String tel;//	TEL	VARCHAR2(20 BYTE)
private String email;//	EMAIL	VARCHAR2(20 BYTE)
private String major;//	MAJOR	VARCHAR2(20 BYTE)
private String school;//	SCHOOL	VARCHAR2(20 BYTE)
private String qq;//	QQ	VARCHAR2(20 BYTE)
private String wechat;//	WECHAT	VARCHAR2(20 BYTE)
private String identification;//	IDENTIFICATION	VARCHAR2(500 BYTE)
private String introduction;//	INTRODUCTION	VARCHAR2(200 BYTE)
private String timg;//	IMG	VARCHAR2(500 BYTE)
private String rimg;//	RIMG	VARCHAR2(500 BYTE)
public String getTname() {
	return tname;
}
public void setTname(String tname) {
	this.tname = tname;
}
public String getRname() {
	return rname;
}
public void setRname(String rname) {
	this.rname = rname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPassmessage() {
	return passmessage;
}
public void setPassmessage(String passmessage) {
	this.passmessage = passmessage;
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
public String getMajor() {
	return major;
}
public void setMajor(String major) {
	this.major = major;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
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
public String getIdentification() {
	return identification;
}
public void setIdentification(String identification) {
	this.identification = identification;
}
public String getIntroduction() {
	return introduction;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}
public String getTimg() {
	return timg;
}
public void setTimg(String timg) {
	this.timg = timg;
}
public String getRimg() {
	return rimg;
}
public void setRimg(String rimg) {
	this.rimg = rimg;
}

}
