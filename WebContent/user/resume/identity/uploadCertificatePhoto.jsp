<%@page import="java.util.Map"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="com.clv.server.user.ResumeInformationServer"%>
<%@page import="org.springframework.web.multipart.MultipartFile"%>
<%@page import="org.springframework.web.multipart.MultipartHttpServletRequest"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			ResumeInformationServer resumeInformation = (ResumeInformationServer) wac.getBean("resumeInformationImpl");
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file");
			
			String type = multipartRequest.getParameter("type");
			String enId = multipartRequest.getParameter("enId");
			Map<String,String> id = userDao.IdAuthentication(enId);
		%>
<%=resumeInformation.uploadCertificatePhoto(id,Integer.parseInt(type), file, request) %>
	