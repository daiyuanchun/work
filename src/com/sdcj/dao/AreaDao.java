package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Area;
import com.sdcj.util.JDBCUtil;

public class AreaDao {
	public List<Area> findById(int cityId) throws Exception{
		List<Area> areaList= new ArrayList<Area>();
		String sql ="select * from  area where CITY_ID =?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,cityId);
		ResultSet rs = pstat.executeQuery();
		//当前的查询是按主键做为查询条件，所以查询结果只能是一条记录或没有。
		while(rs.next()){
			Area area = new Area();
			area.setId(rs.getInt("ID"));
			area.setArea(rs.getString("AREA"));
			area.setCity_id(rs.getInt("CITY_ID"));
			areaList.add(area);
		}
		return areaList;
	}
	public void addCityName(String personName,String cityName) throws Exception
	{
		String sql ="update person_add  set city=? where pname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cityName);
		pstat.setString(2,personName);
	    pstat.executeUpdate();
	}
	public void addAreaName(String personName,String areaName) throws Exception
	{
		String sql ="update person_add  set area=? where pname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,areaName);
		pstat.setString(2,personName);
	    pstat.executeUpdate();
	}
}
