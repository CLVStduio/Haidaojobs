package com.clv.mapper;  
  
import java.sql.Date;

import org.apache.ibatis.annotations.Param;

import com.clv.user.model.Code;
import com.clv.user.model.User;  
/** 
 * Mapper用户数据库操作映射类
 * @author Evanglist
 * @time 2016.12.31
 */  
public interface UserMapper {  
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
	/**
	 * 根据用户ID查询用户信息
	 * @param user_id
	 * @return
	 */
    public User selectUserById(int user_id);  
    
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
    public void addUser(@Param("password") String password,@Param("phone") String phone,@Param("security_key") String security_key,@Param("complement_key") String complement_key,@Param("date") Date date);
    /**
     * 查询指定密码
     * @param phone
     * @return
     */
    public String signIn(@Param("phone") String phone);
    //更新安全码
    public String modifySecurity(@Param("phone") String phone,@Param("security_key") String security_key,@Param("complement_key") String complement_key);
    /**
     * 修改昵称
     * @param id
     * @param name
     * @return
     */
    public void modifyUserName(@Param("user_id")int id,@Param("user_name")String name);
    
    public void modifyUserPhone(@Param("user_id")int id,@Param("user_phoneNo")String phone);
    
    public void modifyUserPassword(@Param("user_id")int id,@Param("user_password")String password);
    //public void resetUserPassword(@Param("user_phoneNo")String phone,@Param("user_password")String password);
    
    public void modifyUserHeadPortrait(@Param("user_id")int id,@Param("path")String path);
    
}  