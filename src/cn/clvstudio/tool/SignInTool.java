package cn.clvstudio.tool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * 与签到相关的工具类
 * @author evanglist
 *
 */
public class SignInTool {
	/**
	 * 将十六进制签到记录转译成可视的日期记录
	 * @param strHex
	 * 			十六进制的签到记录
	 * @return
	 * @throws JSONException
	 */
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
	/**
	 * 查询所有可以领取奖励的日期
	 * @param signInHex
	 * @return
	 */
	public long selectGift(String signInHex) {
		String signInBin = Long.toBinaryString(Long.parseLong(signInHex, 16));
		int num=0;
		int leng = signInBin.length();
		long hex = 0l;
		for(int i=0;i<leng;i++){
			num = signInBin.charAt(i)=='1' ? ++num:0;
			if(num == 7){
				hex+=(long)Math.pow(2,signInBin.length()-i-1 );
				num=0;
			}
		}
		return hex;
	}
	public boolean isGift(String signInHex,long hex,int date){
		String binary = Long.toBinaryString(selectGift(signInHex)-hex);
		int leng = binary.length();
		for(int i=0;i<leng;i++){
			if(binary.charAt(i)=='1' && date == i+33-binary.length()){
				return true;
			}
		}
		return false;
	}
}
