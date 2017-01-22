package com.clv.user.dao;

import java.util.Calendar;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clv.mapper.MyComponentMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.mycomponent.SignIn;

import cn.clvstudio.tool.Factory;

@Component
public class MyComponentImpl implements MyComponent {
	@Autowired
	private MyComponentMapper myCMapper;
	private Factory factory = new Factory();
	
	private static String tableName;
	static Calendar nowtime = Calendar.getInstance(); 
	
	static {
		tableName = "my_signIn_"+nowtime.get(Calendar.YEAR);
	}
	/*
	@Override
	public String signIn(int user_id) throws JSONException {
		if(user_id>0){
			String month = ""+nowtime.get(Calendar.MONTH)+1;
			int day = nowtime.get(Calendar.DAY_OF_MONTH);
			System.out.println("month:"+month+",day:"+day);
			SignIn signIn = myCMapper.selectSignIn(tableName, user_id, month);
			if(signIn == null){
				long dec = (long) Math.pow(2, 32-day);
				System.out.println("dec:"+dec);
				myCMapper.addSignIn(tableName, month,Long.toHexString(dec), user_id);
				return new JsonFormat("success",factory.getReadDate().getDate(Long.toHexString(dec))).toString();
			}
			String newDate = Long.toHexString((long) Math.pow(2,32-day)+Long.parseLong(signIn.getSignIn_date(), 16));
			myCMapper.modifySignIn(tableName, signIn.getSignIn_id(), newDate);
			return new JsonFormat("success",factory.getReadDate().getDate(newDate)).toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}
*/
	@Override
	public String retroactive(int user_id, int date) throws JSONException {
		if(user_id>0){
			String month = ""+nowtime.get(Calendar.MONTH)+1;
			SignIn signIn = myCMapper.selectSignIn(tableName, user_id, month);
			int day = nowtime.get(Calendar.DAY_OF_MONTH);
			if(day-date<=7 && day-date>=0){
				if(signIn!=null){
					String binary = Long.toBinaryString(Long.parseLong(signIn.getSignIn_date(), 16));
					if(binary.charAt(date-1) != '1'){
						String newDate = Long.toHexString((long) Math.pow(2, 32-date)+Long.parseLong(signIn.getSignIn_date(), 16));
						myCMapper.modifySignIn(tableName, signIn.getSignIn_id(), newDate);
						return new JsonFormat("success",factory.getReadDate().getDate(newDate)).toString();
					}
					System.out.println("已经签过到了");
					return new JsonFormat("101","fail").toString();
				}
				long dec = (long) Math.pow(2, 32-date);
				System.out.println("dec:"+dec);
				myCMapper.addSignIn(tableName, month,Long.toHexString(dec), user_id);
				return new JsonFormat("success",factory.getReadDate().getDate(Long.toHexString(dec))).toString();
			}
			System.out.println("签到时间超过规定日期");
			return new JsonFormat("102","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}

	@Override
	public String selectSignIn(int user_id,int year, String month) throws JSONException {
		if(year>=2017){
			if(user_id>0){
				tableName = "my_signIn_"+year;
				SignIn signIn = myCMapper.selectSignIn(tableName, user_id, month);
				if(signIn != null)
					return new JsonFormat("success",factory.getReadDate().getDate(signIn.getSignIn_date())).toString();
				System.out.println("无该年月记录");
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
		}
		System.out.println("无该年月记录");
		return new JsonFormat("101","fail").toString();
	}

}
