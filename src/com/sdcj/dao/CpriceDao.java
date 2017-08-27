package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Cprice;
import com.sdcj.util.JDBCUtil;

public class CpriceDao {
	public List<Cprice> findAllByCname(String cname) throws Exception{
		List<Cprice> cpriceList = new ArrayList<Cprice>();
		String sql ="select  *  from  cprice  where cname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Cprice cprice = new Cprice();
			cprice.setCname(rs.getString("CNAME")); 
			cprice.setPost(rs.getString("POST"));
			cprice.setPrice(Integer.parseInt(rs.getString("PRICE")));
			cpriceList.add(cprice);
		}
		return cpriceList;
	}
	public void insertTable(String cname,String post,int price) throws Exception
	{
		String sql ="insert into cprice(cname,post,price)  values(?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		pstat.setString(2,post);
		pstat.setInt(3,price);
		pstat.executeUpdate();
		
	}
	public void updateTable(String cname,String post,int price) throws Exception
	{

		String sql ="update  cprice set price=? where cname = ? and post = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,price);
		pstat.setString(2,cname);
		pstat.setString(3,post);
		pstat.executeUpdate();
		
	}
	public void deleteTable(String cname,String post) throws Exception
	{

		String sql ="delete cprice where cname = ? and post = ? ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		pstat.setString(2,post);
		pstat.executeUpdate();
		
	}
}
