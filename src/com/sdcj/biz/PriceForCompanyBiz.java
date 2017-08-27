package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.PriceForCompanyDao;
import com.sdcj.domain.PriceForCompany;
import com.sdcj.util.JDBCUtil;

public class PriceForCompanyBiz {
	public List<PriceForCompany> findAll() {
		try {
			PriceForCompanyDao priceDao=new PriceForCompanyDao();
			return priceDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
