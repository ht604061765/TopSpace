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
.bjt {
	background: url(/static_resources/images/bjt.jpg)repeat;
	weight: 100%;
	height: 500px;
}
</style>
<div class="bjt">
<div style="margin-top:10px;margin-left:100px;">
<h1>
<i class="uicon-location_history"></i> 委托人信息
<small class="smalltitle">为保证您的委托顺利交接, 请务必填写真实信息!</small>
</h1>
</div>

<form class="form-horizontal" role="form">
    <div class="form-group"style="margin-top:30px">
        <label for="firstname" class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="firstname" 
                   placeholder="请输入姓名">
        </div>
    </div>
    <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">学号</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="lastname" 
                   placeholder="请输入学号">
        </div>
    </div>
    
    <div class="form-group">
		<label for="name" class="col-sm-2 control-label">性别</label>
    <label class="radio-inline">
		<input type="radio" name="optionsRadiosinline" id="optionsRadios3" value="option1" checked> 男
	</label>
	<label class="radio-inline">
		<input type="radio" name="optionsRadiosinline" id="optionsRadios4"  value="option2"> 女
	</label>
</div>
    
 <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">电话</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="lastname" 
                   placeholder="请输入电话">
        </div>
    </div>
 <div class="form-group">
        <label for="lastname" class="col-sm-2 control-label">邮箱</label>
        <div class="col-sm-10"style="width:300px">
            <input type="text" class="form-control" id="lastname" 
                   placeholder="请输入邮箱">
        </div>
    </div>
<div class="form-group">
		<label for="name" class="col-sm-2 control-label">委托事项</label>
	    <div class="col-sm-10"style="width:300px">	
		   <select class="form-control">
			   <option>代课</option>
			   <option>交友</option>
			   <option>取快递</option>
			   <option>顺风车</option>
			   <option>占位</option>
			   <option>其他</option>
		</select>
	</div>	
</div>

<div class="form-group">
    <label for="name" class="col-sm-2 control-label">任务详情</label>
    <div class="col-sm-10"style="width:300px">	
    <textarea class="form-control" rows="3"></textarea>
  </div>
  </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">提交</button>
        </div>
    </div>
</form>
</div>
                    <a href="#">关于我们</a>
					<a href="#">联系我们</a>
					<a href="#">招贤纳士</a>
					<a href="#">法律声明</a>
					<a href="#">友情链接</a>
					<a href="#">支付方式</a>
					<a href="#">配送方式</a>
					<a href="#">服务声明</a>
					<a href="#">广告声明</a>
					<p>
						Copyright © 2017-2018  GO GO GO
					</p>
</div>
</body>
</html>
