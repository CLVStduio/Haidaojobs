<%@page import="java.util.Map"%>
<%@page import="com.clv.server.user.ResumeInformationServer"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		ResumeInformationServer resumeInformation = (ResumeInformationServer) wac.getBean("resumeInformationImpl");
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enId=(String)request.getParameter("enId");
			Map<String,String> id = userDao.IdAuthentication(enId);
		%>
<%=resumeInformation.getInformation(id) %>