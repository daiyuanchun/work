package com.sdcj.checkedController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.sdcj.biz.CompanyBiz;
import com.sdcj.domain.Company;


@WebServlet("/companyUpdate.do")
public class CompanyUpdateMessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CompanyBiz companyBiz=new CompanyBiz();
		if(request.getParameter("companyForm")!=null)
		{
		String lastTname=request.getParameter("hiddenName");
		String provinceId = request.getParameter("province");
		String cname = request.getParameter("cname").trim();
		String tel = request.getParameter("tel").trim();
		String email = request.getParameter("email").trim();
		String firm = request.getParameter("firm").trim();
		String address = request.getParameter("address").trim();
		String rimg = request.getParameter("rimg").trim();
		String websit = request.getParameter("websit").trim();
		String introdution = request.getParameter("introdution").trim();
		
		}
		Company  company=(Company)request.getSession().getAttribute("company");
		HttpSession session = request.getSession();
		session.setAttribute("company",company);
		response.sendRedirect(request.getContextPath()
				+ "/companyCenter.jsp");
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
