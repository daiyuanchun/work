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

import com.sdcj.biz.CpriceBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Cprice;

@WebServlet("/see.do")
public class SeeCpriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Company  company=(Company)request.getSession().getAttribute("company");
		String cname = company.getCname();
		List<Cprice>  list=new ArrayList<Cprice>();
		CpriceBiz cpriceBiz=new CpriceBiz();
		list=cpriceBiz.findAllByCname(cname);
		HttpSession session = request.getSession();
		 session.setAttribute("list",list);
		 response.sendRedirect(request.getContextPath()
					+ "/seeCprice.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
