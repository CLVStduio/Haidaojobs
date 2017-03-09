package com.clv.server.job;

import java.sql.Timestamp;
import java.util.Map;

import org.json.JSONException;

import com.clv.server.ServerFather;

/**
 * 兼职客户端操作
 * @author evanglist
 * 
 */
public interface PartTimeJobsClientVersionDao extends ServerFather {
	/**
	 * 获取未获取的兼职列表
	 * @param lastTime
	 * 			上次获取兼职的时间
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeList(Timestamp lastTime)throws JSONException;

	/**
	 * 获取兼职详细信息
	 * @param parttimeId
	 * 			兼职id
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeInformation(int partTimeId)throws JSONException;
	/**
	 * 获取兼职详细信息
	 * @param partTimeId
	 * 			兼职id
	 * @param userId
	 * 			用户id
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeInformation(String partTimeId,Map<String,String> userId)throws JSONException;
	/**
	 * 兼职报名
	 * @param userId
	 * 			用户id
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @return
	 * 			若商家未设置问题，则可直接报名
	 * @throws JSONException
	 */
	public String partTimeRegistration(Map<String,String> userId,String enparttimeId) throws JSONException;
	/**
	 * 兼职报名
	 * @param userId
	 * 			用户id
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @param enAnswer
	 * 			信息匙加密的问题回答
	 * @return
	 * 		在商家设计问题时，可直接报名
	 * @throws JSONException
	 */
	public String partTimeRegistration(Map<String,String> userId,String enparttimeId,String enAnswer) throws JSONException;
	/**
	 * 撤销报名
	 * @param userId
	 * 			用户id
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @return
	 * @throws JSONException
	 */
	public String cancelTheRegistration(Map<String,String> userId,String enparttimeId) throws JSONException;
	/**
	 * 获取待审核列表
	 * @param userId
	 * 			用户id
	 * @return
	 * @throws JSONException
	 */
	public String getPendingList(Map<String,String> userId) throws JSONException;
	//查看兼职保名结果
	/**
	 * 获取兼职报名结果
	 * @param userId
	 * 			用户id
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @return
	 * @throws JSONException
	 */
	public String getEnrollmentResults(Map<String,String> userId,String enparttimeId) throws JSONException;
	/**
	 * 获取已录取列表
	 * @param userId
	 * 			用户id
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeAdmission(Map<String,String> userId) throws JSONException;
	//获取待结算列表
	//确认收到款项
	//获取待评论列表
	//兼职评论
	//投诉商家
}
