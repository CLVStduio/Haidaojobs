<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String user_phoneNo=(String)request.getParameter("enPhone");
			String user_password=(String)request.getParameter("enPassword");
			
			System.out.println("添加用户名"+user_phoneNo);
			System.out.println("添加用户密码"+user_password);
		%>
<%=userDao.addUser(user_phoneNo,user_password)%>
