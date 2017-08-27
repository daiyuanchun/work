package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sdcj.domain.Manager;
import com.sdcj.util.JDBCUtil;

public class ManagerDao {

	public Manager findByManagerName(String managerName) throws Exception
	{
		String sql="select * from manager where MNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, managerName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			Manager manager=new Manager();
			manager.setMname(rs.getString("MNAME"));
			manager.setPassword(rs.getString("PASSWORD"));
			return manager;
		}
		else
		{
			return null;
		}
	}
	
}
