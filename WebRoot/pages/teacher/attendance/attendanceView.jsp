<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查看考勤</title>
<link href="${pageContext.request.contextPath}/pages/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/pages/css/select.css" rel="stylesheet" type="text/css" />

<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/editor/kindeditor.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/pages/js/laydate/laydate.js"></script>

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

</head>

<body>

	<div class="place">
    <span>查看考勤</span>
    </div>
    
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <!--<li><a href="../#tab1" class="selected">发布通知</a></li>--> 
    <li><a href="../#tab2">查看考勤</a></li> 
  	</ul>
    </div> 
    
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>日期</th>
        <th>学院</th>
        <th>专业</th>
        <th>班级</th>
        <th>学生</th>
        <th>机房</th>
        <th>出勤状态</th>
        </tr>
        </thead>
        <tbody>
        <s:iterator  value="recordList" >
        <tr>
        <td><s:property value="attendanceMain.day"/></td>
        <td><s:property value="student.classRoom.major.department.departmentName"/></td>
        <td><s:property value="student.classRoom.major.majorName"/></td>
        <td><s:property value="student.classRoom.classRoomName"/></td>
        <td><s:property value="student.studentName"/></td>
        <td><s:property value="attendanceMain.computerRoom.roomNo"/></td>
        <s:if test="%{signInTrue=='signInTrue'} ">
        <td>已签到</td>
        </s:if>
        <s:else>
        <td>未签到</td>
        </s:else>
        </tr> 
        </s:iterator>
    
        </tbody>
    </table>
    
    <s:form action="attendanceAction_viewAttendanceList.action" name="page" method="post" enctype="multipart/form-data">
	<%@include file="../../common/pagebean.jspf" %>
      </s:form>
  
    
       
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
