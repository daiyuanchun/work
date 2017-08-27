package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.VideoDao;
import com.sdcj.domain.Video;
import com.sdcj.domain.Wvideo;
import com.sdcj.util.JDBCUtil;

public class VideoBiz {
	public void save(Wvideo wvideo){
		VideoDao videoDao=new VideoDao();
		try {
			videoDao.save(wvideo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Video findByTname(String tname){
		VideoDao videoDao=new VideoDao();
		try {
			return videoDao.findByTname(tname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public List<Video> findAll(){
		VideoDao videoDao=new VideoDao();
		try {
			return videoDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
}
