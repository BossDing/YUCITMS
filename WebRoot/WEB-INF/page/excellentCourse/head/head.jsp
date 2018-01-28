<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<style>
.brand-img{
    height: 100px;
    width: 295px;
    margin-top: -15px;
  }
  .nnnnnn{
    border-radius: 0px;
    height:100px;
  }
</style>

<nav class="navbar navbar-default navbar-fixed-top nnnnnn"  role="navigation">

  <div class="container navbar-oracle">
   <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#zy">
        <span class="sr-only"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      
      <a class="navbar-brand" href="${pageContext.request.contextPath}/course_index.action">
        <img class="brand-img"alt="Brand" src="${pageContext.request.contextPath}/img/brand.png">
      </a>
    </div>
   <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="zy" style="background:#f8f8f8;margin-top:20px;font-size:16px">
      <ul class="nav navbar-nav">
          <li><a href="${pageContext.request.contextPath}/course_index.action?id=${id}"><span class="glyphicon glyphicon-home"></span> 主页</a></li>
          <li><a href="course_courseIntroduce.action?id=${id}"><span class="glyphicon glyphicon-tasks"></span> 课程介绍</a></li>
          <li><a href="course_teachingProcess.action?id=${id}"><span class="glyphicon glyphicon-tasks"></span> 教学过程</a></li>
          <li><a href="difficulty_guidance.action?courseId=${id}"><span class="glyphicon glyphicon-tasks"></span> 难点解析</a></li>
          <li><a href="video_excellentMP4.action?courseId=${id}"><span class="glyphicon glyphicon-tasks"></span> 精品视频</a></li>
          <li><a href="data_referenceData.action?courseId=${id}"><span class="glyphicon glyphicon-tasks"></span> 参考资料</a></li>
          <li><a href="bbs_index.action" target="_blank"><span class="glyphicon glyphicon-tasks"></span>社区</a></li>
          <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">切换 <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
          <s:iterator value="#session.courses">
           <li><a href="course_courseIntroduce.action?id=${id}">${name}</a></li>
            <li class="divider"></li>
          </s:iterator>
          
            
           
          </ul>
        
     
        </li>
      </ul>
    </div>
  </div>
</nav>