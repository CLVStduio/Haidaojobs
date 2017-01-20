package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户相关操作连接
 * @author Evanglist
 * @time 2016.12.31
 */
@Controller
public class UserController {
	@RequestMapping("/")
	public String getIndex(){	
		return "index";
	}
	
	@RequestMapping(value="/user/getUser",method = RequestMethod.POST)
	public String getUser(){	
		return "getUser";
	}
	
	@RequestMapping(value="/user/isUserPhoneNo",method = RequestMethod.POST)
	public String isUserPhoneNo(){
		return "isUserPhoneNo";
	}
	
	@RequestMapping(value="/user/addUser",method = RequestMethod.POST)
	public String addUser(){
		return "addUser";
	}

	@RequestMapping(value="/user/signIn",method = RequestMethod.POST)
	public String signIn(){
		return "signIn";
	}
	
	@RequestMapping(value="/user/modify/modifyUserName",method = RequestMethod.POST)
	public String modifyUserName(){
		return "modifyUserName";
	}

	@RequestMapping(value="/user/modify/modifyUserPhone",method = RequestMethod.POST)
	public String modifyUserPhone(){
		return "modifyUserPhone";
	}
	@RequestMapping(value="/user/modify/modifyUserPassword",method = RequestMethod.POST)
	public String modifyUserPassword(){
		return "modifyUserPassword";
	}
	@RequestMapping(value="/user/modify/resetUserPassword",method = RequestMethod.POST)
	public String resetUserPassword(){
		return "resetUserPassword";
	}
	@RequestMapping(value="/user/modify/modifyUserHeadPortrait",method = RequestMethod.POST)
	public String modifyUserHeadPortrait(){
		return "modifyUserHeadPortrait";
	}
	
	@RequestMapping(value="/user/selectHeadPortraitURL",method = RequestMethod.POST)
	public String selectHeadPortraitURL(){
		return "selectHeadPortraitURL";
	}
}
