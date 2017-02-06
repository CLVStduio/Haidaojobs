package com.clv.model.user;

import java.sql.Date;

/**
 * User的映射类
 * @author Evanglist
 * @time 2016.12.31
 */
public class User {
	private Integer userId;
	private String userName;
	private String userPassword;
	private String userPhoneNo;
	private String securityKey;
	private String complementKey;
	private Date registeredDate;
	private String headPortraitName;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserPhoneNo() {
		return userPhoneNo;
	}
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}
	public String getSecurityKey() {
		return securityKey;
	}
	public void setSecurityKey(String securityKey) {
		this.securityKey = securityKey;
	}
	public String getComplementKey() {
		return complementKey;
	}
	public void setComplementKey(String complementKey) {
		this.complementKey = complementKey;
	}
	public Date getRegisteredDate() {
		return registeredDate;
	}
	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}
	public String getHeadPortraitName() {
		return headPortraitName;
	}
	public void setHeadPortraitName(String headPortraitName) {
		this.headPortraitName = headPortraitName;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userPhoneNo="
				+ userPhoneNo + ", securityKey=" + securityKey + ", complementKey=" + complementKey
				+ ", registeredDate=" + registeredDate + ", headPortraitName=" + headPortraitName + "]";
	}
	
}