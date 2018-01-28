<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("msgContent") != null ? request.getParameter("msgContent") : "";
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath()+ "/";
	//System.out.println(htmlData);

%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>KindEditor JSP</title>
	<link rel="stylesheet" href="../themes/default/default.css" />
	<link rel="stylesheet" href="../plugins/code/prettify.css" />
	<script charset="utf-8" src="../kindeditor.js"></script>
	<script charset="utf-8" src="../lang/zh_CN.js"></script>
	<script charset="utf-8" src="../plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K){
			var editor1 = K.create('textarea[name="msgContent"]',{
			    width:700,
				height:400,
				cssPath : '../plugins/code/prettify.css',
				uploadJson : '<%=basePath%>upload/upBatch_uploadBatch.asp',
				fileManagerJson : '<%=basePath%>upload/upBatch_viewFiles.asp',
				allowFileUpload:true,
				allowFileManager : true
			});
		});
	</script>
</head>
<body>
	<form name="addForm" action="message_addMsg.asp" method="post" >
		<textarea name="msgContent" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea>
		<br />
		<input type="submit" name="button" value="提交内容" />
	</form>
</body>
</html>
<%!
private String htmlspecialchars(String str){
	str = str.replaceAll("&", "&amp;");
	str = str.replaceAll("<", "&lt;");
	str = str.replaceAll(">", "&gt;");
	str = str.replaceAll("\"", "&quot;");
	return str;
}
%> 