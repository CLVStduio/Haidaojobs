<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="jquery.min.js"></script>  
<title>登录表单</title>
</head>
<body>
   <form action="signIn" method="post">
			请输入用户phone:<input type="text" name="user_phoneNo"><br>
			请输入用户password:<input type="text" name="user_password"><br>
			 <input type="submit" value="确定">  
		</form>
</body>
</html>