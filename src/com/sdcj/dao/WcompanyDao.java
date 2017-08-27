package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Wcompany;
import com.sdcj.util.JDBCUtil;

public class WcompanyDao {
	public List<Wcompany> findAll() throws Exception{
		List<Wcompany> wcompanyList=new ArrayList<Wcompany>();
		String sql="select * from WCOMPANY";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Wcompany wcompany=new Wcompany();
			wcompany.setCname(rs.getString("CNAME"));
			wcompany.setPassword(rs.getString("PASSWORD"));
			wcompany.setTel(rs.getString("TEL"));
			wcompany.setEmail(rs.getString("EMAIL"));
			wcompany.setFirm(rs.getString("FIRM"));
			wcompany.setIndustry(rs.getString("INDUSTRY"));
			wcompany.setAddress(rs.getString("ADDRESS"));
			wcompany.setPicture(rs.getString("PICTURE"));
			wcompany.setIntroduction(rs.getString("INTRODUCTION"));
			wcompany.setCimg(rs.getString("CIMG"));
			wcompany.setRimg(rs.getString("RIMG"));
			wcompany.setWebsit(rs.getString("WEBSIT"));
			wcompany.setPassmessage(rs.getString("PASSMESSAGE"));
			wcompanyList.add(wcompany);
		}
		return wcompanyList;
	}
	
	public int deletByCname(String cname) throws Exception{
		String sql="delete from WCOMPANY where CNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, cname);
		int i=prep.executeUpdate();
		return i;
	}

	public void save(Wcompany wcompany) throws Exception {
		String sql = "insert into wcompany(CNAME,PASSWORD,TEL,EMAIL,FIRM,INDUSTRY,ADDRESS,PICTURE,INTRODUCTION,CIMG,RIMG,WEBSIT,PASSMESSAGE)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, wcompany.getCname());
		pstat.setString(2, wcompany.getPassword());
		pstat.setString(3, wcompany.getTel());
		pstat.setString(4, wcompany.getEmail());
		pstat.setString(5, wcompany.getFirm());
		pstat.setString(6, wcompany.getIndustry());
		pstat.setString(7, wcompany.getAddress());
		pstat.setString(8, wcompany.getPicture());
		pstat.setString(9, wcompany.getIntroduction());
		pstat.setString(10,wcompany.getCimg());
		pstat.setString(11,wcompany.getRimg());
		pstat.setString(12,wcompany.getWebsit());
		pstat.setString(13,wcompany.getPassmessage());
		pstat.executeUpdate();
	}

	public Wcompany findByCompanyName(String companyName) throws Exception{
		String sql = "select * from wcompany where CNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, companyName);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()){
			Wcompany wcompany = new Wcompany();
			wcompany.setCname(rs.getString("CNAME"));
			wcompany.setPassword(rs.getString("PASSWORD"));
			wcompany.setTel(rs.getString("TEL"));
			wcompany.setEmail(rs.getString("EMAIL"));
			wcompany.setFirm(rs.getString("FIRM"));
			wcompany.setIndustry(rs.getString("INDUSTRY"));
			wcompany.setAddress(rs.getString("ADDRESS"));
			wcompany.setPicture(rs.getString("PICTURE"));
			wcompany.setIntroduction(rs.getString("INTRODUCTION"));
			wcompany.setCimg(rs.getString("CIMG"));
			wcompany.setRimg(rs.getString("RIMG"));
			return wcompany;
		} else {
			return null;
		}
	}

}
