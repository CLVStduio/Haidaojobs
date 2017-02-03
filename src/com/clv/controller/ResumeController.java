package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResumeController {
	//********************************
	//**		简历-->风采			**
	//********************************
	@RequestMapping(value="/user/resume/photo/addPhoto",method = RequestMethod.POST)
	public String addPhoto(){
		return "addPhoto";
	}
	@RequestMapping(value="/user/resume/photo/deletePhoto",method = RequestMethod.POST)
	public String deletePhoto(){
		return "deletePhoto";
	}
	@RequestMapping(value="/user/resume/photo/selectPhoto",method = RequestMethod.POST)
	public String selectPhoto(){
		return "selectPhoto";
	}
	//********************************
	//**		简历-->特长			**
	//********************************
	@RequestMapping(value="/user/resume/skill/addSkill",method = RequestMethod.POST)
	public String addSkill(){
		return "addSkill";
	}
	@RequestMapping(value="/user/resume/skill/selectSkill",method = RequestMethod.POST)
	public String selectSkill(){
		return "selectSkill";
	}
	@RequestMapping(value="/user/resume/skill/deleteSkill",method = RequestMethod.POST)
	public String deleteSkill(){
		return "deleteSkill";
	}
	@RequestMapping(value="/user/resume/skill/modifySkill",method = RequestMethod.POST)
	public String modifySkill(){
		return "modifySkill";
	}
	//********************************
	//**	用户提交身份认证相关		**
	//********************************
	@RequestMapping(value="/user/resume/identity/identityAuthentication",method = RequestMethod.POST)
	public String identityAuthentication(){
		return "identityAuthentication";
	}
	@RequestMapping(value="/user/resume/identity/modifyIdentityAuthentication",method = RequestMethod.POST)
	public String modifyIdentityAuthentication(){
		return "modifyIdentityAuthentication";
	}
	@RequestMapping(value="/user/resume/identity/uploadCertificatePhoto",method = RequestMethod.POST)
	public String uploadCertificatePhoto(){
		return "uploadCertificatePhoto";
	}
	@RequestMapping(value="/user/resume/identity/selectIdentityAuditConclusion",method = RequestMethod.POST)
	public String selectIdentityAuditConclusion(){
		return "selectIdentityAuditConclusion";
	}
	@RequestMapping(value="/user/resume/identity/modifyHeight",method = RequestMethod.POST)
	public String modifyHeight(){
		return "modifyHeight";
	}
	@RequestMapping(value="/user/resume/identity/modifyEmail",method = RequestMethod.POST)
	public String modifyEmail(){
		return "modifyEmail";
	}
	@RequestMapping(value="/user/resume/identity/getInformation",method = RequestMethod.POST)
	public String getInformation(){
		return "getInformation";
	}
}
