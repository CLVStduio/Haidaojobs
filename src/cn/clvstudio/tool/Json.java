package cn.clvstudio.tool;

import java.util.List;

import org.json.JSONArray;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

/**
 * Json操作相关类
 * @author   Evanglist
 * @time 2016.12.31
 */
public class Json {
	/**
	 * 将对象类转成JSON格式的字符串输出
	 * @param obj
	 * 		对象类
	 * @param strings
	 * 		不参与输出的属性名
	 * @return
	 */
	public JSONObject toJson(Object obj,String ...strings){
		JsonConfig config = new JsonConfig();    
		if(strings != null){
			config.setIgnoreDefaultExcludes(false);       
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);     
			config.setExcludes(strings);//只要设置这个数组，指定过滤哪些字段。    
		}
		JSONObject object = JSONObject.fromObject(obj,config);
		return object;
	}
	
	public <T> JSONArray listToJsonArray(List<T> list,String ...strings){
		JSONArray jsonArray = new JSONArray();
		for(T t : list){
			jsonArray.put(toJson(t,strings));
		}
		return jsonArray;
	}
}
