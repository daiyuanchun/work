package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Wvideo;
import com.sdcj.util.JDBCUtil;

public class WvideoDao {
	public List<Wvideo> findAll() throws Exception{
		List<Wvideo> WvideoList=new ArrayList<Wvideo>();
		String sql="select * from WVIDEO";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Wvideo video=new Wvideo();
			video.setTname(rs.getString("TNAME"));
			video.setRname(rs.getString("RNAME"));
			video.setVideo(rs.getString("VIDEO"));
			video.setPhoto(rs.getString("PHOTO"));
			video.setTitle(rs.getString("TITLE"));
			WvideoList.add(video);
		}
		return WvideoList;
	}
	
	public int deletByTname(String tname) throws Exception{
		String sql="delete from WVIDEO where TNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, tname);
		int i=prep.executeUpdate();
		return i;
	}
	
	public Wvideo findByTname(String tname) throws Exception{
		String sql="select * from WVIDEO WHERE TNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, tname);
		ResultSet rs=prep.executeQuery();
		if(rs.next()){
			Wvideo wvideo=new Wvideo();
			wvideo.setTname(rs.getString("TNAME"));
			wvideo.setRname(rs.getString("RNAME"));
			wvideo.setVideo(rs.getString("VIDEO"));
			wvideo.setPhoto(rs.getString("PHOTO"));
			wvideo.setTitle(rs.getString("TITLE"));
			return wvideo;
		}
		return null;
	}
	

	public int save(Wvideo wvideo) throws Exception {
		String sql="insert into WVIDEO(TNAME,RNAME,VIDEO,PHOTO,TITLE)values(?,?,?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, wvideo.getTname());
		pstat.setString(2, wvideo.getRname());
		pstat.setString(3, wvideo.getVideo());
		pstat.setString(4, wvideo.getPhoto());
		pstat.setString(5, wvideo.getTitle());
		int d=pstat.executeUpdate();
		return d;
	}
}
