package com.tt.springboottest.ui.dao;

import java.sql.ResultSet;

public interface WorkDaysRepository {
	int workdayAdd(String date);
	/*
	 * throws SQLException { String sql = "insert into workday values (null,?)";
	 * PreparedStatement pstmt = con.prepareStatement(sql); pstmt.setString(1,
	 * date); return pstmt.executeUpdate(); }
	 */

	ResultSet countWorkday(String beginDay,
			String endDay); /*
							 * throws Exception { StringBuffer sb = new
							 * StringBuffer("SELECT COUNT(w.id) - 2 FROM workday w WHERE w.workday BETWEEN '"
							 * +beginDay+"' AND '"+endDay+"'"); PreparedStatement pstmt =
							 * con.prepareStatement(sb.toString()); return pstmt.executeQuery(); }
							 */
}
