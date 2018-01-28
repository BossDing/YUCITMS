<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增考勤</title>
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
	fm.action="attendanceAction_addAttendance.action";
	fm.submit();
// 	layer.open({
//       type: 2,
//       shadeClose: true,
//       shade: false,
//       maxmin: false, //开启最大化最小化按钮
//       area: ['89.3px', '60px'],
//       content:'attendanceAction_addAttendance.action'
// })
	
}
</script>

</head>

<body>
<form name ="addAttendance" id ="addAttendance"  action="attendanceAction_addAttendance.action" method="post" enctype="multipart/form-data">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
  
  <ul class="seachform">
 <li><label>考勤日期</label>  
    <div class="vocation">
    <input placeholder="请输入日期" class="laydate-icon" onclick="laydate()" name="attendanceMain.day">
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
    <li><label>备注</label>  
    <div class="vocation">
    <input type="" name="attendanceMain.remark" id="" value=""  class="dfinput"/>
    </div>
    </li>
    <input name="" type="button" onclick="submitForm();" class="btn" value="确认新建考勤">
    </ul>
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    
    
    
    
    </div>

</div>
</form>
</body>

</html>
