package com.sdcj.biz;

import java.util.List;
import com.sdcj.dao.WteacherDao;
import com.sdcj.domain.Wteacher;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UsersUtil;

public class WteacherBiz {
	public List<Wteacher> findAll(){
		WteacherDao wteacherDao=new WteacherDao();
		try {
			return wteacherDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int deleteByTname(String tname){
		WteacherDao wteacherDao=new WteacherDao();
		try {
			return wteacherDao.deletByTname(tname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public  Wteacher findByName(String wteacherName){
		WteacherDao wteacherDao=new WteacherDao();
		try {
			return wteacherDao.findByName(wteacherName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int save(Wteacher wteacher){
		WteacherDao wteacherDao=new WteacherDao();
		try {
			Wteacher wteacherTmp=wteacherDao.findByName(wteacher.getTname());
			if (wteacherTmp == null) {
				wteacherDao.save(wteacher);
				return UsersUtil.USER_SUCCESS;
			} else {
				return UsersUtil.USER_USERNAME_NOT_EMPTY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return UsersUtil.USER_ERROR;
		}finally {
			JDBCUtil.closeConnection();
		}
	}
	
	public Wteacher isLogin(String teacherName, String teacherPass) {
		try {
			WteacherDao wteacherDao = new WteacherDao();
			Wteacher teacher = wteacherDao.findByTeacherName(teacherName);
			if (teacher!= null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(teacherPass);
				if (md5UserPass.equals(teacher.getPassword())) {
					return teacher;
				} else {
					throw new Exception("密码错误");
				}
			} else {
				throw new Exception("用户名不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}

