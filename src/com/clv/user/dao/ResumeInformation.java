package com.clv.user.dao;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 我的-->简历-->基本信息
 * @author Evanglist
 *
 */
public interface ResumeInformation {
	/**
	 * 身份认证基本信息填写
	 * @param id
	 * 		用户id
	 * @param name
	 * 		真实姓名
	 * @param gender
	 * 		用户性别
	 * @param idNum
	 * 		身份证号
	 * @return
	 * @throws JSONException
	 */
	public String identityAuthentication(int id,String name,String gender,String idNum) throws JSONException;
	public String modifyIdentityAuthentication(int id,String name,String gender,String idNum) throws JSONException;
	/**
	 * 证件照片上传
	 * @param id
	 * 		用户id
	 * @param type
	 * 		照片种类
	 * 		101：身份证正面照片
	 * 		102：手持身份证照片
	 * 		103：学生证内页照片
	 * 		104：其他证件照片
	 * @param file
	 * 		照片文件
	 * @param reques
	 * 		http服务
	 * @return
	 * @throws JSONException
	 */
	public String uploadCertificatePhoto(int id,int type,MultipartFile file,HttpServletRequest reques) throws JSONException;
	
	/**
	 * 查询用户身份审核结论
	 * @param id
	 * 		用户id
	 * @return
	 * @throws JSONException
	 */
	public String selectIdentityAuditConclusion(int id) throws JSONException;
	/**
	 * 修改身高
	 * @param id
	 * 		用户id
	 * @param height
	 * 		用户身高
	 * @return
	 * @throws JSONException
	 */
	public String modifyHeight(int id,int height) throws JSONException;
	/**
	 * 修改电子邮件
	 * @param id
	 * 		用户id
	 * @param eMail
	 * 		提交的电子邮件
	 * @return
	 * @throws JSONException
	 */
	public String modifyEmail(int id,String eMail) throws JSONException;
	/**
	 * 获取用户简历的基本信息
	 * @param id
	 * 		用户id
	 * @return
	 * @throws JSONException
	 */
	public String getInformation(int id) throws JSONException;
}
