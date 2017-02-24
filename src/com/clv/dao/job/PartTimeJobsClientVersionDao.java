package com.clv.dao.job;

import java.sql.Timestamp;

import org.json.JSONException;

public interface PartTimeJobsClientVersionDao {
	/****************客户端****************/
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
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeInformation(int partTimeId)throws JSONException;
	/**
	 * 兼职报名
	 * @param userId
	 * 			用户id
	 * @param enJobId
	 * 			信息匙加密的兼职id
	 * @param enAnswer
	 * 			信息匙加密的问题回答
	 * @return
	 * @throws JSONException
	 */
	public String partTimeRegistration(int userId,String enparttimeId,String enAnswer) throws JSONException;
	/**
	 * 撤销报名
	 * @param userId
	 * 			用户id
	 * @param enparttimeId
	 * 			信息匙加密的兼职id
	 * @return
	 * @throws JSONException
	 */
	public String cancelTheRegistration(int userId,String enparttimeId) throws JSONException;
	/**
	 * 获取待审核列表
	 * @param userId
	 * 			用户id
	 * @return
	 * @throws JSONException
	 */
	public String getPendingList(int userId) throws JSONException;
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
	public String getEnrollmentResults(int userId,String enparttimeId) throws JSONException;
	/**
	 * 获取已录取列表
	 * @param userId
	 * 			用户id
	 * @return
	 * @throws JSONException
	 */
	public String getPartTimeAdmission(int userId) throws JSONException;
	//获取待结算列表
	//确认收到款项
	//获取待评论列表
	//兼职评论
	//投诉商家
}
