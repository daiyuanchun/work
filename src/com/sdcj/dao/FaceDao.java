package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Face;
import com.sdcj.util.JDBCUtil;

public class FaceDao {
	public void saveFace(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String tel) throws Exception
	{
    String sql = "insert into face(tname,rname,pname,sname,price,last,sumPrice,time,id,tel)values(?,?,?,?,?,?,?,?,?,?)";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,tname);
	pstat.setString(2,rname);
	pstat.setString(3,pname);
	pstat.setString(4,sname);
	pstat.setInt(5,price);
	pstat.setInt(6,last);
	pstat.setInt(7,sumPrice);
	pstat.setString(8,time);
	pstat.setInt(9,0);
	pstat.setString(10,tel);
	pstat.executeUpdate();
	}
	//改变审核状态
	public void update(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String tel,String address) throws Exception
	{
		String sql="update face set id=1,address=? where tname=? and rname=? and pname=? and sname=? and price=?  "
		 		+ "and last=? and sumPrice=?  and time=?  and tel=? ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,address);
		pstat.setString(2,tname);
		pstat.setString(3,rname);
		pstat.setString(4,pname);
		pstat.setString(5,sname);
		pstat.setInt(6,price);
		pstat.setInt(7,last);
		pstat.setInt(8,sumPrice);
		pstat.setString(9,time);
		pstat.setString(10,tel);
		int m=pstat.executeUpdate();
		System.out.println("更新了"+m+"条");
	}
	public void delete(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String tel) throws Exception
	{
		 String sql = "delete  from face where tname=? and rname=? and pname=? and sname=? and price=?   "
		 		+ "and last=? and sumPrice=?  and time=?  and tel=? ";
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1,tname);
			pstat.setString(2,rname);
			pstat.setString(3,pname);
			pstat.setString(4,sname);
			pstat.setInt(5,price);
			pstat.setInt(6,last);
			pstat.setInt(7,sumPrice);
			pstat.setString(8,time);
			pstat.setString(9,tel);
			
			pstat.executeUpdate();
	}
	public List<Face> selectFaceByTname(String tname) throws Exception
	{
		List<Face>  faceList=new ArrayList<Face>();
		String sql="select *  from face  where tname=?  and id=0";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Face face=new Face();
			face.setTname(rs.getString("TNAME"));
			face.setRname(rs.getString("RNAME"));
			face.setPname(rs.getString("PNAME"));
			face.setSname(rs.getString("SNAME"));
			face.setPrice(rs.getInt("PRICE"));
			face.setLast(rs.getInt("LAST"));
			face.setSumprice(rs.getInt("SUMPRICE"));
			face.setTime(rs.getString("TIME"));
			face.setTel(rs.getString("TEL"));
			faceList.add(face);
		}
		return faceList;
		
	}
	public List<Face> selectCheckedFaceByTname(String tname) throws Exception
	{
		List<Face>  faceCheckedList=new ArrayList<Face>();
		String sql="select *  from face  where tname=?  and id=1";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Face face=new Face();
			face.setTname(rs.getString("TNAME"));
			face.setRname(rs.getString("RNAME"));
			face.setPname(rs.getString("PNAME"));
			face.setSname(rs.getString("SNAME"));
			face.setPrice(rs.getInt("PRICE"));
			face.setLast(rs.getInt("LAST"));
			face.setSumprice(rs.getInt("SUMPRICE"));
			face.setTime(rs.getString("TIME"));
			faceCheckedList.add(face);
		}
		return faceCheckedList;
		
		
	}
	public List<Face> selectFaceByPname(String pname) throws Exception
	{
		List<Face>  faceList=new ArrayList<Face>();
		String sql="select *  from face  where pname=? and id=1";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,pname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Face face=new Face();
			face.setTname(rs.getString("TNAME"));
			face.setRname(rs.getString("RNAME"));
			face.setPname(rs.getString("PNAME"));
			face.setSname(rs.getString("SNAME"));
			face.setPrice(rs.getInt("PRICE"));
			face.setLast(rs.getInt("LAST"));
			face.setSumprice(rs.getInt("SUMPRICE"));
			face.setTime(rs.getString("TIME"));
			face.setAddress(rs.getString("ADDRESS"));
			face.setTel(rs.getString("TEL"));
			
			faceList.add(face);
		}
		return faceList;
		
	}
}
