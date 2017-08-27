package com.sdcj.domain;

import java.io.Serializable;

public class Manager  implements Serializable {
	private String mname;// MNAME VARCHAR2(32 BYTE)
	private String password;// PASSWORD VARCHAR2(32 BYTE)
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
