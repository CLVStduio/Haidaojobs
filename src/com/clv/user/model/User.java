package com.clv.user.model;

import java.sql.Date;

/**
 * User的映射类
 * @author Evanglist
 * @time 2016.12.31
 */
public class User {
	private Integer user_id;
	private String user_name;
	private String user_password;
	private String user_phoneNo;
	private String security_key;
	private String complement_key;
	private Date registered_date;
	private String HeadPortraitPath;

	
	public User() {
		super();
	}

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


	public String getUser_password() {
		return user_password;
	}


	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}


	public String getUser_phoneNo() {
		return user_phoneNo;
	}


	public void setUser_phoneNo(String user_phoneNo) {
		this.user_phoneNo = user_phoneNo;
	}


	public String getSecurity_key() {
		return security_key;
	}


	public void setSecurity_key(String security_key) {
		this.security_key = security_key;
	}


	public Date getRegistered_date() {
		return registered_date;
	}


	public void setRegistered_date(Date registered_date) {
		this.registered_date = registered_date;
	}

	public String getComplement_key() {
		return complement_key;
	}

	public void setComplement_key(String complement_key) {
		this.complement_key = complement_key;
	}

	public String getHeadPortraitPath() {
		return HeadPortraitPath;
	}

	public void setHeadPortraitPath(String headPortraitName) {
		HeadPortraitPath = headPortraitName;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", user_name=" + user_name + ", user_phoneNo=" + user_phoneNo
				+ ", security_key=" + security_key + ", complement_key=" + complement_key + ", registered_date="
				+ registered_date + ", HeadPortraitPath=" + HeadPortraitPath + "]";
	}




}