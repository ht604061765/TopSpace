<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title>资料填写</title>
<meta http-equiv="content-Type" content="text/html; charset="UTF-8">

<link rel="stylesheet"
	href="/static_resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/static_resources/jquery-3.2.1.min.js"></script>
<script src="/static_resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
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
<div class="head_picture_div col-md-4 ">
<img class="head_pciture"
		src="/static_resources/images/h2.jpg">	
</div>
<div class=" col-md-4 col-xs-6"">
<a href="#">登录</a>
<a href="#">注册</a>		
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

<h1>资料<h1>
   <HR>
<form class="form-horizontal" role="form" action="/shishi.do?p=shishiz" method="post">
  <div class="form-group">
    <label for="firstname" class="col-sm-2 control-label">名字</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="firstname" name="userAccount" placeholder="请输入名字">
    </div>
  </div>
  <div class="form-group">
    <label for="usersex" class="col-sm-2 control-label">性别</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="lastname" name="userPassword" placeholder="请输入性别">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">保存</button>
    </div>
  </div>
</form>
   <HR>
   <div class="col-md-8 col-xs-6">
	<a href="/shishi.do?p=shishic">资料查询</a>
	</div>
</body>
</html>
