package com.coder.dao;

/**
 *  数据库的相关操作
 * 
 * **/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.coder.model.UserInfo;

public class Dao {

	private SqlBean db = new SqlBean();
	private Connection conn;
	private PreparedStatement stmt = null;

	/**
	 * @exception 检测数据库连接状态
	 * 
	 **/
	public void checkConnect() {
		try {
			if (conn == null || conn.isClosed()) {
				conn = db.getConnection();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @exception 检验登录是否正确
	 * @return boolean
	 * 
	 **/
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

	/**
	 * @exception 获得所有用户的list集合
	 * @return list
	 * 
	 **/
	public List<UserInfo> getAllUser() {
		checkConnect();
		List<UserInfo> list_user = new ArrayList<UserInfo>();
		String sql = "select * from tb_user";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_user;
	}

	/**
	 * @exception 添加用户信息
	 * @return boolean
	 * 
	 **/
	public boolean addUser(String uid, String uname, String password, String state, String time, String power) {
		checkConnect();
		String sql = "insert into tb_user (uid,uname,password,state,time,power) values (?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, uname);
			stmt.setString(3, password);
			stmt.setString(4, state);
			stmt.setString(5, time);
			stmt.setString(6, power);
			if (stmt.execute()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @exception 通过普通用户删除用户信息(需要密码)
	 * @return boolean
	 * 
	 **/
	public boolean deleteUserByUser(String uid, String password) {
		checkConnect();
		String sql = "delete from tb_user where uid = ? and password = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, uid);
			stmt.setString(2, password);
			if (stmt.execute()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @exception 通过管理员删除用户信息(不需要密码)
	 * @return boolean
	 * 
	 **/
	public boolean deleteUserByAdmin(String uid) {
		checkConnect();
		String sql = "delete from tb_user where uid = " + uid;
		try {
			stmt = conn.prepareStatement(sql);
			if (stmt.execute()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * @exception 添加员工信息
	 * @return boolean
	 * 
	 **/
	public boolean addWorker(String wId, String wName, String sex, String phone, String email, String pid,
			String education, String idNumber, String address, String creatTime, String birthday, String interests,
			String qq, String political, String postcode, String family, String major, String remarks, String did) {
		checkConnect();
		String sql = "insert into tb_user (wId,wName,sex,phone,email,pid,education,idNumber, "
				+ "address,creatTime,birthday,interests,qq,political,postcode,family,major,remarks,did) values (?,?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,wId);
			stmt.setString(2,wName);
			stmt.setString(3,sex);
			stmt.setString(4,phone);
			stmt.setString(5,email);
			stmt.setString(6,pid);
			stmt.setString(7,education);
			stmt.setString(8,idNumber);
			stmt.setString(9,address);
			stmt.setString(10,creatTime);
			stmt.setString(11,birthday);
			stmt.setString(12,interests);
			stmt.setString(13,qq);
			stmt.setString(14,political);
			stmt.setString(15,postcode);
			stmt.setString(16,family);
			stmt.setString(17,major);
			stmt.setString(18,remarks);
			stmt.setString(19,did);
			if (stmt.execute()) {
				conn.close();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
