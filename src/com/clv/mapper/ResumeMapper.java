package com.clv.mapper;  
  
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clv.model.resume.Identity;
import com.clv.model.resume.Information;
import com.clv.model.resume.Skill;
import com.clv.user.model.User;

/** 
 * Mapper用户简历数据库操作映射类
 * @author Evanglist
 * @time 2017.1.2
 */  
public interface ResumeMapper { 
	/**
	 * 根据用户ID查询用户信息
	 * @param user_id
	 * @return
	 */
    public User selectUserById(int user_id); 
	/*****************用户基本信息****************/
	/**
	 * 添加用户基本信息
	 * @param userId
	 * 		用户id
	 */
	public void addInformation(@Param("userId")int userId);
	/**
	 * 修改用户基本信息中的身高
	 * @param userId
	 * @param height
	 */
	public void modifyHeightOfInformation(@Param("userId")int userId,@Param("height")String height);
	/**
	 * 修改用户基本信息中的邮箱
	 * @param userId
	 * @param email
	 */
	public void modifyEmailOfInformation(@Param("userId")int userId,@Param("email")String email);
	/**
	 * 修改用户基本信息中的身份信息
	 * @param userId
	 * @param name
	 * @param gender
	 * @param dateBirth
	 */
	public void modifyIdentityOfInformation(@Param("userId")int userId,@Param("name")String name,@Param("gender")String gender,@Param("dateBirth")String dateBirth);
	/**
	 * 查询用户基本信息
	 * @param userId
	 * 		用户id
	 * @return
	 */
	public Information selectInformation(@Param("userId")int userId);
	/*****************用户基本信息****************/
	/*****************用户认证信息****************/
	/**
	 * 添加用户认证信息
	 * @param userId
	 * 		用户id
	 * @param name
	 * 		用户真实姓名
	 * @param gender
	 * 		用户性别
	 * @param idNum
	 * 		用户身份证
	 * @param dateBirth
	 * 		用户出生日期
	 */
	public void addIdentity(@Param("userId")int userId,@Param("name")String name,@Param("gender")String gender,@Param("idNum")String idNum,@Param("dateBirth")String dateBirth);
	/**
	 * 修改用户认证信息
	 * @param userId
	 * 		用户id
	 * @param name
	 * 		用户姓名
	 * @param gender
	 * 		用户性别
	 * @param idNum
	 * 		用户身份证
	 * @param dateBirth
	 * 		用户出生日期
	 */
	public void modifyIdentity(@Param("userId")int userId,@Param("name")String name,@Param("gender")String gender,@Param("idNum")String idNum,@Param("dateBirth")String dateBirth);
	/**
	 * 修改用户认证状态
	 * @param userId
	 * 		用户id
	 * @param adminId
	 * 		管理员id
	 * @param auditType
	 * 		用户认证状态
	 */
	public void modifyAuditTypeOfIdentity(@Param("userId")int userId,@Param("adminId")int adminId,@Param("auditType")int auditType);
	/**
	 * 查询用户认证信息
	 * @param userId
	 * 		用户id
	 * @return
	 */
	public Identity selectIdentity(@Param("userId")int userId);
	/*****************用户认证信息****************/
	/*****************特长相关****************/	
	/**
	 * 添加特长
	 * @param skill
	 * @return
	 */
	public Integer addSkill(Skill skill);
	/**
	 * 删除指定特长
	 * @param skillId
	 */
	public void deleteSkill(@Param("skill_id")int skillId);
	/**
	 * 修改特长
	 * @param skillId
	 * @param sksillText
	 */
	public void modifySkill(@Param("skill_id")int skillId,@Param("skill_content")String sksillText);
	/**
	 * 查询特长
	 * @param userId
	 * @return
	 */
	public List<Skill> selectSkill(@Param("user_id")int userId);
	/*****************特长相关****************/
	
}