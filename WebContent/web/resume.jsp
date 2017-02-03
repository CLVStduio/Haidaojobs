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
	 ***********添加风采照片***********
		<form action="user/resume/addPhoto" method="post" enctype="multipart/form-data">
			<label>请输入用户名Id:</label><input type="text" name="enId"><br/>
			<label>选择照片:</label><input type="file" name="file"/><br/>
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********删除风采照片***********
		<form action="user/resume/deletePhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			photoName:<input type="text" name="photoName">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********查看风采照片***********
		<form action="user/resume/selectPhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	*************************************************************<br>
	<center>
	***********添加特长***********
		<form action="user/resume/addSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			特长内容:<input type="text" name="skill_content">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********查看特长***********
		<form action="user/resume/selectSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********删除特长***********
		<form action="user/resume/deleteSkill" method="post">
			请输入用户ID:<input type="text" name="enId"><br>
			特长ID:<input type="text" name="skill_id"><br>
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********修改特长***********
		<form action="user/resume/modifySkill" method="post">
			请输入用户ID:<input type="text" name="enId"><br>
			特长ID:<input type="text" name="skill_id"><br>
			特长内容:<input type="text" name="skill_content"><br>
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>
</html>