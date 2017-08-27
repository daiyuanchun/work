package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Price;
import com.sdcj.util.JDBCUtil;

public class PriceDao {
	public List<Price> findAll() throws Exception{
		List<Price> priceList = new ArrayList<Price>();
		String sql ="select  *  from  price";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			Price price = new Price();
			price.setId(rs.getInt("ID"));  
			price.setPriceBa(rs.getString("PRICE_BA"));
			priceList.add(price);
		}
		return priceList;
	}
	public Price findById(int id) throws Exception {
		String sql="select * from  price where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Price price = new Price();
			price.setId(rs.getInt("ID"));
			price.setPriceBa(rs.getString("PRICE_BA"));
			return price;
		} else {
			return null;
		}
	}
	
}
