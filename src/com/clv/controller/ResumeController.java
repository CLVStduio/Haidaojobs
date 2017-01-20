package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResumeController {
	@RequestMapping(value="/user/resume/addPhoto",method = RequestMethod.POST)
	public String addPhoto(){
		return "addPhoto";
	}
	@RequestMapping(value="/user/resume/deletePhoto",method = RequestMethod.POST)
	public String deletePhoto(){
		return "deletePhoto";
	}
	@RequestMapping(value="/user/resume/selectPhoto",method = RequestMethod.POST)
	public String selectPhoto(){
		return "selectPhoto";
	}
	@RequestMapping(value="/user/resume/addSkill",method = RequestMethod.POST)
	public String addSkill(){
		return "addSkill";
	}
	@RequestMapping(value="/user/resume/selectSkill",method = RequestMethod.POST)
	public String selectSkill(){
		return "selectSkill";
	}
	
}
