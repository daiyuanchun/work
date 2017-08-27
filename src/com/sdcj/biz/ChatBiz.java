package com.sdcj.biz;

import java.util.ArrayList;
import java.util.List;

import com.sdcj.dao.ChatDao;
import com.sdcj.domain.Chat;
import com.sdcj.util.JDBCUtil;

public class ChatBiz {
	public void   saveChat(String tname,String rname,String pname, String sname, int price,
			int last, int sumPrice,String time,String qq,String wechat) {

		try {
			ChatDao chatDao = new ChatDao();
			chatDao.saveChat(tname,rname,pname,sname, price, last, sumPrice,time,qq,wechat);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public void updateChat(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time) 
	{
		try {
			ChatDao chatDao=new ChatDao();
			chatDao.updateChat(tname, rname, pname, sname, price, last, sumPrice, time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	public void deleteChat(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time)
	{
		try {
			ChatDao chatDao=new ChatDao();
			chatDao.deleteChat(tname,rname,pname,sname,price,last,sumPrice,time);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Chat>  selectChatByTname(String tname)
	{
		List<Chat>  chatList=new ArrayList<Chat>();
		try {
			ChatDao chatDao=new ChatDao();
			chatList=chatDao.selectChatByTname(tname);
			return chatList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	public List<Chat> selectCheckedChatByTname(String tname)
	{
		List<Chat>  chatCheckedList=new ArrayList<Chat>();
		try {
			ChatDao chatDao=new ChatDao();
			chatCheckedList=chatDao.selectCheckedChatByTname(tname);
			return chatCheckedList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public List<Chat>  selectChatByPname(String pname)
	{
		List<Chat>  chatList=new ArrayList<Chat>();
		try {
			ChatDao chatDao=new ChatDao();
			chatList=chatDao.selectChatByPname(pname);
			return chatList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
}
