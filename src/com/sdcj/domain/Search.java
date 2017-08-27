package com.sdcj.domain;

import java.io.Serializable;

public class Search implements Serializable{
	private Integer page;
	private Integer majorId;
	private Integer wayId;
	private Integer priceId;
	private Integer provinceId;

	public Search() {

	}

	public Search(Integer page, Integer majorId, Integer wayId,
			Integer priceId, Integer provinceId) {
		super();
		this.page = page;
		this.majorId = majorId;
		this.wayId = wayId;
		this.priceId = priceId;
		this.provinceId = provinceId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}

	public Integer getWayId() {
		return wayId;
	}

	public void setWayId(Integer wayId) {
		this.wayId = wayId;
	}

	public Integer getPriceId() {
		return priceId;
	}

	public void setPriceId(Integer priceId) {
		this.priceId = priceId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	
}
