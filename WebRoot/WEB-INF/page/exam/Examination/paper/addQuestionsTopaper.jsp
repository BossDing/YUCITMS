<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加试卷</title>
<link
	href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/excellentCourseStyle/css/select.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/editor/kindeditor.js"></script>
	<script src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
	<script type="text/javascript">
	function add(url){
		layer.open({
			  type: 2,
			  area: ['1000px', '650px'],
			  fix: false, //不固定
			  maxmin: true,
			  content: url
			});
	}
	
	$(function() {
		var str = "<tr>"
		                            + "<td>"
									+ "<input type=\"text\" name=\"jiegou\" class=\"dfinput\"/>"
									+ "</td>" 
									+ "<td><input type=\"text\" name=\"index\" class=\"dfinput\" onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"this.v();\" /></td>"
									+"<td><a onclick=\"getDel(this);\" class=\"\">删除</a></td>"
									+ "</tr>";
	$("#tbody").append(str);
		$("#add")
				.click(
						function() {
							var str = "<tr>"
		                            + "<td>"
									+ "<input type=\"text\" name=\"jiegou\" class=\"dfinput\"/>"
									+ "</td>" 
									+ "<td><input type=\"text\" name=\"index\" class=\"dfinput\" onkeyup=\"(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)\" onblur=\"this.v();\" /></td>"
									+"<td><a onclick=\"getDel(this);\" class=\"\">删除</a></td>"
									+ "</tr>";
							$("#tbody").append(str);
						});
	});

	function getDel(k) {
		$(k).parent().parent().remove();
	}
	</script>
	</head>
	<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">考试管理</a></li>
			<li><a href="#">试卷</a></li>
			<li><a href="#">添加试卷</a></li>
		</ul>
	</div>

	<div class="formbody">
<form action="paper_addGrouping.action?paperId=${id}" method="post">
		<div id="usual1" class="usual">
<div class="tools">

				<ul class="toolbar">
					<li id="add"><span><img
							src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加大题描述</li>
				</ul>
				<ul class="toolbar1">
					<%-- <li><span><img
							src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>保存</li> --%>
				</ul>
			</div>
			

			<table class="tablelist">
				<thead>
					<tr>
						<th>试题结构</th>
						<th>索引</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id="tbody">
				<s:iterator value="questionsGroupings">
					<tr>
						<td>${name}</td>
						<td>${index}</td>
						<td>
							<a  class="tablelink" onclick="add('paper_getTKquestionList.action?qgroupingId=${id}');">添加试题</a>
							<a  href="paper_deleteGrouping.action?qgroupingId=${id}" onclick="javascript:if(!confirm('删除后无法恢复，并且此结构下的试题也全部删除，确实要删除吗？'))return false;" class="tablelink">删除</a>
							<a  class="tablelink" onclick="add('paper_selectQuestion.action?qgroupingId=${id}&paperId=${examPaper.id}');">设置分值</a>
						</td>
					</tr>
                </s:iterator>
				</tbody>
			</table>
<li style="align-items: center;"><label>&nbsp;</label><input name="" type="submit" class="btn" value="更新试卷结构" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><label>&nbsp;</label><input name="" type="button" class="btn" value="保存试卷" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label></li>
		</div>
		</form>
	</div>
	</body>
</html>
	