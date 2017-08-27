package com.sdcj.checkedController;

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
import com.sdcj.biz.FaceBiz;
import com.sdcj.domain.Chat;
import com.sdcj.domain.Face;
import com.sdcj.domain.Teacher;


@WebServlet("/teacherRecord.do")
public class TeacherRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Teacher teacher = (Teacher) request.getSession().getAttribute("teacher");
		String tname=teacher.getTname();
		List<Chat>  chatList=new ArrayList<Chat>();
		List<Chat>  chatCheckedList=new ArrayList<Chat>();
		ChatBiz chatBiz=new ChatBiz();
		chatList=chatBiz.selectChatByTname(tname);
		chatCheckedList=chatBiz.selectCheckedChatByTname(tname);
		HttpSession session = request.getSession();
		session.setAttribute("chatList",chatList);
		session.setAttribute("chatCheckedList",chatCheckedList);
		List<Face>  faceList=new ArrayList<Face>();
		List<Face>  faceCheckedList=new ArrayList<Face>();
		FaceBiz faceBiz=new FaceBiz();
		faceList=faceBiz.selectFaceByTname(tname);
		faceCheckedList=faceBiz.selectCheckedFaceByTname(tname);
		session.setAttribute("faceList",faceList);
		session.setAttribute("faceCheckedList",faceCheckedList);
		response.sendRedirect(request.getContextPath()
				+ "/teacherRecord.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
