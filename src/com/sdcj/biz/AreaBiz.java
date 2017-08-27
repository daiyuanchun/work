package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.AreaDao;
import com.sdcj.domain.Area;
import com.sdcj.util.JDBCUtil;

public class AreaBiz{
	public List<Area> findAll(int id) {
		try {
			AreaDao areaDao = new AreaDao();
			return areaDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public void addCityName(String personName,String cityName)
	{
		try {
			AreaDao areaDao = new AreaDao();
			areaDao.addCityName(personName,cityName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}	
	}
	public void addAreaName(String personName,String areaName)
	{
		try {
			AreaDao areaDao = new AreaDao();
			areaDao.addAreaName(personName, areaName);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
}
