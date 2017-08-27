package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.ExperienceBiz;

@WebServlet("/dealExperience.do")
public class AgressOrDisagressExperence extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("agress") != null) {
			String cname = request.getParameter("cname");
			String pname = request.getParameter("pname");
			String time = request.getParameter("time");
			int last = Integer.parseInt(request.getParameter("last"));
			String firm = request.getParameter("firm");
			String sname = request.getParameter("sname");
			String field = request.getParameter("field");
			int price = Integer.parseInt(request.getParameter("price"));
			int sumPrice = Integer.parseInt(request.getParameter("sumPrice"));
			ExperienceBiz experienceBiz = new ExperienceBiz();
			experienceBiz.updateId(cname, firm, pname, sname, field, price,
					last, sumPrice, time);
			
		}
		if (request.getParameter("disagress") != null) {
			String cname = request.getParameter("cname");
			String pname = request.getParameter("pname");
			String time = request.getParameter("time");
			int last = Integer.parseInt(request.getParameter("last"));
			String firm = request.getParameter("firm");
			String sname = request.getParameter("sname");
			String field = request.getParameter("field");
			int price = Integer.parseInt(request.getParameter("price"));
			int sumPrice = Integer.parseInt(request.getParameter("sumPrice"));
			ExperienceBiz experienceBiz = new ExperienceBiz();
			experienceBiz.delete(cname, firm, pname, sname, field, price, last,
					sumPrice, time);
			
		}
		response.sendRedirect(request.getContextPath()
				+ "/companyRecord.do");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
