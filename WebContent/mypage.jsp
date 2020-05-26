<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>result</title>
<style>
p{
	color: red;
}
</style>
</head>
<body>
	<h2>${item.userName}さんのマイページ</h2>
	
	<form action="ManageServlet" method="get">
	<button name="btn" value="find">商品を探しに行こうぜ！</button>
	</form>
</body>
</html>