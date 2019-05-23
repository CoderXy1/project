package com.coder.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {

	private SqlBean db = new SqlBean();
	private Connection conn;
	private PreparedStatement stmt = null;

	public void checkConnect() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = db.getConnection();
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		}
	}

	// 检验登录信息
	public boolean isRight(String name, String pass) {
		checkConnect();
		String sql = "select * from tb_user where uid = '" + name + "' and password = '" + pass + "'";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
