package com.clv.server.admin;

import java.util.Map;

import org.json.JSONException;

import com.clv.server.ServerFather;

/**
 * 用户身份审核相关
 * @author evanglist
 *
 */
public interface UserIdentityServer extends ServerFather{
	/**
	 * 获取待审核队列
	 * @param adminMap
	 * 			管理员信息
	 * @return
	 * @throws JSONException
	 */
	public String getAuditQueue(Map<String,String> adminMap) throws JSONException;
	/**
	 * 查询用户提交的身份认证信息
	 * @param adminMap
	 * 		管理员信息
	 * @param enUserId
	 * 		"信息匙"加密的用户id
	 * @return
	 * @throws JSONException
	 */
	public String selectIdentity(Map<String,String> adminMap,String enUserId) throws JSONException;
	/**
	 * 给出用户认证结果
	 * @param adminMap
	 * 		管理员信息
	 * @param enUserId
	 * 		"信息匙"加密的用户id
	 * @param auditType
	 * 		认证情况结果
	 * @return
	 * @throws JSONException
	 */
	public String setAuditConclusion(Map<String,String> adminMap,String enUserId,int auditType) throws JSONException;
}
