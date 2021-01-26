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
<style type="text/css">
.fltj {
	height: 290px;
}
.caption:hover {
	border: 1px solid ;
}
.heardtop{
border: solid 0.5px gray;
width: 1320px;
height: 2000px;
margin:100px  auto;
}
.top-wrap{
 position:absolute;
 top:0px;
 left:0px;
 width:100%;
 height:80px;
 margin-bottom:5px;
}
</style>
</head>
<body>
<div id="top-wrap" class="top-wrap"><a href="" target="blank">
<img src="img/157.jpg" alt="" width="100%" height="80px"></a></div>


<!-- <div style="margin-top: 20px"> -->

<!-- </div> -->
	<div class="heardtop">
	<jsp:include page="header.jsp"></jsp:include>
	<div style="height: 400px;width: 1320px">
<div class="col-md-12 col-md-offset-0">
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

						<div class='item <c:if test="${status.index == 0 }">active</c:if>'>
							<img src="${ad.ad_pic}" alt="${status.index }" style="width: 1320px;height: 300px">
							<div class="carousel-caption">...</div>
						</div>
					</c:forEach>
					<!-- <div class="item active">
						<img src="img/pic1.webp" alt="">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item ">
						<img src="img/pic1.webp" alt="">
						<div class="carousel-caption">...</div>
					</div>
					<div class="item ">
						<img src="img/pic1.webp" alt="">
						<div class="carousel-caption">...</div>
					</div> -->
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
		<!-- 大图轮播结束 -->
</div>

<div style="height: 250px; width: 1320px">
	<div class="ad col-md-12">
		<!-- 销量排行 -->
		<div class="ad col-md-2">
			<h4 class="text-success ">销量排行榜</h2>
			<div class="list-group">
<!-- 			//orderHive -->
				<a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">商品销量排行榜一</h4>
					<p class="list-group-item-text">...</p>
				</a> 
	<c:forEach items="${orderHive}" var="order" varStatus="status">
					<a href="#" class="list-group-item active">
					<h4 class="list-group-item-heading">${order.product_name}</h4>
					<p class="list-group-item-text">${order.product_description}</p>
					<p class="list-group-item-text">......</p>
				</a> 
					</c:forEach>
			</div>
		</div>
		<!-- 销量排行结束 -->
		
			<jsp:include page="daojishi.html"></jsp:include>
<!-- 		<div class="col-md-6"> -->
<!-- 			<!-- 推荐开始 --> -->
<!-- 			<div class="row"> -->
<%-- 				<c:forEach items="${head2Product}" var="product"> --%>
<!-- <!--  -->
<!-- 	EL\JSTL   -->
<!--  --> -->
<!-- 					<div class="col-md-4 col-md-offset-2"> -->
<!-- 						<div class="thumbnail"> -->
<%-- 						<a href="goods_detail.do?pid=${product.product_id }"> --%>
						
<%-- 							<img src="upload/${product.product_icon  }" alt="..." style="height: 150px;width: 150px"> --%>
<!-- 						</a> -->
<!-- 							<div class="caption"> -->
<!-- 							<span> -->
<%-- 							${product.product_name } --%>
<!-- 								<p style="color: red ;font-size: 22px">￥ -->
<%-- 						${product.product_price}</p> --%>
<!-- 							</span> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 			<!-- 推荐结束 --> -->

		</div>
		<!-- 推荐结束 -->
	</div>
</div>
	<!-- 分类推荐开始 -->
<div class="">

		<h2 class="bg-success">商品推荐</h2>
		<div class="">
		<!-- 	<div class="row"> -->
				<c:forEach items="${product }" var="produ">
					<div class="caption" style="display: inline-block;">
						<a href="goods_detail.do?pid=${produ.product_id }" class="thumbnail"> 
						<img src="upload/${produ.product_icon }" alt="..." style="width: 220px;height: 220px" >
						</a>
						<div class="caption">
								<span>
							${produ.product_name }
								<p style="color: red ;font-size: 22px">￥
						${produ.product_price}</p>
							</span>
							</div>
					</div>
				
				</c:forEach>
			</div>
			</div>
	<!-- 	</div> -->
<%-- 	<jsp:include page="daojishi.jsp"></jsp:include> --%>
</div>
<div style="margin-top: 10px">

<jsp:include page="footer.jsp"></jsp:include>
</div>
	<!-- 底部 -->
	<!-- 分类推荐结束 -->
</body>
</html>