package com.clv.mapper;  
  
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.clv.model.resume.Skill;
import com.clv.user.model.User;

/** 
 * Mapper用户简历数据库操作映射类
 * @author Evanglist
 * @time 2017.1.2
 */  
public interface ResumeMapper {  
	/*****************特长相关****************/
	/**
	 * 根据用户ID查询用户信息
	 * @param user_id
	 * @return
	 */
    public User selectUserById(int user_id); 
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