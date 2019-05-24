package com.coder.service;

import java.util.ArrayList;
import java.util.List;

import com.coder.dao.Dao;
import com.coder.model.MenuInfo;
import com.coder.model.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class UserService {

	private Dao dao = new Dao();

	public JSONObject searchUserService(String uname, String power) {
		JSONObject tree = new JSONObject();
		List<UserInfo> list = dao.getAllUser(uname, power);
		tree.put("total", list.size());
		tree.put("rows", list);
		return tree;
	}
	
	public boolean deleteUserService(String uid) {
		
		JSONArray json = JSONArray.fromObject(uid);	
		for (int i=0;i < json.size();i++) {
			JSONObject tree = json.getJSONObject(i);
			dao.deleteUserByAdmin(tree.getString("uid"));
		}
		return true;
		
	}
	
	public boolean addUserService(String uid, String uname, String password, String state, String time, String power) {
		
		return dao.addUser(uid, uname, password, state, time, power);

	}
	
}
