package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.ChatBiz;
@WebServlet("/chat.do")
public class AgressOrDisagressChat extends HttpServlet {
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
		String time = request.getParameter("time");
		System.out.println(time);
		ChatBiz chatBiz = new ChatBiz();
		if (request.getParameter("agress") != null) {
			
			chatBiz.updateChat(tname, rname, pname, sname, price, last,
					sumPrice, time);
			System.out.println("同意");
			
		}
		if (request.getParameter("disagress") != null) {
			chatBiz.deleteChat(tname, rname, pname, sname, price, last,
					sumPrice, time);
			System.out.println("不同意");

		}
		response.sendRedirect(request.getContextPath() + "/teacherRecord.do");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
