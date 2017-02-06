<%@page import="com.clv.dao.admin.AdminDao"%>
<%@page import="com.clv.dao.user.ResumeInformation"%>
<%@page import="com.clv.dao.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			AdminDao adminDao = (AdminDao) wac.getBean("adminImpl");
			ResumeInformation resumeInformation = (ResumeInformation) wac.getBean("resumeInformationImpl");
			UserDao userDao = (UserDao)  wac.getBean("userDaoImpl");
			
			String enAdminId=(String)request.getParameter("adminId");
			String enUserId=(String)request.getParameter("userId");
			
			int adminId = adminDao.IdAuthentication(enAdminId);
			int userId = userDao.IdAuthentication(enUserId);
		%>
<%=resumeInformation.selectIdentity(adminId, userId) %>
