<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%-- <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> --%>
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
//iframe层
function addqjfie(){
layer.open({
      type: 2,
      shadeClose: true,
      shade: false,
      maxmin: true, //开启最大化最小化按钮
      area: ['893px', '600px'],
      content: '${pageContext.request.contextPath}/pages/teacher/attendance/attendanceAdd.jsp'
})
}
/* 查看考勤列表 */
function viewAttendanceList(id){
	layer.open({
      type: 2,
      shadeClose: true,
      shade: false,
      maxmin: true, //开启最大化最小化按钮
      area: ['1000px', '600px'],
      content: 'attendanceAction_viewAttendanceList.action?attendanceMainID='+id
})
}
/* 删除考勤 */
function deleteAttendanceMain(id){

// alert("df2e");
var f = document.forms[0];
f.action = "attendanceAction_deleteAttendanceMain.action?attendanceMainID="+id;
f.submit();
// window.location.href=window.location.href;
}
/* 修改考勤 */
function editAttendanceMain(id){
	layer.open({
      type: 2,
      shadeClose: true,
      shade: false,
      maxmin: true, //开启最大化最小化按钮
      area: ['1000px', '600px'],
      content: 'attendanceAction_editAttendanceMain.action?attendanceMainID='+id
})
}
</script>
</head>

<body>

	<div class="place">
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">考勤</a></li>
    <li><a href="#">考勤管理</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">考勤管理</a></li> 
  	</ul>
    </div> 
    <form action="attendanceAction_queryAttendance.action" method="post" enctype="multipart/form-data">
  	<div id="tab1" class="tabson">
    
    
    <ul class="seachform">
    
    <li><label>起始日期</label>  
    <div class="vocation">
    <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="startDate">
    </div>
    </li>
    <li><label>终止日期</label>  
    <div class="vocation">
    <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="endtDate">
    </div>
    </li>
    
    <li><label>学院</label>  
    <div class="vocation">
    <select class="select3" id="department" name="department.departmentID" >
    <option value="">全部</option>
    </select>
    </div>
    </li>
    <li><label>专业</label>  
    <div class="vocation">
    <select class="select3" id="major" name="major.majorID">
    <option value="">全部</option>
    </select>
    </div>
    </li>
    <li><label>班级</label>  
    <div class="vocation">
    <select class="select3" id="classRoom" name="classRoom.classRoomID">
    <option value="">全部</option>
    </select>
    </div>
    </li>
    <li><label>机房</label>  
    <div class="vocation">
    <select class="select3" id="computerRoom" name="computerRoom.computerRoomID">
    <option>请选择</option>
    </select>
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
        <th>日期</th>
        <th>学院</th>
        <th>专业</th>
        <th>班级</th>
        <th>机房</th>
        <th>备注</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody> 
        <s:iterator  value="recordList" >
        <tr>
        <td><input name="" type="checkbox" value="" /></td>
		<s:hidden name="id" value="id"></s:hidden>
        <td>${day}</td>
        <td><s:property value="classRoom.major.department.departmentName"/></td>
        <td><s:property value="classRoom.major.majorName"/></td>
        <td><s:property value="classRoom.classRoomName"/></td>
        <td><s:property value="computerRoom.roomNo"/></td>
        <td><s:property value="remark"/></td>
        <td>
        	<a href="#" onclick="viewAttendanceList('${id}');" class="tablelink"> 查看</a>
        	<a href="#" onclick="editAttendanceMain('${id}');" class="tablelink"> 修改</a>
        	<a href="#" onclick="deleteAttendanceMain('${id}');" class="tablelink"> 删除</a>
        </td>
        </tr>
    
        </s:iterator>
        </tbody>
    </table>
     <s:form action="attendanceAction_queryAttendance.action" name="page" method="post" enctype="multipart/form-data">
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

