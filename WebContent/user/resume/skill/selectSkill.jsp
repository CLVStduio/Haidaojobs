<%@page import="com.clv.dao.user.ResumeOther"%>
<%@page import="com.clv.dao.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			ResumeOther resumeOther = (ResumeOther) wac.getBean("resumeOtherImpl");
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
<%=resumeOther.selectSkill(id) %>