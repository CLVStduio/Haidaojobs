<%@page import="com.clv.server.user.UserDao"%>
<%@page import="com.clv.server.user.ResumeOther"%>
<%@page import="org.springframework.web.multipart.MultipartFile"%>
<%@page import="org.springframework.web.multipart.MultipartHttpServletRequest"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			ResumeOther resumeOther = (ResumeOther) wac.getBean("resumeOtherImpl");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file");
			
			String enId = multipartRequest.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
<%=resumeOther.addPhoto(id, file, request) %>
	