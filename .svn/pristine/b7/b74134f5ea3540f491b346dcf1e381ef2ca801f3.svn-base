<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
<script>
function img() {
	layer.photos({
	    photos: '#layer-photos-demo' ,
	    	 area:['700px','auto'],       
		    	closeBtn:1,	
	  });
}
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="course_getCourse.action?id=${courseId}">工作台</a></li>
    <li><a href="#">轮播</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
       <a href="img_addImgCarouselPage.action?courseId=${courseId}"><li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加</li></a>
       <%--  <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> --%>
        </ul>
        
        
        <ul class="toolbar1">
        <%-- <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>设置</li> --%>
        </ul>
    
    </div>
    
    
    <ul class="imglist">
    <div class="layer-photos-demo" id="layer-photos-demo">
    <s:iterator value="recordList">
    
    <li class="selected">
    <span><img onclick="img();" src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"	height="130px" width="175px" 
layer-pid="${id}" layer-src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"  alt="${imgExplain}"/></span>
    <p><a href="img_updateImgCarouselPage.action?id=${id}&courseId=${courseId}">编辑</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="img_deleteImgCarousel.action?id=${id}&courseId=${courseId}" onclick="javascript:if(!confirm('删除后无法恢复，确实要删除吗？'))return false;">删除</a></p>
    </li>

    </s:iterator>
   
    </div>
    </ul>
    
    
   
    <s:form action="img_getImgCarouselList?courseId=%{courseId}">
    <%@include file="../../../common/pagebean.jspf" %>
    </s:form>

    </div>
    

</body>

</html>