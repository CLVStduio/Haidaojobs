package cn.clvstudio.tool;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

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
	public static JSONObject toJson(Object obj,String ...strings){
		JsonConfig config = new JsonConfig();    
		if(strings != null){
			config.setIgnoreDefaultExcludes(false);       
			config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);     
			config.setExcludes(strings);//只要设置这个数组，指定过滤哪些字段。    
		}
		JSONObject object = JSONObject.fromObject(obj,config);
		return object;
	}
	/**
	 * 对象列表转成JSON数组
	 * @param list
	 * @param strings
	 * @return
	 */
	public static <T> JSONArray listToJsonArray(List<T> list,String ...strings){
		JSONArray jsonArray = new JSONArray();
		for(T t : list){
			jsonArray.put(toJson(t,strings));
		}
		return jsonArray;
	}
	/**
	 * 将json对象转换成类对象
	 * @param jsonObject
	 * @param cla
	 * @return
	 */
	public static <T> T convertToObj(org.json.JSONObject jsonObject,Class<T> cla){
    	if(jsonObject==null) return null;
    	
    	Field[] fb  =cla.getDeclaredFields();
    	T t;
    	try {
	    	t = cla.newInstance();
	    	for(int j=0;j<fb.length;j++){
	    		System.out.println("***"+j+"***");
	    	    String fieldName = fb[j].getName();
	    	    System.out.println("*fieldName: "+fieldName);
	    	    String fieldNameU=fieldName.substring(0, 1).toUpperCase()+fieldName.substring(1);
	    	    System.out.println("*fieldNameU: "+fieldNameU);
	    	    Method method=cla.getMethod("set"+fieldNameU, fb[j].getType());
	    	    method.invoke(t, jsonObject.get(fieldName));
	    	}
	    	System.out.println(t.toString());
    	    return t;
    	} catch (SecurityException e) {
    		e.printStackTrace();
    	} catch (IllegalArgumentException e) {
    		e.printStackTrace();
    	} catch (IllegalAccessException e) {
    		e.printStackTrace();
    	} catch (InstantiationException e) {
    		e.printStackTrace();
    	} catch (NoSuchMethodException e) {
    		e.printStackTrace();
    	} catch (InvocationTargetException e) {
    		e.printStackTrace();
    	} catch (JSONException e) {
			e.printStackTrace();
		}
    	return null;
    }

	/**
	 * 将json数组字符串转换成列表
	 * @param str
	 * @param cla
	 * @return
	 */
	public static <T> List<T> convertToList(String str,Class<T> cla){
		JSONArray jsonArray = null;
		try {
			jsonArray = new JSONArray(str);
		} catch (JSONException e1) {
			e1.printStackTrace();
		}
    	List<T> list=new ArrayList<T>();
    	if(jsonArray==null) return list;
    	try {
	    	for(int i=0;i<jsonArray.length();i++){ 
	    		org.json.JSONObject jsonObject = jsonArray.getJSONObject(i);
	    	   T t=convertToObj(jsonObject, cla);
	    	   list.add(t);
	    	}
    	} catch (SecurityException e) {
	    	e.printStackTrace();
    	} catch (IllegalArgumentException e) {
	    	e.printStackTrace();
    	} catch (JSONException e) {
	    	e.printStackTrace();
    	}
    	return list;
	}
}
