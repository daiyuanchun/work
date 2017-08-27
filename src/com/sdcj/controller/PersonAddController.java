package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.domain.PersonAdd;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.UUIDUtil;

@WebServlet("/add.do")
@MultipartConfig
public class PersonAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String pname=request.getParameter("nameForImg");
	Part pimg=request.getPart("upimg");
	String uuidfilename_1 = UUIDUtil.getUUID();
	String head_1=pimg.getHeader("Content-Disposition");
	String realfilename_1 = FileNameUtil.getRealFileName(head_1);
	String savefilename_1 = uuidfilename_1+FileNameUtil.getFileType(realfilename_1);
	String path = this.getServletContext().getRealPath("/upimg");
	pimg.write(path+"/"+savefilename_1);
	PersonAddBiz personAddBiz=new PersonAddBiz();
	if(personAddBiz.checkName(pname)==0)
	{
	personAddBiz.saveName(pname);
	}
	
	personAddBiz.saveImg(pname,savefilename_1);

	PersonAdd personAdd=personAddBiz.find(pname);
	HttpSession session = request.getSession();
	session.setAttribute("personAdd", personAdd);
	response.sendRedirect(request.getContextPath()
			+ "/personInformation.jsp");

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	
	}

}
