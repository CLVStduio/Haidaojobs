package com.mysubmail.lib.base;

import java.util.HashMap;
import java.util.Map;

import com.mysubmail.lib.Mail;

/**
 * A interface define a method of {@link #send(Map)}.All classes what can send
 * request data must implement it.And the classes are always designed as
 * communication mode or a tool,that is,mail mode and message mode.No matter
 * what kinds of mode or tool we choose,we can send a request.
 * 
 * @see Mail
 * @version 1.0 at 2014/10/28
 * */
public interface ISender {

	/**
	 * Send the request data.
	 * @param data {@link HashMap}contains the request data.Such as
	 * <p>
	 * to->xxx@submail.cn
	 * cc->nnn@submail.cn
	 * text->Hello,world!
	 * </p>
	 * @return If send successfully,return true.Error occurs,return false.
	 * */
	public boolean send(Map<String, Object> data);

	public boolean xsend(Map<String, Object> data);
	
	public boolean subscribe(Map<String, Object> data);
	
	public boolean unsubscribe(Map<String, Object> data);

}
