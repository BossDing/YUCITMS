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
		</script>
	</head>
	<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">考试管理</a></li>
			<li><a href="#">试卷</a></li>
			<li><a href="#">修改试卷</a></li>
		</ul>
	</div>
<form action="paper_updatePaper.action?paperId=${id}&pageNum=${pageNum}" method="post">
	<div class="formbody">

		<div id="usual1" class="usual">

			<div id="tab1" class="tabson">

				<div class="itab">
					<ul>
						<li><a href="#tab1" class="selected">试卷数据</a></li>
					</ul>
				</div>
				<ul class="forminfo">

					<li><label>试卷名称<b>*</b></label>
						<div class="usercity">
							<div class="cityleft">
								<s:textfield name="paperName" type="text" cssClass="scinput" cssStyle="width: 300px" />
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
									value="${zongScore}" style="width: 100px" /> <span
									style="display:inline-block; height:22px; font-size:12px; line-height:22px; color:#b2b2b2;">自动累加所有试题分数</span>
							</div>

							<label>及格分数</label>
							<div class="cityright">
								<s:textfield name="jigeScore" type="text" cssClass="scinput" cssStyle="width: 100px" />
							</div>
							<label>试卷状态</label>
							<div class="cityright">
								<s:select list="#{true:'启用',false:'禁用'}" cssClass="select3" name="paperstate" />
							</div>
						</div></li>
					<li></li>
				</ul>
				
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
			<hr>
         <li style="align-items: center;"><label>&nbsp;</label><input name="" type="submit" class="btn" value="修改" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label></li>
		</div>
	</div>
</form>
	</body>
</html>