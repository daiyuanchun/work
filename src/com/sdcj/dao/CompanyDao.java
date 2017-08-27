package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Company;
import com.sdcj.domain.PriceForCompany;
import com.sdcj.domain.SearchVO;
import com.sdcj.domain.Wcompany;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.SQLUtil;

public class CompanyDao {
	public void saveMany(String lastCname,String  cname,String  tel,String  email,String firm, 
			String industry,String  address,String  websit,String introduction, 
			int provinceId,int fieldId) throws Exception {
String sql="update  company set cname=?,tel=?,email=?,firm=?,"
		+ "industry=?,address=?,websit=?,introduction=?,province_id=?,field_id=?   where cname=?";
Connection conn = JDBCUtil.getConnection();
PreparedStatement pstat = conn.prepareStatement(sql);
pstat.setString(1,cname);
pstat.setString(2,tel);
pstat.setString(3,email);
pstat.setString(4,firm);
pstat.setString(5,industry);
pstat.setString(6,address);
pstat.setString(7,websit);
pstat.setString(8,introduction);
pstat.setInt(9,provinceId);
pstat.setInt(10,fieldId);
pstat.setString(11,lastCname);
		pstat.executeUpdate();
	}

	public void saveTimg(String name, String img) throws Exception {
		String sql = "update company set cimg=? where cname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, img);
		pstat.setString(2, name);
		pstat.executeUpdate();
	}

	public void saveRimg(String name, String img) throws Exception {
		String sql = "update company set rimg=? where cname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, img);
		pstat.setString(2, name);
		pstat.executeUpdate();
	}

	public void save(Wcompany wcompany) throws Exception {
		String sql = "insert into COMPANY(CNAME,PASSWORD,TEL,EMAIL,FIRM,INDUSTRY,ADDRESS,PICTURE,INTRODUCTION,CIMG,RIMG,WEBSIT,PASSMESSAGE)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
		pstat.setString(10, wcompany.getCimg());
		pstat.setString(11, wcompany.getRimg());
		pstat.setString(12, wcompany.getWebsit());
		pstat.setString(13, wcompany.getPassmessage());
		pstat.executeUpdate();
	}

	public List<Company> SearchByName(String companyName) throws Exception {
		String sql = "select * from company  where firm=%" + companyName + "%";
		List<Company> companyList = new ArrayList<Company>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Company company = new Company();
			company.setCname(rs.getString("CNAME"));
			company.setFirm(rs.getString("FIRM"));
			company.setIndustry(rs.getString("INDUSTRY"));
			company.setEmail(rs.getString("EMAIL"));
			company.setAddress(rs.getString("ADDRESS"));
			company.setCimg(rs.getString("CIMG"));
			company.setIntroduction(rs.getString("INTRODUCTION"));
			company.setRimg(rs.getString("RIMG"));
			company.setTel(rs.getString("TEL"));
			company.setWebsit(rs.getString("WEBSIT"));
			FieldDao fieldDao = new FieldDao();
			company.setFieldId(fieldDao.findById(rs.getInt("FIELD_ID")));
			ProvinceDao provinceDao = new ProvinceDao();
			company.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceForCompanyDao priceForCompanyDao = new PriceForCompanyDao();
			company.setPriceId(priceForCompanyDao.findById(rs.getInt("PRICE_ID")));

			companyList.add(company);
		}
		return companyList;
	}

	public Company findByCompanyName(String companyName) throws Exception {
		String sql = "select * from COMPANY where CNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, companyName);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Company company = new Company();
			company.setCname(rs.getString("CNAME"));
			company.setPassword(rs.getString("PASSWORD"));
			company.setTel(rs.getString("TEL"));
			company.setEmail(rs.getString("EMAIL"));
			company.setFirm(rs.getString("FIRM"));
			company.setIndustry(rs.getString("INDUSTRY"));
			company.setAddress(rs.getString("ADDRESS"));
			company.setPicture(rs.getString("PICTURE"));
			company.setIntroduction(rs.getString("INTRODUCTION"));
			company.setCimg(rs.getString("CIMG"));
			company.setRimg(rs.getString("RIMG"));
			company.setWebsit(rs.getString("WEBSIT"));
			FieldDao fieldDao = new FieldDao();
			company.setFieldId(fieldDao.findById(rs.getInt("FIELD_ID")));
			ProvinceDao provinceDao = new ProvinceDao();
			company.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceForCompanyDao priceForCompanyDao = new PriceForCompanyDao();
			company.setPriceId(priceForCompanyDao.findById(rs.getInt("PRICE_ID")));
			return company;
		} else {
			return null;
		}
	}

	public Company findByName(String name) throws Exception {
		String sql = "select  *  from company where cname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Company company = new Company();
			company.setCname(rs.getString("CNAME"));
			company.setFirm(rs.getString("FIRM"));
			company.setIndustry(rs.getString("INDUSTRY"));
			company.setEmail(rs.getString("EMAIL"));
			company.setAddress(rs.getString("ADDRESS"));
			company.setCimg(rs.getString("CIMG"));
			company.setIntroduction(rs.getString("INTRODUCTION"));
			company.setRimg(rs.getString("RIMG"));
			company.setTel(rs.getString("TEL"));
			company.setWebsit(rs.getString("WEBSIT"));
			FieldDao fieldDao = new FieldDao();
			company.setFieldId(fieldDao.findById(rs.getInt("FIELD_ID")));
			ProvinceDao provinceDao = new ProvinceDao();
			company.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceForCompanyDao priceForCompanyDao = new PriceForCompanyDao();
			company.setPriceId(priceForCompanyDao.findById(rs.getInt("PRICE_ID")));

			return company;
		} else {
			return null;
		}
	}

	public String getWhere(SearchVO searchVO) {
		String wheresql = " where 1=1  ";
		if (searchVO.getFieldId() != null && searchVO.getFieldId() != -1) {
			wheresql += " and FIELD_ID = " + searchVO.getFieldId();
		}

		if (searchVO.getPriceId() != null && searchVO.getPriceId() != -1) {
			wheresql += " and PRICE_ID = " + searchVO.getPriceId();
		}
		if (searchVO.getProvinceId() != null && -1 != searchVO.getProvinceId()) {
			wheresql += " and PROVINCE_ID = " + searchVO.getProvinceId();
		}
		return wheresql;
	}

	public int findCountBySearch(SearchVO searchVO) throws Exception {
		String sql = "select count(*) from company   ";
		sql += getWhere(searchVO);
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	public List<Company> findBySearch(SearchVO searchVO) throws Exception {
		String sql = "select * from company  ";
		sql = sql + getWhere(searchVO);
		String pageSql = SQLUtil.getPageSql(sql, searchVO.getPage(), 5);
		List<Company> wcompanyList = new ArrayList<Company>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(pageSql);
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			Company company = new Company();
			company.setCname(rs.getString("CNAME"));
			company.setFirm(rs.getString("FIRM"));
			company.setIndustry(rs.getString("INDUSTRY"));
			company.setEmail(rs.getString("EMAIL"));
			company.setAddress(rs.getString("ADDRESS"));
			company.setCimg(rs.getString("CIMG"));
			company.setIntroduction(rs.getString("INTRODUCTION"));
			company.setRimg(rs.getString("RIMG"));
			company.setTel(rs.getString("TEL"));
			company.setWebsit(rs.getString("WEBSIT"));
			FieldDao fieldDao = new FieldDao();
			company.setFieldId(fieldDao.findById(rs.getInt("FIELD_ID")));
			ProvinceDao provinceDao = new ProvinceDao();
			company.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceForCompanyDao priceForCompanyDao = new PriceForCompanyDao();
			company.setPriceId(priceForCompanyDao.findById(rs.getInt("PRICE_ID")));

			wcompanyList.add(company);
		}
		return wcompanyList;
	}

	public Company findCompanyName(String userName) throws Exception {
		String sql = "select  *  from COMPANY where CNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			Company company = new Company();
			company.setCname(rs.getString("CNAME"));
			return company;
		}
		return null;
	}

	public String findPassmessage(String userName) throws Exception {
		String passmessage = null;
		String sql = "select * from COMPANY where CNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if (rs.next()) {
			passmessage = rs.getString("PASSMESSAGE");
		}
		return passmessage;
	}

	public int updatePassword(String password, String cname) throws Exception {
		String sql = "update COMPANY set PASSWORD = ? where CNAME = ?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement prep = conn.prepareStatement(sql);
		prep.setString(1, password);
		prep.setString(2, cname);
		int i = prep.executeUpdate();
		return i;
	}

	public void updatePriceId(String cname,int priceId) throws Exception {
	Company company=findByName(cname);
	System.out.println(company.getAddress());
	PriceForCompany priceId1=company.getPriceId();
	System.out.println(priceId1+"zheshi1   "+priceId);
	
	if((priceId1!=null)&&(priceId1.getId()>priceId)){
		System.out.println("出问题了！");
	}else
	{
	String sql="update company set  PRICE_ID=?  where  cname=? ";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement prep = conn.prepareStatement(sql);
	prep.setInt(1, priceId);
	prep.setString(2, cname);
	prep.executeUpdate();
	System.out.println("更新了");
	}
	}
}
