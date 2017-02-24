<%@page import="com.clv.dao.job.PartTimeJobsClientVersionDao"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		PartTimeJobsClientVersionDao partTimeJobsClientVersionDao = (PartTimeJobsClientVersionDao) wac.getBean("partTimeJobsClientVersionImpl");
			
			String partTimeId = (String)request.getParameter("partTimeId");
		%>
<%=partTimeJobsClientVersionDao.getPartTimeInformation(Integer.parseInt(partTimeId))%>
