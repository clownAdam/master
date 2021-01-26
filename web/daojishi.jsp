<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>e-乐购</title>

</head>
<body>
<script type="text/javascript">
var maxtime = 10 * 60; // 
     function CountDown() {
       if (maxtime >= 0) {
         minutes = Math.floor(maxtime / 60);
         seconds = Math.floor(maxtime % 60);
         msg = "距离结束还有" + minutes + "分" + seconds + "秒";
         document.all["timer"].innerHTML = msg;
         if (maxtime == 5 * 60)alert("距离结束仅剩5分钟");
           --maxtime;
       } else{
         clearInterval(timer);
         alert("时间到，结束!");
       }
     }
     timer = setInterval("CountDown()", 1000);   
</script>
<div id="timer"></div>
 <div id="warring"><img alt="" src=""></div>
</body>
</html>