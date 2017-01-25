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
		<form action="user/getUser" method="post">
			请输入用户ID(json):<input type="text" name="id">
			 <input type="submit" value="确定">  
		</form>
	</center>
	
	<center>
		<form action="user/isUserPhoneNo" method="post">
			输入手机号判断是否已经注册:<input type="text" name="isphoneNo">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="code/getCode" method="post">
			请输入phone获取验证码:<input type="text" name="phoneGetCode">
			 <input type="submit" value="确定">  
		</form>
	</center>
	
	<center>
		<form action="code/checkCode" method="post">
			手机号:<input type="text" name="checkPhone">
			验证码:<input type="text" name="checkCode">
			 <input type="submit" value="确定">  
		</form>
	</center>
	
	<center>
	添加用户<br/>
		<form action="user/addUser" method="post">
			请输入用户phone:<input type="text" name="enPhone">
			请输入用户password:<input type="text" name="enPassword">
			 <input type="submit" value="确定">  
		</form>
	</center>

	<center>
	登录<br/>
		<form action="user/signIn" method="post">
			请输入用户phone:<input type="text" name="user_phoneNo">
			请输入用户password:<input type="text" name="user_password">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	修改用户名<br/>
		<form action="user/modify/modifyUserName" method="post">
			请输入新的用户名:<input type="text" name="user_name">
			请输入用户Id:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	修改用户手机号<br/>
		<form action="user/modify/modifyUserPhone" method="post">
			请输入新的手机号:<input type="text" name="enPhone">
			请输入用户名Id:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	修改用户密码<br/>
		<form action="user/modify/modifyUserPassword" method="post">
			请输入旧的密码:<input type="text" name="enOldPassword">
			请输入新的密码:<input type="text" name="enNewPassword">
			请输入用户名Id:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	重置用户密码<br/>
		<form action="user/modify/resetUserPassword" method="post">
			请输入新的密码:<input type="text" name="enPassword">
			请输入手机号:<input type="text" name="enPhone">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
		<form action="user/modify/modifyUserHeadPortrait" method="post" enctype="multipart/form-data">
			<label>请输入用户名Id:</label><input type="text" name="enId"><br/>
			<label>头 像</label><input type="file" name="file"/><br/>
			<input type="submit" value="提  交"/>
		</form>
	</center>
</body>
</html>