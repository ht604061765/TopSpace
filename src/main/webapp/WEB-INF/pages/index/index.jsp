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
		<h3>这是潘多拉盒子里的内容</h3>
		<div class="col-sm-6 col-md-3">
         <div class="thumbnail">
            <img src="/static_resources/images/Pandora.jpg" 
             alt="通用的占位符缩略图">
            <div class="caption">
                <h3>缩略图标签</h3>
                <p>一些示例文本。一些示例文本。</p>
            </div>
         </div>
    </div>
		
	</div>
	
</div>
	
<style>
.Pandora_Box{
    position: absolute;
	width: 80%;
	height: auto;
	left: 10%;
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

