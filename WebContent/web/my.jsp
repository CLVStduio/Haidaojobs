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
<title>我的</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<center>
	**************************************************	<br>
	<a href = "index.jsp">用户基本信息操作</a>	<br>
	<a href = "web/admin.jsp">管理员</a><br>
	<a href = "web/my.jsp">我的</a><br>
	<a href = "web/parttime.jsp">兼职信息</a><br>
	<a href = "web/resume.jsp">简历</a><br>
	<a href = "web/resumeIdentity.jsp">身份认证</a><br>
	**************************************************
	</center>		 
	<center>
		<form action="user/my/retroactive" method="post">
			用户id:<input type="text" name="enId">
			签到日期：<input type="text" name="date">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/my/selectSignIn" method="post">
			用户id:<input type="text" name="enId">
			查询年份：<input type="text" name="year">
			查询月份：<input type="text" name="month">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	************************************************************
	签到礼包相关
	</center>
	<center>
		<form action="user/my/getSignInGift" method="post">
			用户id:<input type="text" name="enId">
			领取日期：<input type="text" name="date">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/my/selectSignInGift" method="post">
			用户id:<input type="text" name="enId">
			查询年份：<input type="text" name="year">
			查询月份：<input type="text" name="month">
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>