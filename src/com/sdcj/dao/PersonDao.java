package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdcj.domain.Person;
import com.sdcj.util.JDBCUtil;

public class PersonDao {
	public void save(Person person) throws Exception {
		String sql = "insert into PERSON(PNAME,PASSWORD,PASSMESSAGE)values(?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, person.getPname());
		pstat.setString(2, person.getPassword());
		pstat.setString(3, person.getPassMessage());
        pstat.executeUpdate();
	}
	public Person findByPersonName(String personName) throws Exception
	{
		String sql="select * from person where PNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, personName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			Person person=new Person();
			person.setPname(rs.getString("PNAME"));
			person.setPassword(rs.getString("PASSWORD"));
			person.setPassMessage(rs.getString("PASSMESSAGE"));
			return person;
		}
		else
		{
			return null;
		}
	}
	public String findPassmessage(String userName) throws Exception
	{
		String passmessage=null;
		String sql="select * from person where PNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			passmessage=rs.getString("PASSMESSAGE");
		}
		return passmessage;
	}
	
	public int updatePassword(String password,String pname) throws Exception{
		String sql="update PERSON set PASSWORD = ? where PNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, password);
		prep.setString(2, pname);
		int i=prep.executeUpdate();
		return i;
	}
			
}

