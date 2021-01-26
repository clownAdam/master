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
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

body {
	background-color: #f4f4f4;
}

.outer {
	height: 400px;
	width: 1320px;
	background-color: #fff;
}

.outer1 {
	margin: 0 auto;
	height: 300px;
	width: 1320px;
	background-color: #fff;
	position: relative;
}

.fltj {
	height: 290px;
}

.caption:hover {
	border: 1px solid #e1251b;
}

.heardtop {
	width: 1320px;
	height: auto;
	margin: 80px auto;
}

.navbar {
	margin-bottom: 20px;
}

.top-wrap {
	position: absolute;
	top: 0px;
	left: 0px;
	width: 100%;
	height: 80px;
	margin-bottom: 5px;
}

.hhh {
	width: 70%;
	height: 100%;
	margin: 20px auto;
	background-color: #fff;
	position: relative;
}

.caption {
	margin-left: 22px;
	margin-right: 8px;
	margin-bottom: 5px;
}

.ad1 {
	width: 95%;
	max-height: 290px;
	position: relative;
	left: 10px;
	top: 0px;
	background-color: #f9f9f9;
	box-shadow: 1px 0 4px 2px #fff;
}

.vv {
	margin-top: -60px;
}

.ls {
	position: absolute;
	top: -10px;
	left: 220px;
}

.ls>ul>li {
	list-style: none;
	float: left;
	margin-left: 25px;
}

.hu {
	width: 100%;
	height: 45px;
	margin-bottom: 10px;
	background-color: #fdf4ed;
}

.hu>h3 {
	line-height: 45px;
	color: #E96F1E;
	margin-left: 20px;
}

.hu>h3::before {
	content: "";
	display: block;
	width: 10px;
	height: 25px;
	background-color: #E96F1E;
	position: absolute;
	top: 10px;
	left: 0px;
}

.gao {
	width: 100%;
	height: 30px;
	background-color: #fdf6f6;
	position: relative;
}

.gao>h4 {
	line-height: 30px;
	color: #db5757;
	margin-left: 15px;
}

.gao>h4::after {
	content: "";
	display: block;
	width: 5px;
	height: 15px;
	background-color: #db5757;
	position: absolute;
	top: 8px;
	left: 0px;
}

.list-group>a>h4 {
	margin-top: 23px;
	margin-left: 15px;
}

.vfdd {
	width: 100%;
	height: 30px;
	background-color: #fffaf2;
	color: #ff9902;
	margin-bottom: 20px;
}

.vfdd>h4 {
	margin-top: 10px;
	margin-left: 10px;
	line-height:30px;
}

.vfdd>h4::before {
	content: "";
	display: block;
	height: 20px;
	width: 5px;
	position: relative;
	background-color: #ff9902;
	top: 3px;
	left: -10px;
	float:left;
}
</style>
</head>
<body>
	<div id="top-wrap" class="top-wrap">
		<a href="" target="blank"> <img src="img/157.jpg" alt=""
			width="100%" height="80px"></a>
	</div>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="heardtop">
		<div class="outer">
			<div class="col-md-9 col-md-offset-0">
				<div id="carousel-example-generic" class="carousel slide"
					data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0"
							class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<c:forEach items="${ads}" var="ad" varStatus="status">

							<div
								class='item <c:if test="${status.index == 0 }">active</c:if>'>
								<img src="${ad.ad_pic}" alt="${status.index }"
									style="width: 1320px; height: 300px">
								<div class="carousel-caption">...</div>
							</div>
						</c:forEach>
					</div>
					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic"
						role="button" data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#carousel-example-generic"
						role="button" data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<div class="col-md-3 col-md-offset-0">
				<div class="ad1">
					<div class="gao">
						<h4>销量排行榜</h4>
					</div>
					<div class="list-group">
<!-- 						<a href="#" class="lines"> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> <a href="#" class="lines"> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> <a href="#" class=""> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> <a href="#" class=""> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> <a href="#" class=""> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> <a href="#" class=""> -->
<!-- 							<h4 class="">商品销量排行榜一</h4> -->
<!-- 						</a> -->
						<c:forEach items="${orderHive}" var="order" varStatus="status">
							<a href="goods_detail.do?pid=${order.product_id }" class="lines">
								<h4 class="">${order.product_name}</h4>
							</a>
						
						
<!-- 							<a href="#" class=""> -->
<%-- 								<h4 class="">${order.product_name}</h4> --%>
<%-- 								<p class="">${order.product_description}</p> --%> 
<!-- 								<p class="">......</p> -->
<!-- 							</a> -->
						</c:forEach>
					</div>
				</div>
			</div>
			<!-- 大图轮播结束 -->
		</div>
	</div>
	<!-- 推荐结束 -->
	<div class="outer1 vv">
		<jsp:include page="daojishi.html"></jsp:include>
		<div class="ls">
			<div class="vfdd">
				<h4>猜你喜欢</h4>
			</div>
			<ul>
				<!-- 销量排行 -->
				<c:forEach items="${ head2Product}" var="product">
					<li><a href="goods_detail.do?pid=${product.product_id }">
							<img src="upload/${product.product_icon}" alt="..."
							style="height: 180px; width: 240px">
					</a>
						<p>${product.product_name }
						<p style="color: red; font-size: 22px">￥
							${product.product_price}</p>
						</p></li>
				</c:forEach>

			</ul>
		</div>
	</div>
	<!-- 分类推荐开始 -->
	<div class="hhh">
		<div class="hu">
			<h3>热销推荐</h3>
		</div>
		<div class="">
			<div class="row">
				<c:forEach items="${product }" var="produ">
					<div class="caption" style="display: inline-block;">
						<a href="goods_detail.do?pid=${produ.product_id }"
							class="thumbnail"> <img src="upload/${produ.product_icon }"
							alt="..." style="width: 220px; height: 220px">
						</a>
						<div class="caption">
							<span> ${produ.product_name }
								<p style="color: red; font-size: 22px">￥
									${produ.product_price}</p>
							</span>
						</div>
					</div>

				</c:forEach>
			</div>
		</div>
	</div>
	<!-- 底部 -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- 分类推荐结束 -->
</body>
</html>