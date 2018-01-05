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
	<%@ include file="/index/headIndex.jsp"%>

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
				<img src="/static_resources/images/mainPage_4.png" alt="First slide">
			</div>
			<div class="item">
				<img src="/static_resources/images/whiteBack1.png"
					alt="Second slide">
				<div class="indexText">
					<h1>titleTwo</h1>
					<p>contentTwo</p>
				</div>
			</div>
			<div class="item">
				<img src="/static_resources/images/whiteBack1.png" alt="Third slide">
				<div class="indexText">
					<h1 class="text">titleThree</h1>
					<p class="text">contrntThree</p>
				</div>
			</div>
		</div>
		<!-- 轮播（Carousel）导航 -->
		<a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
		<a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
	</div>
	<style>
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

