package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.sdcj.biz.WteacherBiz;
import com.sdcj.domain.Wteacher;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UUIDUtil;
import com.sdcj.util.UsersUtil;

@WebServlet("/TeacherRegist.do")
@MultipartConfig//文件上传必须加的注解
public class TeacherRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tname = request.getParameter("tname");
		String rname=request.getParameter("rname");
		String password = request.getParameter("password");
		String passmessage=request.getParameter("passmessage");
		String tel=request.getParameter("tel");
		String email=request.getParameter("email");
		String major=request.getParameter("major");
		String school=request.getParameter("school");
		String qq=request.getParameter("qq");
		String wechat=request.getParameter("wechat");
		Part identification=request.getPart("identification");
		String introduction=request.getParameter("introduction");
		Part timg=request.getPart("timg");
		Part rimg=request.getPart("rimg");
		//第一个照片
		String uuidfilename_1 = UUIDUtil.getUUID();
		String head_1= identification.getHeader("Content-Disposition");
		String realfilename_1 = FileNameUtil.getRealFileName(head_1);
		String savefilename_1 = uuidfilename_1+FileNameUtil.getFileType(realfilename_1);
		//获取文件上传位置
		
		String path = this.getServletContext().getRealPath("/upimg");
		identification.write(path+"/"+savefilename_1);
	  
	    String uuidfilename_2 = UUIDUtil.getUUID(); 
		String head_2= timg.getHeader("Content-Disposition");
		String realfilename_2 = FileNameUtil.getRealFileName(head_2);
		String savefilename_2 = uuidfilename_2+FileNameUtil.getFileType(realfilename_2);
		timg.write(path+"/"+savefilename_2);

		String uuidfilename_3 = UUIDUtil.getUUID(); 
		String head_3= rimg.getHeader("Content-Disposition");
		String realfilename_3 = FileNameUtil.getRealFileName(head_3);
		String savefilename_3 = uuidfilename_3+FileNameUtil.getFileType(realfilename_3);
		rimg.write(path+"/"+savefilename_3);
	    
		MD5_Encoding md5 = new MD5_Encoding();
		Wteacher  wteacher=new Wteacher ();
		wteacher.setTname(tname);
		wteacher.setRname(rname);
		wteacher.setPassword(md5.getMD5ofStr(password));
		wteacher.setPassmessage(passmessage);
		wteacher.setTel(tel);
		wteacher.setEmail(email);
		wteacher.setMajor(major);
		wteacher.setSchool(school);
		wteacher.setQq(qq);
		wteacher.setWechat(wechat);
		wteacher.setIdentification(savefilename_1);
		wteacher.setIntroduction(introduction);
		wteacher.setTimg(savefilename_2);
		wteacher.setRimg(savefilename_3);
		WteacherBiz wteacherBiz = new WteacherBiz();
		int i = wteacherBiz.save(wteacher);
		switch(i){
			case UsersUtil.USER_SUCCESS:
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			case UsersUtil.USER_ERROR:
				request.setAttribute("teacherErrorInfo", "注册申请提交失败！请重新注册！");
				request.getRequestDispatcher("/teacherRegist.jsp").forward(request, response);
				return;
			case UsersUtil.USER_USERNAME_NOT_EMPTY:
				request.setAttribute("teacherErrorInfo", "用户名已存在！请重新输入用户名！");
				request.getRequestDispatcher("/teacherRegist.jsp").forward(request, response);
				return;
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
