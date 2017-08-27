package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.ChatBiz;

@WebServlet("/deal.do")
public class DealChat extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("askTeacherForCheck")!=null)
		{
		String tname=request.getParameter("tname").trim();
		String rname=request.getParameter("rname").trim();
		String pname=request.getParameter("pname").trim();
		String studentName = request.getParameter("userName").trim();// 学生真实姓名
		String timex = request.getParameter("xytime").trim();
		String timey = "";
		timey = request.getParameter("abctime").trim();
		System.out.println("这是"+timey);
		String time = timex + timey;
		String lastTime = request.getParameter("lastTime").trim();
		String hiddenPrice = request.getParameter("hiddenPrice").trim();
		String qq=request.getParameter("qq").trim();
		System.out.println(qq);
		String wechat=request.getParameter("wechat").trim();
		System.out.println(wechat);
		int price = Integer.parseInt(hiddenPrice);
		System.out.println(price);
		int i = Integer.parseInt(lastTime);
		System.out.println(i);
		int sumPrice = i * price;
		ChatBiz chatBiz=new ChatBiz();
		chatBiz.saveChat(tname,rname,pname,studentName,price,i,sumPrice,time,qq,wechat);
		response.sendRedirect(request.getContextPath()
				+ "/form1.jsp");
		}
		
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
