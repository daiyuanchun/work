package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdcj.biz.PersonBiz;
import com.sdcj.domain.Person;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UsersUtil;


@WebServlet("/reg.do")
public class PersonRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			String personName = request.getParameter("username");
			String password = request.getParameter("password");
			String passMessage = request.getParameter("passmessage");
			MD5_Encoding md5 = new MD5_Encoding();
			Person person = new Person();
			person.setPname(personName);
			person.setPassword(md5.getMD5ofStr(password));
			person.setPassMessage(passMessage);
			PersonBiz personBiz = new PersonBiz();
			int i = personBiz.save(person);
			switch(i){
				case UsersUtil.USER_SUCCESS:
					response.sendRedirect(request.getContextPath()+"/login.jsp");
					return;
				case UsersUtil.USER_ERROR:
					request.setAttribute("errorInfo", "注册失败!请重新注册！");
					request.getRequestDispatcher("/regist1.jsp").forward(request, response);
					return;
				case UsersUtil.USER_USERNAME_NOT_EMPTY:
					request.setAttribute("errorInfo", "用户名已存在!");
					request.getRequestDispatcher("/regist1.jsp").forward(request, response);
					return;
			}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
