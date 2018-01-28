<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="X-UA-Compatible" content="IE=9">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->

<title>精品课程</title>
</head>
<body>
<jsp:include page="head/head.jsp"></jsp:include>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
  
 <div class="carousel-inner" role="listbox" style="width:1200px;margin:auto">
   <s:iterator value="imgCarousels">

    <div class="item">
      <img src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}" alt="${id}">
      <div class="carousel-caption">
        <div>
        <h4></h4>
              <p>
                ${imgExplain}
              </p>
        </div>
      </div>
    </div>
    </s:iterator>

  <!-- Controls -->
  <s:a cssClass="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
    <div class="glyphicon glyphicon-chevron-left"></div>
    <div class="sr-only">上一页</div>
  </s:a>
  <s:a cssClass="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">下一页</span>
  </s:a>
  </div>
</div>
<!--教师团队-->
<div class="container">
<hr>
  <div class="row" id="tx-row">
  <s:iterator value="teachers">
  <div class="col-md-4">
    <img class="tx" src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}">
    <h1>${teacherName}</h1>
    <p>${content}</p>
    <a href="excellentTeacher_teacherDetails.action?id=${id}" class="btn btn-info"  target="_blank" role="button">了解详情</a>
  </div>
 </s:iterator>
</div>
<hr>
</div>
<footer class="navbar-fixed-bottom" style="background-color:white;text-align: center;">
  <p class="footer-zzuli">Copyright © 2013 <a href="http://soft.zzuli.edu.cn/" target="_blank" title="-">  郑州轻工业学院软件学院  </a></p> 
</footer>
<style type="text/css">
html, body {
    font: 14px/1.5 "Microsoft Yahei","Hiragino Sans GB",Helvetica,"Helvetica Neue","微软雅黑",Tahoma,Arial,sans-serif;
    color: #14191E;
}
  body{
    padding-top: 130px;
  }
  .brand-img{
    height: 100px;
    width: 295px;
    margin-top: -15px;
  }
  .nnnnnn{
    border-radius: 0px;
    height:100px;
  }
  .carousel-inner{
    height: 500px;
  }
  .carousel {
    height: 500px;
    margin-bottom: 50px;
  }
  .carousel .item {
    height: 500px;
  }
  .carousel-control{
    height: 100%;
  }
  .glyphicon{
    height: 100%;
  }
  .carousel .item img {
    width: 100%;
  }      
  #carousel-example-generic{
    margin-top: -20px;
  }
  .tx{
    width:100px;
    height: 100px;
    border: solid 6px rgba(99,99,99,0.2);
    border-radius: 50px;
    transition: border 1s;
  }
  .tx:hover{
    border: solid 10px rgba(20,20,20,0.6);
  }
  #tx-row{
    text-align: center;
  }
  .navbar-oracle{
    background-color: #f8f8f8;
  }
</style>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript">
  $(document).ready(function(){
		$('.item:first').addClass('active');
	});
  </script>
</body>
</html>
