package com.clv.model.parttime;

/**
 * 兼职用户报名信息的数据模型
 * @author evanglist
 *
 */
public class ParttimeRegistration {
	/**
	 * 1、待审核
	 * 2、取消报名
	 * 3、被录取
	 * 4、被拒绝
	 */
	private int registrationType;
	private int userId;
	private int parttimeId;
	public ParttimeRegistration() {
		super();
	}
	public int getRegistrationType() {
		return registrationType;
	}
	public void setRegistrationType(int registrationType) {
		this.registrationType = registrationType;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getParttimeId() {
		return parttimeId;
	}
	public void setParttimeId(int parttimeId) {
		this.parttimeId = parttimeId;
	}
	@Override
	public String toString() {
		return "ParttimeRegistration [registrationType=" + registrationType + ", userId=" + userId + ", parttimeId="
				+ parttimeId + "]";
	}
	
}
