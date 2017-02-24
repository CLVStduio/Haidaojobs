package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParttimeController {
	@RequestMapping(value="/user/parttimes/getPartTimeInformation",method = RequestMethod.POST)
	public String getPartTimeInformation(){
		return "getPartTimeInformation";
	}
	@RequestMapping(value="/user/parttimes/getPartTimeList",method = RequestMethod.POST)
	public String getPartTimeList(){
		return "getPartTimeList";
	}
}
