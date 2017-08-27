package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.sdcj.domain.Video;
import com.sdcj.domain.Wvideo;
import com.sdcj.util.JDBCUtil;

public class VideoDao {
	public void save(Wvideo wvideo) throws Exception {
		String sql="insert into VIDEO(TNAME,RNAME,VIDEO,PHOTO,TITLE)values(?,?,?,?,?)";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1, wvideo.getTname());
		pstat.setString(2, wvideo.getRname());
		pstat.setString(3, wvideo.getVideo());
		pstat.setString(4, wvideo.getPhoto());
		pstat.setString(5, wvideo.getTitle());
		pstat.executeUpdate();
	}
	
	public Video findByTname(String tname) throws Exception{
		String sql="select * from VIDEO WHERE TNAME = ?";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		prep.setString(1, tname);
		ResultSet rs=prep.executeQuery();
		if(rs.next()){
			Video video=new Video();
			video.setTname(rs.getString("TNAME"));
			video.setRname(rs.getString("RNAME"));
			video.setVideo(rs.getString("VIDEO"));
			video.setPhoto(rs.getString("PHOTO"));
			video.setTitle(rs.getString("TITLE"));
			return video;
		}
		return null;
	}
	
	public List<Video> findAll() throws Exception{
		List<Video> videoList=new ArrayList<Video>();
		String sql="select * from VIDEO";
		Connection conn=JDBCUtil.getConnection();
		PreparedStatement prep=conn.prepareStatement(sql);
		ResultSet rs=prep.executeQuery();
		while(rs.next()){
			Video video=new Video();
			video.setTname(rs.getString("TNAME"));
			video.setRname(rs.getString("RNAME"));
			video.setVideo(rs.getString("VIDEO"));
			video.setPhoto(rs.getString("PHOTO"));
			video.setTitle(rs.getString("TITLE"));
			videoList.add(video);
		}
		return videoList;
	}
}
