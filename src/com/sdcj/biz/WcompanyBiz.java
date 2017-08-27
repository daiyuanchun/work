package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.WcompanyDao;
import com.sdcj.domain.Wcompany;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;
import com.sdcj.util.UsersUtil;

public class WcompanyBiz {
	public List<Wcompany> findAll(){
		WcompanyDao wcompanyDao=new WcompanyDao();
		try {
			return wcompanyDao.findAll();
		} catch (Exception e) {
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int deleteByCname(String cname){
		WcompanyDao wcompanyDao=new WcompanyDao();
		try {
			return wcompanyDao.deletByCname(cname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Wcompany findByCompanyName(String wcompanyName){
		WcompanyDao wcompanyDao=new WcompanyDao();
		try {
			return wcompanyDao.findByCompanyName(wcompanyName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int save(Wcompany wcompany) {
		try {
			WcompanyDao wcompanyDao = new WcompanyDao();
			Wcompany wcompanyTemp = wcompanyDao.findByCompanyName(wcompany.getCname());
			if (wcompanyTemp == null) {
				wcompanyDao.save(wcompany);
				return UsersUtil.USER_SUCCESS;
			} else {
				return UsersUtil.USER_USERNAME_NOT_EMPTY;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return UsersUtil.USER_ERROR;
		} finally {
			JDBCUtil.closeConnection();
		}

	}

	
	public Wcompany isLogin(String companyName, String companyPass) {
		try {
			WcompanyDao wcompanyDao = new WcompanyDao();
			Wcompany wcompany = wcompanyDao.findByCompanyName(companyName);
			if (wcompany!= null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(companyPass);
				if (md5UserPass.equals(wcompany.getPassword())) {
					return wcompany;
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



