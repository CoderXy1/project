package com.coder.model;

public class DeptInfo {
	private String  did;
	private String name;
	private String info;
	
	
	public String getDid() {
		return did;
	}
	public void setDid(String did) {
		this.did = did;
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
	public DeptInfo(String did, String name, String info) {
		super();
		this.did = did;
		this.name = name;
		this.info = info;
	}
	
}
