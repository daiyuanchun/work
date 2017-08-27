package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.CpriceBiz;

@WebServlet("/updateOrDelete.do")
public class UpdateOrDeleteCpriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("cname");
		String post = request.getParameter("post");
		CpriceBiz cpriceBiz = new CpriceBiz();
		if (request.getParameter("updateCprice") != null) {
			int price = Integer.parseInt(request.getParameter("price"));
			cpriceBiz.updateTable(cname, post, price);
		}
		if (request.getParameter("deleteCprice") != null) {
			cpriceBiz.deleteTable(cname, post);
		}
		response.sendRedirect(request.getContextPath() + "/see.do");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
