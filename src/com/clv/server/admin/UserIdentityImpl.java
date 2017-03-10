package com.clv.server.admin;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clv.mapper.AdminMapper;
import com.clv.mapper.ResumeMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.resume.Identity;

import cn.clvstudio.tool.Factory;
import cn.clvstudio.tool.Json;

/**
 * 用户身份审核相关实现
 * @author evanglist
 *
 */
@Service
public class UserIdentityImpl implements UserIdentityServer{
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private ResumeMapper resumeMapper;
	
	private Factory factory = new Factory();
	@Override
	public String getAuditQueue(Map<String,String> adminMap) throws JSONException {
		int adminId = Integer.parseInt(adminMap.get(ADMINID));
		if(adminId>0){
			List<Identity> auditQueue = adminMapper.getAuditQueue();
			if(auditQueue != null){
				JSONArray jsonArray = Json.listToJsonArray(auditQueue);
				return new JsonFormat(SUCCESS,jsonArray).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(adminId),FAIL).toString();
	}

	@Override
	public String selectIdentity(Map<String,String> adminMap, String enUserId) throws JSONException {
		int adminId = Integer.parseInt(adminMap.get(ADMINID));
		if(adminId>0){
			String userIdStr = factory.getCrypto().decrypMessage(enUserId,adminMap.get(ADMINIDPHONENO),adminMap.get(SECURITYKEY));
			if(!FAIL.equals(userIdStr)){
				int userId = Integer.parseInt(userIdStr);
				Identity identity = resumeMapper.selectIdentity(userId);
				if(identity != null){
					return new JsonFormat(SUCCESS,new JSONArray().put(Json.toJson(identity))).toString();
				}
				//不存在相关信息
				return new JsonFormat("101",FAIL).toString();
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("21"+Math.abs(adminId),FAIL).toString();
	}

	@Override
	public String setAuditConclusion(Map<String,String> adminMap, String enUserId, int auditType) throws JSONException {
		int adminId = Integer.parseInt(adminMap.get(ADMINID));
		if(adminId>0){
			String userIdStr = factory.getCrypto().decrypMessage(enUserId,adminMap.get(ADMINIDPHONENO),adminMap.get(SECURITYKEY));
			if(!FAIL.equals(userIdStr)){
				int userId = Integer.parseInt(userIdStr);
				Identity identity = resumeMapper.selectIdentity(userId);
				if(identity != null){
					if(identity.getAuditType()!=1){
						adminMapper.modifyAuditTypeOfIdentity(userId, adminId, auditType);
						if(auditType == 1){
							resumeMapper.modifyIdentityOfInformation(userId, identity.getName(), identity.getGender(), identity.getDateBirth());
						}
						return new JsonFormat(SUCCESS).toString();
					}
					//已经认证成功不能修改
					return new JsonFormat("101",FAIL).toString();
				}
				//不存在相关认证信息
				return new JsonFormat("401",FAIL).toString();
			}
			//信息解密失败
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(adminId),FAIL).toString();
	}
}
