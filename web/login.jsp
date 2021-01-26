<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎登录e-乐购</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="fonts/iconfont.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<style>
*{
margin:0;
padding:0;
}
body {
	background-color:#f3f7f9;	
}
#cc {
	position: relative;
	top: 100px;
	width: 900px;
	height: auto;
	background-color:#fff;
	margin: 0 auto;
}
.row{
   background-color:#fff;
}
.col-md-6,
.col-xs-9{
  padding-left:0;
  margin-top:px;
}
.cc1{
    position:relative;
    top:120px;
    margin-bottom:80px;
    font-family:MicrosoftYaHei;
    height: 28px;
    font-size: 28px;
    color: rgba(58,64,91,1);
    line-height: 28px;
    text-align: center;
}
.form-group{
 width:340px;
 height:auto;
 margin-left:60px;
 margin-bottom:20px;
 background-color:red;
 position:relative;
 top:70px;
}
.form-control{
    width:280px;
    height:43px;
    border-radius:0 21px 21px 0;
    position: absolute;
    right: 0px;
    border: 0;
    top:0px;
    line-height: 43px;
    background-color:  #f0f2f7;
    outline: 0;
    font-size: 14px;
}
.ff{
   position:relative;
   height:45px;
   background-color: #f0f2f7;
   border-radius:21px;
}
.iconfont{
 position:absolute;
 left:18px;
 top:5px;
 font-size:25px;
 color:#555;
}
.hu{
 width: 340px;
    height: 50px;
    background-color: #0076fe;
    border-radius: 25px;
    font-size: 18px;
    color: #fff;
    margin-top: 80px;
    cursor: pointer;
    margin-left:65px;
}
.checkbox{
 position:relative;
 top:70px;
 left:80px;
}
.hu:hover{
color:#fff;
}
.ii{
 position:relative;
 top:-20px;
 left:280px;
 cursor:pointer;
}
#jj{
  position:relative;
  top:-90px;
  right:-335px;
}
</style>
</head>
<body>
<jsp:include page="header1.jsp"></jsp:include>
<div id="cc">
<div class="row">
	<div class="col-xs-9 col-md-6">
				<img src="img/cc.webp" alt="" width="400px" height="600px">
			</div>
<div class="col-xs-9 col-md-6">
   <h1 class="cc1">欢迎登陆</h1>
	<form action="login.do" method="post">
		<div class="form-group ff">
		<i class="iconfont icon-zhuye"></i>
			<label for="user_account"></label> <input
				type="text" class="form-control" id="user_account" name="user_account"
				placeholder="帐号/手机号/邮箱">
		</div>
		<div class="form-group ff">
		<i class="iconfont icon-zhanghaoanquan"></i>
			<label for="user_password"></label> <input
				type="password" class="form-control" id="user_password" name="user_password"
				placeholder="密码">
		<div class="ii"><i class="iconfont icon-yanjing1"></i></div>	
		</div>
		<div class="checkbox">
			<label> <input type="checkbox"> 1天内免密登录
			</label>
		</div>
		<input type="submit" class="btn hu" value="登录">
		<div id="jj"><a href="regist.jsp">直接注册</a></div>
	</form>
</div>
</div>
</div>
<script>
	$(document).ready(function() {
	    $(".form-control").focus(function(){
	    	$(this).parent().css({
	    		backgroundColor :"#fff",
	    		border:"1px solid #0076fe"
	    	})
	    $(this).css({
	    	backgroundColor :"#fff"
	    })
	    });
	    $(".form-control").blur(function(){
	    	$(this).parent().css({
	    		backgroundColor :"",
	    		border:""
	    	})
	    $(this).css({
	    	backgroundColor :""
	    })
	    });
	    $(".ii").click(function(){
	         var cc=$("#user_password").attr("type");
	    	$(this).children(".iconfont").toggleClass("icon-yanjing1").toggleClass("icon-yanjing");
	      if(cc=="password"){
	    	  $("#user_password").attr("type","text");
	      }else{
	    	  $("#user_password").attr("type","password");
	      }
	    	
	    });
	 //正则表达式密码验证
	 var password=$("#user_password").val();
	 var reg=/^((\d{3}-\d{8}|\d{4}-\d{7,8})|(1[3|5|7|8][0-9]{9}))$/;
	 
	})
</script>
</body>
</html>