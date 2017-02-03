package com.clv.model.admin;

/**
 * 管理员数据库映射类
 * @author evanglist
 *
 */
public class Admin{
	private int adminId;
	private String adminName;
	private int permissions;
	private String adminPassword;
	private String adminPhoneNo;
	private String securityKey;
	private String complementKey;
	private String headPortritPath;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public int getPermissions() {
		return permissions;
	}
	public void setPermissions(int permissions) {
		this.permissions = permissions;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public String getAdminPhoneNo() {
		return adminPhoneNo;
	}
	public void setAdminPhoneNo(String adminPhoneNo) {
		this.adminPhoneNo = adminPhoneNo;
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
	public String getHeadPortritPath() {
		return headPortritPath;
	}
	public void setHeadPortritPath(String headPortritPath) {
		this.headPortritPath = headPortritPath;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", permissions=" + permissions
				+ ", adminPassword=" + adminPassword + ", adminPhoneNo=" + adminPhoneNo + ", securityKey="
				+ securityKey + ", complementKey=" + complementKey + ", headPortritPath=" + headPortritPath + "]";
	}
	
}