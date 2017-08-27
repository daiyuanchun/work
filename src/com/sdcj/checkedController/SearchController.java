package com.sdcj.checkedController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.MajorBiz;
import com.sdcj.biz.PriceBiz;
import com.sdcj.biz.ProvinceBiz;
import com.sdcj.biz.TeacherBiz;
import com.sdcj.biz.WayBiz;
import com.sdcj.domain.Search;
import com.sdcj.domain.Teacher;
@WebServlet("/search.do")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Search search=new Search(1,null,null,null,null);
		if(request.getParameter("majorId") != null
				&& !"-1".equals(request.getParameter("majorId"))) {
			int majorId = Integer.parseInt(request
					.getParameter("majorId"));
			search.setMajorId(majorId);
		}
		if (request.getParameter("wayId") != null) {
			int wayId = Integer.parseInt(request.getParameter("wayId"));
			search.setWayId(wayId);
		}
		if(request.getParameter("priceId") != null
				&& !"-1".equals(request.getParameter("priceId"))) {
			int priceId = Integer.parseInt(request.getParameter("priceId"));
			search.setPriceId(priceId);
		}
		if(request.getParameter("provinceId") != null
				&& !"-1".equals(request.getParameter("provinceId"))) {
			int provinceId = Integer.parseInt(request.getParameter("provinceId"));
			search.setProvinceId(provinceId);
		}
		TeacherBiz teacherBiz = new TeacherBiz();
		int recordCount = teacherBiz.findCountBySearch(search);
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
			search.setPage(page);
		}
		request.setAttribute("recordCount", recordCount);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("page", search.getPage());
		List<Teacher> wteacherList = teacherBiz.findBySearch(search);
		request.setAttribute("wteacherList", wteacherList);
		request.setAttribute("majorList", new MajorBiz().findAll());
		request.setAttribute("wayList", new WayBiz().findAll());
		request.setAttribute("priceList", new PriceBiz().findAll());
		request.setAttribute("provinceList", new ProvinceBiz().findAll());
		request.getRequestDispatcher("counselor.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
