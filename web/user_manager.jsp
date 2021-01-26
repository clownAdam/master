<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>e-乐购用户中心</title>
		<!-- Bootstrap -->
		<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<style>
			#header_pic{
				width:100px;
				height:100px;
			}
		</style>
	</head>

	<body>
	<jsp:include page="header.jsp"></jsp:include>	
		<div class="col-md-12">
			<h3 class="text-success">你好，${sessionScope.user_info.user_name }</h3></div>
			<img id="header_pic" src="/kmmall/upload/${sessionScope.user_info.user_pic}"/>
		<h2>订单列表</h2>
		<table class="table table-hover table-striped col-md-10 col-md-offset-1">
			<tr>
				<th>订单编号</th>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>订单价格</th>
				<th>订单状态</th>
				<th>操作订单</th>
			</tr>
			<c:forEach items="${orders }" var="order">
			<tr>
				<td>${order.order_id }</td>
				<td>${order.product_id }</td>
				<td>${order.product_name}</td>
				<td>${order.order_amount  }</td>
				<td>
				<c:if test="${order.order_status ==0}">已下单</c:if>
				<c:if test="${order.order_status ==1}">发货</c:if>
				<c:if test="${order.order_status ==2}">收货</c:if>
				<c:if test="${order.order_status ==-1}">订单取消</c:if>
				${order.order_status }
				
				</td>
				<!-- 0 ：新下单，-1：表示订单取消，1：发货，2：收获 -->
				<td><a href="updateStatus.do?status=-1&order_id=${order.order_id }" class="btn btn-danger">取消订单</a> &nbsp;&nbsp;<a href="updateStatus.do?status=2&order_id=${order.order_id }" class="btn btn-success">确认收货</a> </td> 
			</tr>
			</c:forEach>
			
		</table>
	</body>

</html>