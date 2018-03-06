<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登陆</title>
<link rel="stylesheet"
	href="/static_resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/static_resources/jquery-3.2.1.min.js"></script>
<script src="/static_resources/jquery.md5.js"></script>
<script src="/static_resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/static_resources/js/ajax.js"></script>
<script src="/static_resources/js/cookie.js"></script>

<link rel="stylesheet" href="/static_resources/customer/css/login.css">
</head>
<body>
	<div id="loginBox" class="loginBox">
		<form id="loginForm" class="form-horizontal" role="form" action="/login.do?p=login" method="post">
			<div class="form-group">
				<label for="firstname" class="col-xs-4 col-sm-2  control-label" >账号</label>
				<div class="col-xs-8 col-sm-8 ">
					<input type="text" class="form-control" id="loginAcc" name="userAccount"
						placeholder="请输入账号">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-xs-4 col-sm-2 control-label" >密码</label>
				<div class="col-xs-8 col-sm-8">
					<input type="text" class="form-control" id="loginPwd" name="userPassword"
						placeholder="请输入密码">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-xs-10 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> 请记住我
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10  col-xs-12">
					<button type="button" class="btn btn-default loginbtn" onclick="login()">登录</button>
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
				<span class="glyphicon glyphicon-exclamation-sign notice" id="account_notice" data-toggle="tooltip" data-placement="right" title="账号必填，而且要唯一"></span>
				<span class="glyphicon glyphicon-ok can_register" id="can_register"></span>
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
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="密码必填，最短6位数"></span>
				</div>
			</div>
						<div class="form-group">
				<label for="VerificationPwd" class="col-sm-2 control-label">验证密码：</label>
				<div class="col-sm-8">
					<input type="password" class="form-control" id="VerificationPwd"
						placeholder="请输入密码" onblur="VerificationPwdEqual()">
						
				</div>
				<div class="col-sm-2">
				<span class="glyphicon glyphicon-exclamation-sign notice" data-toggle="tooltip" data-placement="right" title="与密码一致的验证密码"></span>
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
		
<div class="alert alert-info caution_Box" id="caution_userAccount">
	<strong>信息：请输入您要注册的账户！</strong>
</div>
<div class="alert alert-info caution_Box" id="caution_inputPassword">
	<strong>信息：请输入注册密码,不能少于6位数！</strong>
</div>
<div class="alert alert-warning caution_Box" id="caution_VerificationPwd">
	<strong>警告：请输入和注册密码一致的验证密码！</strong>
</div>
<div class="alert alert-danger caution_Box" id="caution_HasAccount">
	<strong>错误：您要注册的账号已存在！</strong>
</div>
<div class="alert alert-success caution_Box" id="success_RegisterSuccess">
	<strong>成功：注册成功!</strong>
</div>
<div class="alert alert-info caution_Box" id="caution_loginAcc">
	<strong>信息：请输入登录账号！</strong>
</div>
<div class="alert alert-info caution_Box" id="caution_loginPwd">
	<strong>信息：请输入登录密码！</strong>
</div>
<div class="alert alert-danger caution_Box" id="danger_HasNoAccount">
	<strong>错误：您要登录的账号不存在！</strong>
</div>
<div class="alert alert-danger caution_Box" id="danger_invalidPwd">
	<strong>错误：输入的密码有误！</strong>
</div>

</body>
</html>
<script>
$(function () { $("[data-toggle='tooltip']").tooltip(); });

$('#regBox').hover(function(){
	$('#caution_userAccount').hide(500);
	$('#caution_inputPassword').hide(500);
	$('#caution_VerificationPwd').hide(500);
	$('#caution_HasAccount').hide(500);
	$('#success_RegisterSuccess').hide(500);
	 },function(){
		 // 鼠标移出区域
	 })
$('#loginBox').hover(function(){
	$('#caution_loginAcc').hide(500);
	$('#caution_loginPwd').hide(500);
	$('#danger_HasNoAccount').hide(500);
	$('#danger_invalidPwd').hide(500);

	 },function(){
		 // 鼠标移出区域
	 })
function login(){
	var account = $("#loginAcc").val(); 
	var pwd = $("#loginPwd").val(); 
	var md5Pwd = $.md5(pwd);
	
	if(account.length==0){
		$('#caution_loginAcc').show(500);
		return false;
	}
	if(pwd.length==0){
		$('#caution_loginPwd').show(500);
		return false;
	}
	
	ajaxPostForm("/login.do?p=checkUser",{userAccount:account,userPwd:md5Pwd},function(data){
		if (data.msg == "OK") {
	    	saveCookie(account,md5Pwd,false);
			$("#loginForm").submit();
			
		}else if(data.msg == "hasNoUser"){
			$('#danger_HasNoAccount').show(500);
		}else if(data.msg == "invalidPwd"){
			$('#danger_invalidPwd').show(500);
		}else{
			
		}
	}); 
	
}	 
	 
function isHasAccount(){
	//判断账号是否已存在
	var account = document.getElementById('userAccount').value
	ajaxPostForm("/login.do?p=isHasAccount",{userAccount:account},function(data){
		if (data.result) {
			$('#account_notice').hide(500);
			$('#can_register').show(500);
		}else{
			$('#account_notice').show(500);
			$('#can_register').hide(500);
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
	//判断验证密码填写是否正确
	if(document.getElementById("inputPassword").value != document.getElementById("VerificationPwd").value){
		//两次密码输入不一致
		$('#caution_VerificationPwd').show(500);
		return false;
	}
	//判断账号是否已存在
	var account = document.getElementById('userAccount').value
	ajaxPostForm("/login.do?p=isHasAccount",{userAccount:account},function(data){
		if (data.result) {
			$('#success_RegisterSuccess').show(500);
			$("#regForm").submit();
		}else{
			$('#caution_HasAccount').show(500);
			return false;
		}
	}); 
	}

function backLogin(){
	window.location.reload();
}
function showRegBox(){
	  $("#regBox").show(500);
	  $("#loginBox").hide(1000);
}

function saveCookie(sysAccount,pwd,isSaveCookie){
	 addCookie("sysAccount",sysAccount,1,"/");
	 if(isSaveCookie){
		 addCookie("pwd",pwd,14,"/");
		 addCookie("isSaveCookie",true,14,"/");
	 }else {
		 deleteCookie("pwd","/");
		 deleteCookie("isSaveCookie","/");
	 }
}

</script>



