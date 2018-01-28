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
    
    <div class="formtitle"><span>试卷分类</span></div>
    <form id="form1" action="papegClassify_updatePaperClassify.action?id=${id}" method="post">
    <ul class="forminfo">
    <li><label>试卷分类</label><s:textfield name="paperClassify" type="text" cssClass="dfinput" /><i></i></li>
    <li>
   <label>&nbsp;</label><input type="button" class="btn"  onclick="javascript:window.history.back(-1);"  value="上一步"/>
    <label>&nbsp;</label><input type="submit" class="btn" onclick="next();" value="修改"/>
    </li>
    </ul>
    </form>
    
    </div>


</body>

</html>
