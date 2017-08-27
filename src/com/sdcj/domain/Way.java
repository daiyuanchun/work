package com.sdcj.domain;

import java.io.Serializable;

public class Way implements Serializable{
private int id;//	ID	NUMBER
private String way;//	WAY	VARCHAR2(50 BYTE)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getWay() {
	return way;
}
public void setWay(String way) {
	this.way = way;
}

}
