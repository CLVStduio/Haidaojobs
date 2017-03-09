package com.clv.server.user;

import java.util.Map;

import org.json.JSONException;

import com.clv.server.ServerFather;

/**
 * “我的”中的各小部件
 * @author evanglist
 * @建议
 * 		日后建立补签制度的时候，设立签到信息表中，增加补签次数一列
 * 		
 */
public interface MyComponentServer extends ServerFather {
	/**
	 * 补签
	 * @提示
	 * 		日后补签时需要扣除补签次数
	 * @param userMap
	 * 		用户信息
	 * @param date
	 * 			补签日期（7天内方可补签）
	 * @return

	 * @throws JSONException
	 */
	public String retroactive(Map<String,String> userMap ,int date) throws JSONException;
	
	/**
	 * 查询签到情况
	 * @param userMap
	 * 		用户信息
	 * @param year
	 * 			查询的年份
	 * @param Month
	 * 			查询的月份
	 * @return
	 * @throws JSONException
	 */
	public String selectSignIn(Map<String,String> userMap,int year,String month) throws JSONException;
	/**
	 * 查询礼包领取情况
	 * @param userMap
	 * 		用户信息
	 * @param year
	 * 			查询的年份
	 * @param month
	 * 			查询的月份
	 * @return
	 * @throws JSONException
	 */
	public String selectGiftBag(Map<String,String> userMap,int year,String month) throws JSONException;
	
	/**
	 * 判断用户的这个日期是否符合领取条件
	 * 并随机返回领取的礼包内容
	 * 仅本月有效
	 * @param userMap
	 * 		用户信息
	 * @param date
	 * 		用户询问的日期
	 * @return
	 * @throws JSONException
	 */
	public String skillGiftBag(Map<String,String> userMap,int date)throws JSONException;
	
}
