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
<script src="/static_resources/jquery.md5.js"></script>
<script src="/static_resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/static_resources/js/ajax.js"></script>
<script src="/static_resources/js/cookie.js"></script>
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
<div class=" col-md-4 col-xs-6"style="margin-top:30px">
<a href="/login/index.jsp">登录/注册</a>		
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
.logWeightBox {
	
	position: absolute;
  	left: 15%;
  	top: 30%;
	height: auto;
	weight: 30%;

	background:rgba(115, 106, 106, 0.5);
	color:#FFF;
	border-radius:20px;
}

</style>
<div>
<div style="margin-top:10px;margin-left:100px;">
<h1>
<i class="uicon-location_history"></i> 体重信息
<small class="smalltitle">撑一撑 ！！称一称！!</small>
</h1>
</div>
<div class="logWeightBox">
<form class="form-horizontal" role="form" action="/weight.do?p=save" method="post">
    <div class="form-group"style="margin-top:30px">
        <label for="firstname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="firstname" name="memberName"
                   placeholder="请输入姓名">
        </div>
    </div>
    <div class="form-group" >
        <label for="lastname" class="col-sm-2 control-label">体重</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="weight" 
                   placeholder="请输入实时体重">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">称量时间</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="weightTime" 
                   placeholder="请输入称量时间">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>
</form>
</div>
</div>

<div class="alert alert-info caution_Box" id="caution_userAccount">
	<strong>信息：请输入您要注册的账户！</strong>
</div>
<script>
$(function () { $("[data-toggle='tooltip']").tooltip(); });

</script>
