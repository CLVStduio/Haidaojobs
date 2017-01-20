package com.clv.model.resume;


public class Skill {
	private Integer skill_id;
	private Integer user_id;
	private String skill_content;
	public Skill() {
		
	}
	public Skill(Integer user_id, String skill_content) {
		super();
		this.user_id = user_id;
		this.skill_content = skill_content;
	}
	public Integer getSkill_id() {
		return skill_id;
	}
	public void setSkill_id(Integer skill_id) {
		this.skill_id = skill_id;
	}
	public String getSkill_content() {
		return skill_content;
	}
	public void setSkill_content(String skill_content) {
		this.skill_content = skill_content;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	
}
