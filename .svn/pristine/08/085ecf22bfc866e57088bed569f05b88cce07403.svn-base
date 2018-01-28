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
<link rel="stylesheet" href="css/bootstrap.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="js/html5shiv.min.js"></script>
      <script src="js/respond.min.js"></script>
    <![endif]-->

<title>教师信息</title>
</head>
<body>
<%-- <jsp:include page="head/head.jsp"></jsp:include> --%>
<div class="container"> 
  <div class="jumbotron">
  <label> <img class="dtx" src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}" width="350px" height="250px">
    <h1>${teacherName}-${jobTitle}</h1>
    </label>
    <p>${content}</p>
  </div>
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
    background: #EDEFF0;
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
  .carousel {
    height: 400px;
    margin-bottom: 50px;
  }
  .carousel .item {
    height: 400px;
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
  .dtx{
    border-radius: 105px;
    border:solid 10px #aaa;
    float: left;
  }
  label h3{
    float: left;
    margin-left: 30px;
    margin-top: 40px;
  }
</style>

<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
