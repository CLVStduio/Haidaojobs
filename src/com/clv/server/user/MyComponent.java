package com.clv.server.user;

import org.json.JSONException;

/**
 * “我的”中的各小部件
 * @author evanglist
 * @建议
 * 		日后建立补签制度的时候，设立签到信息表中，增加补签次数一列
 * 		
 */
public interface MyComponent {
	/**
	 * 补签
	 * @提示
	 * 		日后补签时需要扣除补签次数
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
	/**
	 * 查询礼包领取情况
	 * @param user_id
	 * 			用户id
	 * @param year
	 * 			查询的年份
	 * @param month
	 * 			查询的月份
	 * @return
	 * @throws JSONException
	 */
	public String selectGiftBag(int user_id,int year,String month) throws JSONException;
	
	/**
	 * 判断用户的这个日期是否符合领取条件
	 * 并随机返回领取的礼包内容
	 * 仅本月有效
	 * @param user_id
	 * 		用户id
	 * @param date
	 * 		用户询问的日期
	 * @return
	 * @throws JSONException
	 */
	public String skillGiftBag(int user_id,int date)throws JSONException;
	
}
