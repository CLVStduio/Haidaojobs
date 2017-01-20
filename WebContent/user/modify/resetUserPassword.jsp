<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String phone=(String)request.getParameter("enPhone");
			String password=(String)request.getParameter("enPassword");
			
			System.out.println("添加用户名"+phone);
			System.out.println("添加用户密码"+password);
		%>
<%=userDao.resetUserPassword(phone, password) %>
