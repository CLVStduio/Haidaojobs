<%@page import="com.clv.user.dao.UserDao"%>
<%@page import="com.clv.user.dao.MyComponent"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			MyComponent myComponent = (MyComponent) wac.getBean("myComponentImpl");
			
			int date=Integer.parseInt((String)request.getParameter("date"));
			String enId = (String)request.getParameter("enId");
			int id = userDao.IdAuthentication(enId);
		%>
<%=myComponent.skillGiftBag(id,date)%>