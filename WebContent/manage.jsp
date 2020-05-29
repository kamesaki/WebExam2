<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>manage</title>
<link rel="stylesheet" href="css/manage.css">
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
<h2><span class="outline">商品検索しちゃおうぜ！</span></h2>
	
	<form action="ManageServlet" method="get">
		<button class = "btnchan" name="btn" value="search">全商品一覧表示</button>
		<input type="hidden" name="selectWay" value="all">
	</form>
	
	
	<form action="ManageServlet" method="get">
		<p><span class="outline">商品名で検索</span></p>
		<input type="text" name="name">
		<button class = "btnbtn" name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="name">
	</form>
	
	<form action="ManageServlet" method="get">	
		<p><span class="outline">カテゴリから検索</span></p>
		<select name="category">
			<option value="general">雑貨</option>
			<option value="electric">家電</option>
			<option value="book">書籍</option>
			<option value="food">食品</option>
			<option value="fashion">ファッション</option>
			<option value="other">未分類</option>
		</select>
		<button class = "btnbtn" name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="category">
	</form>
		
	<form action="ManageServlet" method="get">	
		<p><span class="outline">値段から検索</span></p>
		<select name="price">
			<option value="0">0-1500円</option>
			<option value="1">1500-3000円</option>
			<option value="2">3000-5000円</option>
			<option value="3">5000-10000円</option>
			<option value="4">10000円以上</option>
		</select>
		<button class = "btnbtn" name="btn" value="search">検索</button>
		<input type="hidden" name="selectWay" value="price">
	</form>
	
	<c:if test="${list != null }">
		<table border="1">
			<tr>
				<th>商品id</th><th>商品コード</th><th>商品名</th><th>カテゴリ</th><th>価格</th><th></th><th></th>
			</tr>
			
			<c:forEach var="item" items="${list}">
				<tr>
					<td>${item.id}</td><td>${item.code}</td><td>${item.name}</td><td>${item.category}</td><td>${item.price}</td>
					<td>
						<form action="ManageServlet" method="get">
							<button class = "btnchans" name="btn" value="cart">カートに入れる</button>
							<input type="hidden" name="code" value="${item.code}">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>