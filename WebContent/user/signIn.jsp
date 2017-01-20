<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String user_phoneNo=(String)request.getParameter("user_phoneNo");
			String user_password=(String)request.getParameter("user_password");
			
			//System.out.println("登录用户名"+user_phoneNo);
			
		%>
<%=userDao.signIn(user_phoneNo,user_password)%>
	