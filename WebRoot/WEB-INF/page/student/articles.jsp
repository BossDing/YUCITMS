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
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/click.js" ></script>
	</head>
	<body>
		<div class="sys_main">
			<div class="sys_wrap clear">
				<div class="sys_title">
					<p>已上传文件</p>
				</div>
				<div class="sys_select">
					<a class="btn" onclick="return addSource();" >上传文件</a>
					<a class="btn" onclick="return delete_more();" >批量删除</a>
				</div>
			</div>
			<div class="sys_content">
				<table height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0 >
					<thead><tr>
						<th><span title="点击选中全部"><input type="checkbox" name="checkbox" onclick="checkAll(this)" /></span></th>
						<th>文件名</th><th>上传时间</th><th>操作</th>
					</tr></thead>
					<tbody>
						<tr>
							<th><input name="id" type="checkbox" class="hand" value="${entity.id}" /></th>
							<td>tomcat重启问题</td>
							<td>2016-04-23 15:46:54</td>
							<td><a class="a" onclick="return deleteByIds(${entity.id})" >删除</a></td>
						</tr>
						<tr>
							<th><input name="id" type="checkbox" value="${entity.stuTask.id}" /></th>
							<td>图片</td>
							<td>2016-04-23 15:58:09</td>
							<td><a class="a" onclick="return deleteByIds(${entity.id})" >删除</a></td>
						</tr>
					</tbody>
					<tfoot><th colspan="4" style="text-align: right;"></th></tfoot>
				</table>
			</div>
		</div>
	</body>
</html>
