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
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>
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
	
	function show(content,a,b,c,d,answer,parse){
		layer.open({
			  type: 1,
			  skin: 'layui-layer-rim', //加上边框
			  area: ['420px', '240px'], //宽高
			  content: content+'<hr />A：'+a+'<hr />B：'+b+'<hr/>C：'+c+'<hr/>D：'+d+'<hr/>答案：'+answer+'<hr/>解析：'+parse
			});	
	}
	
	function update(url) {
		layer.open({
			  type: 2,
			  title: '修改页',
			  shadeClose: true,
			  shade: 0.8,
			  area: ['900px', '500px'],
			  content: url //iframe的url
			}); 
	}
	
	//批量操作
	function aa(url,hint,utype){
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
        		 window.location.href=url+"?"+ss+"qtype=${qtype}&utype="+utype+"&pageNum=${pageNum}";
        	   }
        }
	}
	//批量导出
	function ex(url,hint,utype) {
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
        	if(confirm("共"+'${recordCount}'+"条记录，确定要导出全部吗？"))
     	   {
     		
     		 window.location.href=url+"?"+ss+"qtype=${qtype}&utype="+utype+"&pageNum=${pageNum}";
     		
     	   }
        }else{
        	 if(confirm("你选中了"+flag+"个，确定要"+hint+"吗？"))
        	   {
        		 
        		 window.location.href=url+"?"+ss+"qtype=${qtype}&utype="+utype+"&pageNum=${pageNum}";
        		
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
    <li><a href="#">试题</a></li>
    <li><a href="#">试题管理</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    <%@include file="head.jsp" %>
    
    <table class="tablelist">
    	<thead>
    	<tr>
        <th><input name="" type="checkbox" value="" onclick="checkAll(this)"/></th>
        <th>编号<i class="sort"><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/px.gif" /></i></th>
        <th>题型</th>
        <th>状态</th>
        <th>试题内容</th>
        <th>创建人</th>
        <th>最后更新</th>
        <th>操作</th>
        </tr>
        </thead>
        <tbody>
       
        <s:iterator value="recordList">
        <tr>
        <td><input name="check" type="checkbox" value="${id}" /></td>
        <td>${id}</td>
        <td>多选题</td>
        <td>
        <s:if test="%{state==true}">
                   启用
        </s:if>
        <s:else>禁用</s:else>
        </td>
        <td onclick="show('${id}、${questions_DXS}','${A}','${B}','${C}','${D}','${answer_DXS}','${parse}');">
        <s:if test="%{questions_DXS.length()>10}">
        ${fn:substring(questions_DXS,0,10)}...
        </s:if>
        <s:else>
        ${questions_DXS}
        </s:else>
        </td>
        <td>${teacher.teacherName}</td>
        <td><s:date name="createDate"  format="yyyy-MM-dd HH:mm:ss"/></td>
        <td>     <a onclick="update('question_updateDuoXuanPage.action?id=${id}&pageNum=${pageNum}');" class="tablelink">编辑</a></td>
        </tr>   
        </s:iterator>     
        </tbody>
    </table>
     
    <s:form action="questionManager_getDXSquestionList" name="page">
	   <%@include file="../../../common/questionManagerpagebean.jspf" %>
      </s:form>
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
	</div>
</body>


</html>
