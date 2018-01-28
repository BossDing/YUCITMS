<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
    String basePath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学习与交流</title>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bbs.css" />
<script type="text/javascript" src="<%=basePath%>/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/layer/layer.min.js"></script>
<script type="text/javascript">
  function closeWindow () {
      layer.closeAll();
      location.reload();
  }
$(document).ready(function(){
    $(".operator").click(function(){
        if (this.title == 'more') {
            $(this).parent().css("height","auto");
            this.title = 'less';
            this.innerHTML = '口';
        } else if (this.title == 'less'){
            $(this).parent().css("height","40px");
            this.title = 'more';
            this.innerHTML = '-';
        }
    });
    
    $('#createQuestion').click(function(){
        $.layer({
  		  type: 2,
		  title: '提问',
		  shadeClose: true,
		  shade: 0.8,
		  offset: ['50px','30%'],
		  shade:[0.5,'#CCFFEE'],
		  border:[1],
		  area: ['670px', '450px'],
		  iframe: {
		      src: '<%=basePath%>/bbs_addPostPage.asp',
		      scrolling: 'no'
		  } 
           });
    });
});
</script>
<style type="text/css">
  html,header,body {
    padding:0px;
    margin:0px;
  }
</style>
</head>
<body>
    <header class="head box-shdow bg-style">
        <div>
            <img alt="" src="<%=basePath%>/images/bbs_icon.png" />
        </div>
        <div class="center">
            <img id="myquestion" style="cursor: pointer;" onclick="javascript:location.href='<%=basePath%>/bbs_myPosts.asp'" src="<%=basePath%>/images/my_question.png" />
            <img id="createQuestion" style="cursor: pointer;" src="<%=basePath%>/images/create_question.png" />
        </div>
    </header>
    <c:forEach var="entity" items="${etyList}">
        <div class="font-style box-shdow question-title">
            <div>
                <h2>${entity.title}</h2>
                <div class="post-content"><p>${entity.content}</p></div>
                <div style="text-align:right;">
                  <span>创建时间</span>
                  <em>${entity.createTime}</em>
                  <span>回复数量</span>
                  <em>${entity.respCount}</em>
                  </div>
            </div>
            <div><span class="resp-content">回复内容</span></div>
                <c:choose>
                   <c:when test="${empty entity.responses}"> 
                     <div style="text-align:right;">
                      <em style="color:red;font-size:10pt;">尚未有人回复！</em>
                     </div>
                   </c:when>
                   <c:otherwise>
                    <c:forEach var="resp" items="${entity.responses}">
                      <div>
                        <div><p>${resp.content}</p></div>
                          <div style="text-align:right;">
                            <span>回复者：${resp.userName}</span>
                            <span>|</span>
                            <span>回复时间：${resp.responseTime}</span>
                        </div>
                      </div>
                      </c:forEach>
                   </c:otherwise>
                </c:choose> 
                <hr />
        </div>
    </c:forEach>
    <div class="page-area">
        <aug:pager page="${page}" />
    </div>
    <footer>zzuli.edu.cn 学习交流</footer>
</body>
</html>