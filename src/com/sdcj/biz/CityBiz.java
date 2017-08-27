package com.sdcj.biz;

import java.util.ArrayList;
import java.util.List;

import com.sdcj.dao.CityDao;
import com.sdcj.domain.City;
import com.sdcj.util.JDBCUtil;

public class CityBiz {
	public List<City> findById(int id) {
		try {
			CityDao cityDao = new CityDao();
			List<City>  cityList=new ArrayList<City>();
			cityList=cityDao.findById(id);
			return cityList;
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
			CityDao cityDao = new CityDao();
			return cityDao.findByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public void addProvinceName(String personName,String provinceName)
	{
		try {
			CityDao cityDao = new CityDao();
			cityDao.addProvinceName(personName, provinceName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	
}
