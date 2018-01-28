<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
function addT() {
	$("form1").action="course_addCourse3.action?id=${id}&flag=${flag}";
}
function next(){
	form1.action="course_addCourse4.action?id=${id}&flag=${flag}";
}
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">表单</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>教师团队</span></div>
    <form id="form1" action="course_addCourse3.action?id=${id}&flag=${flag}" method="post" enctype="multipart/form-data">
    <ul class="forminfo">
    <li><label>教师姓名</label><input name="teacher.teacherName" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>职称</label><input name="teacher.jobTitle" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>简介</label><textarea name="teacher.content" cols="" rows="" class="textinput"></textarea></li>
    <li><label>教师头像</label><input name="upload" type="file" class="dfinput" onchange="showPreview(this)"/></li>
    <li><label></label><img src="" id="portrait" width="70" height="75" /></li>
    <li>
   <label>&nbsp;</label><input type="submit" class="btn" value="继续添加教师" onclick="addT();"/>
   <label>&nbsp;</label><input type="button" class="btn"  onclick="javascript:window.history.back(-1);"  value="上一步"/>
    <label>&nbsp;</label><input type="submit" class="btn" onclick="next();" value="下一步"/>
    </li>
    </ul>
    </form>
    
    </div>


</body>

</html>
