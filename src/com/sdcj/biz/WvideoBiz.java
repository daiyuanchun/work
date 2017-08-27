package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.WvideoDao;
import com.sdcj.domain.Wvideo;
import com.sdcj.util.JDBCUtil;

public class WvideoBiz {
	public List<Wvideo> findAll(){
		WvideoDao wvideoDao=new WvideoDao();
		try {
			return wvideoDao.findAll();
		} catch (Exception e) {
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int deleteByTname(String tname){
		WvideoDao wvideoDao=new WvideoDao();
		try {
			return wvideoDao.deletByTname(tname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Wvideo findByTname(String tname){
		WvideoDao wvideoDao=new WvideoDao();
		try {
			return wvideoDao.findByTname(tname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int save(Wvideo wvideo){
		WvideoDao wvideoDao=new WvideoDao();
		try {
			return wvideoDao.save(wvideo);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}

}
