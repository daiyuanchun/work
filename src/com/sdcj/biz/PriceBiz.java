package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.PriceDao;
import com.sdcj.domain.Price;
import com.sdcj.util.JDBCUtil;

public class PriceBiz {
	public List<Price> findAll() {
		try {
			PriceDao priceDao=new PriceDao();
			return priceDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
