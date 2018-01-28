<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
<script>
function tishi(text){
	layer.msg(text, {
	    time: 20000, //20s后自动关闭
	    btn: ['确定']
	});			
	}
	function video(url){
		layer.open({
			  type: 2,
			  title: false,
			  area: ['630px', '360px'],
			  shade: 0.8,
			  closeBtn: 0,
			  shadeClose: true,
			  content: url
			});

	}
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
 <li><a href="course_getCourse.action?id=${courseId}">工作台</a></li>
    <li><a href="">文件管理</a></li>
    </ul>
    </div>
     <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
       <a href="video_addExcellentVideoPage.action?courseId=${courseId}"><li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加</li></a>
        <%-- <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> --%>
        </ul>
        
        
       <%--  <ul class="toolbar1">
        <li><span><img src="images/t05.png" /></span>设置</li>
        </ul> --%>
    
    </div>
    
    <table class="filetable">
    
    <thead>
    	<tr>
        <th width="25%">名称</th>
        <th width="11%">创建日期</th>
        <th width="10%">类型</th>
        <th width="48%">操作</th>
        <th width="6%"></th>
        </tr>    	
    </thead>
    
    <tbody>
        <s:iterator value="recordList">
    	<tr>
        <td onclick="tishi('${videoName}');"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/f03.png" />${videoName}</td>
        <td><s:date name="createDate" format="yyyy-MM-dd"/></td>
        <td>视频</td>
        <td>
        <a onclick="video('<%=Config.EXCELLENTCOURSE_VideoPath%>/${videoPath}');">预览</a>
        <a href="video_updateExcellentVideoPage.action?id=${id}&courseId=${courseId}">修改</a>
        <a href="video_deleteExcellentVideo.action?id=${id}&courseId=${courseId}" onclick="javascript:if(!confirm('删除后无法恢复，确实要删除吗？'))return false;">删除</a>
        </td>
        <td></td>
        </tr>
        </s:iterator>
        
    </tbody>
    
    
    
    
    </table>
    
    
      <s:form action="video_getExcellentVideoList?courseId=%{courseId}" name="page">
	   <%@include file="../../../common/pagebean.jspf" %>
      </s:form>
   

</body>

</html>
