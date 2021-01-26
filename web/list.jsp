<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>e-乐购列表页面</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style type="text/css">
.fltj {
	height: 260px;
}

section {
	width: 1150px;
	margin: 0 auto;
}

.caption {
	padding: 2px;
	vertical-align: top;
	width: 225px;
}

.caption:hover {
	border: 0.8px solid rgba(230, 66, 60, 0.8);
}

</style>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<div class="div">
			<c:forEach items="${products }" var="product">
				<div style="display: inline-block;">
					<div class="caption" style="display: inline-block;">
						<a href="goods_detail.do?pid=${product.product_id }"> <img
							src="upload/${product.product_icon }" alt="..." width="220px"
							height="220px"></a>
						<h4 style="color: rgb(228, 57, 60);">
							&yen;${product.product_price }
							</h3>
							<a class="desc_font"
								href="goods_detail.do?pid=${product.product_id }">
								<div class="desc_font" style="color: rgb(102, 102, 102);">${product.product_description }</div>
							</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</section>
	<!-- end -->
	<%-- 	<c:forEach items="${products }" var="product"> --%>
	<!-- 		<div class="col-md-2"> -->
	<!-- 			<div class="thumbnail"> -->
	<%-- 				<a href="goods_detail.do?pid=${product.product_id }"> <img --%>
	<%-- 					src="upload/${product.product_icon }" alt="..."> --%>
	<!-- 					<div class="caption"> -->
	<%-- 						<h3>${product.product_name }</h3> --%>
	<%-- 						<p>${product.product_description }</p> --%>
	<!-- 					</div> -->
	<!-- 				</a> -->
	<!-- 			</div> -->
	<!-- 		</div> -->
	<%-- 	</c:forEach> --%>
</body>
</html>