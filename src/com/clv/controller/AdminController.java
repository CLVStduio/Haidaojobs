package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {
	@RequestMapping(value="/admin/addAdmin",method = RequestMethod.POST)
	public String addAdmin(){
		return "addAdmin";
	}
	@RequestMapping(value="/admin/selectAdmin",method = RequestMethod.POST)
	public String selectAdmin(){
		return "selectAdmin";
	}
	@RequestMapping(value="/admin/getAuditQueue",method = RequestMethod.POST)
	public String getAuditQueue(){
		return "getAuditQueue";
	}
	@RequestMapping(value="/admin/selectIdentity",method = RequestMethod.POST)
	public String selectIdentity(){
		return "selectIdentity";
	}
	@RequestMapping(value="/admin/setAuditConclusion",method = RequestMethod.POST)
	public String setAuditConclusion(){
		return "setAuditConclusion";
	}
}
