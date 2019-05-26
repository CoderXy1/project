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

import com.coder.model.DeptInfo;
import com.coder.model.NoticeInfo;
import com.coder.model.PostInfo;
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
	 * @exception 通过uid获得用户名
	 * @return boolean
	 * 
	 **/
	public String getUserNameById(String uid) {
		checkConnect();
		String name = "";
		String sql = "select * from tb_user where uid = '" + uid + "'";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				name = rs.getString("uname");
				conn.close();
				return name;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return name;
	}
	
	/**
	 * @exception 通过用户名和权限查找用户的list集合
	 * @return list
	 * 
	 **/
	public List<UserInfo> getAllUser(String uName,String power) {
		checkConnect();
		List<UserInfo> list_user = new ArrayList<UserInfo>();
		String sql = "";
		if (uName == null && power == null) {
			sql = "select * from tb_user";
		}else if (uName == null) {
			if (power.equals("全部")) {
				sql = "select * from tb_user";
			}else{
				sql = "select * from tb_user where power = '" + power + "'";
			}
		}else{
			if (uName.equals("")) {
				if (power.equals("全部")) {
					sql = "select * from tb_user";
				}else{
					sql = "select * from tb_user where power = '" + power + "'";
				}
			}else {
				if (power.equals("全部")) {
					sql = "select * from tb_user where uname like '%" + uName + "%'";
				}else{
					sql = "select * from tb_user where uname like '%" + uName + "%' and power = '" + power + "'";
				}
			}

		}
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				UserInfo user = new UserInfo();
				user.setUid(rs.getString("uid"));
				user.setUname(rs.getString("uname"));
				user.setPassword(rs.getString("password"));
				user.setState(rs.getString("state"));
				user.setTime(rs.getString("time"));
				user.setPower(rs.getString("power"));
				list_user.add(user);	
			}
			conn.close();
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
			stmt.executeUpdate();
			conn.close();
			return true;
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
			stmt.executeUpdate();
			return true;
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
		String sql = "delete from tb_user where uid = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,uid);
			stmt.executeUpdate();
			conn.close();
			return true;
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
	
	/**
	 * @exception 获得部门id最大值
	 * @return boolean
	 * 
	 **/
	public int getMaxDeptId() {
		checkConnect();
		String sql = "select max(did) as maxNo from tb_dept";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				return rs.getInt("maxNo");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @exception 通过部门名查找部门的list集合
	 * @return list
	 * 
	 **/
	public List<DeptInfo> getAllDept(String deptName) {
		checkConnect();
		List<DeptInfo> list_dept = new ArrayList<DeptInfo>();
		String sql = "";
		if (deptName == null) {
			sql = "select * from tb_dept";
		}else{
			sql = "select * from tb_dept where name like '%" + deptName + "%'";
		}

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				DeptInfo dept = new DeptInfo();
				dept.setDid(rs.getInt("did"));
				dept.setName(rs.getString("name"));
				dept.setInfo(rs.getString("info"));
				list_dept.add(dept);	
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_dept;
	}
	
	/**
	 * @exception 删除部门
	 * @return boolean
	 * 
	 **/
	public boolean deleteDept(String did) {
		checkConnect();
		String sql = "delete from tb_dept where did = " + did;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @exception 添加部门信息
	 * @return boolean
	 * 
	 **/
	public boolean addDept(String name, String info) {
		int did = getMaxDeptId() + 1;
		checkConnect();
		String sql = "insert into tb_dept (did,name,info) values (?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,did);
			stmt.setString(2, name);
			stmt.setString(3, info);
			stmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @exception 获得公告id最大值
	 * @return boolean
	 * 
	 **/
	public int getMaxNoticeId() {
		checkConnect();
		String sql = "select max(nid) as maxNo from tb_notice";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				return rs.getInt("maxNo");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	/**
	 * @exception 添加公告信息
	 * @return boolean
	 * 
	 **/
	public boolean addNotice(String name, String content,String time,String uid) {
		int nid = getMaxNoticeId() + 1;
		checkConnect();
		String sql = "insert into tb_notice (nid,name,content,time,uid) values (?,?,?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,nid);
			stmt.setString(2, name);
			stmt.setString(3, content);
			stmt.setString(4, time);
			stmt.setString(5, uid);
			stmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @exception 获得所有的公告list
	 * @return list
	 * 
	 **/
	public List<NoticeInfo> getAllNotice(String name,String content) {
		checkConnect();
		List<NoticeInfo> list_user = new ArrayList<NoticeInfo>();
		String sql = "";
		if (name == null && content == null) {
			sql = "select * from tb_notice";
		}else if (name == null) {
			sql = "select * from tb_notice where content like '%" + content + "%'";
		}else{
			sql = "select * from tb_notice where content like '%" + name + "%' and content like '%" + content + "%'";
		}
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				NoticeInfo notice = new NoticeInfo();
				notice.setNid(rs.getInt("nid"));
				notice.setName(rs.getString("name"));
				notice.setContent(rs.getString("content"));
				notice.setTime(rs.getString("time"));
				notice.setUid(rs.getString("uid"));
				list_user.add(notice);	
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_user;
	}
	
	/**
	 * @exception 删除公告
	 * @return boolean
	 * 
	 **/
	public boolean deleteNotice(String nid) {
		checkConnect();
		String sql = "delete from tb_notice where nid = " + nid;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @exception 获得职位id最大值
	 * @return boolean
	 * 
	 **/
	public int getMaxPostId() {
		checkConnect();
		String sql = "select max(pid) as maxNo from tb_post";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()){
				return rs.getInt("maxNo");
			}		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * @exception 通过职位名查找职位的list集合
	 * @return list
	 * 
	 **/
	public List<PostInfo> getAllPostt(String postName) {
		checkConnect();
		List<PostInfo> list_post = new ArrayList<PostInfo>();
		String sql = "";
		if (postName == null) {
			sql = "select * from tb_post";
		}else{
			sql = "select * from tb_post where name like '%" + postName + "%'";
		}

		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				PostInfo post = new PostInfo();
				post.setPid(rs.getInt("pid"));
				post.setName(rs.getString("name"));
				post.setInfo(rs.getString("info"));
				list_post.add(post);	
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list_post;
	}
	
	/**
	 * @exception 添加部门信息
	 * @return boolean
	 * 
	 **/
	public boolean addPost(String name, String info) {
		int pid = getMaxPostId() + 1;
		checkConnect();
		String sql = "insert into tb_post (pid,name,info) values (?,?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,pid);
			stmt.setString(2, name);
			stmt.setString(3, info);
			stmt.executeUpdate();
			conn.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * @exception 删除职位
	 * @return boolean
	 * 
	 **/
	public boolean deletePost(String pid) {
		checkConnect();
		String sql = "delete from tb_post where pid = " + pid;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	

}
