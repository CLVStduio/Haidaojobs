<%@page import="com.clv.dao.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			String in=(String)request.getParameter("id");
			System.out.println("查询ID:"+in);
			int num=Integer.parseInt(in);			
		%>
<%=userDao.getUser(num)%>
