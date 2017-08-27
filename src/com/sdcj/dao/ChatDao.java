package com.sdcj.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sdcj.domain.Chat;
import com.sdcj.util.JDBCUtil;

public class ChatDao {
	public void saveChat(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time,String qq,String wechat) throws Exception
	{
    String sql = "insert into chat(tname,rname,pname,sname,price,last,sumPrice,time,qq,wechat,id)values(?,?,?,?,?,?,?,?,?,?,?)";
	Connection conn = JDBCUtil.getConnection();
	PreparedStatement pstat = conn.prepareStatement(sql);
	pstat.setString(1,tname);
	pstat.setString(2,rname);
	pstat.setString(3,pname);
	pstat.setString(4,sname);
	pstat.setInt(5,price);
	pstat.setInt(6,last);
	pstat.setInt(7,sumPrice);
	pstat.setString(8,time);
	pstat.setString(9,qq);
	pstat.setString(10,wechat);
	pstat.setInt(11,0);
	pstat.executeUpdate();
	}
	//改变审核状态
	public void updateChat(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time) throws Exception
	{
		String sql="update chat set id=1 where tname=? and rname=? and pname=? and sname=? and price=? "
		 		+ "and last=? and sumPrice=?  and time=?";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		pstat.setString(2,rname);
		pstat.setString(3,pname);
		pstat.setString(4,sname);
		pstat.setInt(5,price);
		pstat.setInt(6,last);
		pstat.setInt(7,sumPrice);
		pstat.setString(8,time);
		pstat.executeUpdate();
	}
	public void deleteChat(String tname,String rname,String pname,String sname,int price,int last,int sumPrice,String time) throws Exception
	{
		 String sql = "delete  from chat where tname=? and rname=? and pname=? and sname=? and price=? "
		 		+ "and last=? and sumPrice=?  and time=?";
			Connection conn = JDBCUtil.getConnection();
			PreparedStatement pstat = conn.prepareStatement(sql);
			pstat.setString(1,tname);
			pstat.setString(2,rname);
			pstat.setString(3,pname);
			pstat.setString(4,sname);
			pstat.setInt(5,price);
			pstat.setInt(6,last);
			pstat.setInt(7,sumPrice);
			pstat.setString(8,time);
			pstat.executeUpdate();
	}
	public List<Chat> selectChatByTname(String tname) throws Exception
	{
		List<Chat>  chatList=new ArrayList<Chat>();
		String sql="select *  from chat  where tname=?  and id=0";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Chat chat=new Chat();
			chat.setTname(rs.getString("TNAME"));
			chat.setRname(rs.getString("RNAME"));
			chat.setPname(rs.getString("PNAME"));
			chat.setSname(rs.getString("SNAME"));
			chat.setPrice(rs.getInt("PRICE"));
			chat.setLast(rs.getInt("LAST"));
			chat.setSumprice(rs.getInt("SUMPRICE"));
			chat.setTime(rs.getString("TIME"));
			chatList.add(chat);
		}
		return chatList;
		
	}
	public List<Chat> selectCheckedChatByTname(String tname) throws Exception
	{
		List<Chat>  chatCheckedList=new ArrayList<Chat>();
		String sql="select *  from chat  where tname=?  and id=1";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,tname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Chat chat=new Chat();
			chat.setTname(rs.getString("TNAME"));
			chat.setRname(rs.getString("RNAME"));
			chat.setPname(rs.getString("PNAME"));
			chat.setSname(rs.getString("SNAME"));
			chat.setPrice(rs.getInt("PRICE"));
			chat.setLast(rs.getInt("LAST"));
			chat.setSumprice(rs.getInt("SUMPRICE"));
			chat.setTime(rs.getString("TIME"));
			chatCheckedList.add(chat);
		}
		return chatCheckedList;
		
		
	}
	public List<Chat> selectChatByPname(String pname) throws Exception
	{
		List<Chat>  chatList=new ArrayList<Chat>();
		String sql="select *  from chat  where pname=? and id=1";
		Connection conn = JDBCUtil.getConnection();
		PreparedStatement pstat = conn.prepareStatement(sql);
		pstat.setString(1,pname);
		ResultSet rs=pstat.executeQuery();
		while(rs.next())
		{
			Chat chat=new Chat();
			chat.setTname(rs.getString("TNAME"));
			chat.setRname(rs.getString("RNAME"));
			chat.setPname(rs.getString("PNAME"));
			chat.setSname(rs.getString("SNAME"));
			chat.setPrice(rs.getInt("PRICE"));
			chat.setLast(rs.getInt("LAST"));
			chat.setSumprice(rs.getInt("SUMPRICE"));
			chat.setTime(rs.getString("TIME"));
			chat.setQq(rs.getString("QQ"));
			chat.setWechat(rs.getString("WECHAT"));
			chatList.add(chat);
		}
		return chatList;
		
	}
}
