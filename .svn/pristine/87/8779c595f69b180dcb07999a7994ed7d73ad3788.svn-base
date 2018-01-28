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
<script>
function showPreview(source) {  
    var file = source.files[0];  
    if (window.FileReader) {  
        var fr = new FileReader();  
        fr.onloadend = function(e) {  
            document.getElementById("portrait").src = e.target.result;  
        };  
        fr.readAsDataURL(file);  
    }  
}  
function dialog(url,name,jobTitle,text,id){
	  $(".tip").fadeIn(200);
	  
	  $(".tiptop a").click(function(){
	  $(".tip").fadeOut(200);
	});

	  $(".sure").click(function(){
	  $(".tip").fadeOut(100);
	//  window.location.href="excellentTeacher_updateExcellentTeacherPage.action?id="+id; 
	});

	  $(".cancel").click(function(){
	  $(".tip").fadeOut(100);
	//  window.location.href="excellentTeacher_deleteExcellentTeacherPage.action?id="+id; 
	});
	  img1.src=url;
	  p1.innerHTML=name+"-"+jobTitle;
	  cite1.innerHTML=text;
	/*   $(".update").click(function(){
		 
	  });
	  $(".del").click(function(){
		 
	  }); */
}
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
   <li><a href="course_getCourse.action?id=${courseId}">工作台</a></li>
    <li><a href="#">教师团队</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
       <a href="excellentTeacher_addExcellentTeacherPage.action?courseId=${courseId}"><li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加</li></a>
       <%--  <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> --%>
        </ul>
        
        
        <ul class="toolbar1">
        <%-- <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>设置</li> --%>
        </ul>
    
    </div>
    
    
    <ul class="imglist">
    <s:iterator value="recordList">
    
    <li class="selected">
    <a onclick="dialog('<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}','${teacherName}','${jobTitle}','${content}','${id}');"><span><img src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}" height="130px" width="175px"/></span>
    <h2>${teacherName}-${jobTitle}</h2></a>
    <p><a href="excellentTeacher_updateExcellentTeacherPage.action?id=${id}&courseId=${courseId}">编辑</a>
    &nbsp;&nbsp;&nbsp;&nbsp;
    <a href="excellentTeacher_deleteExcellentTeacher.action?id=${id}&courseId=${courseId}" onclick="javascript:if(!confirm('删除后无法恢复，确实要删除吗？'))return false;">删除</a></p>
    </li>

    </s:iterator>
   
    
    </ul>
    
    
   
    <s:form action="excellentTeacher_getExcellentTeacherList?courseId=%{courseId}">
    <%@include file="../../../common/pagebean.jspf" %>
    </s:form>
    
    
  <!--对话框  -->
    <div class="tip" style="position:absolute; height:400px; overflow:auto">
    	<div class="tiptop"><span>教师详细信息</span><a></a></div>  
      <div class="tipinfo">
        <span><img src="" id="img1" height="80px" width="80px"/></span>
        <div class="tipright">
        <p id="p1"></p>
        <cite id="cite1"></cite>
        </div>
        </div>
         <!-- <div class="tipbtn">
        <input  type="button" id="update" class="sure" value="修改" />&nbsp;
        <input  type="button"  id="del" class="cancel" value="删除" />
        </div> -->
    </div>
    
    
    
    
    </div>
    

</body>

</html>