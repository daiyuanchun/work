package com.sdcj.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Wteacher;
import com.sdcj.util.JDBCUtil;
public class WteacherDao {
	public List<Wteacher> findAll() throws Exception{
		List<Wteacher> WteacherList=new ArrayList<Wteacher>();
		String sql="select * from WTEACHER";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Wteacher wteacher=new Wteacher();
			wteacher.setTname(rs.getString("TNAME"));
			wteacher.setRname(rs.getString("RNAME"));
			wteacher.setPassword(rs.getString("PASSWORD"));
			wteacher.setTel(rs.getString("TEL"));
			wteacher.setEmail(rs.getString("EMAIL"));
			wteacher.setMajor(rs.getString("MAJOR"));
			wteacher.setSchool(rs.getString("SCHOOL"));
			wteacher.setQq(rs.getString("QQ"));
			wteacher.setWechat(rs.getString("WECHAT"));
			wteacher.setIdentification(rs.getString("IDENTIFICATION"));
			wteacher.setIntroduction(rs.getString("INTRODUCTION"));
			wteacher.setTimg(rs.getString("TIMG"));
			wteacher.setRimg(rs.getString("RIMG"));
			wteacher.setPassmessage(rs.getString("PASSMESSAGE"));
			WteacherList.add(wteacher);
		}
		return WteacherList;
	}
	
	public int deletByTname(String tname) throws Exception{
		String sql="delete from WTEACHER where TNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, tname);
		int i=prep.executeUpdate();
		return i;
	}
	
	public  Wteacher findByName(String wteacherName) throws Exception
	{
		String sql="select * from WTEACHER where TNAME=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,wteacherName);
		ResultSet rs = pstat.executeQuery();
		if(rs.next()){
			Wteacher teacher=new Wteacher();
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
			return teacher;
		}
		else
		{
			return null;
		}
	}

		public void save(Wteacher wteacher) throws Exception {
			String sql = "insert into wteacher(TNAME,RNAME,PASSWORD,TEL,EMAIL,MAJOR,SCHOOL,QQ,WECHAT,IDENTIFICATION,INTRODUCTION,TIMG,RIMG,PASSMESSAGE)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
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
	        pstat.setString(14, wteacher.getPassmessage());
	        pstat.executeUpdate();
		}
		
		public  Wteacher findByTeacherName(String teacherName) throws Exception
		{
			String sql="select * from wteacher where TNAME=?";
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1,teacherName);
			ResultSet rs = pstat.executeQuery();
			if(rs.next()){
				Wteacher wteacher=new Wteacher();
				wteacher.setTname(rs.getString("TNAME"));
				wteacher.setRname(rs.getString("RNAME"));
				wteacher.setPassword(rs.getString("PASSWORD"));
				wteacher.setTel(rs.getString("TEL"));
				wteacher.setEmail(rs.getString("EMAIL"));
				wteacher.setMajor(rs.getString("MAJOR"));
				wteacher.setSchool(rs.getString("SCHOOL"));
				wteacher.setQq(rs.getString("QQ"));
				wteacher.setWechat(rs.getString("WECHAT"));
				wteacher.setIdentification(rs.getString("IDENTIFICATION"));
				wteacher.setIntroduction(rs.getString("INTRODUCTION"));
				wteacher.setTimg(rs.getString("TIMG"));
				wteacher.setRimg(rs.getString("RIMG"));
				return wteacher;
			}
			else
			{
				return null;
			}
		}
				
	}



