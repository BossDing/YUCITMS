<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/new_style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/select.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/jquery-ui.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
<script src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery-ui.js"></script>
<script type="text/javascript">
function getDel(k,id) {
	if(confirm('确定要移除本题吗？')){
		var url="paper_deleteQuestion.action";
		var date={"questionId":id};
    $.post(url,date,function(result){
    	if(result=='true'){
	    $(k).parent().remove();    		
    	}
    });		
	}	
}

function sumf(){
	var zongfen=0;
	var fenzhi=document.getElementsByName("fenzhi");
	for(var i=0;i<fenzhi.length;i++){//
		zongfen+=Number(fenzhi[i].value);
	}
	var sumfz=document.getElementById("sum");
	sumfz.value=zongfen;
}
function load(){
	var index = layer.load(1, {
		  shade: [0.1,'#fff'] //0.1透明度的白色背景
		});
}
</script>
<style>
  #sortable { list-style-type: none; margin: 0; padding: 0; width: 60%; }
  #sortable tr { margin: 0 3px 3px 3px; padding: 0.4em; padding-left: 1.5em; font-size: 1.4em; height: 18px; }
  </style>
  <script>
  $(function() {
    $( "#sortable" ).sortable();
    $( "#sortable" ).disableSelection();
  });
  </script>
</head>


<body>

	<div class="place">
    <span>拖动排序</span>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">    
    <form action="paper_qusetionSort.action?qgroupingId=${qgroupingId}&paperId=${paperId}" method="post" target="rightFrame">
    <table class="tablelist">
    	<thead>
    	<tr>
        <th>编号<i class="sort"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/px.gif" /></i></th>
        <th>题型</th>
        <th>试题内容</th>
        <th>分值</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody id="sortable">
       
        <s:iterator value="questions">
        
        <tr class="ui-state-default">
        <td style="display:none;"><input type="text" name="questionIds" value="${id}"/></td>
        <td>${id}</td>
        <td>
        <s:if test="type=='tiankong'">填空</s:if>
        <s:elseif test="type=='danxuan'">单选</s:elseif>
        <s:elseif test="type=='duoxuan'">多选</s:elseif>
        <s:elseif test="type=='tiankong'">填空</s:elseif>
        <s:elseif test="type=='jianda'">简答</s:elseif>
        </td>
        <td>
        <s:if test="%{questions.length()>10}">
        ${fn:substring(questions,0,10)}...
        </s:if>
        <s:else>
        ${questions}
        </s:else>
        </td>
        <td><input type="text" name="fenzhi" class="dfinput"   required="required" value="${fenzhi}" onblur="sumf();"/></td>
        <td onclick="getDel(this,'${id}')">删除</td>
        </tr>   
        </s:iterator>  
        <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td>总分：<input id="sum" name="sumScore" value="${sumScore}" readonly="readonly"/></td>
        </tr>   
        </tbody>
        
    </table>
    <input value="确定" type="submit" class="scbtn" onclick="load()"/>
     </form>
    
    </div>
    
   <%--  <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script> --%>
	</div>
</body>


</html>
