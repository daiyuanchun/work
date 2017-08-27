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

@WebServlet("/companyBasic.do")
public class CompanyBasicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String lastCname = request.getParameter("lastCname");
		String cname = request.getParameter("cname");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String firm = request.getParameter("firm");
		String industry = request.getParameter("industry");
		String address = request.getParameter("address");
		String websit = request.getParameter("websit");
		String introduction = request.getParameter("introduction");
		int provinceId = Integer.parseInt(request.getParameter("provinceId"));
		int fieldId = Integer.parseInt(request.getParameter("fieldId"));
		CompanyBiz companyBiz = new CompanyBiz();
		companyBiz.saveMany(lastCname, cname, tel, email, firm, industry, address, websit, introduction, provinceId, fieldId);
        Company   company=companyBiz.findByName(cname);
		HttpSession session = request.getSession();
		session.setAttribute("company", company);
		response.sendRedirect(request.getContextPath() + "/companyBasic.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
