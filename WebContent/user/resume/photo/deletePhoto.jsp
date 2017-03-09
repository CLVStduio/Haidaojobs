<%@page import="java.util.Map"%>
<%@page import="com.clv.server.user.ResumeOtherServer"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			ResumeOtherServer resumeOther = (ResumeOtherServer) wac.getBean("resumeOtherImpl");
			
			String photoName=(String)request.getParameter("photoName");
			String enId=(String)request.getParameter("enId");
			Map<String,String> userMap = userDao.IdAuthentication(enId);
		%>
		
<%=resumeOther.deletePhoto(userMap, photoName) %>
