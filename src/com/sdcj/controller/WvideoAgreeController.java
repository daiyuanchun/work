package com.sdcj.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sdcj.biz.VideoBiz;
import com.sdcj.biz.WvideoBiz;
import com.sdcj.domain.Wvideo;

@WebServlet("/WvideoAgree.do")
public class WvideoAgreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Wvideo wvideo=(Wvideo) session.getAttribute("wvideo");
		//插入VIDEO表
		VideoBiz videoBIZ=new VideoBiz();
		videoBIZ.save(wvideo);
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
