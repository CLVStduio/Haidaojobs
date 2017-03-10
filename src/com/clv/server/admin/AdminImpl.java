package com.clv.server.admin;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.clv.mapper.AdminMapper;
import com.clv.model.admin.Admin;
import com.clv.model.format.JsonFormat;

import cn.clvstudio.tool.Factory;
import cn.clvstudio.tool.Json;
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
		return Json.toJson(admin, "complementKey","adminPassword").toString();
	}
/*
	@Override
	public String signIn(String phone, String password) throws JSONException {
		return null;
	}
*/
	@Override
	public Map<String,String> idAuthentication(String enId) throws JSONException {
		String deIdmessage = factory.getCrypto().decryptTime(enId);
		Map<String,String> adminMap = new HashMap<String,String>();
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
							//安全码已经过期，请重新登录
							adminMap.put(ADMINID, "-1");
							return adminMap;
						}
						adminMap.put(ADMINID, ""+admin.getAdminId());
						adminMap.put(ADMINIDPHONENO, admin.getAdminPhoneNo());
						adminMap.put(ADMINIDPASSWORD, admin.getAdminPassword());
						adminMap.put(SECURITYKEY, admin.getSecurityKey());
						adminMap.put(HEADPORTRAITPATH, admin.getHeadPortritPath());
						return adminMap;
					}
					//安全码不正确
					adminMap.put(ADMINID, "-2");
					return adminMap;
				}
				//不存在相关信息
				adminMap.put(ADMINID, "-3");
				return adminMap;
			}
			//解密结果不合规范
			adminMap.put(ADMINID, "-5");
			return adminMap;
		}
		//解密失败
		adminMap.put(ADMINID, "-4");
		return adminMap;
	}

}
