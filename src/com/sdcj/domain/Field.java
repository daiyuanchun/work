package com.sdcj.domain;

import java.io.Serializable;

public class Field implements Serializable{
private int id;//	ID	NUMBER(6,0)
private String field;//	FIELD	VARCHAR2(50 BYTE)
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getField() {
	return field;
}
public void setField(String field) {
	this.field = field;
}

}
