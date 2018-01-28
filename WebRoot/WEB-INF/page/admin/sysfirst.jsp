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
	</head>
	<body>
		<div class="sys_main">
			<div class="sys_wrap"><p>系统简介</p></div>
			<div class="sys_content">
				<table height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0 >
					<tr><th colspan="2"></th></tr>
					<tr>
						<td >系统名称</td>
						<td>一体化教学资源辅助管理平台（学生平台）</td>
					</tr>
					<tr>
						<td>系统简介</td>
						<td>本系统的使用用户为学生。学生可以完成实训的任务和老师分配的考试。可以上传文档共享自己的学习资料。</td>
					</tr>
					<tr>
						<td>版本号</td>
						<td>Version 1.0</td>
					</tr>
					<tr>
						<td>发行时间</td>
						<td>2016年06月01日</td>
					</tr>
					<tr>
						<td>使用说明文档</td>
						<td><a class="a" href="">下载使用说明</a></td>
					</tr>
					<tr>
						<td>版权所有者</td>
						<td>郑州轻工业学院（软件学院）</td>
					</tr>
				</table>
			</div>
		</div>
	</body>
</html>
