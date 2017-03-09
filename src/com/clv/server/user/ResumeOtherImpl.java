package com.clv.server.user;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
import com.clv.model.resume.Skill;

import cn.clvstudio.tool.Factory;
/**
 * 我的-->简历-->教育经历、技能特长、个人风采
 * 实现类
 * @author Evanglist
 * @time 2017.1.3
 */
@Component
public class ResumeOtherImpl implements ResumeOtherServer {
	@Autowired
	private ResumeMapper resumeMapper;
	private Factory factory = new Factory();
	@Override
	public String addPhoto(Map<String,String> userMap, MultipartFile file, HttpServletRequest request) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		//获得物理路径webapp所在路径
		if(userId>0){
			if(!file.isEmpty()){
				//生成uuid作为文件名称
				//获得文件类型（可以判断如果不是图片，禁止上传）
				String contentType=file.getContentType();
					//获得文件后缀名称
					String imageName=contentType.substring(contentType.indexOf("/")+1);
				if(factory.getPhotoProcessing().isImage(imageName)){
					String photoName = Long.valueOf(System.currentTimeMillis()).toString()+"_"+userMap.get(USERID)+"."+imageName;
					String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+""+userMap.get(USERID);
					factory.getPhotoProcessing().savefile(photoName, path, file);
					return new JsonFormat("http://images.haidaojobs.cn/photoAlhum/"+userMap.get(USERID)+"/",new JSONArray().put(new JSONObject().put("photoName",photoName))).toString();
				}
				
				return new JsonFormat("301",FAIL).toString();//格式不符
			}
			
			return new JsonFormat("302",FAIL).toString();//上传的图片为空
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String deletePhoto(Map<String,String> userMap, String photoName) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+userMap.get(USERID)+File.separator+photoName;
			factory.getPhotoProcessing().deleteFile(path);
			return new JsonFormat(SUCCESS).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String selectPhoto(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+Integer.valueOf(userId).toString();
			JSONArray jArray = factory.getPhotoProcessing().selectFileForDir(path,"Image");
			if(jArray != null){
				return new JsonFormat("http://images.haidaojobs.cn/photoAlhum/"+userId+"/",jArray).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String addSkill(Map<String,String> userMap, String skill_content) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			if(skill_content!=null){
				Skill skill = new Skill(userId,skill_content);
				resumeMapper.addSkill(skill);
				return new JsonFormat(""+skill.getSkill_id()).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String selectSkill(Map<String,String> userMap) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			List<Skill> list =new ArrayList<Skill>();
			list = resumeMapper.selectSkill(userId);
			JSONArray jsonArray = new JSONArray();
			if(list != null){
				for(Skill l : list){
					jsonArray.put(factory.getJson().toJson(l,"user_id"));
				}
				return new JsonFormat(SUCCESS,jsonArray).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String deleteSkill(Map<String,String> userMap,String enskill_id) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String skill_id = factory.getCrypto().decrypMessage(enskill_id, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(skill_id != null){
				resumeMapper.deleteSkill(Integer.parseInt(skill_id));
				return new JsonFormat(SUCCESS).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

	@Override
	public String modifySkill(Map<String,String> userMap,String enskill_id, String skill_content) throws JSONException {
		int userId = Integer.parseInt(userMap.get(USERID));
		if(userId>0){
			String skill_id = factory.getCrypto().decrypMessage(enskill_id, userMap.get(PHONENO), userMap.get(SECURITYKEY));
			if(skill_id!=null){
				if(skill_content !=null){
					resumeMapper.modifySkill(Integer.parseInt(skill_id), skill_content);
					return new JsonFormat(SUCCESS).toString();
				}
				return new JsonFormat("102",FAIL).toString();
			}
			return new JsonFormat("101",FAIL).toString();
		}
		return new JsonFormat("20"+Math.abs(userId),FAIL).toString();
	}

}
