package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.WvideoBiz;
import com.sdcj.domain.Wvideo;

@WebServlet("/WvideoDisagree.do")
public class WvideoDisagreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Wvideo wvideo=(Wvideo) session.getAttribute("wvideo");
		//从WVIDEO表删除
		String tname=wvideo.getTname();
		WvideoBiz wvideoBiz=new WvideoBiz();
		wvideoBiz.deleteByTname(tname);
		request.getRequestDispatcher("checkVideo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
