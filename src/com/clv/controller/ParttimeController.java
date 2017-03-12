package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user/parttimes")
public class ParttimeController {
	@RequestMapping(value="/getPartTimeInformation",method = RequestMethod.POST)
	public String getPartTimeInformation(){
		return "getPartTimeInformation";
	}
	@RequestMapping(value="/getPartTimeList",method = RequestMethod.POST)
	public String getPartTimeList(){
		return "getPartTimeList";
	}
	@RequestMapping(value="/partTimeRegistration",method = RequestMethod.POST)
	public String partTimeRegistration(){
		return "partTimeRegistration";
	}
	@RequestMapping(value="/cancelTheRegistration",method = RequestMethod.POST)
	public String cancelTheRegistration(){
		return "cancelTheRegistration";
	}
}
