package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.TeacherBiz;
import com.sdcj.biz.WteacherBiz;
import com.sdcj.domain.Wteacher;

@WebServlet("/WteacherAgree.do")
public class WteacherAgreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Wteacher wteacher=(Wteacher) session.getAttribute("wteacher");
		//插入TEACHER表
		TeacherBiz teacherBIZ=new TeacherBiz();
		teacherBIZ.save(wteacher);
		//从WTEACHER表删除
		String tname=wteacher.getTname();
		WteacherBiz wteacherBiz=new WteacherBiz();
		wteacherBiz.deleteByTname(tname);
		request.getRequestDispatcher("checkTeacher.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
