package com.sdcj.checkedController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.sdcj.biz.TeacherBiz;
import com.sdcj.domain.Teacher;
import com.sdcj.util.FileNameUtil;
import com.sdcj.util.UUIDUtil;
@MultipartConfig//文件上传必须加的注解
@WebServlet("/teacherPhoto.do")
public class TeacherPhotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("timgSubmit")!=null){
		String tname=request.getParameter("nameForImg");
		Part pimg_1=request.getPart("upimg");
		String uuidfilename_1 = UUIDUtil.getUUID();
		String head_1=pimg_1.getHeader("Content-Disposition");
		String realfilename_1 = FileNameUtil.getRealFileName(head_1);
		String savefilename_1 = uuidfilename_1+FileNameUtil.getFileType(realfilename_1);
		String path = this.getServletContext().getRealPath("/upimg");
		pimg_1.write(path+"/"+savefilename_1);
		TeacherBiz teacherBiz=new TeacherBiz();
		teacherBiz.saveTimg(tname, savefilename_1);
		Teacher teacher=teacherBiz.findByName(tname);
		HttpSession session = request.getSession();
		session.setAttribute("teacher",teacher);
		}
		if(request.getParameter("rimgSubmit")!=null){
			String name=request.getParameter("tnameForPhoto");
			Part pimg_2=request.getPart("photo");
			String uuidfilename_2 = UUIDUtil.getUUID();
			String head_2=pimg_2.getHeader("Content-Disposition");
			String realfilename_2= FileNameUtil.getRealFileName(head_2);
			String savefilename_2= uuidfilename_2+FileNameUtil.getFileType(realfilename_2);
			String path = this.getServletContext().getRealPath("/upimg");
			pimg_2.write(path+"/"+savefilename_2);
			TeacherBiz teacherBiz=new TeacherBiz();
			teacherBiz.saveRimg(name,savefilename_2);
			System.out.println("保存了");
			Teacher teacher=teacherBiz.findByName(name);
			HttpSession session = request.getSession();
			session.setAttribute("teacher",teacher);
		}
		
		
		response.sendRedirect(request.getContextPath()
				+ "/teacherPhoto.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		this.doGet(request, response);
	}
}
