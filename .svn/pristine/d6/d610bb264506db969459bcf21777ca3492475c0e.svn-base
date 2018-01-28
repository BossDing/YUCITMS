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
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
 <li>试卷分类</li>

    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<ul class="toolbar">
       <a href="papegClassify_addPaperClassifyPage.action"><li class="click"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加</li></a>
       <%--  <li class="click"><span><img src="images/t02.png" /></span>修改</li>
        <li><span><img src="images/t03.png" /></span>删除</li>
        <li><span><img src="images/t04.png" /></span>统计</li> --%>
        </ul>
        
        
        <ul class="toolbar1">
        <%-- <li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>设置</li> --%>
        </ul>
    
    </div>
    
    
  
    <table class="imgtable">
    
    <thead>
    <tr>
    <th>分类</th>
    <th>操作</th>
    </tr>
    </thead>
    
    <tbody>
    <s:iterator value="recordList">
    <tr>
    <td>${paperClassify}<p>发布时间：<s:date name="createDate" format="yyyy-MM-dd HH:mm:ss"/></p></td>
    <td>
    <a href="papegClassify_updatePaperClassifyPage.action?id=${id}" class="button button-blue button-tiny" >修改</a> 
    <s:if test="%{state==true}">
     <a href="papegClassify_disablePaperClassify.action?id=${id}" class="button button-blue button-tiny" onclick="javascript:if(!confirm('禁用后，添加试卷时，将无此属性。确定操作吗？'))return false;">禁用</a>
    </s:if>
    <s:else>
   <a href="papegClassify_enabledPaperClassify.action?id=${id }" class="button button-blue button-tiny" onclick="javascript:if(!confirm('确实要启用吗？'))return false;" style="color: red;">启用</a>
    </s:else> 
    </td>
    </tr>
    </s:iterator>
    </tbody>
    
    </table>
    
    
   
    <s:form action="papegClassify_getPaperClassifyList" name="page">
	   <%@include file="../../../../common/pagebean.jspf" %>
      </s:form>
    
    
    </div>
    

</body>

</html>