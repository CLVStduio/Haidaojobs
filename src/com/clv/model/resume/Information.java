package com.clv.model.resume;

/**
 * 用户基本信息映射类
 * @author evanglist
 *
 */
public class Information {
	private int informationId;
	private int userId;
	private String name;
	private String gender;
	private String height;
	private String dateBirth;
	private String email;
	
	public int getInformationId() {
		return informationId;
	}
	public void setInformationId(int informationId) {
		this.informationId = informationId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Information [informationId=" + informationId + ", userId=" + userId + ", name=" + name + ", gender="
				+ gender + ", height=" + height + ", dateBirth=" + dateBirth + ", email=" + email + "]";
	}
	
	
}
