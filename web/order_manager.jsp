<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	
	
		<h1>订单管理页面：
	</h1>
		<h2>订单列表</h2>
		<table class="table table-hover table-striped col-md-10 col-md-offset-1">
			<tr>
				<th>订单编号</th>
				<th>买家姓名</th>
				<th>买家编号</th>
				<th>商品名称</th>
				<th>订单价格</th>
				<th>订单状态</th>
				<th>操作订单</th>
			<c:forEach items="${orders }" var="order">
			<tr>
				<td>${order.order_id }</td>
				<td>${order.buyer_name}</td>
				<td>${order.user_id}</td>
				<td>${order.product_name }</td>
				<td>${order.order_amount}</td>
				<td><c:if test="${order.order_status ==0}">已下单</c:if>
				<c:if test="${order.order_status ==1}">发货</c:if>
				<c:if test="${order.order_status ==2}">收货</c:if>
				<c:if test="${order.order_status ==-1}">订单取消</c:if></td>
				<!-- 0 ：新下单，-1：表示订单取消，1：发货，2：收获 -->
				<td><a href="updateStatus.do?status=-1&order_id=${order.order_id }" class="btn btn-danger">取消订单</a> &nbsp;&nbsp;<a href="updateStatus.do?status=1&order_id=${order.order_id }" class="btn btn-success">确认发货</a> </td> 
			
			</tr>
		</c:forEach>
				
		</table>
	</body>

</html>