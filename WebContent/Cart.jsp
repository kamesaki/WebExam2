<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>買い物かご</title>
</head>
<body>
	<h2>あなたのカートの中身です</h2>
	<form action="CartServlet" method="post">
		<table border="1">
			<tr>
				<th>商品名</th><td>${item.name}</td>
			</tr>
			<tr>
				<th>カテゴリ</th><td>${item.category}</td>
			</tr>
			<tr>
				<th>価格</th><td>${item.price}</td>
			</tr>
		</table>
		<p>こちらの商品を購入します</p>
		<p>よろしいですか？</p>
		<button name="btn" value="yes">はい</button>
		<button name="btn" value="no">いいえ</button>
		<input type="hidden" name="code" value="${item.code}">
	</form>
</body>
</html>