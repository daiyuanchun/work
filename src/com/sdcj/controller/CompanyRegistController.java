package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sdcj.biz.WcompanyBiz;
import com.sdcj.domain.Wcompany;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UUIDUtil;
import com.sdcj.util.UsersUtil;

@WebServlet("/CompanyRegist.do")
@MultipartConfig
public class CompanyRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String companyName = request.getParameter("cname");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String firm = request.getParameter("firm");
		String industry = request.getParameter("industry");
		String address = request.getParameter("address");
		Part picture = request.getPart("picture");
		String introduction = request.getParameter("introduction");
		Part cimg = request.getPart("cimg");
		Part rimg = request.getPart("rimg");
		String websit = request.getParameter("website");
		String passmessage=request.getParameter("passmessage");

		String uuidfilename_1 = UUIDUtil.getUUID();
		String head_1 = picture.getHeader("Content-Disposition");
		String realfilename_1 = FileNameUtil.getRealFileName(head_1);
		String savefilename_1 = uuidfilename_1
				+ FileNameUtil.getFileType(realfilename_1);
		String path = this.getServletContext().getRealPath("/upimg");
		picture.write(path + "/" + savefilename_1);
		String uuidfilename_2 = UUIDUtil.getUUID();
		String head_2 = cimg.getHeader("Content-Disposition");
		String realfilename_2 = FileNameUtil.getRealFileName(head_2);
		String savefilename_2 = uuidfilename_2
				+ FileNameUtil.getFileType(realfilename_2);
		cimg.write(path + "/" + savefilename_2);
		String uuidfilename_3 = UUIDUtil.getUUID();
		String head_3 = rimg.getHeader("Content-Disposition");
		String realfilename_3 = FileNameUtil.getRealFileName(head_3);
		String savefilename_3 = uuidfilename_3
				+ FileNameUtil.getFileType(realfilename_3);
		rimg.write(path + "/" + savefilename_3);

		MD5_Encoding md5 = new MD5_Encoding();
		Wcompany  wcompany = new Wcompany ();
		wcompany.setCname(companyName);
		wcompany.setPassword(md5.getMD5ofStr(password));
		wcompany.setTel(tel);
		wcompany.setEmail(email);
		wcompany.setFirm(firm);
		wcompany.setIndustry(industry);
		wcompany.setAddress(address);
		wcompany.setIntroduction(introduction);
		wcompany.setPicture(savefilename_1);
		wcompany.setCimg(savefilename_2);
		wcompany.setRimg(savefilename_3);
		wcompany.setWebsit(websit);
		wcompany.setPassmessage(passmessage);

		WcompanyBiz wcompanyBiz = new WcompanyBiz();
		int i = wcompanyBiz.save(wcompany);
		switch (i) {
		case UsersUtil.USER_SUCCESS:
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		case UsersUtil.USER_ERROR:
			request.setAttribute("errorInfo", "注册申请提交失败！请重新注册！");
			request.getRequestDispatcher("companyRegist.jsp").forward(request,
					response);
			return;
		case UsersUtil.USER_USERNAME_NOT_EMPTY:
			request.setAttribute("errorInfo", "用户名已存在！请重新输入用户名！");
			request.getRequestDispatcher("/companyRegist.jsp").forward(request,
					response);
			return;
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);

	}

}
