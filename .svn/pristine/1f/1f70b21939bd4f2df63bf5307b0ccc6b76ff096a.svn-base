<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script language="javascript">
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">图片列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
        <a href="course_addCoursePage1.action?flag=1"> <li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加</li></a>
       <%--  <li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t02.png" /></span>修改</li>
        <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t03.png" /></span>删除</li>
        <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t04.png" /></span>统计</li>
         --%></ul>
        
        
        <ul class="toolbar1">
        <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>设置</li>
        </ul>
    
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
    <th width="100px;">缩略图</th>
    <th>标题</th>
    <th>基本信息</th>
    <th>发布人</th>
    <th>是否审核</th>
    <th>点击</th>
    <th>更新时间</th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <s:iterator value="recordList">
    <tr>
    <td class="imgtd"><img src="<%=Config.EXCELLENTCOURSE_ImgPath %>/${thumbnailPath}" height="60px" width="80px"/></td>
    <td><a href="course_getCourse.action?id=${id}">${name}</a><p>发布时间：<s:date name="createDate" format="yyyy-MM-dd HH:mm:ss"/></p></td>
    <td>
    <s:if test="%{addFinish==true}">完成</s:if>
    <s:else>未完成</s:else>
    </td>
    <td>admin</td>
    <td><s:if test="%{Audit==true}">已审核</s:if>
    <s:else>未审核</s:else></td>
    <td>${clickNum}</td>
    <td>
    <s:date name="updateDate" format="yyyy-MM-dd HH:mm:ss"/>
    </td>
    <td>
    <s:if test="%{addFinish==true}">
    <a href="course_addCoursePage1.action?id=${id}&flag=0" class="button button-blue button-tiny" >修改</a> 
    </s:if>
    <s:else>
    <a href="course_addCoursePage1.action?id=${id}&flag=1" class="button button-blue button-tiny" >继续添加</a> 
    </s:else>
    <a href="course_recoverCourse.action?id=${id }" class="button button-blue button-tiny" onclick="javascript:if(!confirm('确实要恢复吗？'))return false;">恢复</a> 
    </td>
    </tr>
    </s:iterator>
    </tbody>
    
    </table>
    
    
    
    
     <s:form action="course_getCourseList" name="page">
	<%@include file="../../../common/pagebean.jspf" %>
      </s:form>
   
   
    
    
   <%--  <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
     --%>
    
    
    
    </div>
    
   <%--  <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div> --%>
    
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    
</body>

</html>

