package com.clv.model.resume;

/**
 * 用户身份信息映射类
 * @author evanglist
 *
 */
public class Identity {
	private int identityId;
	/**
	 * 用户id
	 */
	private int userId;
	private String name;
	private String gender;	
	/**
	 * 用户提交的身份证号
	 */
	private String idNum;
	private String dateBirth;
	private int adminId;
	/**
	 * 认证情况
	 * 0：认证中
	 * 1：认证成功
	 * 2：姓名填写错误
	 * 3：性别填写错误
	 * 4：身份证填写错误
	 * 5：身份证照片拍摄不符合规范
	 * 6：审核员认为非本人操作
	 * 7：其他原因
	 */
	private int auditType;
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
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
	public int getAuditType() {
		return auditType;
	}
	public void setAuditType(int auditType) {
		this.auditType = auditType;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getDateBirth() {
		return dateBirth;
	}
	public void setDateBirth(String dateBirth) {
		this.dateBirth = dateBirth;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	@Override
	public String toString() {
		return "Identity [identityId=" + identityId + ", userId=" + userId + ", name=" + name + ", gender=" + gender
				+ ", auditType=" + auditType + ", idNum=" + idNum + ", dateBirth=" + dateBirth + ", adminId=" + adminId
				+ "]";
	}

	
}
