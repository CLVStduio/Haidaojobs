package com.clv.user.dao;

import org.json.JSONException;

/**
 * “我的”中的各小部件
 * @author evanglist
 *
 */
public interface MyComponent {
	/**
	 * 补签
	 * @param user_id
	 * 			用户id
	 * @param date
	 * 			补签日期（7天内方可补签）
	 * @return
	 * @throws JSONException
	 */
	public String retroactive(int user_id ,int date) throws JSONException;
	
	/**
	 * 查询签到情况
	 * @param user_id
	 * 			用户id
	 * @param year
	 * 			查询的年份
	 * @param Month
	 * 			查询的月份
	 * @return
	 * @throws JSONException
	 */
	public String selectSignIn(int user_id,int year,String month) throws JSONException;
	
}
