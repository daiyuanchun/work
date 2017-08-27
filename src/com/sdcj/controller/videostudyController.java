package com.sdcj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sdcj.biz.VideoBiz;
import com.sdcj.domain.Video;

@WebServlet("/videostudy.do")
public class videostudyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		String name=(String)session.getAttribute("teacherName");
		System.out.println(name);
		VideoBiz videoBiz=new VideoBiz();
		Video vid=videoBiz.findByTname(name);
		session.setAttribute("vid",vid);
		List<Video> videoList=videoBiz.findAll();
		session.setAttribute("videoList", videoList);
		response.sendRedirect("videoStudy.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
