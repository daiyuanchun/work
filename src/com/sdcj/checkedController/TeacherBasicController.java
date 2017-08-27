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


@WebServlet("/teacherBasic.do")
public class TeacherBasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TeacherBiz teacherBiz=new TeacherBiz();
		String lastTname=request.getParameter("hiddenName");
		int provinceId=Integer.parseInt(request.getParameter("provinceId"));
		int majorId=Integer.parseInt(request.getParameter("majorId"));
		int wayId=Integer.parseInt(request.getParameter("wayId"));
		int pricex=Integer.parseInt(request.getParameter("pricex"));
		int pricey=Integer.parseInt(request.getParameter("pricey"));
		int pricexId=1;
		int priceyId=1;
		//网上交流的价格区间
		if((pricex>=20)&&(pricex<30))
		{
			pricexId=2;
		}else  if((pricex>=30)&&(pricex<40))
		{
			pricexId=3;
		}
		else  if((pricex>=40)&&(pricex<50))
		{
			pricexId=4;
		}
		else  if((pricex>=50)&&(pricex<60))
		{
			pricexId=5;
		}
		else  if((pricex>=60)&&(pricex<100))
		{
			pricexId=6;
		}
		else  if((pricex>=100)&&(pricex<150))
		{
			pricexId=7;
		}
		else  if((pricex>=150)&&(pricex<200))
		{
			pricexId=8;
		}
		else  if((pricex>=200)&&(pricex<250))
		{
			pricexId=9;
		}
		else  if((pricex>=250)&&(pricex<300))
		{
			pricexId=10;
		}
		else  if((pricex>=300)&&(pricex<500))
		{
			pricexId=11;
		}
		
		//面对面交流的价格区间
		if((pricey>=20)&&(pricey<30))
		{
			priceyId=2;
		}else  if((pricey>=30)&&(pricey<40))
		{
			priceyId=3;
		}
		else  if((pricey>=40)&&(pricey<50))
		{
			priceyId=4;
		}
		else  if((pricey>=50)&&(pricey<60))
		{
			priceyId=5;
		}
		else  if((pricey>=60)&&(pricey<100))
		{
			priceyId=6;
		}
		else  if((pricey>=100)&&(pricey<150))
		{
			priceyId=7;
		}
		else  if((pricey>=150)&&(pricey<200))
		{
			priceyId=8;
		}
		else  if((pricey>=200)&&(pricey<250))
		{
			priceyId=9;
		}
		else  if((pricey>=250)&&(pricey<300))
		{
			priceyId=10;
		}
		else  if((pricey>=300)&&(pricey<500))
		{
			priceyId=11;
		}
		
		String tname = request.getParameter("teacherTname").trim();
		String rname = request.getParameter("teacherRname").trim();
		String tel = request.getParameter("teacherTel").trim();
		String email = request.getParameter("teacherEmail").trim();
		String major = request.getParameter("teacherMajor").trim();
		String school = request.getParameter("teacherSchool").trim();
		String qq = request.getParameter("teacherQQ").trim();
		String wechat = request.getParameter("teacherWechat").trim();
		String introduction = request.getParameter("aboutme").trim();
		
		teacherBiz.saveMany(lastTname, tname, rname, tel, email, major, school, qq, 
				wechat, introduction,provinceId,majorId,wayId,pricexId,priceyId,pricex,pricey);
		
		Teacher teacher=teacherBiz.findByName(tname);
		HttpSession session = request.getSession();
		session.setAttribute("teacher",teacher);
		response.sendRedirect(request.getContextPath()
				+ "/teacherBasic.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
