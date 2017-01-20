<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			
			String enPhone=(String)request.getParameter("enPhone");
			String enId=(String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
			System.out.println("用户名Id"+id);
		%>
<%=userDao.modifyUserPhone(enPhone,id) %>
	