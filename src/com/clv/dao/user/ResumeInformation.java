package com.clv.dao.user;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

/**
 * 我的-->简历-->基本信息
 * @author Evanglist
 *
 */
public interface ResumeInformation {
	//用户提交身份认证相关
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
	/**
	 * 重新提交身份验证信息
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
	public String uploadCertificatePhoto(int id,int type,MultipartFile file,HttpServletRequest request) throws JSONException;	
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
	//用户身份审核相关
	/**
	 * 获取待审核队列
	 * @param adminId
	 * 			管理员id
	 * @return
	 * @throws JSONException
	 */
	public String getAuditQueue(int adminId) throws JSONException;
	/**
	 * 查询用户提交的身份认证信息
	 * @param adminId
	 * 		管理员id
	 * @param user_id
	 * 		用户id
	 * @return
	 * @throws JSONException
	 */
	public String selectIdentity(int adminId,int userId) throws JSONException;
	/**
	 * 给出用户认证结果
	 * @param adminId
	 * 		管理员id
	 * @param user_id
	 * 		用户id
	 * @param auditType
	 * 		认证情况结果
	 * @return
	 * @throws JSONException
	 */
	public String setAuditConclusion(int adminId,String enUserId,int auditType) throws JSONException;
}
