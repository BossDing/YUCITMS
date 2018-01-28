<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/editor/kindeditor.js"></script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
    });
       KE.show({
        id : 'content',
    });
 
$(document).ready(function(e) {
    $(".select1").uedSelect({
		width : 345			  
	});
	$(".select2").uedSelect({
		width : 167  
	});
	$(".select3").uedSelect({
		width : 100
	});
});
</script>
</head>

<body>

	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
	    	<li><a href="#">考试管理</a></li>
			<li><a href="#">试题</a></li>
			<li><a href="#">修改试题</a></li>
    	</ul>
    </div>
    <form name="form1" method="post" action="question_updateTianKong.action?tianKong.id=${tianKong.id}&pageNum=${pageNum}" target="rightFrame">
    <div class="formbody"> 
    <div id="usual1" class="usual"> 
  	<div id="tab1" class="tabson">
    <ul class="forminfo">
    	<li><label>试题难度<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <s:select list="difficulties" cssClass="select2" name="difficultyId" listKey="id" listValue="difficulty"
    />
    </div>
    <label>试题来源<b>*</b></label>
    <div class="cityright">
     <s:select list="sources" cssClass="select2" name="sourceId" listKey="id" listValue="source"
    />
    </div>
    <label>试题分类<b>*</b></label>
    <div class="cityright">
    <s:select list="classifies" cssClass="select2" name="classifyId" listKey="id" listValue="classify"
    />
    </div>
    </div>
    
    
    
    </li>
    <li><label>试题类型<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <select class="select2" iname="sel" id="sel" onchange="sel_div(this)" >
    <option value="d_1">填空题</option>

    </select>
    </div>
    <label>所属分组<b>*</b></label>
    <div class="cityright">
     <s:select list="groupings" cssClass="select2" name="groupingId" listKey="id" listValue="grouping"
    />
    </div>
    <label>试题状态<b>*</b></label>
    <div class="cityright">
    <select class="select2" name="state">
  <s:if test="%{tianKong.state==true}"><option value="true" selected="selected">启用</option></s:if>
    <s:else><option value="true">启用</option></s:else>
    <s:if test="%{tianKong.state==false}"> <option value="false" selected="selected">禁用</option></s:if>
    <s:else> <option value="false">禁用</option></s:else>
    </select>
    </div>
    </div>
    
    
    
    </li>
    <!--
    	作者：javafengyu@163.com
    	时间：2016-07-13
    	描述：填空题开始
    -->
  <div id="d_1">
    <li><label>试题描述<b>*</b></label><s:textarea id="content7" name="tianKong.questions_TK" cssStyle="width:700px;height:140px;visibility:hidden;"></s:textarea></li>   
    </li>
    <li><label>答案解析<b>*</b></label>
    <s:textarea id="content" name="tianKong.answer_TK" cssStyle="width:700px;height:140px;visibility:hidden;"></s:textarea>
    </li>
    <li><label>&nbsp;</label><input type="submit" onclick="javascript:if(!confirm('确实要修改吗？'))return false;" class="btn" value="保存" style="width: 50px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label></li>
</div>
    </ul>
    
    </div> 
    
    
  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    

    
    
    </div>
</form>

</body>

</html>
