package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	@RequestMapping(value="/user/my/retroactive",method = RequestMethod.POST)
	public String retroactive(){
		return "retroactive";
	}
	@RequestMapping(value="/user/my/selectSignIn",method = RequestMethod.POST)
	public String selectSignIn(){
		return "selectSignIn";
	}
}
