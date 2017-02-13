package com.clv.mapper;

import org.apache.ibatis.annotations.Param;

import com.clv.model.user.Code;

/**
 * 信息操作数据库映射类
 * @author evanglist
 *
 */
public interface MessageMapper {
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
}
