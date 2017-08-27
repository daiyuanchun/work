package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.CpriceBiz;

@WebServlet("/cprice.do")
public class CpriceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cname = request.getParameter("cname");
		String post = request.getParameter("post");
		int price = Integer.parseInt(request.getParameter("price"));
		int priceId=1;
		if(price<=50)
		{
			priceId=2;
		}else if(price<=100)
		{
			priceId=3;
		}else if(price<=150)
		{
			priceId=4;
		}else if(price<=200)
		{
			priceId=5;
		}else if(price<=250)
		{
			priceId=6;
		}else if(price<=300)
		{
			priceId=7;
		}else if(price<=350)
		{
			priceId=8;
		}else if(price<=400)
		{
			priceId=9;
		}else if(price<=450)
		{
			priceId=10;
		}else if(price<=500)
		{
			priceId=11;
		}
		else if(price<=600)
		{
			priceId=12;
		}
		
		CpriceBiz cpriceBiz=new CpriceBiz();
		cpriceBiz.insertTable(cname, post, price);
		System.out.println(priceId);
		CompanyBiz companyBiz=new CompanyBiz();
		companyBiz.updatePriceId(cname,priceId);
		response.sendRedirect(request.getContextPath()
				+ "/companyPosition.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
