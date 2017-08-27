package com.sdcj.domain;

public class PersonAdd{
private String pname;//	PNAME	VARCHAR2(20 BYTE)
private String pimg;//	PIMG	VARCHAR2(500 BYTE)
private String email;//	EMAIL	VARCHAR2(32 BYTE)
private String age;//	AGE	VARCHAR2(32 BYTE)
private String province;//	PROVINCE	VARCHAR2(32 BYTE)
private String city;//	CITY	VARCHAR2(32 BYTE)
private String area;//	AREA	VARCHAR2(32 BYTE)
public String getPname() {
	return pname;
}
public void setPname(String pname) {
	this.pname = pname;
}
public String getPimg() {
	return pimg;
}
public void setPimg(String pimg) {
	this.pimg = pimg;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getAge() {
	return age;
}
public void setAge(String age) {
	this.age = age;
}
public String getProvince() {
	return province;
}
public void setProvince(String province) {
	this.province = province;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getArea() {
	return area;
}
public void setArea(String area) {
	this.area = area;
}

}
