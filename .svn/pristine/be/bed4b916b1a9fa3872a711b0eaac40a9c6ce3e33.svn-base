<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.0.js" charset="UTF-8"></script>	
		<script type="text/javascript">
		  	function check(form) {
		  		var errorStr1="";
		  		var errorStr2="";
			    var account = document.login.account.value.trim();
			    var password = document.login.password.value.trim();
//			    var role = document.login.role.value;
			    var errorAct = $("#account_error");
			    var errorPsw = $("#password_error");
			    if (!account || account.length < 0) {errorStr1="账户不能为空";}
			    else if (!password || password.length < 0) {errorStr2="密码不能为空！";}
			    else if (!/^[0-9]{1,9}$/.test(account)) {errorStr1="账户必须为数字";}
			    if (errorStr1==""&&errorStr2=="") {return true;}
			    else{
			    	errorAct.text(errorStr1);
			    	errorPsw.text(errorStr2);
			    	return false;
			    }
			}
			function selectRole(obj) {
			      if (obj.value == 0) {
			          document.login.action = 'teacher_login.asp';
			      } else if (obj.value == 1) {
			          document.login.action = 'student_login.action';
			      }
		  	}
	  	</script>
  	</head>
	<body>
		<s:fielderror></s:fielderror>
	</body>
</html>
