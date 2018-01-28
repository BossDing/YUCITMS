<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/new_style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>


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

	function checkAll(field){
	//根据checkbox框的名称，查询得到所有的checkbox对象
	var idCheckboxs = document.getElementsByName("check");
	for(var i=0; i<idCheckboxs.length; i++){
		//判断顶上那个checkbox框的选中状态
		if(field.checked){
			idCheckboxs[i].checked = true;
		}else{
			idCheckboxs[i].checked = false;
		}
	}
}
	//批量操作
	function batch(url,hint,utype){
		var aa = document.getElementsByName("check");
        var ss = "";
        var flag=0;
        for (var i = 0; i < aa.length; i++) {
            if (aa[i].checked) {
            	ss +="ids="+aa[i].value+"&";
            	++flag;
            }
        }  
        if(flag==0){
        	alert("请至少选择一个，进行操作");
        }else{
        	 if(confirm("你选中了"+flag+"个，确定要"+hint+"吗？"))
        	   {
        		 window.location.href=url+"?"+ss+"utype="+utype+"&pageNum=${pageNum}";
        	   }
        }
	}
</script>

</head>


<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">考试管理</a></li>
    <li><a href="#">试卷</a></li>
    <li><a href="#">试卷管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    <form action="paper_getExamPaperList.action" method="post">
     <ul class="seachform">
    
    <li><label>试卷编号</label><s:textfield name="paperId" type="text" cssClass="scinput" /></li>
    <li><label>试卷难度</label>  
    <div class="vocation">
    <s:select cssClass="select3" list="paperClassifies" listKey="id" listValue="paperClassify"/>
    </div>
    </li>
    
    <li><label>试卷来源</label>  
    <div class="vocation">
    <s:select cssClass="select3" list="paperSources" listKey="id" listValue="paperSource"/>
    </div>
    </li>
    
    <li><label>试卷分类</label>  
    <div class="vocation">
    <s:select cssClass="select3" list="paperGroupings" listKey="id" listValue="paperGrouping"/>
    </div>
    </li>
    
    
    
    </ul>
      <ul class="seachform" style="float: left;">
    
    <li><label>试卷名称</label><s:textfield name="paperName" type="text" cssClass="scinput" /></li>
    <li><label>状态</label>  
    <div class="vocation">
    <s:select list="#{true:'启用',false:'禁用'}" cssClass="select3" name="paperstate" />
    </div>
    </li>
    
 <li><label>创建人</label><input name="" type="text" class="scinput" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="搜索"/></li>
    <li><label>&nbsp;</label><input name="" type="reset" class="scbtn" value="重置"/></li>
    
    </ul>
 </form>
   <div class="tools">
    
    	<ul class="toolbar">
        <li onclick="batch('paper_batch.action','启用','enabled');"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t02.png" /></span>启用</li>
        <li onclick="batch('paper_batch.action','禁用 ','disable');"><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t03.png" /></span>禁用</li>
      </ul>
    
    </div>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" onclick="checkAll(this)"/></th>
        <th>编号<i class="sort"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/px.gif" /></i></th>
        <th>试卷名称</th>
        <th>试卷总分</th>
        <th>及格分</th>
        <th>状态</th>
        <th>创建人</th>
        <th>最后更新</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       
        <s:iterator value="recordList">
        <tr>
        <td><input id="check" name="check" type="checkbox" value="${id}" /></td>
        <td>${id}</td>
        <td>${paperName}</td>
        <td>${zongScore}</td>
        <td>${jigeScore}</td>
        <td>${state}</td>
        <td>${teacher.teacherName}</td>
        <td>${createDate}</td>
        <td>
        <a href="paper_updatePaperPage.action?paperId=${id}" class="tablelink">修改</a>
        <a href="paper_seePaperQuestion.action?paperId=${id}" class="tablelink">编辑试题</a>
        <a href="paper_exportPaper.action?paperId=${id}" class="tablelink">导出试卷</a>
        </td>
        </tr>        
        </s:iterator>
        </tbody>
    </table>
    <s:form action="paper_getExamPaperList" name="page">
	   <%@include file="../../../common/questionManagerpagebean.jspf" %>
      </s:form>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</div>
</body>

</html>
