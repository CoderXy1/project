package com.coder.service;

import java.util.List;

import com.coder.dao.Dao;
import com.coder.model.DeptInfo;
import com.coder.model.UserInfo;
import com.coder.model.WorkersInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WorkerService {
	
	private Dao dao = new Dao();
	
	public boolean addWorkerService(String wName, String sex, String phone, String email, String pName,
			String education, String idNumber, String address, String creatTime, String birthday, String interests,
			String qq, String political, String postcode, String family, String major, String remarks, String dName) {
		
		int did = dao.getDeptIdByName(dName);
		int pid = dao.getPostIdByName(pName);
		return dao.addWorker(wName, sex, phone, email, pid, education, idNumber, address, creatTime, birthday, interests, qq, political, postcode, family, major, remarks, did);
	}
	
	public JSONObject searchWorkerService(String wName,String dName) {
		JSONObject tree = new JSONObject();
		List<WorkersInfo> list = dao.getAllWorker(wName, dName);
		tree.put("total", list.size());
		tree.put("rows", list);
		return tree;
	}
	
	public boolean deleteWorkerService(String wid) {
		
		JSONArray json = JSONArray.fromObject(wid);	
		for (int i=0;i < json.size();i++) {
			JSONObject tree = json.getJSONObject(i);
			dao.deleteWorker(tree.getString("wId"));
		}
		return true;
		
	}
}
