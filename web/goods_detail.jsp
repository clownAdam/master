<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>e-乐购商品详情</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
.font_D {
	font: 700 16px Arial, "microsoft yahei";
	font-style: normal;
	font-variant-caps: normal;
	font-weight: 700;
	font-stretch: normal;
	font-size: 16px;
	line-height: normal;
	font-family: Arial, "microsoft yahei";
	font-size-adjust: none;
	font-kerning: auto;
	font-optical-sizing:;
	font-variant-alternates: normal;
	font-variant-east-asian: normal;
	font-variant-ligatures: normal;
	font-variant-numeric: normal;
	font-variant-position: normal;
	font-language-override: normal;
	font-feature-settings: normal;
	font-variation-settings:;
}

.text-primary_abc {
	color: #999999;
	font: 12px simsun;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="col-md-offset-2 col-md-7"
		style="border: 1 solid red; padding: 2px;">
		<!--row col-md-offset-2 -->
		<div class="col-md-4" style="height: 550px; border: 1 solid red;">
			<!-- 			<img src="img/g1.png" class="img-rounded" /> -->
			<img src="upload/${product.product_icon }" alt="this impage not null"
				class="img-rounded" alt="..." width="350px" height="450px" />
		</div>
		<div class="col-md-4" style="width: 650px; height: 550px;">
			<br>
			<%-- 			<p>商品名称：${product.product_name }</p> --%>
			<div class="font_D"
				style="font: 16px arial; color: rgb(102, 102, 102); padding-left: 2px;">
				<strong> ${product.product_description } </strong>
			</div>
			<!-- 			<h2>价格</h2> -->
			<div
				style="background-color: rgb(243, 243, 243); height: 100px; padding: 5px 10px;">
				<span
					style="color: rgb(153, 153, 153); font: 12px simsun; text-align: centor;">优
					惠 价：</span> <span style="color: #e4393c; font: 16px 'microsoft yahei';">&yen;</span>
				<span style="color: rgb(228, 57, 60); font: 22px 'microsoft yahei';"
					class="text-danger">${product.product_price }</span>

			</div>
			<div style="padding: 5px 10px;">
				<br /> <span class="text-primary_abc" style="font: 12px simsun;">库&nbsp;&nbsp;存：</span>
				<span class="text-primary">${product.product_stock }</span><br /> <span
					class="text-primary_abc" style="line-height: 30px;">商品属性：</span> <span
					class="text-primary">${product.product_stock }</span><br /> <span
					class="text-primary_abc" style="line-height: 30px;">商品属性：</span> <span
					class="text-primary">${product.product_stock }</span><br /> <span
					class="text-primary_abc" style="line-height: 30px;">库&nbsp;&nbsp;存：</span>
				<span class="text-primary">${product.product_stock }</span><br /> <br />
				<%-- 				<input type="text" value="${user_info.user_id}">  --%>
				<a type="button" style="padding-left: 20px; margin-left: 70px;"
					class="btn btn-warning" href="order.do?pid=${product.product_id }">点击购买</a>
				<a type="button" style="padding-left: 20px; margin-left: 70px;"
<%--				<li><a href="user_manager.do">${sessionScope.user_info.user_name }</a></li>--%>
				   class="btn btn-warning" href="/product_cart.do?pid=${product.product_id}&uid=${sessionScope.user_info.user_id}">加入购物车</a>
			</div>
		</div>
	</div>
	<!-- 导航条结束 -->
	<!-- 	<div class="row col-md-12"> -->
	<!-- 		<div class="col-md-4 col-md-offset-2"> -->
	<!-- 			<img src="img/g1.png" class="img-rounded" /> -->
	<!-- 		</div> -->
	<!-- 		<div class="col-md-4"> -->
	<!-- 			<br /> -->
	<!-- 			<br /> -->
	<!-- 			<br /> -->
	<!-- 			<br /> -->
	<%-- 			<p>${product.product_name }</p> --%>
	<%-- 		<h2>价格</h2>	<span>优惠价：</span><span class="text-danger">${product.product_price }</span> --%>
	<!-- 		<br /> -->
	<%-- 		<span class="text-primary">库存：${product.product_stock }</span> --%>
	<!-- 		<br /> -->
	<%-- 		<a type="button" class="btn btn-warning" href="order.do?pid=${product.product_id }">点击购买</a> --%>
	<!-- 		</div> -->
	<!-- 	</div> -->
	<!--商品详情开始-->
	<div class="col-md-8 col-lg-offset-3">
		<br />
	</div>
</body>
</html>