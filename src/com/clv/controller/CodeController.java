package com.clv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 验证码 相关操作连接
 * @author Evanglist
 * @time 2016.12.31
 *
 */
@Controller
public class CodeController {
	@RequestMapping(value="/code/getCode",method = RequestMethod.POST)
	public String getCode(){
		return "getCode";
	}
	@RequestMapping(value="/code/checkCode",method = RequestMethod.POST)
	public String checkCode(){
		return "checkCode";
	}
}
