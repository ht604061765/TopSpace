<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登陆</title>
<link rel="stylesheet"
	href="/static_resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/static_resources/jquery-3.2.1.min.js"></script>
<script src="/static_resources/jquery.md5.js"></script>
<script src="/static_resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<div id="loginBox" class="loginBox">
		<form id="loginForm" class="form-horizontal" role="form" action="/index">
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">账号</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="firstname"
						placeholder="请输入账号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">密码</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="lastname"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> 请记住我
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default loginbtn">登录</button>
					<button type="button" class="btn btn-default regbtn" onclick="showRegBox()">注册一个</button>
				</div>
			</div>
		</form>
	</div>
	
		<div id="regBox" class="regBox">
		<form id="regForm" class="form-horizontal" role="form" action="/login.do?p=register" method="post">
			<div class="form-group">
				<label for="userAccount" class="col-sm-2 control-label">注册账号：</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="userAccount" name="userAccount"
						placeholder="请输入账号" onblur="isHasAccount()">
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="账号必填"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">注册密码：</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="inputPassword" 
					placeholder="请输入密码" onblur="VerificationPwdLong()">
					<input type="hidden" class="form-control" id="userPassword" name="userPassword">
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="密码，必填，最短6位"></span>
				</div>
			</div>
						<div class="form-group">
				<label for="VerificationPwd" class="col-sm-2 control-label">验证密码：</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="VerificationPwd"
						placeholder="请输入密码" onblur="VerificationPwdEqual()">
						
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="验证密码,必填"></span>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn btn-default regbtn" onclick="register()">注册 &#9658;</button>
					<button type="button" class="btn btn-default regbtn" onclick="backLogin()">&#9668; 登陆界面</button>
					
				</div>
			</div>
		</form>
		</div>
		
<div class="alert alert-warning caution_Box" id="caution_userAccount">
	<strong>提示：请输入您要注册的账户！</strong>
</div>
<div class="alert alert-warning caution_Box" id="caution_inputPassword">
	<strong>提示：请输入注册密码,不能少于6位数！</strong>
</div>
<div class="alert alert-warning caution_Box" id="caution_VerificationPwd">
	<strong>提示：请输入和注册密码一致的验证密码！</strong>
</div>
</body>
</html>
<script>
$(function () { $("[data-toggle='tooltip']").tooltip(); });

$('#regBox').hover(function(){
	$('#caution_userAccount').hide(1000);
	$('#caution_inputPassword').hide(1000);
	$('#caution_VerificationPwd').hide(1000);
	 },function(){
		 // 鼠标移出区域
	 })

function isHasAccount(){
	var account = document.getElementById('userAccount').value
	ajaxPostForm("/login.do?p=isHasAccount",{userAccount:account},function(data){
		if (data.success) {
			alert("success");
		}
	}); 
}
	 
function VerificationPwdLong(){
	var str = document.getElementById('inputPassword').value
	if(str.length < 6){
		$('#caution_inputPassword').show(500);
		return false;
	}
}

function VerificationPwdEqual(){
	if(document.getElementById("inputPassword").value == document.getElementById("VerificationPwd").value){
		//两次密码输入一致
		var pwd = $("#inputPassword").val(); 
		var hashPwd = $.md5(pwd);
		$("#userPassword").val(hashPwd);
	}else{
		$('#caution_VerificationPwd').show(500);
		return false;
		}
}

function register(){
	var userAccount = $.trim($("#userAccount").val()).length
	var inputPassword = $.trim($("#inputPassword").val()).length
	var VerificationPwd = $.trim($("#VerificationPwd").val()).length
	if(userAccount==0){
		$('#caution_userAccount').show(500);
		return false;
	}
	if(inputPassword<6){
		$('#caution_inputPassword').show(500);
		return false;
	}
	if(VerificationPwd==0){
		$('#caution_VerificationPwd').show(500);
		return false;
	}
	//$("#regForm").submit();
	}

function backLogin(){
	window.location.reload();
}
function showRegBox(){
	  $("#regBox").show(500);
	  $("#loginBox").hide(1000);
}

</script>
<style>
.caution_Box{
text-align:center;
  	position: absolute;
	margin:0 auto;
	width: 300px;
	height: auto;
	right: 20px;
  	top: 20px;
	display:none;
}

.notice{
	float:left;
	margin-top:7%;
	color:red;
}

.regbtn{
	float:right;
	margin-right:10%;
}
.loginbtn{
	float:right;
	margin-right:10%;
}

.form-control{
	width: 100%;
}
.form-horizontal{
	padding-top:5%;
}

.regBox {
  	position: absolute;
  	left: 20%;
  	top: 20px;
	display:none;
	margin:0 auto;
	height: auto;
	width: 60%;
	background:rgba(251, 248, 248, 0.45);
	color:#3a2e2e;
	border-radius:5px;
}

.regBox:hover {
  	position: absolute;
  	left: 20%;
  	top: 20px;
	display:none;
	margin:0 auto;
	height: auto;
	width: 60%;
	background:rgba(251, 248, 248, 0.65);
	color:#3a2e2e;
	border-radius:5px;
}
.loginBox {
	margin-top:5%;
	margin-left:10%;
	height: 40%;
	width: 30%;
	background:rgba(115, 106, 106, 0.38);
	color:#FFF;
	border-radius:20px;
}
.loginBox:hover {
	margin-top:5%;
	margin-left:10%;
	height: 40%;
	width: 30%;
	background:rgba(115, 106, 106, 0.5);
	color:#FFF;
	border-radius:20px;
}

body {
	background: url(/static_resources/images/Login_backGround.png) fixed center center no-repeat;
	background-size: cover;
}
</style>


