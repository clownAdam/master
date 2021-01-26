<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<jsp:include page="header.jsp"></jsp:include>			<!--订单详情-->
		<div class="col-md-5 col-md-offset-3">
			<form action='order.do' method='post'>
				<div class="form-group">
					<label for="exampleInputtext1">商品名称</label>
					<input type="text" value="${product.product_name }"  class="form-control" id="product_name" name="product_name">
				</div>
				<div class="form-group">
					<label for="product_id">商品编号</label>
					<input type="text" value="${product.product_id }"  class="form-control" id="product_id" name="product_id">
				</div>
				<div class="form-group">
					<label for="product_price">单价</label>
					<input type="text" value="${product.product_price  }"  class="form-control" id="product_price" name="product_price">
				</div>


				<div class="form-group">
					<label for="product_quantity">商品数量</label>
					<input type="text" value="1"  class="form-control" id="product_quantity" name="product_quantity">
				</div>

				<div class="form-group">
					<label for="buyer_name">买家名字</label>
					<input type="text"  class="form-control" id="buyer_name" name="buyer_name">
				</div>
				<div class="form-group">
					<label for="buyer_phone">买家电话</label>
					<input type="text" class="form-control" id="buyer_phone" name="buyer_phone">
				</div>
				<div class="form-group">
					<label for="buyer_address">买家地址</label>
					<input type="text"  class="form-control" id="buyer_address" name="buyer_address">
				</div>
				<div class="form-group">
					<label for="buyer_openid">买家微信</label>
					<input type="text"  class="form-control" id="buyer_openid" name="buyer_openid">
				</div>
				<div class="form-group">
					<label for="user_id">买家编号</label>
					<input type="text" value="${user_info.user_id}" class="form-control" id="user_id" name="user_id">
				</div>
				<div class="form-group">
					<label for="order_amount">订单总金额</label>
					<input type="text" value="${product.product_price  }" class="form-control" id="order_amount" name="order_amount">
				</div>

				<button type="submit" class="btn btn-success">点击支付</button>
			</form>

		</div>

	</body>

</html>