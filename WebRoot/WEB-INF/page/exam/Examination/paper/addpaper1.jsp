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
<form action="paper_addPaper1.action" method="post">
	<div class="formbody">

		<div id="usual1" class="usual">

			<div id="tab1" class="tabson">
				<div class="formtext">
					Hi，<b>admin</b>，欢迎您添加试卷！
				</div>

				<div class="itab">
					<ul>
						<li><a href="#tab1" class="selected">试卷数据</a></li>
					</ul>
				</div>
				<ul class="forminfo">

					<li><label>试卷名称<b>*</b></label>
						<div class="usercity">
							<div class="cityleft">
								<input name="paperName" type="text" class="scinput" style="width: 300px" />
							</div>
							<label>所属分组<b>*</b></label>
							<div class="cityright">
								<s:select cssClass="select2" name="pgroupingId" list="paperGroupings" listValue="paperGrouping" listKey="id"/>
							</div>
						</div></li>
					<li><label>试卷总分<b>*</b></label>
						<div class="usercity">
							<div class="cityleft">
								<input name="" type="text" class="scinput" readonly="readonly"
									value="0" style="width: 100px" /> <span
									style="display:inline-block; height:22px; font-size:12px; line-height:22px; color:#b2b2b2;">自动累加所有试题分数</span>
							</div>

							<label>及格分数</label>
							<div class="cityright">
								<input name="jigeScore" type="text" class="scinput" style="width: 100px" />
							</div>
							<label>试卷状态</label>
							<div class="cityright">
								<select class="select2" name="state">
									<option value="true">启用</option>
									<option value="false">禁用</option>
								</select>
							</div>
						</div></li>
					<li></li>
				</ul>
				<div class="itab">
					<ul>
						<li><a href="#tab1" class="selected">试卷属性</a></li>
					</ul>
				</div>
				<ul class="forminfo">
					<li>
						<div class="usercity">
							<label>试卷来源</label>
							<div class="cityright">
								<s:select cssClass="select2" name="psourceId" list="paperSources" listValue="paperSource" listKey="id"/>
							</div>
							<label>试卷分类</label>
							<div class="cityright">
								<s:select cssClass="select2" name="pclassifyId" list="paperClassifies" listValue="paperClassify" listKey="id"/>
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="tools">

				<ul class="toolbar">
					<li id="add"><span><img
							src="${pageContext.request.contextPath}/excellentCourseStyle/images/t01.png" /></span>添加大题描述</li>
				</ul>
				<ul class="toolbar1">
					<li><span><img
							src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>保存</li>
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
					<!-- <tr>
						<td></td>
						<td><input name="" type="text" class="dfinput" /> <input
							name="" type="button" class="scbtn" value="添加试卷" /> <input
							name="" type="button" class="scbtn" value="选择试卷" /> <input
							name="" type="button" class="scbtn" value="随机抽题" /></td>
						<td>13</td>
						<td><a onclick="remove(this);" class="tablelink">删除</a></td>
					</tr> -->

				</tbody>
			</table>
         <li style="align-items: center;"><label>&nbsp;</label><input name="" type="submit" class="btn" value="下一步" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label></li>
		</div>
	</div>
</form>
	</body>
</html>