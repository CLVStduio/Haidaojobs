package com.clv.admin.dao;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clv.mapper.AdminMapper;
import com.clv.model.admin.Admin;
import com.clv.model.format.JsonFormat;

import cn.clvstudio.tool.Factory;
@Component
public class AdminImpl implements AdminDao {
	@Autowired
	private AdminMapper adminMapper;
	private Factory factory = new Factory();
	
	@Override
	public String addAdmin(String adminName, String permissions, String enPhone, String enPassword) throws JSONException {
		String phone = factory.getCrypto().decryptTime(enPhone);
		String password = factory.getCrypto().decryptTime(enPassword);
		if("fail".equals(phone) || "fail".equals(password) || phone == null || password==null){
			return new JsonFormat("204","fail").toString();
		}
		adminMapper.addAdmin(adminName, permissions, phone, password, factory.getBKey().builderSecurityKey(phone),factory.getBKey().builderComplementKey(phone));
		return new JsonFormat("success").toString();
	}
	
	@Override
	public String selectAdmin(int adminId) {
		Admin admin = adminMapper.selectAdminById(adminId);
		return factory.getJson().toJson(admin, "complementKey","adminPassword").toString();
	}
/*
	@Override
	public String signIn(String phone, String password) throws JSONException {
		return null;
	}
*/
	@Override
	public int IdAuthentication(String enId) throws JSONException {
//		System.out.println("enId: "+enId);
		String deIdmessage = factory.getCrypto().decryptTime(enId);
		if(deIdmessage!=null ){
			if(deIdmessage.length() >=42){
				StringBuilder sb = new StringBuilder(deIdmessage);
				String skey = sb.substring(0, 29);
				String newTime = sb.substring(29, 42);
				sb.delete(0,42);
				Admin admin = adminMapper.selectAdminById(Integer.parseInt(sb.toString()));
				if(admin!=null){
					if(admin.getSecurityKey().equals(skey)){
						StringBuilder keySb = new StringBuilder(admin.getComplementKey());
						String oldTime = keySb.substring(16);
						if(Long.parseLong(newTime)-Long.parseLong(oldTime)>15*24*60*60*1000){
							System.out.println("安全码已经过期，请重新登录");
							return -1;
						}
						
						return admin.getAdminId();
						
					}
					System.out.println("安全码不正确");
					return -2;
				}
				System.out.println("该ID号不存在");
				return -3;
			}
			return -5;
		}
		System.out.println("解密失败");
		return -4;
	}

	

}
