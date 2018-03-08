<%@ page language="java" contentType="text/html; charset=GBK" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>TopSpace</title>
<link rel="stylesheet"
	href="/static_resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
<script src="/static_resources/jquery-3.2.1.min.js"></script>
<script src="/static_resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
	<%@ include file="/pages/index/headIndex.jsp"%>
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- 轮播（Carousel）指标 -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<!-- 轮播（Carousel）项目 -->
		<div class="carousel-inner">
			<div class="item active">
				<img src="/static_resources/images/azj4-version1.jpg" alt="First slide">
			</div>
			<div class="item">
				<img src="/static_resources/images/timg.jpg"
					alt="Second slide">
				<div class="indexText">
					<h1>Liang JJ</h1>
				</div>
			</div>
			<div class="item">
				<img src="/static_resources/images/mainPage_4.png" alt="Third slide">
				<div class="indexText">
					<h1 class="text">一个小转角</h1>
				</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	
	<div class="Pandora_Box">
	<div class="lineBox"></div>
		<div class="Pandora_content">
            <img src="/static_resources/images/Pandora.jpg" class="Pandora_Img">
         <div class="Pandora_Text">
         	<span>TopSpace-Title1</span>
         </div>
         <div class="Pandora_Text_icon">
         	<span class="texta">TopSpace &nbsp;|</span>
         	<span class="glyphicon glyphicon-heart">5</span>
         	<span class="glyphicon glyphicon-eye-open">1000</span>
         </div>
    </div>
    <div class="Pandora_content">
            <img src="/static_resources/images/Pandora.jpg" class="Pandora_Img">
         <div class="Pandora_Text">
         	<span>TopSpace-Title2</span>
         </div>
         <div class="Pandora_Text_icon">
         	<span class="texta">TopSpace &nbsp;|</span>
         	<span class="glyphicon glyphicon-heart">5</span>
         	<span class="glyphicon glyphicon-eye-open">1000</span>
         </div>
    </div>
    <div class="Pandora_content">
            <img src="/static_resources/images/Pandora.jpg" class="Pandora_Img">
         <div class="Pandora_Text">
         	<span>TopSpace-Title3</span>
         </div>
         <div class="Pandora_Text_icon">
         	<span class="texta">TopSpace &nbsp;|</span>
         	<span class="glyphicon glyphicon-heart">5</span>
         	<span class="glyphicon glyphicon-eye-open">1000</span>
         </div>
    </div>
    <div class="Pandora_content">
            <img src="/static_resources/images/Pandora.jpg" class="Pandora_Img">
         <div class="Pandora_Text">
         	<span>TopSpace-Title4</span>
         </div>
         <div class="Pandora_Text_icon">
         	<span class="texta">TopSpace &nbsp;|</span>
         	<span class="glyphicon glyphicon-heart">5</span>
         	<span class="glyphicon glyphicon-eye-open">1000</span>
         </div>
    </div>
	</div>
	
</div>
	
<style>
.glyphicon-eye-open{
	top: 4px;
}
.glyphicon-heart{
	top: 4px;
}
.lineBox{
	margin: 40px 0 34px 0;
	height: 1px;
	background-color: #d4d5d5;
}

.texta{
    display: inline-block;
	width: 88px;
}

.glyphicon-heart{
	width: 33px;
}

.Pandora_Text_icon{
	width: 200px;
	margin-left: 327px;
	color: #999;
    padding: 0 10px 0 0;
    position: absolute;
    font-weight: bold;
    bottom: 50px;
}

.Pandora_Text{
    font-size: 14px;
    margin-left: 20px;
    float: left;
    padding-top: 18px;
    color: #555;
    display: inline-block;
    font-weight: bold;
}

.Pandora_Img{
	float:left;
	width: 314px;
    height: 160px;
}

.Pandora_content{
	position: relative;
	float:left;
	width: 50%;
	height: 200px;
}

.Pandora_Box{
    position: absolute;
	width: 90%;
	height: auto;
	min-height:400px;
	left: 5%;
}

.indexText {
	position: absolute;
	z-index: 2;
	left: 38%;
	top: 70%;
}

.carousel {
	height: 350px;
	margin-bottom: 70px;
}

.carousel .item {
	text-align: center;
	height: 350px;
}

.carousel-inner .item img {
	width: 100%;
	height: 350px;
}
</style>
</body>
</html>
<script>
function myFunction(){
	alert("sometextsometextsometext");
	}
</script>

