<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>買い物かご</title>
<link rel="stylesheet" type="text/css" href="css/Cart.css">
</head>
<header>
      <div class="container">
        <div class="seitan">
          <p>
   	      <img class="logo" src="./css/ios__________.png">
		     青木商店
		  </p>
        </div>
        <input class="mp" type="button" value="マイページへ" onClick="location.href='http://localhost:8080/webExam2/mypage.jsp'">
      </div>
    </header>
<body>
	<div class = "cage">
		<h1>これを買うんだな？</h1>
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
			<p>これに決めるぞ</p>
			<input class="btn" type="button" value="もちろん" onClick="location.href='http://localhost:8080/webExam2/result.jsp'">
			<input class="btn" type="button" value="ちょっと待て" onClick="location.href='http://localhost:8080/webExam2/result2.jsp'">
			<input class="btn" type="hidden" name="code" value="${item.code}">
		</form>
	</div>
</body>
</html>