package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.TeacherDao;
import com.sdcj.domain.Search;
import com.sdcj.domain.Teacher;
import com.sdcj.domain.Wteacher;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;

public class TeacherBiz {
	public void save(Wteacher wteacher){
		TeacherDao teacherDao=new TeacherDao();
		try {
			teacherDao.save(wteacher);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Teacher isLogin(String teacherName, String teacherPass) {
		try {
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacher = teacherDao.findByTeacherName(teacherName);
			if (teacher!= null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(teacherPass);
				if (md5UserPass.equals(teacher.getPassword())) {
					return teacher;
				} else {
					throw new Exception("密码错误!");
				}
			} else {
				throw new Exception("用户名不存在！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public int findPassByName(String teacherName)
	{
			
			try {
				TeacherDao teacherDao = new TeacherDao();
				Teacher teacher = teacherDao.findByTeacherName(teacherName);
				if(teacher!=null)
				{
					System.out.println("密码不正确！");
					return 1;
				}
				else{
					System.out.println("用户名不存在！");
					return 0;
					
				}
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}finally {
				JDBCUtil.closeConnection();
			}
			
		}
	public int findCountBySearch(Search search) {
		try {
			return new TeacherDao().findCountBySearch(search);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public List<Teacher>  SearchByName(String teacherName) {
		try {
			return new TeacherDao().SearchByName(teacherName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	
	public List<Teacher> findBySearch(Search search) {
		try {
			return new TeacherDao().findBySearch(search);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public void saveTimg(String name,String img)
	{
		try {
			TeacherDao teacherDao=new TeacherDao();
			teacherDao.saveTimg(name, img);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public void saveRimg(String name,String img)
	{
		try {
			TeacherDao teacherDao=new TeacherDao();
			teacherDao.saveRimg(name,img);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public void saveMany(String lastTname, String tname, String rname,
			String tel, String email, String major, String school, String qq,
			String wechat,String introduction,int provinceId,int majorId,
			int wayId,int pricexId,int priceyId,int pricex,int pricey ){
     
     try {
    	 TeacherDao teacherDao=new TeacherDao();
		teacherDao.saveMany(lastTname, tname, rname, tel, email,
				 major, school, qq, wechat,introduction,provinceId,
				 majorId,wayId,pricexId,priceyId,pricex,pricey);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.closeConnection();
	}
	}
	public Teacher findByName(String name)
	{
		try {
			TeacherDao teacherDao=new TeacherDao();
			Teacher teacher=teacherDao.findByName(name);
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public Teacher  findByNameForMany(String name)
	{
		try {
			TeacherDao teacherDao=new TeacherDao();
			Teacher teacher=teacherDao.findByNameForMany(name);
			return teacher;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	public Teacher findTeacherName(String userName){
		TeacherDao teacherDao=new TeacherDao();
		try {
			return teacherDao.findByTeacherName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public String findPassmessage(String userName){
		TeacherDao teacherDao=new TeacherDao();
		try {
			return teacherDao.findPassmessage(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int updatePassword(String password,String tname){
		TeacherDao teacherDao=new TeacherDao();
		try {
			return teacherDao.updatePassword(password, tname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
}
