package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.FaceBiz;

@WebServlet("/dealFace.do")
public class DealFace extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("faceForm") != null) {
    String tname=request.getParameter("tname");
    String rname=request.getParameter("rname");
    String pname=request.getParameter("pname");
    String sname=request.getParameter("userName");
    int last=Integer.parseInt(request.getParameter("lastTime"));
    int price=Integer.parseInt(request.getParameter("price"));
    int sumPrice=price*last;
    String tel=request.getParameter("tel");
    String timex=request.getParameter("xytime");
    String timey=request.getParameter("time");
    String time=timex+timey;
    FaceBiz faceBiz=new FaceBiz();
    faceBiz.saveFace(tname, rname, pname, sname, price, last, sumPrice, time,tel);
    response.sendRedirect(request.getContextPath()
			+ "/form2.jsp");
    
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
