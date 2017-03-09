package com.clv.server.user;

import java.util.Calendar;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clv.mapper.MyComponentMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.mycomponent.Signin;
import com.clv.model.mycomponent.SigninGift;

import cn.clvstudio.tool.Factory;

/**
 * “我的”中的各小部件实现类
 * @author evanglist
 *
 */
@Service
public class MyComponentImpl implements MyComponentServer {
	@Autowired
	private MyComponentMapper myCMapper;
	private Factory factory = new Factory();
	
	private String tableNameSignIn;
	private String tableNameSignInGift;
	private Calendar nowtime;
	
	public MyComponentImpl(){
		this.nowtime = Calendar.getInstance(); 
		this.tableNameSignIn = "my_signin_"+this.nowtime.get(Calendar.YEAR);
		this.tableNameSignInGift = "my_signingift_"+this.nowtime.get(Calendar.YEAR);
	}
	@Override
	public String retroactive(Map<String,String> userMap, int date) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			nowtime = Calendar.getInstance(); 
			int day = nowtime.get(Calendar.DAY_OF_MONTH);
			if(day-date<=7 && day-date>=0){
				String month = Integer.valueOf(nowtime.get(Calendar.MONTH)+1).toString();
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, userId, month);
				if(signIn!=null){
					String binary = Long.toBinaryString(Long.parseLong(signIn.getSignIn_date(), 16));
					if( date<33-binary.length() || binary.charAt(binary.length()-33+date) != '1'){
						String newDate = Long.toHexString((long) Math.pow(2.0, 32.0-date)+Long.parseLong(signIn.getSignIn_date(), 16));
						myCMapper.modifySignIn(tableNameSignIn, signIn.getSignIn_id(), "'"+newDate+"'");
						return new JsonFormat(SUCCESS,factory.getSignIn().getDate(newDate)).toString();
					}
//					已经签过到了
					return new JsonFormat("101",FAIL).toString();
				}
				long dec = (long) Math.pow(2.0, 32.0-date);
				myCMapper.addSignIn(tableNameSignIn, month,"'"+Long.toHexString(dec)+"'", userId);
				return new JsonFormat(SUCCESS,factory.getSignIn().getDate(Long.toHexString(dec))).toString();
			}
//			签到时间超过规定日期
			return new JsonFormat("102",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String selectSignIn(Map<String,String> userMap,int year, String month) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(year>=2017){
			if(userId>0){
				tableNameSignIn = "my_signin_"+year;
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, userId, month);
				if(signIn != null)
					return new JsonFormat(SUCCESS,factory.getSignIn().getDate(signIn.getSignIn_date())).toString();
//				无该年月记录
				return new JsonFormat(SUCCESS,factory.getSignIn().getDate("0")).toString();
			}
			return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
		}
//		无该年月记录
		return new JsonFormat(SUCCESS,factory.getSignIn().getDate("0")).toString();
	}
	public String selectGiftBag(Map<String,String> userMap,int year,String month) throws JSONException{
		int userId = Integer.parseInt(userMap.get(USERID));
		if(year>=2017){
			if(userId>0){
				tableNameSignInGift = "my_signingift_"+year;
				SigninGift signinGift = myCMapper.selectSignInGiftBag(tableNameSignInGift, userId, month);
				if(signinGift != null)
					return new JsonFormat(SUCCESS,factory.getSignIn().getDate(signinGift.getSignInGift_date())).toString();
				
				return new JsonFormat(SUCCESS,factory.getSignIn().getDate("0")).toString();
			}
			return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
		}
//		无该年月记录
		return new JsonFormat(SUCCESS,factory.getSignIn().getDate("0")).toString();
	}
	@Override
	public String skillGiftBag(Map<String,String> userMap, int date) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId > 0){
			if(date>0 && date <32){
				String month = Integer.valueOf(nowtime.get(Calendar.MONTH)+1).toString();
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, userId, month);		
				if(signIn !=null){
					SigninGift giftRecord = myCMapper.selectSignInGiftBag(tableNameSignInGift, userId, month);
					long giftRLong = giftRecord == null ? 0L : Long.parseLong(giftRecord.getSignInGift_date(), 16);
					if(factory.getSignIn().isGift(signIn.getSignIn_date(),giftRLong, date)){
						giftRLong += (long)Math.pow(2.0, 32.0-date);
						if(giftRecord == null)
							myCMapper.addSignInGiftBag(tableNameSignInGift, month, Long.toHexString(giftRLong), userId);
						else
							myCMapper.modifySignInGiftBag(tableNameSignInGift, giftRecord.getSignIn_id(), Long.toHexString(giftRLong));
						return new JsonFormat(SUCCESS,new JSONArray().put(new JSONObject().put("gift", (int)(Math.random()*13)+3))).toString();
					}
					return new JsonFormat("101",FAIL).toString();
				}
				return new JsonFormat("102",FAIL).toString();
			}
			return new JsonFormat("103",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

}
