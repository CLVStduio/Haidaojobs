package com.clv.model.format;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * JSON发送包的格式规范
 * @author Administrator
 * @time 2016.12.31
 */
public class JsonFormat {
	private String code;
	private String msg;
	private JSONArray value;
	private JSONObject json;
	
	public JsonFormat(String msg) throws JSONException {
		super();
		this.msg = msg;
		json = new JSONObject().put("msg", msg);
	}
	public JsonFormat(String code, String msg) throws JSONException {
		super();
		this.code = code;
		this.msg = msg;
		json = new JSONObject().put("code", code).put("msg",msg);
	}
	public JsonFormat(String msg, JSONArray value) throws JSONException {
		super();
		this.msg = msg;
		this.value = value;
		json = new JSONObject().put("msg",msg).put("value", value);
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public JSONArray getVaules() {
		return value;
	}
	public void setVaules(JSONArray value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return json.toString();
	}
}
