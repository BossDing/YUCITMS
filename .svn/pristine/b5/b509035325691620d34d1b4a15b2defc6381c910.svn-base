<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增实训模板</title>
<link href="${pageContext.request.contextPath}/pages/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/pages/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/editor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/cascadingDropDownList.js"></script>

<script type="text/javascript">
    KE.show({
        id : 'content7',
        cssPath : './index.css'
    });
  </script>
  
<script type="text/javascript">
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
<script type="text/javascript">
function submitForm(){
var fm = document.getElementById("addAttendance");
	fm.action="practicalTraining_addTemplate.action";
	fm.submit();
}
function load() {
	var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
	
}
</script>

</head>

<body>
<form name ="practicalTraining" id ="practicalTraining"  action="practicalTraining_updateTemplate.action" method="post" enctype="multipart/form-data" target="rightFrame">
    <div class="formbody">
    
    <div class="formtitle"><span>新增模板</span></div>
    <input type="hidden" name="practicalTrainingTemplate.id" value="${practicalTrainingTemplate.id}"/>
    <ul class="forminfo">
    <li><label>模板名称</label><input name="practicalTrainingTemplate.templateName" type="text" class="dfinput" value="${practicalTrainingTemplate.templateName}"/><i>项目名称不能超过30个字符</i></li>
    <li><label>技术类型</label><input name="practicalTrainingTemplate.technologicalType" type="text" class="dfinput" value="${practicalTrainingTemplate.technologicalType}"/><i>多个技术用,隔开</i></li>
    <li><label>实训模板</label><input name="upload" type="file"   accept=".*"/>（原文件：${practicalTrainingTemplate.uploadTemplateName}）<i>实训模板(请打包上传)</i></li>
    <li><label>降级模板</label><input name="upload2" type="file"   accept="rar,.zip"/>（原文件：${practicalTrainingTemplate.degradationTemplateName}）<i>降级模板(请打包上传)</i></li>
    
    <li><label>模板描述</label><textarea name="" cols="" rows="" class="textinput"></textarea></li>
    <li><label>&nbsp;</label><input name="" type="submit" onclick="load();" class="btn" value="确认新增模板"/></li>
    </ul>



</div>
</form>
</body>

</html>
