package com.clv.server.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import com.clv.server.ServerFather;

/**
 * 我的-->简历-->教育经历、技能特长、个人风采
 * @author Evanglist
 * @time 2016.12.31
 */
public interface ResumeOtherServer extends ServerFather{
	
	/**
	 * 往个人风采中添加照片
	 * @param userMap
	 * 		用户信息
	 * @param file
	 * 		照片文件
	 * @param request
	 * 		http服务
	 * @return
	 */
	public String addPhoto(Map<String,String> userMap, MultipartFile file,HttpServletRequest request)throws JSONException;
	/**
	 * 删除照片
	 * @param userMap
	 * 		用户信息
	 * @param photoName
	 * 		照片名
	 * @return
	 */
	public String deletePhoto(Map<String,String> userMap,String photoName)throws JSONException;
	/**
	 * 获取全部照片名字
	 * @param userMap
	 * 		用户信息
	 * @return
	 * @throws JSONException 
	 */
	public String selectPhoto(Map<String,String> userMap) throws JSONException;

	/**
	 * 添加用户技能特长
	 * @param userMap
	 * 		用户信息
	 * @param skill_content
	 * 		技能内容
	 * @return
	 * @throws JSONException
	 */
	public String addSkill(Map<String,String> userMap,String skill_content) throws JSONException;
	
	/**
	 * 删除用户指定技能特长
	 * @param userMap
	 * 		用户信息
	 * @return
	 * @throws JSONException
	 */
	public String deleteSkill(Map<String,String> userMap,String skill_id) throws JSONException;
	/**
	 * 获取指定用户所有技能信息
	 * @param userMap
	 * 		用户信息
	 * @return
	 * @throws JSONException
	 */
	public String selectSkill(Map<String,String> userMap) throws JSONException;
	/**
	 * 修改用户指定技能内容
	 * @param userMap
	 * 		用户信息
	 * @param skill_id
	 * 		技能id
	 * @param skill_content
	 * 		技能内容
	 * @return
	 * @throws JSONException
	 */
	public String modifySkill(Map<String,String> userMap,String enskill_id, String skill_content) throws JSONException;
}
