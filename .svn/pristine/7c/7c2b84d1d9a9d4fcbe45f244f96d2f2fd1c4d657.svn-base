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

<title>参考资料</title>
</head>
<body>
<jsp:include page="head/head.jsp"></jsp:include>
<div class="container">
  <div class="panel panel-success">
  <div class="panel-heading">
   
  </div>
  
  <div class="panel-body">
    <div role="tabpanel">
      <hr>
      <div class="tab-content">
        
        
        <div role="tabpanel" class="tab-pane active"  id="jxkj">
          <table class="table table-bordered table-hover">
            <tr>
              <th style="font-weight:bold;text-align:center;">序号</th>
              <th style="font-weight:bold;text-align:center;">参考资料</th>
              <th style="font-weight:bold;text-align:center;">附件</th>
               <th style="font-weight:bold;text-align:center;">操作</th>
            </tr>
            <s:iterator value="datas" status="l">
            <tr>
              <td>${l.index+1}</td>
                  <td>${referenceName}</td>
                  <td>
                    <img src="img/icon_pdf.png">
                  </td>
                  <td>
                    <a href="download.action?filename=<%=Config.EXCELLENTCOURSE_downFilePath%>/${oldFilePath}" target="_blank"><span class="glyphicon glyphicon glyphicon-save" aria-hidden="true"></span></a>
                    <a href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${pdfPath}" target="_blank"><span class="glyphicon glyphicon glyphicon-play" aria-hidden="true"></span></a>
                  </td>
                </tr>
                <tr>
              </s:iterator>    
          </table>
        </div>
    </div>
  </div>
  </div>
</div>
<footer class="navbar-fixed-bottom" style="background-color:white;text-align:center;">
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
<script type="text/javascript">
  $(document).ready(function(){
    $("#zy .dropdown-menu a").click(function(){
      var href = $(this).attr("href");
      $("#myTab a[href='"+href+"']").tab("show");
    });
  });
</script>
</body>
</html>
