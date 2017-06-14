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
<title>简历</title>
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
	 ***********添加风采照片***********
		<form action="user/resume/photo/addPhoto" method="post" enctype="multipart/form-data">
			<label>请输入用户名Id:</label><input type="text" name="enId"><br/>
			<label>选择照片:</label><input type="file" name="file"/><br/>
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********删除风采照片***********
		<form action="user/resume/photo/deletePhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			photoName:<input type="text" name="photoName">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********查看风采照片***********
		<form action="user/resume/photo/selectPhoto" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	*************************************************************<br>
	<center>
	***********添加特长***********
		<form action="user/resume/skill/addSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			特长内容:<input type="text" name="skill_content">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********查看特长***********
		<form action="user/resume/skill/selectSkill" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********删除特长***********
		<form action="user/resume/skill/deleteSkill" method="post">
			请输入用户ID:<input type="text" name="enId"><br>
			特长ID:<input type="text" name="skill_id"><br>
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********修改特长***********
		<form action="user/resume/skill/modifySkill" method="post">
			请输入用户ID:<input type="text" name="enId"><br>
			特长ID:<input type="text" name="skill_id"><br>
			特长内容:<input type="text" name="skill_content"><br>
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>
</html>