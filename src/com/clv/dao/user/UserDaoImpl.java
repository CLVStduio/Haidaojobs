package com.clv.dao.user;

import java.io.File;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.clv.mapper.UserMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.user.User;


import cn.clvstudio.tool.Factory;

/**
 * 用户DAO实现类
 * @author Evanglist
 * @time 2017.1.16
 */
@Component
public class UserDaoImpl implements UserDao{
	
	@Autowired 
	private UserMapper userMapper;

	private Factory factory = new Factory();
    
	public String getUser(int id) throws JSONException{
		User user = userMapper.selectUserById(id);
		if(user != null){
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"userPassword","registeredDate","complementKey"))).toString();
		}
		return  new JsonFormat("101","fail").toString();
	}
	
	@Override
	public String isUserPhoneNo(String phone) throws JSONException {
		// 判断手机号是否注册
		if(userMapper.selectUserByPhoneNo(phone) == null){
			System.out.println("该手机号未注册");
			return  new JsonFormat("success").toString();
		}else{
			System.out.println("该手机号已经注册");
			return new JsonFormat("101","fail").toString();
		}
			
	}
	
	@Override
	public String addUser(String enPhone, String enPassword) throws JSONException {
		String phone = factory.getCrypto().decryptTime(enPhone);
		String password = factory.getCrypto().decryptTime(enPassword);
		if("fail".equals(phone) || "fail".equals(password) || phone == null || password==null){
			return new JsonFormat("204","fail").toString();
		}
		if(userMapper.selectUserByPhoneNo(phone) == null){
			Date date = new Date(System.currentTimeMillis());
			userMapper.addUser(password,phone,factory.getBKey().builderSecurityKey(phone),factory.getBKey().builderComplementKey(phone),date);
			return new JsonFormat("success").toString();
		}
		//手机号已经注册
		return new JsonFormat("101","fail").toString();
	}

	@Override
	public String signIn(String enPhone,String enPassword) throws JSONException {
		//登录
		String dePhone = factory.getCrypto().decryptTime(enPhone);
		String dePassword = factory.getCrypto().decryptTime(enPassword);
		if("fail".equals(dePhone) || "fail".equals(dePassword) || dePhone == null || dePassword==null){
			return  new JsonFormat("102","fail").toString();
		}
		User user = userMapper.selectUserByPhoneNo(dePhone);
		if( user == null){
			//帐号或密码错误
			return new JsonFormat("101","fail").toString();
		}
		if(user.getUserPassword().equals(dePassword)){
			//登录
			String securityKey = factory.getBKey().builderSecurityKey(dePhone);
			userMapper.modifySecurity(dePhone, securityKey,factory.getBKey().builderComplementKey(dePhone));
			user.setSecurityKey(securityKey);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"userPassword","registeredDate","complementKey"))).toString();
		}else{
			//帐号或密码错误
			return  new JsonFormat("101","fail").toString();
		}
	}

	public int IdAuthentication(String enId){
		String deIdmessage = factory.getCrypto().decryptTime(enId);
		if(deIdmessage!=null ){
			if(deIdmessage.length() >=42){
				StringBuilder sb = new StringBuilder(deIdmessage);
				String skey = sb.substring(0, 29);
				String newTime = sb.substring(29, 42);
				sb.delete(0,42);
				User user = userMapper.selectUserById(Integer.parseInt(sb.toString()));
				if(user!=null){
					if(user.getSecurityKey().equals(skey)){
						StringBuilder keySb = new StringBuilder(user.getComplementKey());
						String oldTime = keySb.substring(16);
						if(Long.parseLong(newTime)-Long.parseLong(oldTime)>15*24*60*60*1000){
							//安全码过期
							return -1;
						}
						return user.getUserId();
					}
					//安全码不正确
					return -2;
				}
				//不存在相关信息
				return -3;
			}
			//解密结果不合规范
			return -5;
		}
		//解密失败
		return -4;
	}
	@Override
	public String modifyUserName(String enmessage, int id) throws JSONException {
		if(id>0){
			User user = userMapper.selectUserById(id);
			String name = factory.getCrypto().decrypMessage(enmessage, user.getUserPhoneNo(), user.getSecurityKey());
			if("fail".equals(name) || name == null){
				return new JsonFormat("401","fail").toString();
			}
			if(name.length()<=15){
				userMapper.modifyUserName(id, name);
				user.setUserName(name);
				return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"userPassword","registeredDate","complementKey"))).toString();
			}
			return new JsonFormat("101","fail").toString();
		}else{
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
	}

	@Override
	public String modifyUserPhone(String enmessage, int id) throws JSONException {
		if(id>0){
			User user = userMapper.selectUserById(id);
			String phone = factory.getCrypto().decrypMessage(enmessage, user.getUserPhoneNo(), user.getSecurityKey());
			if("fail".equals(phone) || phone == null){
				return new JsonFormat("401","fail").toString();
			}
			
			userMapper.modifyUserPhone(id, phone);
			user.setUserPhoneNo(phone);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"userPassword","registeredDate","complementKey"))).toString();
		}else{
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
	}

	@Override
	public String modifyUserPassword(String enOldPassword, String enNewPassword,int id) throws JSONException {
		if(id>0){
			User user = userMapper.selectUserById(id);
			String deoldPassword = factory.getCrypto().decrypMessage(enOldPassword, user.getUserPhoneNo(), user.getSecurityKey());
			String denewPassword = factory.getCrypto().decrypMessage(enNewPassword, user.getUserPhoneNo(), user.getSecurityKey());
			if("fail".equals(deoldPassword) || deoldPassword == null || "fail".equals(denewPassword) || denewPassword == null){
				return new JsonFormat("401","fail").toString();
			}
			if(deoldPassword.equals(user.getUserPassword())){
				userMapper.modifyUserPassword(id, denewPassword);
				return new JsonFormat("success").toString();
			}else{
				return new JsonFormat("101","fail").toString();
			}
		}else{
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
	}

	@Override
	public String resetUserPassword(String enPhone, String enPassword) throws JSONException {
		String dePhone = factory.getCrypto().decryptTime(enPhone);
		String dePassword = factory.getCrypto().decryptTime(enPassword);
		if("fail".equals(dePhone) || "fail".equals(dePassword) || dePhone == null || dePassword==null){
			return new JsonFormat("401","fail").toString();
		}
		User user = userMapper.selectUserByPhoneNo(dePhone);
		if(user != null){
			userMapper.modifyUserPassword(user.getUserId(), dePassword);
			return new JsonFormat("success").toString();
		}else{
			//该手机未注册
			return new JsonFormat("101","fail").toString();
		}
	}

	public String modifyUserHeadPortrait(int id,MultipartFile file,HttpServletRequest request) throws JSONException{
		if(id<=0){
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
		User user = userMapper.selectUserById(id);
		if(user.getHeadPortraitName()!=null){
			factory.getPhotoProcessing().deleteFile(File.separator+"images"+File.separator+"HeadPortrait"+File.separator+user.getHeadPortraitName());
		}
		if(!file.isEmpty()){
			//生成uuid作为文件名称
			//获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType=file.getContentType();
				//获得文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
			if(factory.getPhotoProcessing().isImage(imageName)){
				String photoName = Long.valueOf(System.currentTimeMillis()).toString()+"_"+id+"."+imageName;
				String path = File.separator+"images"+File.separator+"HeadPortrait";
				factory.getPhotoProcessing().savefile(photoName, path, file);
				userMapper.modifyUserHeadPortrait(id,photoName);
				return new JsonFormat("http://images.haidaojobs.cn/HeadPortrait/",new JSONArray().put(new JSONObject().put("photoName",photoName))).toString();
			}else{
				return new JsonFormat("301","fail").toString();//格式不符
			}
		}else{
			return  new JsonFormat("302","fail").toString();//上传的图片为空
		}
	}
	 public String selectHeadPortraitURL() throws JSONException{
		 return new JsonFormat("http://images.haidaojobs.cn/HeadPortrait/").toString();
	 }
}
