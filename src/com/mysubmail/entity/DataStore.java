package com.mysubmail.entity;

import java.util.TreeMap;

import net.sf.json.JSONObject;
import com.mysubmail.utils.StringUtil;

/**
 * A class extends TreeMap in order to store the request data with format of key-value.
 * Such as appid, appkey, to and other information.The TreeMap ensure that the key can be sorted
 * descending to create signature. 
 * @version 1.0 2014/11/2
 * */
public class DataStore extends TreeMap<String, Object> {

	public static final String COMMA = ",";

	private static final long serialVersionUID = 1L;

	public DataStore() {

	}

	/**
	 * Define a adding pattern that data can be added to map one by one
	 * but displayed with a string separated by comma.
	 * For Example,
	 * <code> 
	 * addWithComma("K", "v1");
	 * addWithComma("K", "v2");
	 * </code>
	 * Then, the map is {"K", "v1, v2"}
	 * @param key is the map's key
	 * @param value is the adding data
	 * */
	public void addWithComma(String key, String value) {
		if (StringUtil.isNullOrEmpty(key))
			return;
		if (this.containsKey(key)) {
			String item = COMMA + value;
			this.put(key, this.get(key) + item);
		} else {
			this.put(key, value);
		}
	}

	/**
	 * Define a adding pattern that data can be added to map one by one
	 * but displayed with a string decorated by angle brackets.
	 * For Example,
	 * <code> 
	 * addWithBracket("K", "v11", "v12");
	 * addWithBracket("K", "v21", "v22");
	 * </code>
	 * Then, the map is {"K", "v11<v12>, v21<v22>"}
	 * @param key is the map's key
	 * @param left 
	 * @param right 
	 * */
	public void addWithBracket(String key, String left, String right) {
		addWithComma(key, left + "<" + right + ">");
	}

	/**
	 * Define a adding pattern that data can be added to map one by one
	 * but displayed with a json.
	 * For Example,
	 * <code> 
	 * addWithBracket("K", "jk1", "jv1");
	 * addWithBracket("K", "jk2", "jv2");
	 * </code>
	 * Then, the map is {"K",{"jk1":"jv1","jk2":"jv2"}
	 * @param key is the map's key
	 * @param jKey is the key of json 
	 * @param jValue is the value of json 
	 * */
	public void addWithJson(String key, String jKey, String jValue) {
		if (StringUtil.isNullOrEmpty(key))
			return;
		try {
			JSONObject json = null;
			if (this.containsKey(key)) {
				Object val = this.get(key);
				json = JSONObject.fromObject(val);
			} else {
				json = new JSONObject();
			}
			if (json != null) {
				json.put(jKey, jValue);
				this.put(key, json.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private int idx = 0;

	/**
	 * Put a data with increasing key.
	 * For exmaple,
	 * <code>addWithIncrease("K", "v1");addWithIncrease("K", "v2");
	 * </code>
	 * Then, the map is {"K[0]", v1},{"K[1]", v2}
	 * @param key is the map's key
	 * @param value is the map's value
	 * */
	public void addWithIncrease(String key, Object value) {
		this.put(key + "[" + idx++ + "]", value);
	}
}
