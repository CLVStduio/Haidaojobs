<%@page import="com.clv.server.tool.MessageDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		MessageDao messageDao = (MessageDao) wac.getBean("messageDaoImpl");
			String phone=(String)request.getParameter("phoneGetCode");
		%>
<%=messageDao.getCode(phone) %>
