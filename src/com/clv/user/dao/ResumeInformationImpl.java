package com.clv.user.dao;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.clv.mapper.ResumeMapper;
import com.clv.model.format.JsonFormat;
import com.clv.model.resume.Identity;
import com.clv.model.resume.Information;
import com.clv.user.model.User;

import cn.clvstudio.tool.Factory;
@Component
public class ResumeInformationImpl implements ResumeInformation {
	@Autowired
	private ResumeMapper resumeMapper;
	private Factory factory = new Factory();
	@Override
	public String identityAuthentication(int id, String enName, String enGender, String enIdNum) throws JSONException {
		if(id>0){
			User user = resumeMapper.selectUserById(id);
			String name = factory.getCrypto().decrypMessage(enName, user.getUserPhoneNo(), user.getSecurityKey());
			String gender = factory.getCrypto().decrypMessage(enGender, user.getUserPhoneNo(), user.getSecurityKey());
			String idNum = factory.getCrypto().decrypMessage(enIdNum, user.getUserPhoneNo(), user.getSecurityKey());
			if(name!=null &&  gender!=null &&  idNum!=null ){
				if(name.length()<30){
					if("男".equals(gender)||"女".equals(gender)){
						if(idNum.length()==18){
							String dateBirth = idNum.substring(6, 10)+"."+idNum.substring(10, 12)+"."+idNum.substring(12, 14);
							resumeMapper.addIdentity(id, name, gender, idNum, dateBirth);
							return new JsonFormat("success").toString();
						}
						//身份证号长度不符
						return new JsonFormat("103","fail").toString();
					}
					//性别格式不符
					return new JsonFormat("102","fail").toString();
				}
				//真实姓名过长
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String modifyIdentityAuthentication(int id, String enName, String enGender, String enIdNum) throws JSONException {
		if(id>0){
			User user = resumeMapper.selectUserById(id);
			String name = factory.getCrypto().decrypMessage(enName, user.getUserPhoneNo(), user.getSecurityKey());
			String gender = factory.getCrypto().decrypMessage(enGender, user.getUserPhoneNo(), user.getSecurityKey());
			String idNum = factory.getCrypto().decrypMessage(enIdNum, user.getUserPhoneNo(), user.getSecurityKey());
			if(name!=null &&  gender!=null &&  idNum!=null ){
				if(name.length()<30){
					if("男".equals(gender)||"女".equals(gender)){
						if(idNum.length()==18){
							String dateBirth = idNum.substring(6, 10)+"."+idNum.substring(10, 12)+"."+idNum.substring(12, 14);
							resumeMapper.modifyIdentity(id, name, gender, idNum, dateBirth);
							return new JsonFormat("success").toString();
						}
						//身份证号长度不符
						return new JsonFormat("103","fail").toString();
					}
					//性别格式不符
					return new JsonFormat("102","fail").toString();
				}
				//真实姓名过长
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String uploadCertificatePhoto(int id, int type, MultipartFile file, HttpServletRequest reques) throws JSONException {
		if(id>0){			
			if(!file.isEmpty()){
				//获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType=file.getContentType();
					//获得文件后缀名称
					String imageName=contentType.substring(contentType.indexOf("/")+1);
				if(factory.getPhotoProcessing().isImage(imageName)){
					String photoName = type+"_"+Long.valueOf(System.currentTimeMillis()).toString()+"."+imageName;
					String path = File.separator+"images"+File.separator+"certificatePhoto"+File.separator+id;
					factory.getPhotoProcessing().savefile(photoName, path, file);
					return new JsonFormat("success").toString();
				}else{
					return new JsonFormat("301","fail").toString();//格式不符
				}
			}else{
				return  new JsonFormat("302","fail").toString();//上传的图片为空
			}
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String selectIdentityAuditConclusion(int id) throws JSONException {
		if(id>0){
			User user = resumeMapper.selectUserById(id);
			Identity identity = resumeMapper.selectIdentity(id);
			if(identity!=null){
				String identityStr = factory.getJson().toJson(identity,"identityId","dateBirth","adminId").toString();
				String enIdentity = factory.getCrypto().encryptMessage(identityStr, user.getUserPhoneNo(), user.getSecurityKey());
				if(!"fail".equals(enIdentity)){
					return new JsonFormat("success",new JSONArray().put(new JSONObject().put("identity",enIdentity))).toString();
				}
				//加密失败，请重新请求
				return new JsonFormat("102","falil").toString();
			}
			//无提交过身份认证信息
			return new JsonFormat("101","falil").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String modifyHeight(int id, int height) throws JSONException {
		if(id>0){
			if(height<250 && height>100){
				resumeMapper.modifyHeightOfInformation(id, Integer.toString(height));
				return new JsonFormat("success").toString();
			}
			//身高信息不符合常理
			return new JsonFormat("101","falil").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String modifyEmail(int id, String enEMail) throws JSONException {
		if(id>0){
			User user = resumeMapper.selectUserById(id);
			String email = factory.getCrypto().decrypMessage(enEMail, user.getUserPhoneNo(), user.getSecurityKey());
			if(email != null){
				if(email.length()<60){
					String regex = "[\\w]+@[A-Za-z0-9]+(\\.[a-zA-Z]+)+";
					if(email.matches(regex)){
						resumeMapper.modifyEmailOfInformation(id, email);
						return new JsonFormat("success").toString();
					}
					//不符合邮箱格式
					return new JsonFormat("101","fail").toString();
				}
				//邮箱长度过长
				return new JsonFormat("102","fail").toString();
			}
			//解密失败
			return new JsonFormat("401","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String getInformation(int id) throws JSONException {
		if(id>0){
			Information information = resumeMapper.selectInformation(id);
			if(information!=null){
				return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(information,"InformationId"))).toString();
			}
			resumeMapper.addInformation(id);
			information = resumeMapper.selectInformation(id);
			//无该用户的基本信息
			return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(information,"informationId"))).toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String getAuditQueue(int adminId) throws JSONException {
		if(adminId>0){
			List<Identity> auditQueue = resumeMapper.getAuditQueue();
			JSONArray jsonArray = new JSONArray();
			if(auditQueue != null){
				for(Identity identity : auditQueue){
					jsonArray.put(factory.getJson().toJson(identity));
//					System.out.println("skill"+factory.getJson().toJson(l).toString());
				}
				return new JsonFormat("success",jsonArray).toString();
			}
//			System.out.println("selectSkill id:"+id+" skill is null");
			return new JsonFormat("101","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(adminId),"fail").toString();
	}

	@Override
	public String selectIdentity(int adminId, int userId) throws JSONException {
		if(adminId>0){
			if(userId>0){
				Identity identity = resumeMapper.selectIdentity(userId);
				if(identity != null){
					return new JsonFormat("success",new JSONArray().put(factory.getJson().toJson(identity))).toString();
				}
				//不存在相关信息
				return new JsonFormat("101","fail").toString();
			}
			return new JsonFormat("20"+Math.abs(userId),"fail").toString();
		}
		return new JsonFormat("21"+Math.abs(adminId),"fail").toString();
	}

	@Override
	public String setAuditConclusion(int adminId, int userId, int auditType) throws JSONException {
		if(adminId>0){
			if(userId>0){
				resumeMapper.modifyAuditTypeOfIdentity(userId, adminId, auditType);
				return new JsonFormat("success").toString();
			}
			return new JsonFormat("20"+Math.abs(userId),"fail").toString();
		}
		return new JsonFormat("21"+Math.abs(adminId),"fail").toString();
	}

}
