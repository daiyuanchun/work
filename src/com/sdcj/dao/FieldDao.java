package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Field;
import com.sdcj.util.JDBCUtil;

public class FieldDao {
	public List<Field> findAll() throws Exception{
		List<Field> fieldList = new ArrayList<Field>();
		String sql ="select * from  field ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Field field = new Field();
			field.setId(rs.getInt("ID"));  
			field.setField(rs.getString("FIELD"));    
			fieldList.add(field);
		}
		return fieldList;
	}
	
	public Field findById(int id) throws Exception {
		String sql="select * from  field where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,id);
		ResultSet rs = pstat.executeQuery();
		// ��ǰ�Ĳ�ѯ�ǰ�������Ϊ��ѯ���������Բ�ѯ���ֻ����һ����¼��û�С�
		if (rs.next()){
			Field field = new Field();
			field.setId(rs.getInt("ID"));
			field.setField(rs.getString("FIELD"));  
			return field;
		} else {
			return null;
		}
	}
}
