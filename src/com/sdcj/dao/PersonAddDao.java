package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdcj.domain.PersonAdd;
import com.sdcj.util.JDBCUtil;

public class PersonAddDao {
	public int  checkName(String name) throws Exception {
		int i=0;
		String checkNameSql="select *  from person_add  where pname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(checkNameSql);
		pstat.setString(1, name);
		ResultSet rs=pstat.executeQuery();
		if(rs.next())
		{
			i=1;
		}
		
		return i;
	}
	
	public void setName(String name) throws Exception {
		String sql = "insert into PERSON_ADD(PNAME)values(?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		pstat.executeUpdate();
	}

	public void setImg(String name, String img) throws Exception {
		String sql = "update person_add  set  pimg=? where pname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, img);
		pstat.setString(2, name);
		pstat.executeUpdate();
	}
public void setSex(String name,String sex)throws Exception
{
	String sql = "update person_add  set sex=? where pname=?";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,sex);
	pstat.setString(2,name);
	pstat.executeUpdate();
	
}
public void setAge(String name,String age)throws Exception
{
	String sql = "update person_add  set age=? where pname=?";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,age);
	pstat.setString(2,name);
	pstat.executeUpdate();
	
}
public void setEmail(String name,String email)throws Exception
{
	String sql = "update person_add  set email=? where pname=?";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,email);
	pstat.setString(2,name);
	pstat.executeUpdate();
	
}

	public PersonAdd findByName(String name) throws Exception {
		String sql = "select * from person_add where PNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			PersonAdd personAdd = new PersonAdd();
			personAdd.setPname(rs.getString("PNAME"));
			personAdd.setPimg(rs.getString("PIMG"));
			personAdd.setEmail(rs.getString("EMAIL"));
			personAdd.setAge(rs.getString("AGE"));
			personAdd.setProvince(rs.getString("PROVINCE"));
			personAdd.setCity(rs.getString("CITY"));
			personAdd.setArea(rs.getString("AREA"));
			return personAdd;
		}else
		{
			return null;
		}
	}

}
