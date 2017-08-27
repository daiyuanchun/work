package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Way;
import com.sdcj.util.JDBCUtil;

public class WayDao {
	public List<Way> findAll() throws Exception{
		List<Way> wayList = new ArrayList<Way>();
		String sql ="select * from  way ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Way way = new Way();
			way.setId(rs.getInt("ID"));  
			way.setWay(rs.getString("WAY")); 
			wayList.add(way);
		}
		return wayList;
	}
	
	public Way findById(int id) throws Exception {
		String sql="select  *  from  way where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,id);
		ResultSet rs = pstat.executeQuery();
		// 当前的查询是按主键做为查询条件，所以查询结果只能是一条记录或没有。
		if (rs.next()) {
			Way way = new Way();
			way.setId(rs.getInt("ID"));
			way.setWay(rs.getString("WAY")); 
			return way;
		} else {
			return null;
		}
	}
	
}
