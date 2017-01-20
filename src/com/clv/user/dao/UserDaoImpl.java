package com.clv.user.dao;

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
import com.clv.user.model.Code;
import com.clv.user.model.User;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

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
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"user_password","registered_date","complement_key"))).toString();
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
	public String getCode(String phone) throws ApiException, JSONException {
		//获取验证码
		 if(userMapper.getCode(phone) != null){
			 userMapper.deleteCode(phone);
		 }
			
			StringBuilder sb = new StringBuilder();
			for(int i = 0;i<6;i++){
				int code = (int)(Math.random()*8+1);
				sb.append(Integer.valueOf(code).toString());
			}
			sb.delete(0, 1);
			
			String strcode = sb.toString();
			System.out.println("code:"+strcode);
			String url = "http://gw.api.taobao.com/router/rest";
			String appkey = " 23561829";
			String secret = "370a9c1e0532706b4857be11cd64f6f7";
			TaobaoClient client = new DefaultTaobaoClient(url, appkey, secret);
			AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
			req.setExtend(phone);
			req.setSmsType("normal");
			req.setSmsFreeSignName("蠢驴工作室");
			req.setSmsParam("{\"code\":\""+strcode+"\"}");
			req.setRecNum(phone);
			req.setSmsTemplateCode("SMS_33605394");
			AlibabaAliqinFcSmsNumSendResponse response = client.execute(req);
			String str = response.getBody();
			
			int a = str.indexOf("error_response");
			if(a==-1){
				String time = Long.valueOf(System.currentTimeMillis()).toString();
				userMapper.storageCode(phone, strcode,time);
				return new JsonFormat("success").toString();
			}else{
				return new JsonFormat("101","fail").toString();
			}
			
	}
	public String checkCode(String phone,String code) throws JSONException{
		 Code Code = userMapper.getCode(phone);
		 if(Code == null){
			 System.out.println("验证码不存在");
			 return new JsonFormat("103","fail").toString();
		 }
		 long time = System.currentTimeMillis();
		 long codeTime = Long.parseLong(Code.getTime());
		
		 if(Code.getCode().equals(code)){
			 System.out.println("验证码正确");
			 return new JsonFormat("success").toString();
		 }
		 if(Math.abs(codeTime-time)>600000){
			 userMapper.deleteCode(phone);
			 System.out.println("验证码过期");
			 return new JsonFormat("102","fail").toString();
		 }else{
			 System.out.println("验证码错误");
			 return new JsonFormat("101","fail").toString();
		 }
	 }
	@Override
	public String addUser(String enPhone, String enPassword) throws JSONException {
		String phone = factory.getCrypto().DecryptTime(enPhone);
		String password = factory.getCrypto().DecryptTime(enPassword);
		if("fail".equals(phone) || "fail".equals(password) || phone == null || password==null){
			return new JsonFormat("204","fail").toString();
		}
		if(userMapper.selectUserByPhoneNo(phone) == null){
			
			Date date = new Date(System.currentTimeMillis());
			userMapper.addUser(password,phone,factory.getBKey().builderSecurityKey(phone),factory.getBKey().builderComplementKey(phone),date);
			return new JsonFormat("success").toString();
		}else{
			System.out.println("手机号已经 注册");
			return new JsonFormat("101","fail").toString();
		}
	}

	@Override
	public String signIn(String enPhone,String enPassword) throws JSONException {
		//登录

		String dePhone = factory.getCrypto().DecryptTime(enPhone);
		String dePassword = factory.getCrypto().DecryptTime(enPassword);
		if("fail".equals(dePhone) || "fail".equals(dePassword) || dePhone == null || dePassword==null){
			return  new JsonFormat("102","fail").toString();
		}
		User user = userMapper.selectUserByPhoneNo(dePhone);
//		System.out.print(dePhone);
//		String password = userMapper.signIn(dePhone);
		if( user == null){
			System.out.println(":帐号或密码错误");
			return new JsonFormat("101","fail").toString();
		}
		if(user.getUser_password().equals(dePassword)){
			System.out.println(":登录");
			String securityKey = factory.getBKey().builderSecurityKey(dePhone);
			userMapper.modifySecurity(dePhone, securityKey,factory.getBKey().builderComplementKey(dePhone));
			user.setSecurity_key(securityKey);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"user_password","registered_date","complement_key"))).toString();
		}else{
			System.out.println(":帐号或密码错误");
			return  new JsonFormat("101","fail").toString();
		}
	}

	public int IdAuthentication(String enId){
		System.out.println("enId: "+enId);
		String deIdmessage = factory.getCrypto().DecryptTime(enId);
//		System.out.println(deIdmessage);
		if(deIdmessage!=null ){
			if(deIdmessage.length() >=42){
				StringBuilder sb = new StringBuilder(deIdmessage);
				String skey = sb.substring(0, 29);
				String newTime = sb.substring(29, 42);
				sb.delete(0,42);
				User user = userMapper.selectUserById(Integer.parseInt(sb.toString()));
				if(user!=null){
					if(user.getSecurity_key().equals(skey)){
						StringBuilder keySb = new StringBuilder(user.getComplement_key());
						String oldTime = keySb.substring(16);
						if(Long.parseLong(newTime)-Long.parseLong(oldTime)>15*24*60*60*1000){
							System.out.println("安全码已经过期，请重新登录");
							return -1;
						}
						
						return user.getUser_id();
						
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
	@Override
	public String modifyUserName(String enmessage, int id) throws JSONException {
		if(id>0){
			User user = userMapper.selectUserById(id);
			String name = factory.getCrypto().DecrypMessage(enmessage, user.getUser_phoneNo(), user.getSecurity_key());
			if("fail".equals(name) || name == null){
				return new JsonFormat("401","fail").toString();
			}
			if(name.length()<=15){
				System.out.println(name);
				userMapper.modifyUserName(id, name);
				user.setUser_name(name);
				return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"user_password","registered_date","complement_key"))).toString();
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
			String phone = factory.getCrypto().DecrypMessage(enmessage, user.getUser_phoneNo(), user.getSecurity_key());
			if("fail".equals(phone) || phone == null){
				return new JsonFormat("401","fail").toString();
			}
			
			userMapper.modifyUserPhone(id, phone);
			user.setUser_phoneNo(phone);
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(user,"user_password","registered_date","complement_key"))).toString();
		}else{
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
	}

	@Override
	public String modifyUserPassword(String enOldPassword, String enNewPassword,int id) throws JSONException {
		if(id>0){
			User user = userMapper.selectUserById(id);
			String deoldPassword = factory.getCrypto().DecrypMessage(enOldPassword, user.getUser_phoneNo(), user.getSecurity_key());
			String denewPassword = factory.getCrypto().DecrypMessage(enNewPassword, user.getUser_phoneNo(), user.getSecurity_key());
			if("fail".equals(deoldPassword) || deoldPassword == null || "fail".equals(denewPassword) || denewPassword == null){
				return new JsonFormat("401","fail").toString();
			}
			if(deoldPassword.equals(user.getUser_password())){
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
		String dePhone = factory.getCrypto().DecryptTime(enPhone);
		String dePassword = factory.getCrypto().DecryptTime(enPassword);
		if("fail".equals(dePhone) || "fail".equals(dePassword) || dePhone == null || dePassword==null){
			return new JsonFormat("401","fail").toString();
		}
		User user = userMapper.selectUserByPhoneNo(dePhone);
		if(user != null){
			userMapper.modifyUserPassword(user.getUser_id(), dePassword);
			return new JsonFormat("success").toString();
		}else{
			System.out.println("该手机未注册");
			return new JsonFormat("101","fail").toString();
		}
	}

	public String modifyUserHeadPortrait(int id,MultipartFile file,HttpServletRequest request) throws JSONException{
		//获得物理路径webapp所在路径
		
		if(id<=0){
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
		User user = userMapper.selectUserById(id);
		if(user.getHeadPortraitPath()!=null){
			factory.getPhotoProcessing().deleteFile(File.separator+"images"+File.separator+"HeadPortrait"+File.separator+user.getHeadPortraitPath());
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
