package com.sdcj.domain;

import java.io.Serializable;

public class Wvideo  implements Serializable {
//	TNAME	VARCHAR2(20 BYTE)
//	RNAME	VARCHAR2(20 BYTE)
//	VIDEO	VARCHAR2(600 BYTE)
//	PHOTO	VARCHAR2(500 BYTE)
//	TITLE	VARCHAR2(100 BYTE)
	private String tname;
	private String rname;
	private String video;
	private String photo;
	private String title;
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
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
