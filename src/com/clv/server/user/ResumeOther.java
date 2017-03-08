package com.clv.server.user;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 我的-->简历-->教育经历、技能特长、个人风采
 * @author Evanglist
 * @time 2016.12.31
 */
public interface ResumeOther {
	
	/**
	 * 往个人风采中添加照片
	 * @param id
	 * 		用户id
	 * @param file
	 * 		照片文件
	 * @param request
	 * 		http服务
	 * @return
	 */
	public String addPhoto(int id, MultipartFile file,HttpServletRequest request)throws JSONException;
	/**
	 * 删除照片
	 * @param id
	 * 		用户id
	 * @param photoName
	 * 		照片名
	 * @return
	 */
	public String deletePhoto(int id,String photoName)throws JSONException;
	/**
	 * 获取全部照片名字
	 * @param id
	 * 		用户 id
	 * @param lastTime
	 * 		用户最后一张照片
	 * @return
	 * @throws JSONException 
	 */
	public String selectPhoto(int id) throws JSONException;

	/**
	 * 添加用户技能特长
	 * @param user_id
	 * 		用户id
	 * @param skill_content
	 * 		技能内容
	 * @return
	 * @throws JSONException
	 */
	public String addSkill(int user_id,String skill_content) throws JSONException;
	
	/**
	 * 删除用户指定技能特长
	 * @param skill_id
	 * 		技能id
	 * @return
	 * @throws JSONException
	 */
	public String deleteSkill(int user_id,String skill_id) throws JSONException;
	/**
	 * 获取指定用户所有技能信息
	 * @param user_id
	 * 		用户id
	 * @return
	 * @throws JSONException
	 */
	public String selectSkill(int user_id) throws JSONException;
	/**
	 * 修改用户指定技能内容
	 * @param skill_id
	 * 		技能id
	 * @param skill_content
	 * 		技能内容
	 * @return
	 * @throws JSONException
	 */
	public String modifySkill(int user_id,String enskill_id, String skill_content) throws JSONException;
}
