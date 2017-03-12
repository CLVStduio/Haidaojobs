<%@page import="java.util.Map"%>
<%@page import="com.clv.server.job.PartTimeJobsClientVersionDao"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		PartTimeJobsClientVersionDao partTimeJobsClientVersionDao = (PartTimeJobsClientVersionDao) wac.getBean("partTimeJobsClientVersionImpl");
			
		UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
		
			String partTimeId = (String)request.getParameter("enpartTimeId");
			String enId=(String)request.getParameter("enUserId");
			Map<String,String> id = userDao.IdAuthentication(enId);
		%>
<%=partTimeJobsClientVersionDao.cancelTheRegistration(id, partTimeId)  %>