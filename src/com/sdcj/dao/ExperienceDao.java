package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Experience;
import com.sdcj.util.JDBCUtil;

public class ExperienceDao {
	public void updateId(String cname,String firm,String pname,String sname,String field,int price,int last,int sumPrice,String time) throws Exception
	{
		String sql="update experience set id=1 where cname=? and firm=? and pname=? and sname=? and field=? and price=? and last=? and sumPrice=? and time=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		pstat.setString(2,firm);
		pstat.setString(3,pname);
		pstat.setString(4,sname);
		pstat.setString(5,field);
		pstat.setInt(6,price);
		pstat.setInt(7,last);
		pstat.setInt(8,sumPrice);
		pstat.setString(9,time);
		pstat.executeUpdate();
		
	}
	public void save(String cname,String firm,String pname,String sname,String field,int price,int last,int sumPrice,String time) throws Exception
	{
		String sql="insert into experience(cname,firm,pname,sname,field,price,last,sumPrice,time,id)  values(?,?,?,?,?,?,?,?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		pstat.setString(2,firm);
		pstat.setString(3,pname);
		pstat.setString(4,sname);
		pstat.setString(5,field);
		pstat.setInt(6,price);
		pstat.setInt(7,last);
		pstat.setInt(8,sumPrice);
		pstat.setString(9,time);
		pstat.setInt(10,0);
		
		pstat.executeUpdate();
	}
	public void delete(String cname,String firm,String pname,String sname,String field,int price,int last,int sumPrice,String time) throws Exception
	{
		String sql="delete experience where cname=? and firm=? and pname=? and sname=? and field=? and price=? and last=? and sumPrice=? and time=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,cname);
		pstat.setString(2,firm);
		pstat.setString(3,pname);
		pstat.setString(4,sname);
		pstat.setString(5,field);
		pstat.setInt(6,price);
		pstat.setInt(7,last);
		pstat.setInt(8,sumPrice);
		pstat.setString(9,time);
		pstat.executeUpdate();
	}
    public List<Experience> findByCname(String cname) throws Exception{
	String sql="select *  from experience where  cname=? and id=0 ";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,cname);
	ResultSet rs=pstat.executeQuery();
	List<Experience> experienceList=new ArrayList<Experience>();
	while(rs.next())
	{
		Experience experience=new Experience();
		experience.setCname(rs.getString("CNAME"));
		experience.setFirm(rs.getString("FIRM"));
		experience.setPname(rs.getString("PNAME"));
		experience.setSname(rs.getString("SNAME"));
		experience.setField(rs.getString("FIELD"));
		experience.setPrice(rs.getInt("PRICE"));
		experience.setLast(rs.getInt("LAST"));
		experience.setSumPrice(rs.getInt("SUMPRICE"));
		experience.setTime(rs.getString("TIME"));
		experienceList.add(experience);
	}
	return experienceList;
}
    public List<Experience> findCheckedByCname(String cname) throws Exception{
    	String sql="select *  from experience where  cname=? and id=1 ";
    	Connection conn = JDBCUtil.getConnection();
    	PreparedStatement pstat = conn.prepareStatement(sql);
    	pstat.setString(1,cname);
    	ResultSet rs=pstat.executeQuery();
    	List<Experience> experienceList=new ArrayList<Experience>();
    	while(rs.next())
    	{
    		Experience experience=new Experience();
    		experience.setCname(rs.getString("CNAME"));
    		experience.setFirm(rs.getString("FIRM"));
    		experience.setPname(rs.getString("PNAME"));
    		experience.setSname(rs.getString("SNAME"));
    		experience.setField(rs.getString("FIELD"));
    		experience.setPrice(rs.getInt("PRICE"));
    		experience.setLast(rs.getInt("LAST"));
    		experience.setSumPrice(rs.getInt("SUMPRICE"));
    		experience.setTime(rs.getString("TIME"));
    		experienceList.add(experience);
    	}
    	return experienceList;
    }
    public List<Experience> findByPname(String pname) throws Exception{
    	String sql="select  *  from experience where  pname=? and id=1 ";
    	Connection conn = JDBCUtil.getConnection();
    	PreparedStatement pstat = conn.prepareStatement(sql);
    	pstat.setString(1,pname);
    	ResultSet rs=pstat.executeQuery();
    	List<Experience> experienceList=new ArrayList<Experience>();
    	while(rs.next())
    	{
    		Experience experience=new Experience();
    		experience.setCname(rs.getString("CNAME"));
    		experience.setFirm(rs.getString("FIRM"));
    		experience.setPname(rs.getString("PNAME"));
    		experience.setSname(rs.getString("SNAME"));
    		experience.setField(rs.getString("FIELD"));
    		experience.setPrice(rs.getInt("PRICE"));
    		experience.setLast(rs.getInt("LAST"));
    		experience.setSumPrice(rs.getInt("SUMPRICE"));
    		experience.setTime(rs.getString("TIME"));
    		experienceList.add(experience);
    	}
    	return experienceList;
    }
}
