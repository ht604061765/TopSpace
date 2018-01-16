<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-Type" content="text/html; charset="UTF-8">
<title>资料填写</title>
</head>
<body>
<div class="head">
<div class="head_line">
</div>
<div class="container-fluid">
<div class="row">
<div class="head_picture_div col-md-4 col-xs-6">
	<img class="head_pciture"
		src="/static_resources/images/logo1220(1590X700).jpg">
	</div>
</div>
</div></div>
<style>
.head_button {
	margin-top:30px;
	margin-left:30px;
	float: left;
}
.head_picture_div {
	height: 100px;
}
.head_pciture {
	float: left;
	margin-top:15px;
	margin-left:30px;
	width: 200px;
	height: 70px;
}

.head_line {
	background: black;
	weight: 100%;
	height: 6px;
}
</style>


<div style = "float:left; border-width:2px; border-style:solid;">
<form name = "form1" action="_" method="get">
<ul class = "wudian">
<li class = "tou">个人资料</li>
</ul>
<ul class = "wudian">
<li >姓名<input type = "text" name = "pname"></li>
</ul>
<ul class = "wudian">
<input type="radio" name="sex" value="male"/>男
<input type="radio" name="sex" value="female"/>女
</ul>
<ul class = "wudian">
<li >爱好<input type = "text" name = "hobit"></li>
</ul>
<ul class = "wudian">
<li ><input type = "submit" value = "提交"></li>
</ul>
</form>
</div>  
<div style = "float:left">  
<img src="/static_resources/images/xixi.gif" alt="嘻嘻">
</div> 
</body>
</html>
<style>
.wudian
{list-style-type:none;
}
.tou
{
font-size:50px;
color:#46A3FF;
}
</style>