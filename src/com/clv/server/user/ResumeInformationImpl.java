package com.clv.server.user;

import java.io.File;
import java.util.Map;

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

import cn.clvstudio.tool.Factory;
@Component
public class ResumeInformationImpl implements ResumeInformationServer {
	@Autowired
	private ResumeMapper resumeMapper;
	private Factory factory = new Factory();
	@Override
	public String identityAuthentication(Map<String,String> userMap, String enName, String enGender, String enIdNum) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			String name = factory.getCrypto().decrypMessage(enName, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			String gender = factory.getCrypto().decrypMessage(enGender, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			String idNum = factory.getCrypto().decrypMessage(enIdNum, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(name!=null &&  gender!=null &&  idNum!=null ){
				if(name.length()<30){
					if("男".equals(gender)||"女".equals(gender)){
						if(idNum.length()==18){
							String dateBirth = idNum.substring(6, 10)+"."+idNum.substring(10, 12)+"."+idNum.substring(12, 14);
							resumeMapper.addIdentity(id, name, gender, idNum, dateBirth);
							return new JsonFormat(SUCCESS).toString();
						}
						//身份证号长度不符
						return new JsonFormat("103",FAIL).toString();
					}
					//性别格式不符
					return new JsonFormat("102",FAIL).toString();
				}
				//真实姓名过长
				return new JsonFormat("101",FAIL).toString();
			}
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String modifyIdentityAuthentication(Map<String,String> userMap, String enName, String enGender, String enIdNum) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			Identity identity = resumeMapper.selectIdentity(id);
			if(identity.getAuditType()!=1){
				String name = factory.getCrypto().decrypMessage(enName, userMap.get(PHONENO), userMap.get(SECURITYKEY));
				String gender = factory.getCrypto().decrypMessage(enGender, userMap.get(PHONENO), userMap.get(SECURITYKEY));
				String idNum = factory.getCrypto().decrypMessage(enIdNum, userMap.get(PHONENO), userMap.get(SECURITYKEY));
				if(name!=null &&  gender!=null &&  idNum!=null ){
					if(name.length()<30){
						if("男".equals(gender)||"女".equals(gender)){
							if(idNum.length()==18){
								String dateBirth = idNum.substring(6, 10)+"."+idNum.substring(10, 12)+"."+idNum.substring(12, 14);
								resumeMapper.modifyIdentity(id, name, gender, idNum, dateBirth);
								return new JsonFormat(SUCCESS).toString();
							}
							//身份证号长度不符
							return new JsonFormat("103",FAIL).toString();
						}
						//性别格式不符
						return new JsonFormat("102",FAIL).toString();
					}
					//真实姓名过长
					return new JsonFormat("101",FAIL).toString();
				}
				return new JsonFormat("401",FAIL).toString();
			}
			//已经认证成功，禁止修改
			return new JsonFormat("104",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String uploadCertificatePhoto(Map<String,String> userMap, int type, MultipartFile file, HttpServletRequest reques) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
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
					return new JsonFormat(SUCCESS).toString();
				}
				return new JsonFormat("301",FAIL).toString();//格式不符
			}
			return  new JsonFormat("302",FAIL).toString();//上传的图片为空
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String selectIdentityAuditConclusion(Map<String,String> userMap) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			Identity identity = resumeMapper.selectIdentity(id);
			if(identity!=null){
				String identityStr = factory.getJson().toJson(identity,"identityId","dateBirth","adminId").toString();
				String enIdentity = factory.getCrypto().encryptMessage(identityStr, userMap.get(PHONENO), userMap.get(SECURITYKEY));
				if(!FAIL.equals(enIdentity)){
					return new JsonFormat(SUCCESS,new JSONArray().put(new JSONObject().put("identity",enIdentity))).toString();
				}
				//加密失败，请重新请求
				return new JsonFormat("102",FAIL).toString();
			}
			//无提交过身份认证信息
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String modifyHeight(Map<String,String> userMap, int height) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			if(height<250 && height>100){
				resumeMapper.modifyHeightOfInformation(id, Integer.toString(height));
				return new JsonFormat(SUCCESS).toString();
			}
			//身高信息不符合常理
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String modifyEmail(Map<String,String> userMap, String enEMail) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			String email = factory.getCrypto().decrypMessage(enEMail, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(email != null){
				if(email.length()<60){
					String regex = "[\\w]+@[A-Za-z0-9]+(\\.[a-zA-Z]+)+";
					if(email.matches(regex)){
						resumeMapper.modifyEmailOfInformation(id, email);
						return new JsonFormat(SUCCESS).toString();
					}
					//不符合邮箱格式
					return new JsonFormat("101",FAIL).toString();
				}
				//邮箱长度过长
				return new JsonFormat("102",FAIL).toString();
			}
			//解密失败
			return new JsonFormat("401",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}

	@Override
	public String getInformation(Map<String,String> userMap) throws JSONException {
		int id = Integer.parseInt(userMap.get(USERID));
		if(id>0){
			Information information = resumeMapper.selectInformation(id);
			if(information!=null){
				String enIdentity = factory.getCrypto().encryptMessage(factory.getJson().toJson(information,"informationId").toString(), userMap.get(PHONENO), userMap.get(SECURITYKEY));
				return new JsonFormat(SUCCESS,new JSONArray().put(new JSONObject().put("informaion", enIdentity))).toString();
			}
			resumeMapper.addInformation(id);
			information = resumeMapper.selectInformation(id);
			//无该用户的基本信息
			return new JsonFormat(SUCCESS,new JSONArray().put(factory.getJson().toJson(information,"informationId"))).toString();
		}
		return new JsonFormat("20"+Math.abs(id),FAIL).toString();
	}


}
