<%@page import="com.clv.server.admin.AdminDao"%>
<%@page import="com.clv.server.user.ResumeInformation"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			AdminDao adminDao = (AdminDao) wac.getBean("adminImpl");
			ResumeInformation resumeInformation = (ResumeInformation) wac.getBean("resumeInformationImpl");
			
			String enId=(String)request.getParameter("adminId");

			int adminId = adminDao.IdAuthentication(enId);
		%>

<%=resumeInformation.getAuditQueue(adminId) %>