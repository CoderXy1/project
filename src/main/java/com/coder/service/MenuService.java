package com.coder.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.coder.model.MenuInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MenuService {
	private int id = 0;
	private String firstMenu[] = {"用户管理","部门管理","职位管理","员工管理","公告管理","下载中心"};
	private String secondMenu[][] = {
		{"用户查询","添加用户"},
		{"部门查询","添加部门"},
		{"职位查询","添加职位"},
		{"员工查询","添加员工"},
		{"公告查询","添加公告"},
		{"文档查询","上传文档"}
	};
	private List<MenuInfo> list_first;
	
	public void initMenu() {
		
		list_first = new ArrayList<>();
		for (int i=0;i < firstMenu.length;i++) {
			MenuInfo menu = new MenuInfo();
			menu.setId(i);
			menu.setText(firstMenu[i]);
			list_first.add(menu);
		}
			
	}
	
	public List<MenuInfo> getMenuInfo(int position){
		List<MenuInfo> list = new ArrayList<MenuInfo>();
		for (int i=0;i < secondMenu[position].length;i++) {
			MenuInfo menu = new MenuInfo();
			menu.setId(i);
			menu.setText(secondMenu[position][i]);
			menu.setPath("test.jsp");
			list.add(menu);
		}
		return list;
	}
	
	public JSONArray getMenu(){
		initMenu();
		JSONArray  tree = JSONArray.fromObject(list_first);
		for (int i = 0; i < tree.size(); i++) {
			JSONObject  f_m = tree.getJSONObject(i);
			List<MenuInfo>  s_m = getMenuInfo(i);
			JSONArray  smjson = JSONArray.fromObject(s_m);
			for (int j = 0; j < smjson.size(); j++) {
				JSONObject sm = smjson.getJSONObject(j);
				sm.put("state", "open");
				sm.put("iconCls","icon-flower");
				JSONObject attr = new JSONObject();
				attr.put("path", sm.getString("path"));
				sm.put("attributes", attr);
			}
			f_m.put("children", smjson);
			f_m.put("iconCls","icon-star");
  		}
		return  tree;
	}
	
}
