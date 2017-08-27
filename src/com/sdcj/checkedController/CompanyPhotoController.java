package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.domain.Company;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.UUIDUtil;
@MultipartConfig//文件上传必须加的注解
@WebServlet("/companyPhoto.do")
public class CompanyPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("submitForCimg")!=null)
		{
		String tname=request.getParameter("cnameForImg");
		Part pimg=request.getPart("newCimg");
		String uuidfilename_1 = UUIDUtil.getUUID();
		String head_1=pimg.getHeader("Content-Disposition");
		String realfilename_1 = FileNameUtil.getRealFileName(head_1);
		String savefilename_1 = uuidfilename_1+FileNameUtil.getFileType(realfilename_1);
		String path = this.getServletContext().getRealPath("/upimg");
		pimg.write(path+"/"+savefilename_1);
		CompanyBiz companyBiz=new CompanyBiz();
		companyBiz.saveTimg(tname, savefilename_1);
		Company company=companyBiz.findByName(tname);
		HttpSession session = request.getSession();
		session.setAttribute("company", company);
		
		}
		if(request.getParameter("submitForRimg")!=null)
		{
		String tnameForImg=request.getParameter("cnameForImg");
		Part pimg_1=request.getPart("newRimg");
		String uuidfilename= UUIDUtil.getUUID();
		String head=pimg_1.getHeader("Content-Disposition");
		String realfilename = FileNameUtil.getRealFileName(head);
		String savefilename = uuidfilename+FileNameUtil.getFileType(realfilename);
		String path = this.getServletContext().getRealPath("/upimg");
		pimg_1.write(path+"/"+savefilename);
		CompanyBiz companyBiz=new CompanyBiz();
		companyBiz.saveRimg(tnameForImg, savefilename);
		Company company=companyBiz.findByName(tnameForImg);
		HttpSession session = request.getSession();
		session.setAttribute("company", company);
		
		}
		
		response.sendRedirect(request.getContextPath()
				+ "/companyPhoto.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
