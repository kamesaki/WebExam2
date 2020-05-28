<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>login</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
	<h1>青木商店</h1>
	<div class = "top">
		<form action="LoginServlet" method="post">
			<p>USER ID</p>
			<input type="text" name="id" value="${valueId}" size=35 placeholder="IDを入力しちゃおうぜ！">
			<p>PASSWORD</p>
			<input type="password" name="pass" value="${valuePass}" size=35 placeholder="パスワードを入力しちゃおうぜ！">
			<br>
			<button name="button" value="login">ログインしちゃおうぜ！</button>
		</form>
	</div>
</body>
</html>