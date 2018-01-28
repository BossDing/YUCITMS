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
<script type="text/javascript" src="<%=basePath%>/bbsStyle/js/jquery-1.11.0.js"></script>
<script type="text/javascript" src="<%=basePath%>/bbsStyle/js/layer/layer.min.js"></script>
<script>
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
                $("#search").click(function(){
                	document.findForm.submit();
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
            		      src: '<%=basePath%>/bbs_addPostPage.action',
            		      scrolling: 'no'
            		  } 
                       });
                });
                
                $.getJSON('bbs_getTodayPostsNumber.action',function(data) {
                    $('#today').text(data.today);
                    $('#yesterday').text(data.yesterday);
                    $('#newresp').text(data.newresp);
                });
				
            });
            function openUrl(url) {
                window.open(url);
            }
        </script>
</head>
<body>
    <header class="head box-shdow bg-style">
        <div>
            <img alt="" src="<%=basePath%>/bbsStyle/images/bbs_icon.png" />
        </div>
        <div class="center">
            <form name="findForm" action="bbs_index.action" method="post">
                <span>
                  <input type="text" name="name" class="area-style search-area" placeholder="请输入问题类型" />
                  <img id="search" style="cursor: pointer;" src="<%=basePath%>/bbsStyle/images/search_btn.png" />
                </span>
            </form>
            <img id="myquestion" style="cursor: pointer;" onclick="javascript:location.href='<%=basePath%>/bbs_myPosts.asp'" src="<%=basePath%>/images/my_question.png" />
            <img id="createQuestion" style="cursor: pointer;" src="<%=basePath%>/bbsStyle/images/create_question.png" />
        </div>
    </header>
    <div class="title-block box-shdow font-style">
        <img src="<%=basePath%>/bbsStyle/images/title_icon.png" />
        <a href="bbs_index.action"> <span>全部</span></a><span>|</span>
        <a href="bbs_todayBbs.action"><span>今日:<label id="today"></label></span></a><span>|</span>
        <a href="bbs_yesterday.action"><span>昨日:<label id="yesterday"></label></span></a><span>|</span>
        <a href="bbs_newResp.action"><span>new回复:<label id="newresp"></label></span></a>
        <span enabled style="float: right; width: 270px"> <iframe width="250" scrolling="no"
                height="20" frameborder="0" allowtransparency="true"
                src="http://i.tianqi.com/index.php?c=code&id=1&bgc=%23FFFFFF&icon=1&num=1"
            ></iframe>
        </span>
    </div>
            <c:forEach var="post" items="${recordList}" varStatus="status">
                <div class="content" title="点击查看详情">
                    <span><c:if test="${status.count<11}">0</c:if>${status.count}</span>
                    <span onclick="openUrl('bbs_findRespData_update.action?id=${post.id}');" class="title-content">${post.title}</span>
                    <span class="suffix">
                        <span title="回复数">${post.respCount}</span>
                        <span>|</span>
                        <span title="发表时间" style="color:#64D2F2">${post.createTime}</span>
                        <span>|</span>
                        <span title="提问者">${post.userName}</span>
                    </span>
                </div>
                <hr />
            </c:forEach>
    <s:form action="bbs_yesterday" method="post" name="page">
    <%@include file="../common/bbsPagebean.jspf" %>
    </s:form>
    <footer>zzuli.edu.cn 学习交流</footer>
</body>
</html>