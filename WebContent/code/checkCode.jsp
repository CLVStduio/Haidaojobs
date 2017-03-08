<%@page import="com.clv.server.tool.MessageDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MessageDao messageDao = (MessageDao) wac.getBean("messageDaoImpl");
			
			String phone=(String)request.getParameter("checkPhone");
			String code =(String)request.getParameter("checkCode"); 
			
			//System.out.println("code:"+code1);
			
			//System.out.println("验证码zifu"+zifu);
			//String[] str = zifu.split("[$]");
			//String phone = str[0];
			//String code = str[1];
			//String phone = (String)request.getParameter("checkPhone");
		//System.out.println("验证码phone："+phone);
		//System.out.println("code:"+code);
		%>
<%=messageDao.checkCode(phone,code) %>