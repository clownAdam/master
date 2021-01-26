<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>欢迎注册e-乐购</title>
<!-- Bootstrap -->
<link rel="shortcut icon" href="favicon.ico" type="image/x-icon"/>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="fonts/iconfont.css" rel="stylesheet">
<script src="js/jquery.min.js"></script>
<script src="js/jquery.form.js"></script>
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
    top:40px;
    margin-bottom:80px;
    font-family:MicrosoftYaHei;
    height: 28px;
    font-size: 28px;
    color: rgba(58,64,91,1);
    line-height: 28px;
    text-align: center;
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
.radio{
 float:left;
 position:rilative;
 top:5px;
 left:12px;
}
.radio>label{
 margin-right:10px;
}
.form-group{
 width:340px;
 margin-left:60px;
 margin-bottom:20px;
}
.cc3{
   width:100px;
   height:10px;
}
.ls{
    width: 330px;
    height: 50px;
    background-color: #0076fe;
    border-radius: 25px;
    font-size: 18px;
    color: #fff;
    margin-top: px;
    cursor: pointer;
    margin-left:60px;
    font-family: MicrosoftYaHei;
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
#user_pic{
 height:34px;
 width:200px;
 border:0;
 outline:0;
 position:relative;
 top:-10px;
 left:100px;
}
#picUpload{
 position:absolute;
 top:383px;
 left:160px;
 z-index:100;
 opacity:0;
}
#up{
 position:relative;
 left:-90px;
 top:25px;
}
.ls:hover{
color:#fff;
}
.ii{
 position:relative;
 top:-22px;
 left:280px;
 cursor:pointer;
}
#jj{
  position:relative;
  top:-154px;
  right:-270px;
}
</style>
</head>
<body>
	<jsp:include page="header1.jsp"></jsp:include>
	<div id="cc">
		<div class="row">
			<div class="col-xs-9 col-md-6">
				<img src="img/11.jpg" alt="" width="400px" height="600px">
			</div>
			<div class="col-xs-9 col-md-6">
			<h1 class="cc1">注册帐号密码</h1>
				<form action="regist.do" method="post">
					<div class="form-group ff">
					    <i class="iconfont icon-zhuye"></i>
						<label for="account"></label> <input type="text"
							class="form-control" id="account" placeholder="帐号/手机号/邮箱"
							name="user_account">
					</div>
					<div class="form-group ff">
					    <i class="iconfont icon-yonghu"></i>
						<label for="username"></label> <input type="text"
							class="form-control" id="username" placeholder="用户名"
							name="user_name">
					</div>
					<div class="form-group ff">
					   <i class="iconfont icon-mima"></i>
						<label for="password"></label> <input type="password"
							class="form-control" id="user_password" placeholder="密码"
							name="user_password">
					<div class="ii"><i class="iconfont icon-yanjing1"></i></div>	
					</div>
					<div class="form-group cc3">
						<div class="radio">
							<label> <input type="radio" name="user_sex" value="1"
								checked> 男
							</label>
							<label> <input type="radio" name="user_sex" value="0">女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pic"></label> <input type="file" name="pic"
							id="picUpload" placeholder="上传头像">
							<button type="submit" id="up" class="btn btn-success">点击上传</button>
							<input type="text" id="user_pic" value="" placeholder="选择上传头像" name="user_pic" />
					</div>
					<button type="submit" class="btn ls">免费注册</button>
					<div id="jj">已有帐号？<a href="login.jsp">直接登录</a></div>
				</form>
				<form id="upForm" action="upPic.do" method="post"
					enctype="multipart/form-data">
					
					
				</form>
			</div>
		</div>
	</div>
</body>
<script>
	//异步上传文件
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
	   //ajax异步上传
		$('#upForm').ajaxForm(function(e) {
			console.log(e);
			$("#user_pic").val(e);
		});
	});
</script>
</html>