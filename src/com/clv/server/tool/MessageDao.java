package com.clv.server.tool;

import org.json.JSONException;

/**
 * 短信相关工具类
 * @author evanglist
 *
 */
public interface MessageDao {
	/**
	 * 获取验证码
	 * @param phone
	 * @return
	 * @throws ApiException 
	 */
	public String getCode(String phone) throws JSONException;
	 /**
	  * 效对验证码
	  * @param phone
	  * @param code
	  * @return
	  */
	 public String checkCode(String phone,String code)throws JSONException;
}
