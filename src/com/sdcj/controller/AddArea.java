package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.AreaBiz;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.domain.PersonAdd;

@WebServlet("/addarea.do")
public class AddArea extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String areaName=request.getParameter("personArea");
		String personName=request.getParameter("nameForArea");
	    if(!(areaName.equals("0")))
	    {
	    	AreaBiz areaBiz=new AreaBiz();
	    	areaBiz.addAreaName(personName, areaName);
	    	PersonAddBiz personAddBiz=new	PersonAddBiz();
			PersonAdd  personAdd=personAddBiz.find(personName);
			HttpSession session = request.getSession();
			session.setAttribute("personAdd", personAdd);
	    }
	    response.sendRedirect(request.getContextPath()+"/personInformation.jsp");	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	
	}

}
