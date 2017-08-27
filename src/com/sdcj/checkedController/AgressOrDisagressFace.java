package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.FaceBiz;

@WebServlet("/face.do")
public class AgressOrDisagressFace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String tname = request.getParameter("tname");
		String rname = request.getParameter("rname");
		String pname = request.getParameter("pname");
		String sname = request.getParameter("sname");
		int price = Integer.parseInt(request.getParameter("price"));
		int last = Integer.parseInt(request.getParameter("last"));
		int sumPrice = Integer.parseInt(request.getParameter("sumPrice"));
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String time = request.getParameter("time");
		FaceBiz faceBiz = new FaceBiz();
		if (request.getParameter("aggress") != null) {
			faceBiz.update(tname, rname, pname, sname, price, last, sumPrice,
					time, tel, address);
			response.sendRedirect(request.getContextPath() + "/teacherRecord.do");

		}
		if (request.getParameter("disaggress") != null) {
			faceBiz.delete(tname, rname, pname, sname, price, last, sumPrice, time, tel);
			response.sendRedirect(request.getContextPath() + "/teacherRecord.do");

		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
