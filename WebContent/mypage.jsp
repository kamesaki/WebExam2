<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>result</title>
<link rel="stylesheet" href="./css/MyPage.css">
</head>
<body>
	<header>
      <div class="container">
        <div class="seitan">
          <p>
   	      <img class="logo" src="./css/ios__________.png">
		     青木商店
		  </p>
        </div>
        <input class="mp" type="button" value="Topページへ" onClick="location.href='http://localhost:8080/webExam2/LoginServlet'">
      </div>
    </header>
	<h2>${id}さんのマイページ</h2>
	
	<div class = "push">
		<form action="ManageServlet" method="get">
		<button name="btn" value="find">商品を探しに行こうぜ！</button>
		</form>
		
		<form action="Omikuji" method="get">
		<button name="btn" value="omikuji">運勢を占う！</button>
		</form>
		<p>${omikuji}</p>
	</div>
</body>
</html>