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
						placeholder="请输入账号">
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="这里必填啊"></span>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword" class="col-sm-2 control-label">注册密码：</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="inputPassword" placeholder="请输入密码">
					<input type="hidden" class="form-control" id="userPassword" name="userPassword">
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="这里必填啊"></span>
				</div>
			</div>
						<div class="form-group">
				<label for="VerificationPwd" class="col-sm-2 control-label">验证密码：</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="VerificationPwd"
						placeholder="请输入密码" onblur="Verification()">
						
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="这里必填啊"></span>
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
		
<div class="alert alert-warning caution">
	<strong>提示：</strong>就这么几个必填项你都能落下，丢人！
</div>
</body>
</html>
<script>
function Verification(){
	if(document.getElementById("inputPassword").value == document.getElementById("VerificationPwd").value){
		//两次密码输入一致
		var pwd = $("#inputPassword").val(); 
		var hashPwd = $.md5(pwd);
		$("#userPassword").val(hashPwd);
	}else{
		alert("您两次输入的密码不一致，请核对。");
	}
}

function register(){
	var userAccount = $.trim($("#userAccount").val()).length
	var inputPassword = $.trim($("#inputPassword").val()).length
	var VerificationPwd = $.trim($("#VerificationPwd").val()).length
	
	if(userAccount > 0){
		if(inputPassword > 0){
			if(VerificationPwd > 0){
				
			}else{
				alert("您需要重复输入密码来证明你不是乱输的");
			}
		}else{
			alert("您没有给您的账户设定密码");
		}
	}else{
		alert("您注册账号连账号都不填的吗");
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

$(function () { $("[data-toggle='tooltip']").tooltip(); });

</script>
<style>
.caution {
  	position: absolute;
	margin:0 auto;
	width: auto;
	height: auto;
	right: 20px;
  	top: 20px;
  	color:red;
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

.loginBox:hover {
	margin-top:5%;
	margin-left:10%;
	height: 40%;
	width: 30%;
	background:rgba(115, 106, 106, 0.5);
	color:#FFF;
	border-radius:20px;
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

body {
	background: url(/static_resources/images/Login_backGround.png) fixed center center no-repeat;
	background-size: cover;
}
</style>


