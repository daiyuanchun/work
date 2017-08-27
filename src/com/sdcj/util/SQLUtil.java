package com.sdcj.util;

public class SQLUtil {
	
	public static String getPageSql(String sql, int page, int recordOfPage) {
		String pageSql = "select * from ( select rownum rn,temp.* from ("
				+ sql
				+ ") temp ) t " 
				+ " where t.rn>" + (page - 1) * recordOfPage
				+ " and  t.rn<=" + (page * recordOfPage);
		return pageSql;

	}
}
