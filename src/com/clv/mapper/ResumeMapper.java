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
	/**
	 * 根据用户ID查询用户信息
	 * @param user_id
	 * @return
	 */
    public User selectUserById(int user_id); 
	public Integer addSkill(Skill skill);
	
	public void delectSkill(@Param("skill_id")int skillId);
	
	public void modifySkill(@Param("skill_id")int skillId,@Param("skill_content")String sksillText);
	
	public List<Skill> selectSkill(@Param("user_id")int userId);
}