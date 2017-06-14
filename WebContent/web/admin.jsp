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
<title>管理员操作</title>
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
	添加管理员<br/>
		<form action="admin/addAdmin" method="post">
			管理员姓名:<input type="text" name="adminName">
			管理员权限:<input type="text" name="permissions">
			管理员手机号:<input type="text" name="phone">
			管理员密码:<input type="text" name="password">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	查看管理员信息<br/>
		<form action="admin/selectAdmin" method="post">
			管理员id:<input type="text" name="adminId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	获取待审核队列<br/>
		<form action="admin/getAuditQueue" method="post">
			管理员id:<input type="text" name="adminId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	查询用户提交的身份认证信息<br/>
		<form action="admin/selectIdentity" method="post">
			管理员id:<input type="text" name="adminId">
			用户id:<input type="text" name="userId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	给出用户认证结果<br/>
		<form action="admin/setAuditConclusion" method="post">
			管理员id:<input type="text" name="adminId">
			用户id:<input type="text" name="userId">
			认证结果:<input type="text" name="auditType">
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>