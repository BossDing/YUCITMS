<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
    String basePath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习与交流</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/bbsStyle/css/bbs.css" />
<script type="text/javascript" src="bbsStyle/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=basePath%>/bbsStyle/js/layer/layer.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/editor/kindeditor.js"></script>
<script type="text/javascript">
KE.show({
    id : 'content7',
    cssPath : './index.css'
});
</script>
</head>
<body>
    <header class="head box-shdow bg-style">
        <div>
            <img alt="" src="<%=basePath%>/bbsStyle/images/bbs_icon.png" />
        </div>
    </header>
    <div class="font-style box-shdow">
        <div class="question-title">
            <div>
                <h2>${title}</h2>
            </div>
            <div style="text-align:right;">
                <span>发表于<em class="font-color">${createTime}</em></span>
                <span>共<em class="font-color">${respCount}</em>次回复</span>
                <span>|</span>
                <span><em class="font-color">作者：${userName}</em></span>
            </div>
        </div>
        <div>
            <div class="resp-top">
                <span class="resp-content">内容</span>
            </div>
            <div class="resp-top">
                <div style="padding:5px;font-size:14px;font-weight:bold;background:white;overflow:hidden;">${content}</div>
            </div>
        </div>
    </div>
    <hr />
    <div class="resp-top">
        <span class="resp-content">回复内容</span>
    </div>
    <div class="min-height font-style box-shdow">
        <c:forEach var="resp" items="${recordList}">
            <div class="resp-top padding-5 bg-white">
                <span style="display:block;width:70%;min-width:200px;font-size:12px;font-family:Arial;min-height:20px;">${resp.content}</span>
                <span style="display:block;text-align: right;padding:5px;">
                    <em>${responseTime}</em>
                    <span>|</span>
                    <em>${userName}</em>
                    <c:if test="${resp.userName eq user.account}">
                    <span class="delete-btn" onclick="location.href='bbs_deleteResp.asp?resp.id=${resp.id}&&resp.post.id=${post.id}'">删除</span>
                </c:if>
                </span>
            </div>
        </c:forEach>
    </div>
      <s:form action="bbs_findRespData?id=%{id}" name="page">
    <%@include file="../common/bbsPagebean.jspf" %>
    </s:form>
    <div class="font-style resp-top resp-form">
            <form action="bbs_addResp.action?id=${id}" method="post">
                <jsp:include page="edit-area.jsp"></jsp:include>
                <div>
                    <textarea id="content7" name="content" style="width:800px;height:280px;visibility:hidden;"></textarea>
                </div>
                <div style="text-align:right;">
                </div>
                <div style="padding:20px;"><input type="submit" class="bg-blue resp-btn" value="回复" /></div>
            </form>
    </div>
    <footer>zzuli.edu.cn 学习交流</footer>
</body>
</html>