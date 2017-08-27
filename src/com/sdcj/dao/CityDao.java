package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.City;
import com.sdcj.util.JDBCUtil;

public class CityDao{
	
	
	public List<City> findById(int provinceId) throws Exception{
		List<City> cityList= new ArrayList<City>();
		String sql ="select  *  from  city where PROVINCE_ID ="+provinceId;
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			City city = new City();
			city.setId(rs.getInt("ID"));
			city.setCity(rs.getString("CITY"));
			city.setProvince_id(rs.getInt("PROVINCE_ID"));
			cityList.add(city);
			}
		return cityList;
	}
	public int findByName(String name) throws Exception
	{
		int id=0;
		String sql ="select * from  city where CITY=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,name);
		ResultSet rs = pstat.executeQuery();
		if(rs.next())
		{
			id=rs.getInt("ID");
		}
		return id;
	}
	public void addProvinceName(String personName,String provinceName) throws Exception
	{
		String sql ="update person_add  set province=? where pname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,provinceName);
		pstat.setString(2,personName);
	    pstat.executeUpdate();
	}
			
}
