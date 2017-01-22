package cn.clvstudio.tool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SignInTool {
	public JSONArray getDate(String strHex) throws JSONException{
		String binary = Long.toBinaryString(Long.parseLong(strHex, 16));
		JSONArray jsonA = new JSONArray();
		int leng = binary.length();
		for(int i=0;i<leng;i++){
			char c = binary.charAt(i);
			if(c == '1'){
				jsonA.put(new JSONObject().put("day", i+33-leng));
			}
		}
		return jsonA;		
	}
}
