package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.ProvinceDao;
import com.sdcj.domain.Province;
import com.sdcj.util.JDBCUtil;

public class ProvinceBiz{
	public List<Province> findAll() {
		try {
			ProvinceDao provinceDao = new ProvinceDao();
			return provinceDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public int findByName(String name)
	{
		
		try {
			ProvinceDao provinceDao = new ProvinceDao();
			return provinceDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
