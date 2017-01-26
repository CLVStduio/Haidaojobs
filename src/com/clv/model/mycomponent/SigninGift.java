package com.clv.model.mycomponent;

/**
 * 我的-->签到-->礼包领取情况
 * @author evanglist
 *
 */
public class SigninGift {
	private int signIn_id;
	private String month;
	private String signInGift_date;
	private int user_id;
	public int getSignIn_id() {
		return signIn_id;
	}
	public void setSignIn_id(int signIn_id) {
		this.signIn_id = signIn_id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getSignInGift_date() {
		return signInGift_date;
	}
	public void setSignInGift_date(String signIn_date) {
		this.signInGift_date = signIn_date;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "SignIn [signIn_id=" + signIn_id + ", month=" + month + ", signInGift_date=" + signInGift_date + ", user_id="
				+ user_id + "]";
	}
}
