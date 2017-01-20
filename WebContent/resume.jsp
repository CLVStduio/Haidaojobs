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
		<form action="user/resume/addPhoto" method="post" enctype="multipart/form-data">
			<label>请输入用户名Id:</label><input type="text" name="enId"><br/>
			<label>头 像</label><input type="file" name="file"/><br/>
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/resume/deletePhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			photoName:<input type="text" name="photoName">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/resume/selectPhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/resume/addSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			Skill_content:<input type="text" name="skill_content">
			 <input type="submit" value="确定">  
		</form>
	</center>
	
	
	<center>
		<form action="user/resume/selectSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>
</html>