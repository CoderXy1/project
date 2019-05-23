package com.coder.model;

public class UserInfo {
	
	private String uid;
	private String uname;
	private String password;
	private String state;
	private String time;
	private String power;
	
	public UserInfo() {
		
	}
	
	public UserInfo(String uid, String uname, String password, String state, String time, String power) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.password = password;
		this.state = state;
		this.time = time;
		this.power = power;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
	
	
	
	
}
