package com.coder.model;

public class NoticeInfo {
	private int nid;
	private String name;
	private String content;
	private String time;
	private String uid;
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	
	public NoticeInfo() {
		
	}
	
	public NoticeInfo(int nid, String name, String content, String time, String uid) {
		super();
		this.nid = nid;
		this.name = name;
		this.content = content;
		this.time = time;
		this.uid = uid;
	}

	
	
	
	
	
	

}
