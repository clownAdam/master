<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.col-md-12{
 padding-right:0;
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
					
				</div>
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">


					<ul class="nav navbar-nav navbar-right">
						<c:if test="${sessionScope.user_info!=null }">
						<li><a href="user_manager.do">${sessionScope.user_info.user_name }</a></li>
						</c:if>
						<c:if test="${sessionScope.user_info==null }">
						<li><a href="log/elg.pptx">网站导航</a></li>
						<li><a href="log/qqq.pptx">开发手册</a></li>
						<li><a href="log/order.log">订单日志</a></li>
						<li><a href="log/uid_pid.log">用户浏览日志</a></li>
						<li><a href="log/sjidea.txt">商家使用说明书</a></li>
						</c:if>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
		<!-- 导航条结束 -->
	</div>