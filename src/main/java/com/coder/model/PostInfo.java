package com.coder.model;

public class PostInfo {
	private String pid;
	private String name;
	private String info;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public PostInfo(String pid, String name, String info) {
		super();
		this.pid = pid;
		this.name = name;
		this.info = info;
	}
	
	
	

}
