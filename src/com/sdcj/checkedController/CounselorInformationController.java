package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.TeacherBiz;
import com.sdcj.domain.Teacher;

@WebServlet("/infofindbyid.do")
public class CounselorInformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String name=request.getParameter("id");
	 HttpSession session = request.getSession();
	 session.setAttribute("teacherName",name);
	 TeacherBiz teacherBiz=new TeacherBiz();
     Teacher wteacherInformation= teacherBiz.findByName(name);
     
	 session.setAttribute("wteacherInformation", wteacherInformation);
	 response.sendRedirect(request.getContextPath()+"/counselorInformation.jsp");
     
    
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
