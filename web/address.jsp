<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>e-乐购地址分析</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
	<!-- 	<h1>商品管理页面：</h1> -->
	<!-- 	<h2>商品列表</h2> -->
	<a class='btn btn-success' href="product_add.jsp">商品添加</a>
	<table class="table table-hover table-striped col-md-2">
		<!-- table table-hover table-striped col-md-10 col-md-offset-1 -->
		<tr>
			<th>地址</th>
			<th>数据</th>
		</tr>
		<c:forEach items="${maps }" var="map">
			<tr>
				<td>${map.key }</td>
				<td>${map.value}</td>
			</tr>
		</c:forEach>


	</table>
	<hr>
	<hr>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<table class="table table-hover table-striped col-md-2">
		<!-- table table-hover table-striped col-md-10 col-md-offset-1 -->
		<tr>
			<th>姓名</th>
			<th>数据</th>
		</tr>
		<c:forEach items="${maps1 }" var="map1">
			<tr>
				<td>${map1.key }</td>
				<td>${map1.value}</td>
			</tr>
		</c:forEach>


	</table>
</body>
</html>