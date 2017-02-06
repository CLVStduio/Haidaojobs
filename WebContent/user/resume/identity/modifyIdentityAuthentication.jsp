<%@page import="com.clv.dao.user.ResumeInformation"%>
<%@page import="com.clv.dao.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			ResumeInformation resumeInformation = (ResumeInformation) wac.getBean("resumeInformationImpl");
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");			
			String name=(String)request.getParameter("name");
			String gender=(String)request.getParameter("gender");
			String idNum=(String)request.getParameter("idNum");
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
<%=resumeInformation.modifyIdentityAuthentication(id, name, gender, idNum)  %>