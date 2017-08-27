package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.FieldDao;
import com.sdcj.domain.Field;
import com.sdcj.util.JDBCUtil;

public class FieldBiz {
	public List<Field> findAll() {
		try {
			FieldDao  fieldDao = new FieldDao();
			return  fieldDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
