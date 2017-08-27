package com.sdcj.checkedController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.ExperienceBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Experience;

@WebServlet("/companyRecord.do")
public class CompanyRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Company  company=(Company)request.getSession().getAttribute("company");
		String cname=company.getCname();
		List<Experience> exList = new ArrayList<Experience>();
		ExperienceBiz experienceBiz = new ExperienceBiz();
		exList = experienceBiz.findByCname(cname);
		HttpSession session = request.getSession();
		session.setAttribute("exList", exList);
		List<Experience> checkedList = new ArrayList<Experience>();
		ExperienceBiz checkedBiz = new ExperienceBiz();
		checkedList = checkedBiz.findCheckedByCname(cname);
		session.setAttribute("checkedList", checkedList);
		response.sendRedirect(request.getContextPath()
				+ "/companyRecord.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
