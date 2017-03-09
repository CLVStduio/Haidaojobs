<%@page import="java.util.Map"%>
<%@page import="com.clv.server.admin.AdminDao"%>
<%@page import="com.clv.server.admin.UserIdentityServer"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			AdminDao adminDao = (AdminDao) wac.getBean("adminImpl");
			UserIdentityServer userIdentityServer = (UserIdentityServer)  wac.getBean("userIdentityImpl");
			
			String enAdminId=(String)request.getParameter("adminId");
			String enUserId=(String)request.getParameter("userId");
			
			Map<String,String> adminMap = adminDao.idAuthentication(enAdminId);
		%>
<%=userIdentityServer.selectIdentity(adminMap, enUserId) %>
