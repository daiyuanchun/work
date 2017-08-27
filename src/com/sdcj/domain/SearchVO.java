package com.sdcj.domain;

import java.io.Serializable;

public class SearchVO implements Serializable{
	private Integer page;
	private Integer fieldId;
	private Integer priceId;
	private Integer provinceId;

	public SearchVO() {

	}

	public SearchVO(Integer page, Integer fieldId, Integer priceId,
			Integer provinceId) {
		super();
		this.page = page;
		this.fieldId = fieldId;
		this.priceId = priceId;
		this.provinceId = provinceId;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getFieldId() {
		return fieldId;
	}

	public void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
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
