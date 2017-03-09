<%@page import="com.clv.server.user.UserDao"%>
<%@page import="java.util.Map"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enOldPassword=(String)request.getParameter("enOldPassword");
			String enNewPassword=(String)request.getParameter("enNewPassword");
			String enId=(String)request.getParameter("enId");
			Map<String,String> userMap = userDao.IdAuthentication(enId);
		%>
<%=userDao.modifyUserPassword(enOldPassword,enNewPassword,userMap) %>
	