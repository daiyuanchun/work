package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.PersonBiz;
import com.sdcj.biz.TeacherBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Person;
import com.sdcj.domain.Teacher;
import com.sdcj.util.MD5_Encoding;

@WebServlet("/forget.do")
public class ForgetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName=request.getParameter("username");
		String passMessage=request.getParameter("passMessage");
		String newPassword=request.getParameter("newPassword");
		String password=request.getParameter("password");
		MD5_Encoding md5 = new MD5_Encoding();
		String realPassword = md5.getMD5ofStr(password);
		//从ImageServlet中获取图片上的二维码
		String piccode = (String) request.getSession().getAttribute("piccode");
		//接受表单上填写的二维码
		String checkcode=request.getParameter("checkcode");
		String userType=request.getParameter("user_type");
		if (!(checkcode.equals(piccode))) {
			response.sendRedirect("forget.jsp?codeError=yes");
			System.out.println("验证码错误！");
		}else if (userType.equals("person")){
			PersonBiz personBiz=new PersonBiz();
			Person person=personBiz.findByPersonName(userName);
			if(person!=null){
				String userPassmessage=personBiz.findPassmessage(userName);
				if(!(passMessage.equals(userPassmessage))){
					response.sendRedirect("forget.jsp?userPassmessageError=yes");
					System.out.println("密码口令错误！");
				}else{
					if(!(newPassword.equals(password))){
						response.sendRedirect("forget.jsp?passwordError=yes");
						System.out.println("新密码与确认密码不一致");
				    }
					else{
						int i=personBiz.updatePassword(realPassword, userName);
						if(i==1){
							response.sendRedirect("forget.jsp?personSuccess=yes");
							System.out.println("修改密码成功");
						}else{
							response.sendRedirect("forget.jsp?personError=yes");
							System.out.println("修改密码失败");
						}
					}
				}
			}else{
				response.sendRedirect("forget.jsp?userNotExitError=yes");
				System.out.println("用户名不存在");
			}
		}else if (userType.equals("teacher")){
			TeacherBiz teacherBiz=new TeacherBiz();
			Teacher teacher=teacherBiz.findTeacherName(userName);
			if(teacher!=null){
				String teacherPassmessage=teacherBiz.findPassmessage(userName);
				if(!(passMessage.equals(teacherPassmessage))){
					response.sendRedirect("forget.jsp?teacherPassmessageError=yes");
					System.out.println("密码口令错误！");
				}else{
					if(!(newPassword.equals(password))){
						response.sendRedirect("forget.jsp?teacherPasswordError=yes");
						System.out.println("新密码与确认密码不一致");
				    }
					else{
						int i=teacherBiz.updatePassword(realPassword, userName);
						if(i==1){
							response.sendRedirect("forget.jsp?teacherSuccess=yes");
							System.out.println("修改密码成功");
						}else{
							response.sendRedirect("forget.jsp?teacherError=yes");
							System.out.println("修改密码失败");
						}
					}
				}
			}else{
				response.sendRedirect("forget.jsp?teacherNotExitError=yes");
				System.out.println("用户名不存在");
			}
		}else if (userType.equals("company")){
			CompanyBiz companyBiz=new CompanyBiz();
			Company company=companyBiz.findCompanyName(userName);
			if(company!=null){
				String companyPassmessage=companyBiz.findPassmessage(userName);
				if(!(passMessage.equals(companyPassmessage))){
					response.sendRedirect("forget.jsp?companyPassmessageError=yes");
					System.out.println("密码口令错误！");
				}else{
					if(!(newPassword.equals(password))){
						response.sendRedirect("forget.jsp?companyPasswordError=yes");
						System.out.println("新密码与确认密码不一致");
				    }
					else{
						int i=companyBiz.updatePassword(realPassword, userName);
						if(i==1){
							response.sendRedirect("forget.jsp?companySuccess=yes");
							System.out.println("修改密码成功");
						}else{
							response.sendRedirect("forget.jsp?companyError=yes");
							System.out.println("修改密码失败");
						}
					}
				}
				
			}else{
				response.sendRedirect("forget.jsp?companyNotExitError=yes");
				System.out.println("用户名不存在");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
