<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>通讯录</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/leftico01.png" /></span>试题
    </div>
    	<ul class="menuson">
      
        <li class="active"><cite></cite><a href="question_addQuestionPage.action" target="rightFrame">添加试题</a><i></i></li>
    
        <li><cite></cite><a href="questionManager_getTKquestionList.action" target="rightFrame">试题管理</a><i></i></li>
         <li><cite></cite><a href="../Examination/question/importquestion.html" target="rightFrame">试题导入</a><i></i></li>
        </ul>    
    </dd>
        
    
    <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/leftico02.png" /></span>试卷
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="paper_getPaperList.action" target="rightFrame">添加试卷</a><i></i></li>
        <li><cite></cite><a href="paper_getExamPaperList.action" target="rightFrame">试卷管理</a><i></i></li>
    
        </ul>     
    </dd> 
     <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/leftico02.png" /></span>考试
    </div>
    <ul class="menuson">
        <li><cite></cite><a href="../Examination/exam/addexam.html" target="rightFrame">添加考试</a><i></i></li>
        <li><cite></cite><a href="../Examination/exam/exammanager.html" target="rightFrame">考试管理</a><i></i></li>
        <li><cite></cite><a href="../Examination/exam/examscore.html" target="rightFrame">考试成绩</a><i></i></li>
        <li><cite></cite><a href="../Examination/exam/markexam.html" target="rightFrame">人工评卷</a><i></i></li>
        <li><cite></cite><a href="../Examination/exam/exammonitor.html" target="rightFrame">考试监控</a><i></i></li>
        <li><cite></cite><a href="../Examination/exam/examcheck.html" target="rightFrame">考试审批</a><i></i></li>
        </ul>     
    </dd> 
    
     <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/leftico01.png" /></span>试题属性配置
    </div>
    	<ul class="menuson">
      
        <li class="active"><cite></cite><a href="qdifficulty_getDifficultyList.action" target="rightFrame">试题难度</a><i></i></li>
    
        <li><cite></cite><a href="source_getSourceList.action" target="rightFrame">试题来源</a><i></i></li>
         <li><cite></cite><a href="classify_getClassifyList.action" target="rightFrame">试题分类</a><i></i></li>
         <li><cite></cite><a href="grouping_getGroupingList.action" target="rightFrame">所属分组</a><i></i></li>
        </ul>    
    </dd>
   
   <dd>
    <div class="title">
    <span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/leftico01.png" /></span>试卷属性配置
    </div>
    	<ul class="menuson">
      
        <li class="active"><cite></cite><a href="papegClassify_getPaperClassifyList.action" target="rightFrame">试卷分类</a><i></i></li>
        <li><cite></cite><a href="paperGrouping_getPaperGroupingList.action" target="rightFrame">试卷分组</a><i></i></li>
         <li><cite></cite><a href="paperSource_getPaperSourceList.action" target="rightFrame">试卷来源</a><i></i></li>
        </ul>    
    </dd>
    </dl>
    
</body>
</html>
