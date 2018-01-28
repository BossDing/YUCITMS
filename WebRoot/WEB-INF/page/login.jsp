<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.11.0.js"
	charset="UTF-8"></script>
<script type="text/javascript">
	function check(form) {
		var errorStr1 = "";
		var errorStr2 = "";
		var account = document.login.account.value.trim();
		var password = document.login.password.value.trim();
		//			    var role = document.login.role.value;
		var errorAct = $("#account_error");
		var errorPsw = $("#password_error");
		if (!account || account.length < 0) {
			errorStr1 = "账户不能为空";
		} else if (!password || password.length < 0) {
			errorStr2 = "密码不能为空！";
		} else if (!/^[0-9]{1,9}$/.test(account)) {
			errorStr1 = "账户必须为数字";
		}
		if (errorStr1 == "" && errorStr2 == "") {
			return true;
		} else {
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
	<div id="top" class="clear">
		<div id="logo">
			<a href="###"></a>
		</div>
	</div>
	<div id="main" class="clear">
		<div id="message">
			<span style="color:#0aa;">系统使用说明：</span><br /> * 账号说明：教职工为新工号,学生为学号。<br />
			* 密码说明：初始密码与个人身份证号相关，15位的取最后6位作为密码；<br />
			18位的取12~17位作为密码；如果不成功则以账号为初始化密码；如尝试以上密码不能登录，请联系管理员（<a
				href="login/caption.html" target="_blank">点击查看联系方式</a>）。<br /> * <span
				style="color:#0aa;">18位身份证截取示例：</span> <img
				src="${pageContext.request.contextPath}/img/id.gif" width="218"
				height="35" vspace="10" align="absmiddle" title="18位身份证实例"
				style="vertical-align: middle;" />
		</div>
		<div id="login">
			<form class="login" name="login" action="student_login.action"
				method="post" onsubmit="return check(this);">
				<h2 style="color: #787D82;">教学辅助登录端</h2>
				<div id="error" style="color:red;font-size:8pt;text-align:center;">
					<s:fielderror
						cssStyle="color:red;font-size:9px;list-style-type:none;"></s:fielderror>
				</div>
				<select class="login-input select" onclick="selectRole(this)">
					<option value="0">---教师---</option>
					<option selected value="1">---学生---</option>
				</select> <input type="text" name="loginName" class="login-input ipt"
					placeholder="账号" autofocus>
				<div id="account_error"></div>
				<input type="password" name="loginPas" class="login-input ipt"
					placeholder="密码">
				<div id="password_error"></div>
				<input type="submit" class="login-submit btn" value="登　录"></input> <input
					type="reset" class="btn" value="重　置"></input>
			</form>
		</div>
	</div>
</body>
</html>
