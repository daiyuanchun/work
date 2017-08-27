package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.sdcj.biz.WvideoBiz;
import com.sdcj.domain.Wvideo;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.UUIDUtil;
@MultipartConfig//文件上传必须加的注解
@WebServlet("/teacherVideo.do")
public class TeacherVideoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tname=request.getParameter("tname");
		String rname=request.getParameter("rname");
		String title=request.getParameter("title");
		
		Part photo=request.getPart("photo");
		Part view=request.getPart("view");
		//第一个照片
		String uuidfilename_1 = UUIDUtil.getUUID();
		String head_1= view.getHeader("Content-Disposition");
		String realfilename_1 = FileNameUtil.getRealFileName(head_1);
		String savefilename_1 = uuidfilename_1+FileNameUtil.getFileType(realfilename_1);
		//获取文件上传位置
		
		String path = this.getServletContext().getRealPath("/videoes");
		view.write(path+"/"+savefilename_1);
	  
		String uuidfilename_2 = UUIDUtil.getUUID();
		String head_2=photo.getHeader("Content-Disposition");
		String realfilename_2 = FileNameUtil.getRealFileName(head_2);
		String savefilename_2 = uuidfilename_2+FileNameUtil.getFileType(realfilename_2);
		photo.write(path+"/"+savefilename_2);
		
		WvideoBiz wvideoBiz=new WvideoBiz();
		Wvideo wvideo=new Wvideo();
		wvideo.setTname(tname);
		wvideo.setRname(rname);
		wvideo.setVideo(savefilename_1);
		wvideo.setPhoto(savefilename_2);
		wvideo.setTitle(title);
		wvideoBiz.save(wvideo);
		response.sendRedirect("teacherVideo.jsp?succeed=yes");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}

}
