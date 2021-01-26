<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.col-md-12 {
	padding-right: 0;
}
</style>
<div class="nav col-md-12">
	<!-- 导航条内容 -->

	<nav class="navbar navbar-default">
		<div class="container-fluid">

			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.do">商城</a>

			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<c:forEach items="${categorys}" var="item">
						<li><a href="categoryList.do?categoryId=${item.category_id}">${item.category_name }
								<span class="sr-only">(current)</span>
						</a></li>
					</c:forEach>


				</ul>
				<form action="queryProductByKey.do" class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" name="key"
							placeholder="请输入搜索内容">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>


				<ul class="nav navbar-nav navbar-right">
					<c:if test="${sessionScope.user_info!=null }">
						<li><a href="log/elg.pptx">网站导航</a></li>
						<li><a href="#">客服</a></li>
						<li><a href="#">收藏夹</a></li>
						<li><a href="#">手机版</a></li>
						<li><a href="user_manager.do">${sessionScope.user_info.user_name }</a></li>
						<li><a href="logout.do">退出登录</a></li>
					</c:if>
					<c:if test="${sessionScope.user_info==null }">
						<li><a href="log/elg.pptx">网站导航</a></li>
						<li><a href="#">客服</a></li>
						<li><a href="#">收藏夹</a></li>
						<li><a href="#">手机版</a></li>
						<li><a href="login.jsp">登录</a></li>
						<li><a href="regist.jsp">注册</a></li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<!-- 导航条结束 -->
</div>