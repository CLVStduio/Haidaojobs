<%@page import="java.util.Map"%>
<%@page import="com.clv.server.job.PartTimeJobsClientVersionDao"%>
<%@page import="com.clv.server.user.UserDao"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
		<%
			WebApplicationContext wac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
		
		PartTimeJobsClientVersionDao partTimeJobsClientVersionDao = (PartTimeJobsClientVersionDao) wac.getBean("partTimeJobsClientVersionImpl");
			
			String partTimeId = (String)request.getParameter("partTimeId");
			String userIdStr = (String)request.getParameter("userId");
			String result = "{\"code\":404,\"msg\":\"fail\"}";
			if(userIdStr!=null){
				UserDao userDao = (UserDao) wac.getBean("userDaoImpl");
				Map<String,String> userId = userDao.IdAuthentication(userIdStr);
				result = partTimeJobsClientVersionDao.getPartTimeInformation(partTimeId,userId);
			}else{
				result = partTimeJobsClientVersionDao.getPartTimeInformation(Integer.parseInt(partTimeId));
			}
		%>
<%=result%>
