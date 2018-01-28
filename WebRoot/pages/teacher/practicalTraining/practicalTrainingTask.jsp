<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>考勤管理</title>
<link href="${pageContext.request.contextPath}/pages/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/pages/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/editor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/laydate/laydate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/layer/layer.js"></script>
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
//iframe层新增模板
function addqjfie(){
layer.open({
      type: 2,
      shadeClose: true,
      shade: false,
      maxmin: true, //开启最大化最小化按钮
      area: ['893px', '600px'],
      content: '${pageContext.request.contextPath}/pages/teacher/practicalTraining/templateAdd.jsp'
})
}
/* 删除模板*/
function deleteTemplate(id){
var f = document.forms[0];
f.action = "practicalTraining_deleteTemplate.action?templateID="+id;
f.submit();
}
/* 修改考勤 */
function updateTemplate(id){
var f = document.forms[0];
f.action = "practicalTraining_editTemplate.action?templateID="+id;
f.submit();
}
</script>
</head>

<body>

	<div class="place">
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">实训</a></li>
    <li><a href="#">模板管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">模板管理</a></li> 
  	</ul>
    </div> 
    <form action="practicalTraining_queryTemplate.action" method="post" enctype="multipart/form-data">
  	<div id="tab1" class="tabson">
    
    
    <ul class="seachform">
    
    
    <li><label>模板名称：</label>  
    <div class="vocation">
    <input type="text" class="dfinput" name="practicalTrainingTemplate.templateName"/>
    </div>
    </li>
    <li><label>技术类型：</label>  
    <div class="vocation">
    <input type="text" class="dfinput" name="practicalTrainingTemplate.technologicalType"/>
    </div>
    </li>
    
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>

    </ul>
    <div class="tools">
    	<ul class="toolbar">
        <li class="click" onclick=addqjfie();><span><img src="${pageContext.request.contextPath}/pages/images/t01.png" /></span>添加</li>
        <li><span><img src="${pageContext.request.contextPath}/pages/images/t03.png" /></span>删除</li>
        </ul>
    </div>
	
	<table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" checked="checked"/></th>
        <th>模板名称</th>
        <th>技术类型</th>
        <th>上传时间</th>
        <th>模板</th>
        <th>降级模板</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody> 
        <s:iterator  value="recordList" >
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
		<s:hidden name="id" value="id"></s:hidden>
        <td>${templateName}</td>
        <td>${technologicalType}</td>
        <td>${uploadTime}</td>
        <td><a class="tablelink" href="download.action?filename=<%=Config.PRACTICALTRAINING_SaveFilePath%>${uploadTemplatePath}">点击下载</a></td>
        <td><a class="tablelink" href="download.action?filename=<%=Config.PRACTICALTRAINING_SaveFilePath%>${degradationTemplatePath}">点击下载</a></td>
        <td>
        	<a href="#" onclick="updateTemplate('${id}');" class="tablelink"> 修改</a>
        	<a href="#" onclick="deleteTemplate('${id}');" class="tablelink"> 删除</a>
        </td>
        </tr>

        </s:iterator>
        </tbody>
    </table>
     <s:form action="practicalTraining_practicalTrainingTask.action" name="page" method="post">
	<%@include file="../../common/pagebean.jspf" %>
      </s:form>

    </div> 
    </form>
    
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>


</body>

</html>

