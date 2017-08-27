package com.sdcj.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.ChatBiz;
import com.sdcj.biz.ExperienceBiz;
import com.sdcj.biz.FaceBiz;
import com.sdcj.biz.PersonAddBiz;
import com.sdcj.biz.ProvinceBiz;
import com.sdcj.domain.Chat;
import com.sdcj.domain.Experience;
import com.sdcj.domain.Face;
import com.sdcj.domain.Person;
import com.sdcj.domain.PersonAdd;
import com.sdcj.domain.Province;
@WebServlet("/province.do")
public class ProvinceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person  person=(Person)request.getSession().getAttribute("person");
		String pname=person.getPname();
		PersonAddBiz personAddBiz=new PersonAddBiz();
		PersonAdd personAdd=personAddBiz.find(pname);
		HttpSession session = request.getSession();
		session.setAttribute("personAdd", personAdd);
		ProvinceBiz provinceBiz=new ProvinceBiz();
		PersonAdd  personadd=(PersonAdd)request.getSession().getAttribute("personAdd");
		List<Province> allProvince=provinceBiz.findAll();
		HttpSession session1 = request.getSession();
		session1.setAttribute("allProvince",allProvince);
		List<Chat>  chatList=new ArrayList<Chat>();
		ChatBiz chatBiz=new ChatBiz();
		chatList=chatBiz.selectChatByPname(pname);
		session.setAttribute("chatList",chatList);
		List<Face>  faceList=new ArrayList<Face>();
		FaceBiz faceBiz=new FaceBiz();
		faceList=faceBiz.selectFaceByPname(pname);
		session.setAttribute("faceList",faceList);
		List<Experience>  experienceList=new ArrayList<Experience>();
		ExperienceBiz experienceBiz=new ExperienceBiz();
		experienceList=experienceBiz.findByPname(pname);
		System.out.println(experienceList);
		session.setAttribute("experienceList",experienceList);
		
		request.getRequestDispatcher("/personInformation.jsp").forward(request, response);
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
