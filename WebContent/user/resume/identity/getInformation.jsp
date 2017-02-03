<%@page import="com.clv.user.dao.ResumeInformation"%>
<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			ResumeInformation resumeInformation = (ResumeInformation) wac.getBean("resumeInformationImpl");
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
<%=resumeInformation.getInformation(id) %>