package com.sdcj.biz;

import java.util.List;

import com.sdcj.dao.WayDao;
import com.sdcj.domain.Way;
import com.sdcj.util.JDBCUtil;

public class WayBiz {
	public List<Way> findAll() {
		try {
			WayDao wayDao=new WayDao();
			return wayDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtil.closeConnection();
		}
	}
}
