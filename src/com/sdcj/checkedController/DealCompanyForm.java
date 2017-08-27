package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.sdcj.biz.ExperienceBiz;


@WebServlet("/dealCompanyFirm.do")
public class DealCompanyForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("askCompanyForCheck")!=null)
		{
		String cname=request.getParameter("cname").trim();
		String firm=request.getParameter("firm").trim();
		String pname=request.getParameter("pname").trim();
		String studentName = request.getParameter("userName").trim();// 真实姓名
		String time = request.getParameter("xytime").trim();
		String lastTime = request.getParameter("lastTime").trim();
		String str=request.getParameter("post").trim();
		String[] strarray=str.split(",");
		String post=strarray[0];
	    int price=Integer.parseInt(strarray[1]);
		int i = Integer.parseInt(lastTime);
		int sumPrice = i * price;
		ExperienceBiz experienceBiz=new ExperienceBiz();
		experienceBiz.save(cname,firm,pname,studentName,post,price,i,sumPrice,time);
		response.sendRedirect(request.getContextPath()
				+ "/form3.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
