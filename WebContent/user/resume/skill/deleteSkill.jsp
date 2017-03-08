<%@page import="com.clv.server.user.ResumeOther"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			ResumeOther resumeOther = (ResumeOther) wac.getBean("resumeOtherImpl");
			String skill_id=(String)request.getParameter("skill_id");
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
		
<%=resumeOther.deleteSkill(id, skill_id) %>
