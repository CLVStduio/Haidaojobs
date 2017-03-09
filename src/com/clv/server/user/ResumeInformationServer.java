package com.clv.server.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

import com.clv.server.ServerFather;

/**
 * 我的-->简历-->基本信息
 * @author Evanglist
 *
 */
public interface ResumeInformationServer extends ServerFather{
	//用户提交身份认证相关
	/**
	 * 身份认证基本信息填写
	 * @param userMap
	 * 		用户信息
	 * @param name
	 * 		真实姓名
	 * @param gender
	 * 		用户性别
	 * @param idNum
	 * 		身份证号
	 * @return
	 * @throws JSONException
	 */
	public String identityAuthentication(Map<String,String> userMap,String name,String gender,String idNum) throws JSONException;
	/**
	 * 重新提交身份验证信息
	 * @param userMap
	 * 		用户信息
	 * @param name
	 * 		真实姓名
	 * @param gender
	 * 		用户性别
	 * @param idNum
	 * 		身份证号
	 * @return
	 * @throws JSONException
	 */
	public String modifyIdentityAuthentication(Map<String,String> userMap,String name,String gender,String idNum) throws JSONException;
	/**
	 * 证件照片上传
	 * @param userMap
	 * 		用户信息
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
	public String uploadCertificatePhoto(Map<String,String> userMap,int type,MultipartFile file,HttpServletRequest request) throws JSONException;	
	/**
	 * 查询用户身份审核结论
	 * @param userMap
	 * 		用户信息
	 * @return
	 * @throws JSONException
	 */
	public String selectIdentityAuditConclusion(Map<String,String> userMap) throws JSONException;
	/**
	 * 修改身高
	 * @param userMap
	 * 		用户信息
	 * @param height
	 * 		用户身高
	 * @return
	 * @throws JSONException
	 */
	public String modifyHeight(Map<String,String> userMap,int height) throws JSONException;
	/**
	 * 修改电子邮件
	 * @param userMap
	 * 		用户信息
	 * @param eMail
	 * 		提交的电子邮件
	 * @return
	 * @throws JSONException
	 */
	public String modifyEmail(Map<String,String> userMap,String eMail) throws JSONException;
	/**
	 * 获取用户简历的基本信息
	 * @param userMap
	 * 		用户信息
	 * @return
	 * @throws JSONException
	 */
	public String getInformation(Map<String,String> userMap) throws JSONException;
	
	
}
