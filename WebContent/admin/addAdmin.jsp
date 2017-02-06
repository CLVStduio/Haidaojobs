<%@page import="com.clv.dao.admin.AdminDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletContext());
		
			AdminDao adminDao = (AdminDao) wac.getBean("adminImpl");
			
			String adminName=(String)request.getParameter("adminName");
			String permissions=(String)request.getParameter("permissions");
			String phone=(String)request.getParameter("phone");
			String password=(String)request.getParameter("password");
		%>

<%=adminDao.addAdmin(adminName, permissions, phone, password) %>