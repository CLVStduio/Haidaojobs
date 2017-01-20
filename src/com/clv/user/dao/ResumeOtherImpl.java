package com.clv.user.dao;

import java.io.File;
import java.util.ArrayList;
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
import com.clv.model.resume.Skill;
import com.clv.user.model.User;

import cn.clvstudio.tool.Factory;
/**
 * @author Evanglist
 * @time 2017.1.3
 */
@Component
public class ResumeOtherImpl implements ResumeOther {
	@Autowired
	private ResumeMapper resumeMapper;
	private Factory factory = new Factory();
	@Override
	public String addPhoto(int id, MultipartFile file, HttpServletRequest request) throws JSONException {
		//获得物理路径webapp所在路径
		if(id<=0){
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
		User user = resumeMapper.selectUserById(id);
		
		if(!file.isEmpty()){
			//生成uuid作为文件名称
			//获得文件类型（可以判断如果不是图片，禁止上传）
			String contentType=file.getContentType();
				//获得文件后缀名称
				String imageName=contentType.substring(contentType.indexOf("/")+1);
			if(factory.getPhotoProcessing().isImage(imageName)){
				String photoName = Long.valueOf(System.currentTimeMillis()).toString()+"_"+id+"."+imageName;
				String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+""+user.getUser_id();
				factory.getPhotoProcessing().savefile(photoName, path, file);
				return new JsonFormat("http://images.haidaojobs.cn/photoAlhum/",new JSONArray().put(new JSONObject().put("photoName",photoName))).toString();
			}else{
				return new JsonFormat("301","fail").toString();//格式不符
			}
		}else{
			return new JsonFormat("302","fail").toString();//上传的图片为空
		}
	}

	@Override
	public String deletePhoto(int id, String photoName) throws JSONException {
		if(id>0){
			String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+Integer.valueOf(id).toString()+File.separator+photoName;
			factory.getPhotoProcessing().deleteFile(path);
			return new JsonFormat("success").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String selectPhoto(int id) throws JSONException {
		if(id<0){
			return new JsonFormat("20"+Math.abs(id),"fail").toString();
		}
		String path = File.separator+"images"+File.separator+"photoAlhum"+File.separator+Integer.valueOf(id).toString();
		JSONArray jArray = factory.getPhotoProcessing().selectFileForDir(path,"Image");
		if(jArray != null){
			return new JsonFormat("http://images.haidaojobs.cn/photoAlhum/"+id+"/",jArray).toString();
		}else{
			return new JsonFormat("101","fail").toString();
		}
	}

	@Override
	public String addSkill(int id, String skill_content) throws JSONException {
		if(id>0){
			if(skill_content!=null){
				Skill skill = new Skill(id,skill_content);
				
				resumeMapper.addSkill(skill);
				return new JsonFormat(""+skill.getSkill_id()).toString();
			}
			return new JsonFormat("101","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String selectSkill(int id) throws JSONException {
		if(id>0){
			List<Skill> list =new ArrayList<Skill>();
			list = resumeMapper.selectSkill(id);
			JSONArray jsonArray = new JSONArray();
			if(list != null){
				for(Skill l : list){
					jsonArray.put(factory.getJson().toJson(l,"user_id"));
					System.out.println("skill"+factory.getJson().toJson(l).toString());
				}
				return new JsonFormat("success",jsonArray).toString();
			}
			System.out.println("selectSkill id:"+id+" skill is null");
			return new JsonFormat("101","fail").toString();
		}
		return new JsonFormat("20"+Math.abs(id),"fail").toString();
	}

	@Override
	public String deleteSkill(int user_id,String enskill_id) throws JSONException {
		if(user_id>0){
			User user = resumeMapper.selectUserById(user_id);
			String skill_id = factory.getCrypto().DecrypMessage(enskill_id, user.getUser_phoneNo(), user.getSecurity_key());
			resumeMapper.deleteSkill(Integer.parseInt(skill_id));
			return new JsonFormat("success").toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}

	@Override
	public String modifySkill(int user_id,String enskill_id, String skill_content) throws JSONException {
		if(user_id>0){
			User user = resumeMapper.selectUserById(user_id);
			String skill_id = factory.getCrypto().DecrypMessage(enskill_id, user.getUser_phoneNo(), user.getSecurity_key());
			resumeMapper.modifySkill(Integer.parseInt(skill_id), skill_content);
			return new JsonFormat("success").toString();
		}
		return new JsonFormat("20"+Math.abs(user_id),"fail").toString();
	}

}
