package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.PersonAddBiz;

@WebServlet("/mes.do")
public class AddSexAgeEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameMes");
		String personSex = request.getParameter("sex");
		System.out.println(personSex);
		String personAge = request.getParameter("personAge");
		String personEmail = request.getParameter("person_email").trim();
		PersonAddBiz personAddBiz = new PersonAddBiz();
		personAddBiz.saveSex(name, personSex);
		personAddBiz.saveAge(name, personAge);
		if (personEmail != null) {
			personAddBiz.saveEmail(name, personEmail);
		}
		response.sendRedirect(request.getContextPath()
				+ "/personInformation.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
