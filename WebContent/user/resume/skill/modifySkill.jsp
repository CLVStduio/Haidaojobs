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
			String skill_id=(String)request.getParameter("skill_id");
			String skill_content=(String)request.getParameter("skill_content");
			String enId=(String)request.getParameter("enId");
			Map<String,String> userMap = userDao.IdAuthentication(enId);
		%>
		
<%=resumeOther.modifySkill(userMap, skill_id, skill_content) %>
