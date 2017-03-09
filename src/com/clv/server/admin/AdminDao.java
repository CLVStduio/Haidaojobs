package com.clv.server.admin;

import java.util.Map;

import org.json.JSONException;

import com.clv.server.ServerFather;

public interface AdminDao extends ServerFather{
	/**
	 * 添加管理员
	 * @param phone
	 * @param password
	 * @return
	 */
	 public String addAdmin(String adminName,String permissions,String phone,String password)throws JSONException;
	 /**
	  * 查看管理员信息
	 * @param adminId
	 * @return
	 */
	public String selectAdmin(int adminId);
	 /**
	  * 待实现
	  * 登录
	  * @param phone
	  * @param password
	  * @return
	  */
	//public String signIn(String phone,String password)throws JSONException;
	/**
	  * 身份认证
	  * @param enId
	  * 		：经过加密的身份信息
	  * @return
	  * 		：解密后可用的id或则是错误信息
	  */
	public Map<String,String> idAuthentication(String enId)throws JSONException;
}
