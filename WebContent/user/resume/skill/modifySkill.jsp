<%@page import="com.clv.user.dao.ResumeOther"%>
<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			ResumeOther resumeOther = (ResumeOther) wac.getBean("resumeOtherImpl");
			String skill_id=(String)request.getParameter("skill_id");
			String skill_content=(String)request.getParameter("skill_content");
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
		
<%=resumeOther.modifySkill(id, skill_id, skill_content) %>