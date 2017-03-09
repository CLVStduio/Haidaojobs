<%@page import="java.util.Map"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="com.clv.server.user.MyComponentServer"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
			UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
			MyComponentServer myComponent = (MyComponentServer) wac.getBean("myComponentImpl");
			
			int year=Integer.parseInt((String)request.getParameter("year"));
			String month = (String)request.getParameter("month");
			String enId = (String)request.getParameter("enId");
			Map<String,String> userMap = userDao.IdAuthentication(enId);
		%>
<%=myComponent.selectSignIn(userMap,year,month)%>
