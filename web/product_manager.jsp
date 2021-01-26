<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>e-乐购</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>

<body>
<!-- 	<h1>商品管理页面：</h1> -->
<!-- 	<h2>商品列表</h2> -->
<jsp:include page="houtaiheader.jsp"></jsp:include>
	<a class='btn btn-success' href="product_add.jsp">商品添加</a>
	<table
		class="table table-hover table-striped col-md-10 col-md-offset-1">
		<tr>
			<th>编号</th>
			<th>商品名称</th>
			<th>单价</th>
			<th>库存</th>
			<th>类目编号</th>
			<th>创建时间</th>
			<th>小图</th>
		</tr>
		<c:forEach items="${products }" var="product">
			<tr>
				<td>${product.product_id }</td>
				<td>${product.product_name}</td>
				<td>${product.product_price }</td>
				<td>${product.product_stock }</td>
				<td>${product.category_type}</td>
				<td>${product.create_time}</td>
				<td><img src="/upload/${product.product_icon}"/></td>
			</tr>
		</c:forEach>


	</table>
</body>

</html>