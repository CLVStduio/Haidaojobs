package com.clv.server.user;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.springframework.web.multipart.MultipartFile;

//import com.taobao.api.ApiException;
/**
 * 用户DAO接口
 * @author Evanglist
 * @time 2017.1.3
 */
public interface UserDao {
	/**
	 * 根据ID获取用户信息
	 * @param id
	 * @return
	 */
//	public User findUserById(int id);
	
	public String getUser(int id)throws JSONException;
	/**
	 * 判断手机号是否注册
	 * @param phone
	 * @return
	 */
	public String isUserPhoneNo(String phone)throws JSONException;
	
	/**
	 * 添加用户
	 * @param phone
	 * @param password
	 * @return
	 */
	 public String addUser(String phone,String password)throws JSONException;
	
	 /**
	  * 登录
	  * @param phone
	  * @param password
	  * @return
	  */
	 public String signIn(String phone,String password)throws JSONException;
	 /**
	  * 身份认证
	  * @param enId
	  * 		：经过加密的身份信息
	  * @return
	  * 		：解密后可用的id或者是报错信息
	  */
	 public int IdAuthentication(String enId);
	 /**
	  * 修改用户名
	  * @param message
	  * 		:新的用户名
	  * @param Id
	  * @return
	  */
	 public String modifyUserName(String message,int id)throws JSONException;
	 /**
	  * 在登录状态下，且经过验证码认证过修改手机号
	  * @param message
	  * 		:新的手机号
	  * @param Id
	  * @return
	  */
	 public String modifyUserPhone(String message,int id)throws JSONException;
	 /**
	  * 修改密码
	  * @param oldPassword
	  * @param newPassword
	  * @param Id
	  * @return
	  */
	 public String modifyUserPassword(String oldPassword,String newPassword,int id)throws JSONException;
	 /**
	  * 忘记密码
	  * @param Phone
	  * @param code
	  * @param password
	  * @return
	  */
	 public String resetUserPassword(String Phone,String password)throws JSONException;
	 /**
	  * 上传头像
	  * @param id
	  * @param file
	  * @param request
	  * @return
	  */
	 public String modifyUserHeadPortrait(int id, MultipartFile file,HttpServletRequest request) throws JSONException;
	 
	 /**
	  * 获取头像图片链接
	 * @return
	 * @throws JSONException
	 */
	public String selectHeadPortraitURL() throws JSONException;
}
