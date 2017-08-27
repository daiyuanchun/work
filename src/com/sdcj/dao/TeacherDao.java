package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Search;
import com.sdcj.domain.Teacher;
import com.sdcj.domain.Wteacher;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.SQLUtil;

public class TeacherDao {
	public void save(Wteacher wteacher) throws Exception {
		String sql = "insert into TEACHER(TNAME,RNAME,PASSWORD,TEL,EMAIL,MAJOR,SCHOOL,QQ,WECHAT,IDENTIFICATION,INTRODUCTION,TIMG,RIMG,PASSMESSAGE)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, wteacher.getTname());
		pstat.setString(2, wteacher.getRname());
		pstat.setString(3, wteacher.getPassword());
		pstat.setString(4, wteacher.getTel());
        pstat.setString(5, wteacher.getEmail());
        pstat.setString(6, wteacher.getMajor());
        pstat.setString(7, wteacher.getSchool());
        pstat.setString(8, wteacher.getQq());
        pstat.setString(9, wteacher.getWechat());
        pstat.setString(10, wteacher.getIdentification());
        pstat.setString(11, wteacher.getIntroduction());
        pstat.setString(12, wteacher.getTimg());
        pstat.setString(13, wteacher.getRimg());
        pstat.setString(14,wteacher.getPassmessage());
        pstat.executeUpdate();
	}
	
	public  Teacher findByTeacherName(String teacherName) throws Exception
	{
		String sql="select * from TEACHER where TNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,teacherName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			Teacher teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			teacher.setRname(rs.getString("RNAME"));
			teacher.setPassword(rs.getString("PASSWORD"));
			teacher.setTel(rs.getString("TEL"));
			teacher.setEmail(rs.getString("EMAIL"));
			teacher.setMajor(rs.getString("MAJOR"));
			teacher.setSchool(rs.getString("SCHOOL"));
			teacher.setQq(rs.getString("QQ"));
			teacher.setWechat(rs.getString("WECHAT"));
			teacher.setIdentification(rs.getString("IDENTIFICATION"));
			teacher.setIntroduction(rs.getString("INTRODUCTION"));
			teacher.setTimg(rs.getString("TIMG"));
			teacher.setRimg(rs.getString("RIMG"));
			teacher.setVideo(rs.getString("VIDEO"));
			MajorDao  majorDao=new MajorDao();
			teacher.setMajorId(majorDao.findById(rs.getInt("MAJOR_ID")));
			ProvinceDao provinceDao=new ProvinceDao();
			teacher.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceDao priceDao=new PriceDao();
			teacher.setPricexId(priceDao.findById(rs.getInt("PRICEX_ID")));
			teacher.setPriceyId(priceDao.findById(rs.getInt("PRICEY_ID")));
			WayDao wayDao=new WayDao();
			teacher.setWayId(wayDao.findById(rs.getInt("WAY_ID")));
			teacher.setPricex(rs.getInt("PRICEX"));
			teacher.setPricey(rs.getInt("PRICEY"));
			return teacher;
		}
		else
		{
			return null;
		}
	}
	public List<Teacher> SearchByName(String  teacherName) throws Exception
	{
		String sql="select * from teacher where rname=? ";
		List<Teacher> teacherList=new ArrayList<Teacher>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,teacherName);
		ResultSet  rs=pstat.executeQuery();
		
		while(rs.next())
		{
			Teacher  teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			teacher.setRname(rs.getString("RNAME"));
			teacher.setTel(rs.getString("TEL"));
			teacher.setEmail(rs.getString("EMAIL"));
			teacher.setMajor(rs.getString("MAJOR"));
			teacher.setSchool(rs.getString("SCHOOL"));
			teacher.setQq(rs.getString("QQ"));
			teacher.setWechat(rs.getString("WECHAT"));
			teacher.setIdentification(rs.getString("IDENTIFICATION"));
			teacher.setIntroduction(rs.getString("INTRODUCTION"));
			teacher.setTimg(rs.getString("TIMG"));
			teacher.setRimg(rs.getString("RIMG"));
			teacher.setVideo(rs.getString("VIDEO"));
			MajorDao  majorDao=new MajorDao();
			teacher.setMajorId(majorDao.findById(rs.getInt("MAJOR_ID")));
			ProvinceDao provinceDao=new ProvinceDao();
			teacher.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceDao priceDao=new PriceDao();
			teacher.setPricexId(priceDao.findById(rs.getInt("PRICEX_ID")));
			teacher.setPriceyId(priceDao.findById(rs.getInt("PRICEY_ID")));
			WayDao wayDao=new WayDao();
			teacher.setWayId(wayDao.findById(rs.getInt("WAY_ID")));
			teacherList.add(teacher);
		}
		return teacherList;
	}
	public Teacher  findByName(String name) throws Exception
	{
		String sql="select  *  from TEACHER where TNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		ResultSet  rs=pstat.executeQuery();
		if(rs.next())
		{
			Teacher  teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			teacher.setRname(rs.getString("RNAME"));
			teacher.setTel(rs.getString("TEL"));
			teacher.setEmail(rs.getString("EMAIL"));
			teacher.setMajor(rs.getString("MAJOR"));
			teacher.setSchool(rs.getString("SCHOOL"));
			teacher.setQq(rs.getString("QQ"));
			teacher.setWechat(rs.getString("WECHAT"));
			teacher.setIdentification(rs.getString("IDENTIFICATION"));
			teacher.setIntroduction(rs.getString("INTRODUCTION"));
			teacher.setTimg(rs.getString("TIMG"));
			teacher.setRimg(rs.getString("RIMG"));
			MajorDao  majorDao=new MajorDao();
			teacher.setMajorId(majorDao.findById(rs.getInt("MAJOR_ID")));
			ProvinceDao provinceDao=new ProvinceDao();
			teacher.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceDao priceDao=new PriceDao();
			teacher.setPricexId(priceDao.findById(rs.getInt("PRICEX_ID")));
			teacher.setPriceyId(priceDao.findById(rs.getInt("PRICEY_ID")));
			WayDao wayDao=new WayDao();
			teacher.setWayId(wayDao.findById(rs.getInt("WAY_ID")));
			teacher.setPricex(rs.getInt("PRICEX"));
			teacher.setPricey(rs.getInt("PRICEY"));
			return teacher;
		}
		else
		{
			return null;
		}
	}
	public String getWhere(Search search) {
		String wheresql = " where 1=1  ";
		if (search.getMajorId()!= null &&search.getMajorId()!=-1) {
			wheresql += " and MAJOR_ID = " + search.getMajorId();
		}
		if (search.getWayId() != null&&search.getWayId() != -1) {
			wheresql += " and WAY_ID = " + search.getWayId();
		}
		if (search.getPriceId()!= null && search.getPriceId() != -1) {
			if(search.getWayId() == -1)
			{
				wheresql += " and (PRICEX_ID = " + search.getPriceId();
				wheresql += "  or PRICEY_ID = " + search.getPriceId()+")";
			}
			if (search.getWayId()==1) 
			{
				wheresql += " and PRICEX_ID = " + search.getPriceId();
			}
			if (search.getWayId()==2) 
			{
				wheresql += " and PRICEY_ID = " + search.getPriceId();
			}
			if(search.getWayId() ==3)
			{
				wheresql += " and  PRICEX_ID = " + search.getPriceId();
				wheresql += "  and PRICEY_ID = " + search.getPriceId();
			}
			
		}
		if (search.getProvinceId()!= null && -1 != search.getProvinceId()) {
			wheresql += " and PROVINCE_ID = " + search.getProvinceId();
		}
		return wheresql;
	}

	public int findCountBySearch(Search search) throws Exception {
		String sql = "select count(*) from teacher   ";
		sql += getWhere(search);
		System.out.println(sql);
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		ResultSet rs = pstat.executeQuery();
		rs.next();
		return rs.getInt(1);
	}


	public List<Teacher> findBySearch(Search search) throws Exception
	{
		String sql="select * from teacher  ";
		sql = sql + getWhere(search);
		String pageSql = SQLUtil.getPageSql(sql,search.getPage(),5);
		List<Teacher> wteacherList=new ArrayList<Teacher>();
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(pageSql);
		ResultSet  rs=pstat.executeQuery();
		while(rs.next())
		{
			Teacher  teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			teacher.setRname(rs.getString("RNAME"));
			teacher.setTel(rs.getString("TEL"));
			teacher.setEmail(rs.getString("EMAIL"));
			teacher.setMajor(rs.getString("MAJOR"));
			teacher.setSchool(rs.getString("SCHOOL"));
			teacher.setQq(rs.getString("QQ"));
			teacher.setWechat(rs.getString("WECHAT"));
			teacher.setIdentification(rs.getString("IDENTIFICATION"));
			teacher.setIntroduction(rs.getString("INTRODUCTION"));
			teacher.setTimg(rs.getString("TIMG"));
			teacher.setRimg(rs.getString("RIMG"));
			MajorDao  majorDao=new MajorDao();
			teacher.setMajorId(majorDao.findById(rs.getInt("MAJOR_ID")));
			ProvinceDao provinceDao=new ProvinceDao();
			teacher.setProvinceId(provinceDao.findById(rs.getInt("PROVINCE_ID")));
			PriceDao priceDao=new PriceDao();
			teacher.setPricexId(priceDao.findById(rs.getInt("PRICEX_ID")));
			teacher.setPriceyId(priceDao.findById(rs.getInt("PRICEY_ID")));
			WayDao wayDao=new WayDao();
			teacher.setWayId(wayDao.findById(rs.getInt("WAY_ID")));
			wteacherList.add(teacher);
		}
		return wteacherList;
}
	
	public void saveTimg(String name, String img) throws Exception {
		String sql = "update teacher set timg=? where tname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, img);
		pstat.setString(2, name);
		pstat.executeUpdate();
	}
	public void saveRimg(String name, String img) throws Exception {
		String sql = "update teacher set rimg=? where tname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, img);
		pstat.setString(2, name);
		pstat.executeUpdate();
	}

	public void saveMany(String lastTname,String tname, String rname, String tel, String email,
			String major, String school, String qq, String wechat,String introduction,int provinceId,int majorId,
			int wayId,int pricexId,int priceyId,int pricex,int pricey) throws Exception {
		String sql = "update teacher set tname=?,rname=?,tel=?,email=?,major=?,school=?,qq=?,"
				+ "wechat=?,introduction=?,PROVINCE_ID=?,MAJOR_ID=?,WAY_ID=?,PRICEX_ID=?,"
				+ "PRICEY_ID=?,PRICEX=?,PRICEY=?  where tname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		pstat.setString(2,rname);
		pstat.setString(3,tel);
		pstat.setString(4,email);
		pstat.setString(5,major);
		pstat.setString(6,school);
		pstat.setString(7,qq);
		pstat.setString(8,wechat);
		pstat.setString(9,introduction);
		pstat.setInt(10,provinceId);
		pstat.setInt(11,majorId);
		pstat.setInt(12,wayId);
		pstat.setInt(13,pricexId);
		pstat.setInt(14,priceyId);
		pstat.setInt(15,pricex);
		pstat.setInt(16,pricey);
		pstat.setString(17,lastTname);
		pstat.executeUpdate();
	}
	
	public Teacher  findByNameForMany(String name) throws Exception
	{
		String sql="select  *  from teacher where tname=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, name);
		ResultSet  rs=pstat.executeQuery();
		if(rs.next())
		{
			Teacher  teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			teacher.setRname(rs.getString("RNAME"));
			teacher.setTel(rs.getString("TEL"));
			teacher.setEmail(rs.getString("EMAIL"));
			teacher.setMajor(rs.getString("MAJOR"));
			teacher.setSchool(rs.getString("SCHOOL"));
			teacher.setQq(rs.getString("QQ"));
			teacher.setWechat(rs.getString("WECHAT"));
			teacher.setIdentification(rs.getString("IDENTIFICATION"));
			teacher.setIntroduction(rs.getString("INTRODUCTION"));
			teacher.setTimg(rs.getString("TIMG"));
			teacher.setRimg(rs.getString("RIMG"));
			return teacher;
		}else
		{
			return null;
		}
	}
    public Teacher findTeacherName(String userName) throws Exception{
    	String sql="select  *  from TEACHER where TNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet  rs=pstat.executeQuery();
		if(rs.next())
		{
			Teacher  teacher=new Teacher();
			teacher.setTname(rs.getString("TNAME"));
			return teacher;
		}
		return null;
    }
	public String findPassmessage(String userName) throws Exception
	{
		String passmessage=null;
		String sql="select * from TEACHER where TNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, userName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			passmessage=rs.getString("PASSMESSAGE");
		}
		return passmessage;
	}
	
	public int updatePassword(String password,String tname) throws Exception{
		String sql="update TEACHER set PASSWORD = ? where TNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, password);
		prep.setString(2, tname);
		int i=prep.executeUpdate();
		return i;
	}
}
