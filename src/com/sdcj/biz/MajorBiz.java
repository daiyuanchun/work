package com.sdcj.biz;

import java.util.List;
import com.sdcj.dao.MajorDao;
import com.sdcj.domain.Major;
import com.sdcj.util.JDBCUtil;

public class MajorBiz {
	public List<Major> findAll() {
		try {
			MajorDao majorDao = new MajorDao();
			return majorDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
