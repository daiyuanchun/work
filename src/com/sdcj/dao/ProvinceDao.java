package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Province;
import com.sdcj.util.JDBCUtil;

public class ProvinceDao {
	public Province findById(int id) throws Exception {
		String sql = "select * from  province where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1, id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Province province = new Province();
			province.setId(rs.getInt("ID"));
			province.setProvince(rs.getString("PROVINCE"));
			return province;
		} else {
			return null;
		}
	}

	public List<Province> findAll() throws Exception {
		List<Province> provinceList = new ArrayList<Province>();
		String sql = "select * from  province ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Province province = new Province();
			province.setId(rs.getInt("ID"));
			province.setProvince(rs.getString("province"));
			provinceList.add(province);
		}
		return provinceList;
	}

	public int findByName(String name) throws Exception {
		int id = 0;
		String sql = "select * from  province where PROVINCE=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			id = rs.getInt("ID");
		}
		return id;
	}

}
