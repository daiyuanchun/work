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

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.CpriceBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Cprice;


@WebServlet("/informationfindbyid.do")
public class FirmInformationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("id");
		 CompanyBiz companyBiz=new CompanyBiz();
	     Company companyInformation= companyBiz.findByName(name);
	     List<Cprice> cpriceList=new ArrayList<Cprice>();
	     CpriceBiz cpriceBiz=new CpriceBiz();
	     cpriceList=cpriceBiz.findAllByCname(name);
	     HttpSession session = request.getSession();
		 session.setAttribute("companyInformation", companyInformation);
		 session.setAttribute("cpriceList",cpriceList);
		 response.sendRedirect(request.getContextPath()+"/firmInformation.jsp");
	     	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
