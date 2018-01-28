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
      content: '${pageContext.request.contextPath}/pages/attendance/attendanceAdd.jsp'
})
}
</script>
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    <li><a href="#">考勤</a></li>
    <li><a href="#">我的考勤</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">我的考勤</a></li> 
  	</ul>
    </div> 
    <form action="student_queryMyAttendance.action" method="post" enctype="multipart/form-data">
  	<div id="tab1" class="tabson">
    
    
    <ul class="seachform">
    
    <li><label>起始日期</label>  
    <div class="vocation">
    <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="startDate">
    </div>
    </li>
    <li><label>终止日期</label>  
    <div class="vocation">
    <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="endDate">
    </div>
    </li>
    <li><label>机房</label>  
    <div class="vocation">
    <select class="select3" id="computerRoom" name="computerRoom.computerRoomID">
    <option>请选择</option>
    </select>
    </div>
    </li>
    <li><label>出勤状态</label>  
    <div class="vocation">
    <select class="select3" id="signIn" name="signInstate">
    <option value="0">全部</option>
    <option value="signInTrue">出勤</option>
    <option value="signInFalse">缺勤</option>
    </select>
    </div>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="查询"/></li>
    <s:if test="%{signInstate=='signInTrue'}">
    <li><label>&nbsp;</label><input type="button" disabled="disabled" alt="已经签到" class="scbtn" value="已签到"/></li>
    </s:if>
    <s:else>
    <li><label>&nbsp;</label><a href="student_signIn.action" target="rightFrame"><input type="button" class="scbtn" value="签到"/></a></li>
    </s:else>
    </ul>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>日期</th>
        <th>机房</th>
        <th>签到状态</th>
        <th>签到时间</th>
        </tr>
        </thead>
        <tbody> 
        <s:iterator  value="recordList" >
        <tr>
        <td><s:property value="attendanceMain.day"/></td>
        <td><s:property value="attendanceMain.computerRoom.roomNo"/></td>
        <s:if test="%{signInTrue=='signInTrue'}">
        <td>已签到</td>
        </s:if>
        <s:else>
        <td>未签到</td>
        </s:else>
        <td><s:property value="signInTime"/></td>
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

