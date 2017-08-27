package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Major;
import com.sdcj.util.JDBCUtil;

public class MajorDao {
	public List<Major> findAll() throws Exception{
		List<Major> majorList = new ArrayList<Major>();
		String sql ="select * from  major ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Major major = new Major();
			major.setId(rs.getInt("ID"));  
			major.setMajor(rs.getString("MAJOR"));    
			majorList.add(major);
		}
		return majorList;
	}
	
	public Major findById(int id) throws Exception {
		String sql="select * from  major where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,id);
		ResultSet rs = pstat.executeQuery();
		// ��ǰ�Ĳ�ѯ�ǰ�������Ϊ��ѯ���������Բ�ѯ���ֻ����һ����¼��û�С�
		if (rs.next()){
			Major major = new Major();
			major.setId(rs.getInt("ID"));
			major.setMajor(rs.getString("MAJOR"));
			return major;
		} else {
			return null;
		}
	}
}
