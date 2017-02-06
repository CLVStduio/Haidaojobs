package com.clv.mapper;  
  
import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.clv.model.user.Code;
import com.clv.model.user.User;  
/** 
 * Mapper用户数据库操作映射类
 * @author Evanglist
 * @time 2016.12.31
 */  
public interface UserMapper {  
	/*****************验证码相关****************/
    /**
     * 保存验证码
     * @param phone
     * @param code
     * @param time
     */
    public void addCode(@Param("phone")String phone,@Param("code")String code,@Param("time")String time);
    /**
     * 删除指定验证码
     * @param phone
     */
    public void deleteCode(@Param("phone")String phone);
    /**
     * 更新验证码
     * @param phone
     * @param code
     * @param time
     */
    public void modifyCode(@Param("phone")String phone,@Param("code")String code,@Param("time")String time);
    /**
     * 查询指定验证码
     * @param phone
     * @return
     */
    public Code selectCode(@Param("phone")String phone);
    /*****************验证码相关****************/
    /*****************用户信息****************/
	/**
	 * 根据用户ID查询用户信息
	 * @param user_id
	 * @return
	 */
    public User selectUserById(int userId);  
    /**
     *根据用户phone查询用户信息
     * @param phone
     * @return
     */
    public User selectUserByPhoneNo(String phone);
    /**
     * 添加用户
     * @param password
     * 			:密码
     * @param phone
     * 			:手机号
     * @param security_key
     * 			:安全码
     * @param date
     * 			:注册日期
     * @return
     */
    public void addUser(@Param("password") String password,@Param("phone") String phone,@Param("securityKey") String securityKey,@Param("complementKey") String complementKey,@Param("date") Date date);
    /**
     * 查询指定密码
     * @param phone
     * @return
     */
    public String signIn(@Param("phone") String phone);
    /**
     * 更新安全码
     * @param phone
     * @param security_key
     * @param complement_key
     * @return
     */
    public String modifySecurity(@Param("phone") String phone,@Param("securityKey") String securityKey,@Param("complementKey") String complementKey);
    /*****************用户信息****************/
    /*****************用户信息修改****************/
    /**
     * 修改昵称
     * @param id
     * @param name
     * @return
     */
    public void modifyUserName(@Param("userId")int id,@Param("userName")String name);
    /**
     * 修改用户手机号
     * @param id
     * @param phone
     */
    public void modifyUserPhone(@Param("userId")int id,@Param("userPhoneNo")String phone);
    /**
     * 修改用户密码
     * @param id
     * @param password
     */
    public void modifyUserPassword(@Param("userId")int id,@Param("userPassword")String password);
    /**
     * 修改用户头像
     * @param id
     * @param path
     */
    public void modifyUserHeadPortrait(@Param("userId")int id,@Param("photoName")String path);
    /*****************用户信息修改****************/
}  