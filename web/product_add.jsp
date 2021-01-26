<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script src="js/jquery.form.js"></script>
</head>

<body>
<jsp:include page="houtaiheader.jsp"></jsp:include>
	<div class="col-md-10 col-md-offset-1">
		<form action="product_add.do" method="post">
			<div class="form-group">
				<label for="product_name"> 商品名称</label> <input type="text"
					class="form-control" id="product_name" name="product_name" placeholder="商品名称">
			</div>
			<div class="form-group">
				<label for="product_price"> 单价</label> <input type="text"
					class="form-control" id="product_price" name="product_price"
					placeholder="单价">
			</div>
			<div class="form-group">
				<label for="product_stock">库存 </label> <input type="text"
					class="form-control" id="product_stock" name="product_stock"
					placeholder="库存">
			</div>
			<div class="form-group">
				<label for="product_description"> 描述</label>
				<textarea class="form-control" name="product_description" rows="8"></textarea>
			</div>

			<div class="form-group">
				<label for="product_icon"> 图片</label> <input type="text"
					class="form-control" id="product_icon" name="product_icon"
					placeholder="小图">
			</div>
			<div class="form-group">
				<label for="category_type">类目编号 </label> <input type="text"
					class="form-control" id="category_type" name="category_type"
					placeholder="类目编号">
			</div>
			<button type="submit" class="btn btn-default">提交</button>
		</form>
		<form id="upForm" action="upPic.do" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="pic">商品图片上传</label> <input type="file" name="pic"
					id="picUpload">
			</div>
			<button type="submit" id="up" class="btn btn-success">点击上传</button>
		</form>
	</div>
<div>
<!-- <a href="product_manager.do">看看后台数据</a> -->
<a class='btn btn-success' href="product_manager.do">查看后台数据</a>
<br>
<a class='btn btn-success' href="address.html" style="margin-top: 10px;">查看地址分析数据</a>
</div>
</body>
<script>
	//异步上传文件
	$(document).ready(function() {
		$('#upForm').ajaxForm(function(e) {
			console.log(e);
			$("#product_icon").val(e);
		});
	});
</script>
</html>