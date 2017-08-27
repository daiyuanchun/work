package com.sdcj.biz;

import com.sdcj.dao.PersonDao;
import com.sdcj.domain.Person;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UsersUtil;

public class PersonBiz {
	public int save(Person person){
		try {
			PersonDao personDao = new PersonDao();
			Person personTemp = personDao.findByPersonName(person.getPname());
			if(personTemp == null){
				personDao.save(person);
				return UsersUtil.USER_SUCCESS;
			}else{
				return UsersUtil.USER_USERNAME_NOT_EMPTY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return UsersUtil.USER_ERROR;
		} finally{
			JDBCUtil.closeConnection();
		}

}
	
	
	public Person isLogin(String personName, String personPass) {
		try {
			PersonDao personDao = new PersonDao();
			Person person = personDao.findByPersonName(personName);
			if (person != null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(personPass);
				if (md5UserPass.equals(person.getPassword())) {
					return person;
				} else {
					//throw new Exception("密码不正确");
					return null;
				}
			} else {
				//throw new Exception("用户名不存在");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	
	//当isLogin(String personName, String personPass)为null时
	public int findPassByName(String personName)
	{
			
			try {
				PersonDao personDao = new PersonDao();
				Person person = personDao.findByPersonName(personName);
				if(person!=null)
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
	public String findPassmessage(String userName){
		PersonDao personDao = new PersonDao();
		try {
			return personDao.findPassmessage(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Person findByPersonName(String personName){
		PersonDao personDao = new PersonDao();
		try {
			return personDao.findByPersonName(personName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int updatePassword(String password,String pname){
		PersonDao personDao = new PersonDao();
		try {
			return personDao.updatePassword(password, pname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
		
	}
