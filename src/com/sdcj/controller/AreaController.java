package com.sdcj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.AreaBiz;
import com.sdcj.biz.CityBiz;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.domain.Area;
import com.sdcj.domain.PersonAdd;

@WebServlet("/area.do")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cityName=request.getParameter("personCity");
		String personName=request.getParameter("nameForCity");
	    if(!(cityName.equals("0")))
	    {
	    	CityBiz cityBiz=new CityBiz();
	    	int id=cityBiz.findByName(cityName);
	    	AreaBiz areaBiz=new AreaBiz();
	    	areaBiz.addCityName(personName, cityName);
	    	List<Area> allArea=areaBiz.findAll(id);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("allArea",allArea);
	    	PersonAddBiz personAddBiz=new	PersonAddBiz();
			PersonAdd  personAdd=personAddBiz.find(personName);
			session.setAttribute("personAdd", personAdd);
			response.sendRedirect(request.getContextPath()+"/personInformation.jsp");	
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
