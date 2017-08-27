package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.CompanyDao;
import com.sdcj.domain.Company;
import com.sdcj.domain.SearchVO;
import com.sdcj.domain.Wcompany;
import com.sdcj.util.JDBCUtil;
import com.sdcj.util.MD5_Encoding;

public class CompanyBiz {
	public void saveMany(String lastCname,String  cname,String  tel,String  email,String firm, 
			String industry,String  address,String  websit,String introduction, 
			int provinceId,int fieldId)
	{
		
		try {
			CompanyDao companyDao=new CompanyDao();
			companyDao.saveMany(lastCname,cname,tel,email,firm,industry,address,websit,introduction,provinceId,fieldId);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public void saveTimg(String name,String img)
	{
		try {
			CompanyDao companyDao=new CompanyDao();
			companyDao.saveTimg(name, img);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
	public void saveRimg(String name,String img)
	{
		try {
			CompanyDao companyDao=new CompanyDao();
			companyDao.saveRimg(name, img);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JDBCUtil.closeConnection();
		}
		
	}
	public void save(Wcompany wcompany){
		CompanyDao companyDao=new CompanyDao();
		try {
			companyDao.save(wcompany);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public Company isLogin(String companyName, String companyPass) {
		try {
			CompanyDao companyDao = new CompanyDao();
			Company company = companyDao.findByCompanyName(companyName);
			if (company!= null) {
				MD5_Encoding md5 = new MD5_Encoding();
				String md5UserPass = md5.getMD5ofStr(companyPass);
				if (md5UserPass.equals(company.getPassword())) {
					return company;
				} else {
					throw new Exception("密码错误！");
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
	public int findPassByName(String companyName)
	{
			
			try {
				CompanyDao companyDao = new CompanyDao();
				Company company = companyDao.findByCompanyName(companyName);
				if(company!=null)
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
	public int findCountBySearch(SearchVO searchVO) {
		try {
			return new CompanyDao().findCountBySearch(searchVO);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	
	public List<Company> findBySearch(SearchVO searchVO) {
		try {
			return new CompanyDao().findBySearch(searchVO);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public List<Company> SearchByName(String name) {
		try {
			return new CompanyDao().SearchByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
	public Company findCompanyName(String userName){
		CompanyDao companyDao = new CompanyDao();
		try {
			return companyDao.findByCompanyName(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public Company findByName(String name)
	{
		try {
			CompanyDao companyDao=new CompanyDao();
			Company company=companyDao.findByName(name);
			return company;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCUtil.closeConnection();
		}
		
	}
	public String findPassmessage(String userName){
		CompanyDao companyDao = new CompanyDao();
		try {
			return companyDao.findPassmessage(userName);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	
	public int updatePassword(String password,String cname){
		CompanyDao companyDao = new CompanyDao();
		try {
			return companyDao.updatePassword(password, cname);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			JDBCUtil.closeConnection();
		}
	}
	public void updatePriceId(String cname,int priceId) {
		CompanyDao companyDao = new CompanyDao();
		 try {
			companyDao.updatePriceId(cname,priceId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
