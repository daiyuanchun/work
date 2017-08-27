package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.ExperienceDao;
import com.sdcj.domain.Experience;
import com.sdcj.util.JDBCUtil;

public class ExperienceBiz {
	public void delete(String cname,String firm,String pname,String sname,String field,int price,int last,int sumPrice,String time)
	{
		
		try {
			ExperienceDao  experienceDao=new ExperienceDao();
			experienceDao.delete(cname, firm, pname, sname, field, price, last, sumPrice, time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public void updateId(String cname,String firm,String pname,String sname,String field,int price,int last,int sumPrice,String time) 
	{
		try {
			ExperienceDao  experienceDao=new ExperienceDao();
			experienceDao.updateId(cname, firm, pname, sname, field, price, last, sumPrice, time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public void save(String cname, String firm, String pname, String sname,
			String field, int price, int last, int sumPrice, String time) {
		
		try {
			ExperienceDao  experienceDao=new ExperienceDao();
			experienceDao.save(cname, firm, pname, sname, field, price, last, sumPrice, time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Experience> findByCname(String cname)
	{
		try {
			ExperienceDao experienceDao=new ExperienceDao();
			return experienceDao.findByCname(cname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Experience> findCheckedByCname(String cname)
	{
		try {
			ExperienceDao experienceDao=new ExperienceDao();
			return experienceDao.findCheckedByCname(cname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Experience> findByPname(String pname)
	{
		try {
			ExperienceDao experienceDao=new ExperienceDao();
			return experienceDao.findByPname(pname);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
}
