package com.clv.user.dao;

import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clv.mapper.MyComponentMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.mycomponent.Signin;
import com.clv.model.mycomponent.SigninGift;

import cn.clvstudio.tool.Factory;

@Component
public class MyComponentImpl implements MyComponent {
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
	public String retroactive(int user_id, int date) throws JSONException {
		if(user_id>0){
			nowtime = Calendar.getInstance(); 
			int day = nowtime.get(Calendar.DAY_OF_MONTH);
			if(day-date<=7 && day-date>=0){
				String month = Integer.valueOf(nowtime.get(Calendar.MONTH)+1).toString();
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, user_id, month);
				if(signIn!=null){
					String binary = Long.toBinaryString(Long.parseLong(signIn.getSignIn_date(), 16));
					if( date<33-binary.length() || binary.charAt(binary.length()-33+date) != '1'){
						String newDate = Long.toHexString((long) Math.pow(2, 32-date)+Long.parseLong(signIn.getSignIn_date(), 16));
						myCMapper.modifySignIn(tableNameSignIn, signIn.getSignIn_id(), "'"+newDate+"'");
						return new JsonFormat("success",factory.getSignIn().getDate(newDate)).toString();
					}
//					System.out.println("已经签过到了");
					return new JsonFormat("101","fail").toString();
				}
				long dec = (long) Math.pow(2, 32-date);
				myCMapper.addSignIn(tableNameSignIn, month,"'"+Long.toHexString(dec)+"'", user_id);
				return new JsonFormat("success",factory.getSignIn().getDate(Long.toHexString(dec))).toString();
			}
//			System.out.println("签到时间超过规定日期");
			return new JsonFormat("102","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}

	@Override
	public String selectSignIn(int user_id,int year, String month) throws JSONException {
		if(year>=2017){
			if(user_id>0){
				tableNameSignIn = "my_signin_"+year;
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, user_id, month);
				if(signIn != null)
					return new JsonFormat("success",factory.getSignIn().getDate(signIn.getSignIn_date())).toString();
//				System.out.println("无该年月记录");
				return new JsonFormat("success",factory.getSignIn().getDate("0")).toString();
			}
			return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
		}
//		System.out.println("无该年月记录");
		return new JsonFormat("success",factory.getSignIn().getDate("0")).toString();
	}
	public String selectGiftBag(int user_id,int year,String month) throws JSONException{
		if(year>=2017){
			if(user_id>0){
				tableNameSignInGift = "my_signingift_"+year;
				SigninGift signinGift = myCMapper.selectSignInGiftBag(tableNameSignInGift, user_id, month);
				if(signinGift != null)
					return new JsonFormat("success",factory.getSignIn().getDate(signinGift.getSignInGift_date())).toString();
				
				return new JsonFormat("success",factory.getSignIn().getDate("0")).toString();
			}
			return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
		}
//		System.out.println("无该年月记录");
		return new JsonFormat("success",factory.getSignIn().getDate("0")).toString();
	}
	@Override
	public String skillGiftBag(int user_id, int date) throws JSONException {
		if(user_id > 0){
			if(date>0 && date <32){
				String month = Integer.valueOf(nowtime.get(Calendar.MONTH)+1).toString();
				Signin signIn = myCMapper.selectSignIn(tableNameSignIn, user_id, month);		
				if(signIn !=null){
					SigninGift giftRecord = myCMapper.selectSignInGiftBag(tableNameSignInGift, user_id, month);
					long giftRLong = giftRecord == null ? 0L : Long.parseLong(giftRecord.getSignInGift_date(), 16);
					if(factory.getSignIn().isGift(signIn.getSignIn_date(),giftRLong, date)){
						giftRLong += (long)Math.pow(2, 32-date);
						if(giftRecord == null)
							myCMapper.addSignInGiftBag(tableNameSignInGift, month, Long.toHexString(giftRLong), user_id);
						else
							myCMapper.modifySignInGiftBag(tableNameSignInGift, giftRecord.getSignIn_id(), Long.toHexString(giftRLong));
						return new JsonFormat("success",new JSONArray().put(new JSONObject().put("gift", (int)(Math.random()*13)+3))).toString();
					}
					return new JsonFormat("101","fail").toString();
				}
				return new JsonFormat("102","fail").toString();
			}
			return new JsonFormat("103","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}

}
