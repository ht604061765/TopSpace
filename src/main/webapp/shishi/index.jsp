<%@ page language="java" contentType="text/html; charset=GBK"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>任务委托</title>
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
<h1>
<i class="uicon-location_history"></i> 委托人信息
<small class="smalltitle">为保证您的委托顺利交接, 请务必填写真实信息!</small>
</h1>
<ul id="userPanel" class="panel-collapse collapse in contactUsForm" role="tabpanel" aria-labelledby="headingOne">
<li>									
<div class="col-md-3">				
<label for="contactOrderName"> 姓名 <small class="english">Name</small></label>						</div>								
<div class="col-md-6">								
<input id="contactOrderName" name="contactOrderName"  class="form-control required" type="text" value="" >
</div>
</li>
<li>								
<div class="col-md-3">								
<label for="orderMail"> 邮箱 <small class="english">Email</small></label>	</div>								
<div class="col-md-6 yx">							
<input id="orderMail" name="orderMail" class="form-control" type="text" value=""  >									</div>								
</li>
<li>
<div class="col-md-3">								
<label for="contactOrderQQ">班级<small class="english">classes</small></label>
</div>									
<div class="col-md-6">
<input id="contactOrderQQ" name="contactOrderQQ" class="form-control" type="text"  value="">								</div>
</li>
<li>
<div class="col-md-3">
<label for="contactOrderWechat">微信 <small class="english">Wechat</small></label>
</div>
<div class="col-md-6">
<input id="contactOrderWechat" name="contactOrderWechat" class="form-control" minlength="2" type="text"   value="">
</div>
</li>
<li>
<div class="col-md-3">
<label for="orderCountry"> * 留学国家/地区<small class="english">Country</small></label>
</div>
<div class="col-md-6">
<select id="orderCountry" name="orderCountry" class="form-control required" data-selected="true" data-value="">
<option value="_none" selected="selected">选择委托任务</option>
		<option value="US">代课</option>
		<option value="AU">交友</option>
		<option value="CN">拿快递</option>
		<option value="CA">顺风车(Canada)</option>
		<option value="FR">占位(France)</option>

		<option value="FI">芬兰(Finland)</option>
		<option value="HK">香港(Hong Kong)</option>
		<option value="IE">爱尔兰(Ireland)</option>
		<option value="MA">澳门(Macao)</option>
		<option value="MY">马来西亚(Malaysia)</option>
		<option value="NZ">新西兰(New Zealand)</option>
		<option value="NO">挪威(Norway)</option>
		<option value="SG">新加坡(Singapore)</option>
		<option value="SE">瑞典(Sweden)</option>
		<option value="CH">瑞士(Swiss)</option>						<option value="-1">其他</option>
</select>
<input class="form-control hidden" placeholder="任务详情" name="orderCountryText" id="orderCountryText" type="text">
</div>
</li>
<li>
<div class="col-md-3">
<label for="contactOrderTel"> * 手机号码 <small class="english">Mobile</small></label>
</div>
<div class="col-md-6">
<input id="contactOrderTel" name="contactOrderTel"  size="24" maxlength="36" class="form-control required" type="text"  value="" >
</div>
</li>
</ul>
</fieldset>
<fieldset id="two" class="col-md-12">
<button type="submit" class="btn" id="orderAddOrderbtn">确认,发布</button>
</form>
</body>
</html>
