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
<title>兼职信息</title>
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
		兼职列表
		<form action="user/parttimes/getPartTimeList" method="post">
			最后查看时间：<input type="text" name="lastTime">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		获取兼职详情1
		<form action="user/parttimes/getPartTimeInformation" method="post">
			兼职id:<input type="text" name="partTimeId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		获取兼职详情2
		<form action="user/parttimes/getPartTimeInformation" method="post">
			用户id：<input type="text" name="userId">
			兼职id:<input type="text" name="partTimeId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		***************************************<br>
		兼职报名1
		<form action="user/parttimes/partTimeRegistration" method="post">
			用户id：<input type="text" name="enUserId">
			兼职id:<input type="text" name="enpartTimeId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		兼职报名2
		<form action="user/parttimes/partTimeRegistration" method="post">
			用户id：<input type="text" name="enUserId">
			兼职id:<input type="text" name="enpartTimeId">
			回答:<input type="text" name="enAnswer">
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