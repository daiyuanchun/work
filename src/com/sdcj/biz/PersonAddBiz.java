package com.sdcj.biz;

import com.sdcj.dao.PersonAddDao;
import com.sdcj.domain.PersonAdd;
import com.sdcj.util.JDBCUtil;

   public class PersonAddBiz {
	   public int checkName(String name)
	   {
		   int i=0;
		  try {
			  PersonAddDao  personAddDao=new PersonAddDao();
			 i=personAddDao.checkName(name);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally {
			JDBCUtil.closeConnection();
		}
		   
	   }
	public void saveName(String name) {
		try {
			PersonAddDao personAddDao = new PersonAddDao();
			personAddDao.setName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}

	public void saveImg(String name, String img) {
		try {
			PersonAddDao personAddDao = new PersonAddDao();
			personAddDao.setImg(name, img);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}

	public void saveSex(String name, String sex) {
		try {
			PersonAddDao personAddDao = new PersonAddDao();
			personAddDao.setSex(name, sex);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}

	public void saveAge(String name, String age) {
		try {
			PersonAddDao personAddDao = new PersonAddDao();
			personAddDao.setAge(name, age);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}

	public void saveEmail(String name, String email) {
		try {
			PersonAddDao personAddDao = new PersonAddDao();
			personAddDao.setEmail(name, email);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.closeConnection();
		}
	}

	public PersonAdd find(String name) {

		try {
			PersonAddDao personAddDao = new PersonAddDao();
			PersonAdd person = personAddDao.findByName(name);
			if (person != null) {
				return person;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}

	}
}
