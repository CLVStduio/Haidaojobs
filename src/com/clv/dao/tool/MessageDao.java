package com.clv.dao.tool;

import org.json.JSONException;

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
