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

<title>教学过程</title>

</head>
<body>
<jsp:include page="head/head.jsp"></jsp:include>
<div class="container">
	<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          教学目的
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <div class="panel panel-info">
  <!-- Default panel contents -->
  <div class="panel-heading">   教学目的</div>
  <div class="panel-body">
 <p>${teachingAim}</p>
  </div>

  <!-- <div class="panel-footer">
    <table class="table table-hover">
    <tr>
      <td style="width:20%;"><font style="font-weight:bold;">课程编号：</font></td>
      <td style="width:30%;">X3050211</td>
      <td style="width:20%;"><font style="font-weight:bold;">课程学分：</font></td>
      <td style="width:30%;">4</td>
    </tr>
    <tr>
      <td><font style="font-weight:bold;">开课学院：</font></td>
      <td>软件学院</td>
      <td><font style="font-weight:bold;">课程学时：</font></td>
      <td>64（讲授44，实验20）</td>
    </tr>
    <tr>
      <td><font style="font-weight:bold;">课程类别：</font></td>
      <td>专业基础课</td>
      <td><font style="font-weight:bold;">开课对象：</font></td>
      <td>大一软件学院学生</td>
    </tr>
  </table>
  </div> -->
  
</div>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          教学要求
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      <div class="panel-body">
        <div class="panel panel-warning">
 			<div class="panel-heading">
    		 教学要求
  			</div>
  			<div class="panel-body">
  			<p>${teachingRequire}</p>
  			</div>
  			<!-- <div class="panel-heading">
  				课程目的
  			</div>
  			<div class="panel-body">
  				<p>不管从事IT的什么职业，数据存储都是基础的内容，尤其是在大型企业的数据库系统，服务器使用的操作系统基本上都是Unix或者Linux，相应的数据库基本都是Oracle数据库。 开设本课程主要是在高校普及企业使用比较广泛的Oracle Database，为今后学习更多的企业IT技术奠定基础。 </p>
  			</div> -->
	  </div>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          讲授和实习
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      	<div class="panel panel-warning">
 			<div class="panel-heading">
    		  讲授和实习
  			</div>
  			<div class="panel-body">
  			<p>${practice}</p>
  			</div>
  			<!-- <div class="panel-heading">
  				后置课程
  			</div>
  			<div class="panel-body">
  				<p>《企业应用系统高级编程》、《软件工程理论与实践》</p>
  			</div> -->
	  	</div>
      </div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          课程学时分配
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      <div class="panel-body">
       ${scheduling}
      </div>
    </div>
  </div> 
 <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" data-toggle="collapse" data-parent="#accordion" href="#collapsefour" aria-expanded="false" aria-controls="collapseThree">
          作业
        </a>
      </h4>
    </div>
    <div id="collapsefour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      	<div class="panel panel-warning">
 			<div class="panel-heading">
    		  作业
  			</div>
  			<div class="panel-body">
  			<p>${work}</p>
  			</div>
  			<!-- <div class="panel-heading">
  				后置课程
  			</div>
  			<div class="panel-body">
  				<p>《企业应用系统高级编程》、《软件工程理论与实践》</p>
  			</div> -->
	  	</div>
      </div>
    </div>
  </div>
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
  label h1{
    float: left;
    margin-left: 100px;
    margin-top: 100px;
  }
  .panel-success{
    margin-top: 30px;
  }  
  .resource-img-panel{
    width: 300px;
    height: 200px;
    margin:auto;
    margin-top: 10px;
    overflow: hidden
  }
  .resource-img{
    width: 300px;
    height: 200px;
    transition:all 0.54s;
  }
  .resource-img:hover{
    width: 340px;
    height: 240px;
  }
  .thumbnail{
    margin-top: 20px; 
  }
  .page-cut{
    margin-left:40%;
  }
  td{
    text-align: center;
  }
</style>
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>
