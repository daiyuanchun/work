package com.sdcj.biz;

import java.util.ArrayList;
import java.util.List;

import com.sdcj.dao.FaceDao;
import com.sdcj.domain.Face;
import com.sdcj.util.JDBCUtil;

public class FaceBiz {
	public void   saveFace(String tname,String rname,String pname, String sname, int price,
			int last, int sumPrice,String time,String tel) {

		try {
			FaceDao faceDao = new FaceDao();
			faceDao.saveFace(tname,rname,pname,sname, price, last, sumPrice,time,tel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public void update(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String tel,String address) 
	{
		try {
			FaceDao faceDao=new FaceDao();
			faceDao.update(tname, rname, pname, sname, price, last, sumPrice, time,tel,address);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	public void delete(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String tel)
	{
		try {
			FaceDao faceDao=new FaceDao();
			faceDao.delete(tname,rname,pname,sname,price,last,sumPrice,time,tel);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Face>  selectFaceByTname(String tname)
	{
		List<Face>  faceList=new ArrayList<Face>();
		try {
			FaceDao faceDao=new FaceDao();
			faceList=faceDao.selectFaceByTname(tname);
			return faceList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	public List<Face> selectCheckedFaceByTname(String tname)
	{
		List<Face>  faceCheckedList=new ArrayList<Face>();
		try {
			FaceDao faceDao=new FaceDao();
			faceCheckedList=faceDao.selectCheckedFaceByTname(tname);
			return faceCheckedList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Face>  selectFaceByPname(String pname)
	{
		List<Face>  faceList=new ArrayList<Face>();
		try {
			FaceDao faceDao=new FaceDao();
			faceList=faceDao.selectFaceByPname(pname);
			return faceList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
}
