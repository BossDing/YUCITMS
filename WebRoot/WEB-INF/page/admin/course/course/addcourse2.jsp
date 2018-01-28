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
function next() {
	form1.action='course_updateCourse1.action?id=${id}&flag=${flag}';
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
    
    <div class="formtitle"><span>课程介绍</span></div>
    <form id="form1" action="course_addCourse2.action?id=${id}&flag=${flag}" method="post">
    <ul class="forminfo">
    <li><label>教学内容</label><s:textarea name="teachingContent" cols="" rows="" cssClass="textinput"></s:textarea></li>
    <li><label>课程解析</label><s:textarea name="courseParsing" cols="" rows="" cssClass="textinput"></s:textarea></li>
    <li>
    <label>&nbsp;</label><input type="button" class="btn"  onclick="javascript:window.history.back(-1);"  value="上一步"/>
   <s:if test="%{flag==1}"><label>&nbsp;</label><input type="submit" class="btn" value="下一步"/></s:if>
   <s:else><label>&nbsp;</label><input type="submit" class="btn" onclick="next();" value="下一步"/></s:else>
    
    </li>
    </ul>
    </form>
    
    </div>


</body>

</html>
