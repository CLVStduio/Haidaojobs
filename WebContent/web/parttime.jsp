<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查找用户信息</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	 
	<center>
		兼职列表
		<form action="user/parttimes/getPartTimeList" method="post">
			最后查看时间：<input type="text" name="lastTime">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		获取兼职详情
		<form action="user/parttimes/getPartTimeInformation" method="post">
			兼职id:<input type="text" name="partTimeId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		撤销报名
		<form action="user/parttimes/cancelTheRegistration" method="post">
			用户id：<input type="text" name="enUserId">
			兼职id:<input type="text" name="enpartTimeId">
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>