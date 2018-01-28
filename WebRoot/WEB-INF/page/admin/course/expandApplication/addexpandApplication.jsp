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
<script src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
<script >
function load() {
	var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
	
}
</script>
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
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
   
<li><a href="course_getCourse.action?id=${courseId}">工作台</a></li>
    <li><a href="#">拓展应用</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>添加扩展应用</span></div>
    <form id="form1" action="expandApplication_addExpandApplication.action?courseId=${courseId}" method="post" enctype="multipart/form-data" onsubmit="javascript:if(!confirm('确实要操作吗？'))return false;">
    <ul class="forminfo">
    <li><label>扩展应用</label><input name="name" type="text" class="dfinput" /><i>标题不能超过30个字符</i></li>
    <li><label>附件</label><input name="upload" type="file" class="dfinput" accept="doc,.docx,.xls,.xlsx,.ppt,.pptx"/></li>
    <li>
   <label>&nbsp;</label><input type="button" class="btn"  onclick="javascript:window.history.back(-1);"  value="上一步"/>
    <label>&nbsp;</label><input type="submit" class="btn" onclick="load();" value="完成"/>
    </li>
    </ul>
    </form>
    
    </div>


</body>

</html>
