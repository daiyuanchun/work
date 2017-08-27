package com.sdcj.checkedController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.TeacherBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Teacher;


@WebServlet("/sbcn.do")
public class SearchByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String name=request.getParameter("counselorname").trim();
      if(name!=null)
      {
    	  List<Teacher>  searchByCounselorName=new ArrayList<Teacher>();
    	  TeacherBiz teacherBiz=new TeacherBiz();
    	  searchByCounselorName=teacherBiz.SearchByName(name); 
    	  request.setAttribute("searchByCounselorName",searchByCounselorName);
    	  List<Company>  searchByCompanyName=new ArrayList<Company>();
    	  CompanyBiz companyBiz=new CompanyBiz();
    	  searchByCompanyName=companyBiz.SearchByName(name); 
    	  request.setAttribute("searchByCompanyName",searchByCompanyName);
    	  request.getRequestDispatcher("/searchByName.jsp").forward(request, response);
    		
      }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
