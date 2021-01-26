package com.kmmall.bean;

public class MallUser {
	private Integer user_id;
	private String user_name;
	private String user_pic;
	private String user_sex;
	private String user_account;
	private String user_password;
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_pic() {
		return user_pic;
	}
	public void setUser_pic(String user_pic) {
		this.user_pic = user_pic;
	}
	public String getUser_sex() {
		return user_sex;
	}
	public void setUser_sex(String user_sex) {
		this.user_sex = user_sex;
	}
	public String getUser_account() {
		return user_account;
	}
	public void setUser_account(String user_account) {
		this.user_account = user_account;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "MallUser [user_id=" + user_id + ", user_name=" + user_name + ", user_pic=" + user_pic + ", user_sex="
				+ user_sex + ", user_account=" + user_account + ", user_password=" + user_password + "]";
	}
	
}
