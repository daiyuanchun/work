package com.sdcj.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.CityBiz;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.biz.ProvinceBiz;
import com.sdcj.domain.City;
import com.sdcj.domain.PersonAdd;

@WebServlet("/city.do")
public class CityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String provinceName=request.getParameter("personProvince");
		String personName=request.getParameter("nameForProvince");
	    if(!(provinceName.equals("0")))
	    {
	    	ProvinceBiz provinceBiz=new ProvinceBiz();
	    	int id=provinceBiz.findByName(provinceName);
	    	CityBiz cityBiz=new CityBiz();
	    	cityBiz.addProvinceName(personName, provinceName);
	    	List<City> allCity=cityBiz.findById(id);
	    	HttpSession session = request.getSession();
	    	session.setAttribute("allCity",allCity);
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
