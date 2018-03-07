<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>  
<div class="head">
<div class="head_line">
</div>
<div class="container-fluid">
<div class="row">
<div class="head_top_div col-md-8 col-xs-12">
	<img class="head_pciture"
		src="/static_resources/images/logo1220(1590X700).jpg">
	</div>
	<div class="head_top_div col-md-4 col-xs-6">
		<button type="button" class="btn btn-default btn-lg find">
  			<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> <b>找人代课</b>
		</button>
		<button type="button" class="btn btn-default btn-lg i_can">
  			<span class="glyphicon glyphicon-user" aria-hidden="true"></span> <b>我能代课</b>
		</button>
	</div>
	<!--  <div class="col-md-8 col-xs-6">
	<a href="/login.do?p=testUserList">测试专用</a>
	</div> -->
</div>
</div></div>
<style>
.glyphicon-tasks{
	top: 4px;
}
.glyphicon-user{
	top: 4px;
}
.find:hover{
    margin-top: 26px;
    background-color: #85a8e4;
    opacity:0.5;
}
.i_can:hover{
    margin-top: 26px;
    background-color: #85a8e4;
    opacity:0.5;
}
.find{
    margin-top: 26px;
    background-color: #85a8e4;
}
.i_can{
    margin-top: 26px;
    background-color: #85a8e4;
}

.head_button {
	margin-top:30px;
	margin-left:30px;
	float: left;
}
.head_top_div {
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
	background: #080808;
	height: 3px;
}
</style>