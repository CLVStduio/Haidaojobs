package com.clv.mapper;

import org.apache.ibatis.annotations.Param;

import com.clv.model.mycomponent.Signin;
import com.clv.model.mycomponent.SigninGift;

/**
 * “我的”小板块数据库操作映射类
 * @author evanglist
 *
 */
public interface MyComponentMapper {
	/*****************签到相关****************/
	/**
	 * 添加用户该月签到信息
	 * @param month
	 * @param date
	 * @param user_id
	 */
	public void addSignIn(@Param("tableName")String tableName,@Param("month") String month,@Param("signIn_date") String date,@Param("user_id")int user_id);
	/**
	 * 修改签到信息
	 * @param id
	 * @param date
	 */
	public void modifySignIn(@Param("tableName")String tableName,@Param("signIn_id") int id,@Param("signIn_date") String date);
	/**
	 * 查询签到信息
	 * @param user_id
	 * @param month
	 * @return
	 */
	public Signin selectSignIn(@Param("tableName")String tableName,@Param("user_id")int user_id,@Param("month")String month);
	/**
	 * 创建用户该月礼包领取情况
	 * @param tableName
	 * @param month
	 * @param date
	 * @param user_id
	 */
	public void addSignInGiftBag(@Param("tableName")String tableName,@Param("month") String month,@Param("signInGift_date") String date,@Param("user_id")int user_id);
	/**
	 * 修改用户该月礼包领取情况
	 * @param tableName
	 * @param id
	 * @param date
	 */
	public void modifySignInGiftBag(@Param("tableName")String tableName,@Param("signIn_id") int id,@Param("signIn_date") String date);
	/**
	 * 查询用户该月礼包领取情况
	 * @param tableName
	 * @param user_id
	 * @param month
	 * @return
	 */
	public SigninGift selectSignInGiftBag(@Param("tableName")String tableName,@Param("user_id")int user_id,@Param("month")String month);
	/*****************签到相关****************/
}
