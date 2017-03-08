<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String isphoneNo=(String)request.getParameter("isphoneNo");
			
			System.out.println("查询手机号"+isphoneNo);
			
		%>
<%=userDao.isUserPhoneNo(isphoneNo) %>