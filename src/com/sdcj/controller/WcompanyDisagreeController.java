package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.WcompanyBiz;
import com.sdcj.domain.Wcompany;

@WebServlet("/WcompanyDisagree.do")
public class WcompanyDisagreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Wcompany wcompany=(Wcompany) session.getAttribute("wcompany");
		//从WCOMPANY表删除
		String cname=wcompany.getCname();
		WcompanyBiz wcompanyBiz=new WcompanyBiz();
		wcompanyBiz.deleteByCname(cname);
		request.getRequestDispatcher("checkCompany.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
