package com.sdcj.biz;

import java.util.ArrayList;
import java.util.List;

import com.sdcj.dao.CpriceDao;
import com.sdcj.domain.Cprice;
import com.sdcj.util.JDBCUtil;

public class CpriceBiz {
public List<Cprice> findAllByCname(String cname)
{
	List<Cprice> cpriceList=new ArrayList<Cprice>();
	
	try {
		CpriceDao cpriceDao=new CpriceDao();
		cpriceList=cpriceDao.findAllByCname(cname);
		return cpriceList;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}finally{
		JDBCUtil.closeConnection();
	}
	
}
public void insertTable(String cname,String post,int price)
{
	try {
		CpriceDao cpriceDao=new CpriceDao();
		cpriceDao.insertTable(cname, post, price);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.closeConnection();
	}
}
public void updateTable(String cname,String post,int price)
{
	
	try {
		CpriceDao cpriceDao=new CpriceDao();
		cpriceDao.updateTable(cname, post, price);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.closeConnection();
	}
}
public void deleteTable(String cname,String post)
{
	try {
		CpriceDao cpriceDao=new CpriceDao();
		cpriceDao.deleteTable(cname, post);
	} catch (Exception e) {
		e.printStackTrace();
	}finally{
		JDBCUtil.closeConnection();
	}
}
}
