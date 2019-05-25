package com.coder.service;

import java.util.List;

import com.coder.dao.Dao;
import com.coder.model.DeptInfo;
import com.coder.model.NoticeInfo;
import com.coder.model.UserInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class NoticeService {
	
	private Dao dao = new Dao();
	
	public boolean addNoticeService(String name, String content,String time,String uid) {
		
		return dao.addNotice(name, content, time, uid);
	}
	
	public JSONObject searchNoticeService(String deptName,String content) {
		JSONObject tree = new JSONObject();
		List<NoticeInfo> list = dao.getAllNotice(deptName, content);
		tree.put("total", list.size());
		tree.put("rows", list);
		return tree;
	}
	
	public boolean deleteNoticeService(String nid) {
		
		JSONArray json = JSONArray.fromObject(nid);	
		for (int i=0;i < json.size();i++) {
			JSONObject tree = json.getJSONObject(i);
			dao.deleteNotice(tree.getString("nid"));
		}
		return true;
		
	}
}
