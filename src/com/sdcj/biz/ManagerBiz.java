package com.sdcj.biz;

import com.sdcj.dao.ManagerDao;
import com.sdcj.domain.Manager;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;

public class ManagerBiz {
	public Manager isLogin(String managerName, String managerPass) {
		try {
			ManagerDao managerDao = new ManagerDao();
			Manager manager = managerDao.findByManagerName(managerName);
			if (manager != null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(managerPass);
				if (md5UserPass.equals(manager.getPassword())) {
					return manager;
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
	public int findPassByName(String managerName)
	{
			
			try {
				ManagerDao managerDao = new ManagerDao();
				Manager manager = managerDao.findByManagerName(managerName);
				if(manager!=null)
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
			}
			finally {
				JDBCUtil.closeConnection();
			}
			
		}
	
}
