package com.coder.service;

import java.util.List;

import com.coder.dao.Dao;
import com.coder.model.DeptInfo;
import com.coder.model.PostInfo;
import com.coder.model.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PostService {
	
	private Dao dao = new Dao();
	
	public boolean addPostService(String postName,String describe) {
		
		return dao.addPost(postName, describe);
	}
	
	public JSONObject searchPostService(String postName) {
		JSONObject tree = new JSONObject();
		List<PostInfo> list = dao.getAllPostt(postName);
		tree.put("total", list.size());
		tree.put("rows", list);
		return tree;
	}
	
	public boolean deletePostService(String pid) {
		
		JSONArray json = JSONArray.fromObject(pid);	
		for (int i=0;i < json.size();i++) {
			JSONObject tree = json.getJSONObject(i);
			dao.deletePost(tree.getString("pid"));
		}
		return true;
		
	}
}
