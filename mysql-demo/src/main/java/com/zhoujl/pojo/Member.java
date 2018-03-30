package com.zhoujl.pojo;

public class Member {
	
	private int member_id;
	private String member_name;
	private String member_email;
	private String member_mobile;
	
	public int getId() {
		return member_id;
	}
	public void setId(int id) {
		this.member_id = id;
	}
	
	public String getName() {
		return member_name;
	}
	public void setName(String name) {
		this.member_name = name;
	}
	
	public String getEmail() {
		return member_email;
	}
	public void setEmail(String email) {
		this.member_email = email;
	}
	
	public String getMobile() {
		return member_mobile;
	}
	public void setMobile(String phone) {
		this.member_mobile = phone;
	}
}
