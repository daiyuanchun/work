package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.CompanyBiz;
import com.sdcj.biz.ManagerBiz;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.biz.PersonBiz;
import com.sdcj.biz.TeacherBiz;
import com.sdcj.biz.WcompanyBiz;
import com.sdcj.biz.WteacherBiz;
import com.sdcj.domain.Company;
import com.sdcj.domain.Manager;
import com.sdcj.domain.Person;
import com.sdcj.domain.PersonAdd;
import com.sdcj.domain.Teacher;
import com.sdcj.domain.Wcompany;
import com.sdcj.domain.Wteacher;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userType = request.getParameter("user_type");
		String userName = request.getParameter("username");
		String userPass = request.getParameter("password");
		// 从ImageServlet中获取图片上的二维码
		String piccode = (String) request.getSession().getAttribute("piccode");
		// 接受表单上填写的二维码
		String checkcode = request.getParameter("checkcode");
		checkcode = checkcode.toUpperCase();
		response.setContentType("text/html;charset=utf-8");
		try {
			if (!(checkcode.equals(piccode))) {
				response.sendRedirect("login.jsp?codeError=yes");
				System.out.println("验证码错误！");
			}
			else if (userType.equals("person")) {
				PersonBiz personBiz = new PersonBiz();
				Person person = personBiz.isLogin(userName, userPass);
				if (person == null) {
					if (personBiz.findPassByName(userName) == 0) {
						response.sendRedirect("login.jsp?userNotExitError=yes");
					} else {
						response.sendRedirect("login.jsp?userPasswordError=yes");
					}
				} else {
					PersonAddBiz personAddBiz=new	PersonAddBiz();
					PersonAdd  personAdd=personAddBiz.find(userName);
					HttpSession session = request.getSession();
					session.setAttribute("person", person);
					session.setAttribute("personAdd", personAdd);
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}
			} else if (userType.equals("teacher")) {
				TeacherBiz teacherBiz = new TeacherBiz();
				Teacher teacher = teacherBiz.isLogin(userName, userPass);
				
				if (teacher == null) {
					if (teacherBiz.findPassByName(userName) == 0) {
						WteacherBiz wteacherBiz = new WteacherBiz();
						Wteacher wteacher = wteacherBiz.findByName(userName);
						if (wteacher == null) {
							response.sendRedirect("login.jsp?userNotExitError=yes");
							System.out.println("用户不存在！");
						} else{
							if (wteacher != null) {
							response.sendRedirect("login.jsp?teacherWait=yes");
							System.out.println("指导老师在审核！");
						    } 
						}
					} else if (teacherBiz.findPassByName(userName) == 1) {
						response.sendRedirect("login.jsp?userPasswordError=yes");
						System.out.println("密码不正确！");
					}
				} else {
					HttpSession session = request.getSession();
					session.setAttribute("teacher", teacher);
					
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}
			}

			else if (userType.equals("company")) {
				CompanyBiz companyBiz = new CompanyBiz();
				Company company = companyBiz.isLogin(userName, userPass);
				if (company == null) {
					int j = companyBiz.findPassByName(userName);
					if (j == 0) {
						WcompanyBiz wcompanyBiz = new WcompanyBiz();
						Wcompany wcompany = wcompanyBiz.findByCompanyName(userName);
						if (wcompany == null) {
							response.sendRedirect("login.jsp?userNotExitError=yes");
							System.out.println("用户不存在！");
						} else {
							response.sendRedirect("login.jsp?companyWait=yes");
							System.out.println("企业在审核！");
						} 
					} 
					if(j==1){
						response.sendRedirect("login.jsp?userPasswordError=yes");
						System.out.println("密码不正确！");
					}

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("company", company);
					response.sendRedirect(request.getContextPath()
							+ "/index.jsp");
				}
			} else if (userType.equals("manager")) {
				ManagerBiz managerBiz = new ManagerBiz();
				Manager manager = managerBiz.isLogin(userName, userPass);
				if (manager == null) {
					if (managerBiz.findPassByName(userName) == 0) {
						response.sendRedirect("login.jsp?userNotExitError=yes");
						System.out.println("用户不存在！");
					} else if (managerBiz.findPassByName(userName) == 1) {
						response.sendRedirect("login.jsp?userPasswordError=yes");
						System.out.println("密码不正确！");
					}

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("manager", manager);
					response.sendRedirect(request.getContextPath()
							+ "/admView.jsp");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}
}
