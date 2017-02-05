<%@page import="com.clv.admin.dao.AdminDao"%>
<%@page import="com.clv.user.dao.ResumeInformation"%>
<%@page import="com.clv.user.dao.UserDao"%>
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
			String auditType=(String)request.getParameter("auditType");
			
			int adminId = adminDao.IdAuthentication(enAdminId);
		%>
	<%=resumeInformation.setAuditConclusion(adminId,enUserId,Integer.parseInt(auditType)) %>
