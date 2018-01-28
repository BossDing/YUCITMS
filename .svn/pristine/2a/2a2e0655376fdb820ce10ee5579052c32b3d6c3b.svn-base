<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
		<style>
			nav{position: absolute;min-width: 300px;width: 100%;top: 80px;}
			#nav{width: 800px;margin: 0 auto;}
			#nav ul li{float:left;height: 60px;width: 200px;margin: 0 auto;}
			#nav ul a{display: block;height: 60px;font-size: 16px;line-height: 60px;text-align: center;color: #14191e;}
			#nav ul a:link{color: #14191e;}
			#nav ul a:visited{color: #14191e;}
			#nav ul a:hover{color: rgba(0,170,170,.85);background-color: #f5f5f5;}
			#nav ul a:active{color: rgba(0,170,170,.85);background-color: #f5f5f5;}
		</style>
	</head>
	<body>
		<div id="top">
			<div id="logo">
				<a href="###"></a><!--a标签用于“进入首页”-->
			</div>
			<div id="message">
				<label>欢迎您：</label>
				<label>${sessionScope.student.studentName}</label>
				<label></label><!--登陆角色-->
				<a href="student_outline.action" target="_parent">退出登录</a><!--a标签用于“退出登录”-->
			</div>
		</div>
		<nav>
			<div id="nav">
				<ul>
					<li><a href="#">我的考试</a></li>
					<li><a href="#">任务列表</a></li>
					<li><a href="#">个人信息</a></li>
					<li><a href="#">文件管理</a></li>
				</ul>
			</div>
		</nav>
	</body>
</html>
