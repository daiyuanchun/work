package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.PriceForCompany;
import com.sdcj.util.JDBCUtil;

public class PriceForCompanyDao {
	public List<PriceForCompany> findAll() throws Exception{
		List<PriceForCompany> priceList = new ArrayList<PriceForCompany>();
		String sql ="select  *  from  priceForCompany ";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while(rs.next()){
			PriceForCompany price = new PriceForCompany();
			price.setId(rs.getInt("ID"));  
			price.setPriceBa(rs.getString("PRICE_BA"));
			priceList.add(price);
		}
		return priceList;
	}
	public PriceForCompany findById(int id) throws Exception {
		String sql="select * from  priceForCompany where id = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setInt(1,id);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			PriceForCompany price = new PriceForCompany();
			price.setId(rs.getInt("ID"));
			price.setPriceBa(rs.getString("PRICE_BA"));
			return price;
		} else {
			return null;
		}
	}
}
