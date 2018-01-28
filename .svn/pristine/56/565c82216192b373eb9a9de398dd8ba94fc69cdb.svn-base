<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
     <title>三级联动</title> 
    <script language="JavaScript" src="js/jquery.js"></script> 
<!--     <script type="text/javascript" src="my.js"></sCript>  -->
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
$(document).ready(function () {
    /* 获取省份 */ 
    $.post("linkageAction_getProvince.action", function (data) { 
        var jsonObj = eval("(" + data + ")"); 
        for (var i = 0; i < jsonObj.length; i++) { 
            var $option = $("<option></option>"); 
            $option.attr("value", jsonObj[i].pid); 
            $option.text(jsonObj[i].pname); 
            $("#province").append($option); 
        } 
    }); 
    /* 根据省份获取城市 */ 
    $("#province").change(function () { 
        $.post("linkageAction_getCityByPid.action", {pid:$("#province").val()}, function (data) { 
            /* 清空城市 */ 
            $("#city option[value!=' ']").remove(); 
            /* 清空乡镇 */ 
            $("#town option[value!=' ']").remove(); 
            var jsonObj = eval("(" + data + ")"); 
            for (var i = 0; i < jsonObj.length; i++) { 
                var $option = $("<option></option>"); 
                $option.attr("value", jsonObj[i].cid); 
                $option.text(jsonObj[i].cname); 
                $("#city").append($option); 
            } 
        }); 
    }); 
    /* 根据城市获取乡镇 */ 
    $("#city").change(function () { 
        $.post("linkageAction_getTownByCid", {cid:$("#city").val()}, function (data) { 
            /* 清空乡镇 */ 
            $("#town option[value!='']").remove(); 
            var jsonObj = eval("(" + data + ")"); 
            for (var i = 0; i < jsonObj.length; i++) { 
                var $option = $("<option></option>"); 
                $option.attr("value", jsonObj[i].tid); 
                $option.text(jsonObj[i].tname); 
                $("#town").append($option); 
            } 
        }); 
    }); 
});
</script>
  </head>
  
  <body>
    UTF <br>
     <select id="province" name="province"> 
       <option value="">请选择</option> 
     </select> 
     <select id="city" name="city"> 
        <option value="">请选择</option> 
     </select> 
     <select id="town" name="town">
        <option value="">请选择</option>
     </select>
  </body>
</html>
