<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css"/>
		<style type="text/css">
			.sys_content tr:hover{background-color: #FFF;}
			#sys_content_s td:hover{background-color: #EEE;}
		</style>
	</head>
	<body>
		<div class="sys_content" align="center">
		<form action="course_updateCourse.action?id=${id}" method="post">
		<table id="sys_content_s" cellSpacing=0 cellPadding=0 width="70%" border=0>
				<thead>
					<tr><th colspan="2" style="line-height:150%"><h2>更新课程</h2></th></tr>
				</thead>
				<tbody>
					<tr>
						<td style="text-align: left;">课程名称：
							<s:textfield type="text" cssClass="ipt" name="name"/>
							<div id="taskNameTip" style="width: 170px"></div>
						</td>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">教学思想：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="teachingThought"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					  </tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">教学内容：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="teachingContent"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">课程解析：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="courseParsing"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">教学目的：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="teachingAim"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">教学要求：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="teachingRequire"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">进度安排：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="scheduling"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">讲授实习：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="practice"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
					<tr>
						<tr>
						<td style="text-align: left;">实验作业：
						<s:textarea cssClass="ipt" cssStyle=" width: 500px;height: 50px;" name="work"></s:textarea>
						<div id="taskMessageTip" style="width: 190px"></div>
						</td>
					</tr>
					</tr>
				</tbody>
				<tfoot><tr><th>
					<input type="submit" value="确&nbsp;&nbsp;认" class="btn"  style="border: 1px solid #787d82;"/>
					<input type="submit" value="重&nbsp;&nbsp;置" class="btn"  style="border: 1px solid #787d82;"/>
				</th></tr></tfoot>
		</table>
		</form>
		</div>
	</body>
</html>