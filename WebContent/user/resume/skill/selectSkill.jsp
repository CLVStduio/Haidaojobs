<%@page import="java.util.Map"%>
<%@page import="com.clv.server.user.ResumeOtherServer"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			ResumeOtherServer resumeOther = (ResumeOtherServer) wac.getBean("resumeOtherImpl");
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enId=(String)request.getParameter("enId");
			Map<String,String> userMap = userDao.IdAuthentication(enId);
		%>
<%=resumeOther.selectSkill(userMap) %>