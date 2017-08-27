package com.sdcj.checkedController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.FieldBiz;
import com.sdcj.biz.PriceForCompanyBiz;
import com.sdcj.biz.ProvinceBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.SearchVO;

@WebServlet("/searchvo.do")
public class SearchVOController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchVO searchVO=new SearchVO(1,null,null,null);
		if (request.getParameter("fieldId") != null
				&& !"-1".equals(request.getParameter("fieldId"))) {
			int fieldId = Integer.parseInt(request
					.getParameter("fieldId"));
			searchVO.setFieldId(fieldId);
		}
		
		if(request.getParameter("priceId") != null
				&& !"-1".equals(request.getParameter("priceId"))) {
			int priceId = Integer.parseInt(request.getParameter("priceId"));
			searchVO.setPriceId(priceId);
		}
		if(request.getParameter("provinceId") != null
				&& !"-1".equals(request.getParameter("provinceId"))) {
			int provinceId = Integer.parseInt(request.getParameter("provinceId"));
			searchVO.setProvinceId(provinceId);
		}
		CompanyBiz companyBiz = new CompanyBiz();
		int recordCount = companyBiz.findCountBySearch(searchVO);
		int pageCount = (recordCount-1)/5 + 1;
		if (request.getParameter("page") != null
				&& !"1".equals(request.getParameter("page"))) {
			int page = Integer.parseInt(request.getParameter("page"));
			if(page < 1){
				page = 1;
			}
			if(page > pageCount){
				page = pageCount;
			}
			searchVO.setPage(page);
		}
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("page", searchVO.getPage());
		List<Company> wcompanyList = companyBiz.findBySearch(searchVO);
		request.setAttribute("wcompanyList", wcompanyList);
		request.setAttribute("fieldList", new FieldBiz().findAll());
		request.setAttribute("priceList", new PriceForCompanyBiz().findAll());
		request.setAttribute("provinceList", new ProvinceBiz().findAll());
		request.getRequestDispatcher("company.jsp").forward(request, response);
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
