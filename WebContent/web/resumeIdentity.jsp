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
	***********身份认证基本信息填写***********
		<form action="user/resume/identity/identityAuthentication" method="post">
			请输入用户ID:<input type="text" name="enId">
			真实姓名:<input type="text" name="name">
			性别:<input type="text" name="gender">
			身份证号:<input type="text" name="idNum">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********重新提交身份验证信息***********
		<form action="user/resume/identity/modifyIdentityAuthentication" method="post">
			请输入用户ID:<input type="text" name="enId">
			真实姓名:<input type="text" name="name">
			性别:<input type="text" name="gender">
			身份证号:<input type="text" name="idNum">
			 <input type="submit" value="确定">  
		</form>
	</center>
	 <center>
	 ***********证件照片上传***********
		<form action="user/resume/identity/uploadCertificatePhoto" method="post" enctype="multipart/form-data">
			<label>请输入用户名Id:</label><input type="text" name="enId"><br/>
			<label>照片类型:</label><input type="text" name="type"><br/>
			<label>选择照片:</label><input type="file" name="file"/><br/>
			 <input type="submit" value="确定">  
		</form>
	 * 		照片种类
	 * 		101：身份证正面照片
	 * 		102：手持身份证照片
	 * 		103：学生证内页照片
	 * 		104：其他证件照片
	</center>
	<center>
	***********查询用户身份审核结论***********
		<form action="user/resume/identity/selectIdentityAuditConclusion" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********修改身高***********
		<form action="user/resume/identity/modifyHeight" method="post">
			请输入用户ID:<input type="text" name="enId">
			输入用户身高:<input type="text" name="height">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********修改电子邮件***********
		<form action="user/resume/identity/modifyEmail" method="post">
			请输入用户ID:<input type="text" name="enId">
			输入email:<input type="text" name="eMail">
			 <input type="submit" value="确定">  
		</form>
	</center>
	<center>
	***********获取用户简历的基本信息***********
		<form action="user/resume/identity/getInformation" method="post">
			请输入用户ID:<input type="text" name="enId">
			 <input type="submit" value="确定">  
		</form>
	</center>
</body>