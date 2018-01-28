<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/excellentCourseStyle/css/select.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.idTabs.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/select-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/editor/kindeditor.js"></script>
    <script>
function sel_div(t) {
    var index = t.selectedIndex;
    for(var i=1;i<t.length;i++) {
        if(t.options[i].value == t.options[index].value){
            document.getElementById(t.options[index].value).style.display="block";
        }else{
            document.getElementById(t.options[i].value).style.display="none";
        }

    }
}

</script>
<script type="text/javascript">
    KE.show({
        id : 'content7',
       
    });
       KE.show({
        id : 'content',
       
    });
     KE.show({
        id : 'danxuan',
       
    });
    KE.show({
        id : 'danxuanA',
       
    });
    KE.show({
        id : 'danxuanB',
       
    });
    KE.show({
        id : 'danxuanC',
       
    });
    KE.show({
        id : 'danxuanD',
       
    });
     KE.show({
        id : 'danxuanAn',
       
    });
     
     
    KE.show({
        id : 'duoxuan',
       
    });
    
    KE.show({
        id : 'duoxuanA',
       
    });
    KE.show({
        id : 'duoxuanB',
       
    });
    KE.show({
        id : 'duoxuanC',
       
    });
    KE.show({
        id : 'duoxuanD',
       
    });
     KE.show({
        id : 'duoxuanAn',
       
    });
    KE.show({
        id : 'panduanA',
       
    });
     KE.show({
        id : 'panduanB',
       
    });
      KE.show({
        id : 'jiandaA',
       
    });
    KE.show({
        id : 'jiandaB',
       
    });
    KE.show({
        id : 'jiandaC',
       
    });
    function tk(){
    	form1.action="question_addTianKong.action";
    }
    function dx(){
    	form1.action="question_addDanXuan.action";
    }
    function dxs(){
    	form1.action="question_addDuoXuan.action";
    }
    function pd(){
    	form1.action="question_addPanDuan.action";
    }
    function jd(){
    	form1.action="question_addJianDa.action";
    }
  </script>
  
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
			<li><a href="#">试题</a></li>
			<li><a href="#">添加试题</a></li>
    	</ul>
    </div>
    <form name="form1" method="post">
    <div class="formbody">
    
    
    <div id="usual1" class="usual"> 
    
    <div class="itab">
  	<ul> 
    <li><a href="#tab1" class="selected">发布通知</a></li> 
  
  	</ul>
    </div> 
    
  	<div id="tab1" class="tabson">
    
    <div class="formtext">Hi，<b>admin</b>，欢迎您添加试题！</div>
    <ul class="forminfo">
    	<li><label>试题难度<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <s:select list="difficulties" cssClass="select2" name="difficultyId" listKey="id" listValue="difficulty"
    />
    </div>
    <label>试题来源<b>*</b></label>
    <div class="cityright">
     <s:select list="sources" cssClass="select2" name="sourceId" listKey="id" listValue="source"
    />
    </div>
    <label>试题分类<b>*</b></label>
    <div class="cityright">
    <s:select list="classifies" cssClass="select2" name="classifyId" listKey="id" listValue="classify"
    />
    </div>
    </div>
    
    
    
    </li>
    <li><label>试题类型<b>*</b></label>
    
    <div class="usercity">
    
    <div class="cityleft">
    <select class="select2" iname="sel" id="sel" onchange="sel_div(this)" >
    	<!-- <option value="请选择">请选择</option> -->
     <option>请选择</option>
    <option value="d_1">填空题</option>
    <option value="d_2">单选题</option>
    <option value="d_3">多选题</option>
    <option value="d_4">判断题</option>
    <option value="d_5">简答题</option>
    </select>
    </div>
    <label>所属分组<b>*</b></label>
    <div class="cityright">
     <s:select list="groupings" cssClass="select2" name="groupingId" listKey="id" listValue="grouping"
    />
    </div>
    <label>试题状态<b>*</b></label>
    <div class="cityright">
    <select class="select2" name="state">
    <option value="true">启用</option>
    <option value="false">禁用</option>
    </select>
    </div>
    </div>
    
    
    
    </li>
    <!--
    	作者：javafengyu@163.com
    	时间：2016-07-13
    	描述：填空题开始
    -->
  <div id="d_1" style="display:none">
    <li><label>试题描述<b>*</b></label><s:textarea id="content7" name="tianKong.questions_TK" cssStyle="width:700px;height:140px;visibility:hidden;"></s:textarea></li>   
    </li>
    <li><label>答案解析<b>*</b></label>
    <s:textarea id="content" name="tianKong.answer_TK" cssStyle="width:700px;height:140px;visibility:hidden;"></s:textarea>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" onclick="tk();" class="btn" value="保存" style="width: 50px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><input name="" type="button" class="btn" value="保存并关闭" "/></li>
</div>
<!--
	作者：javafengyu@163.com
	时间：2016-07-13
	描述：单选题开始
-->
 <div id="d_2" style="display:none">
 	 <li><label>试题描述<b>*</b></label><textarea id="danxuan" name="danXuan.questions_DX" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项A：<b>*</b><input type="radio" name="danXuan.answer_DX" value="A"></label><textarea id="danxuanA" name="danXuan.A" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项B：<b>*</b><input type="radio" name="danXuan.answer_DX" value="B"></label><textarea id="danxuanB" name="danXuan.B" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项C：<b>*</b><input type="radio" name="danXuan.answer_DX" value="C"></label><textarea id="danxuanC" name="danXuan.C" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项D：<b>*</b><input type="radio" name="danXuan.answer_DX" value="D"></label><textarea id="danxuanD" name="danXuan.D" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>答案解析<b>*</b></label>
    <textarea id="danxuanAn" name="danXuan.parse" style="width:700px;height:140px;visibility:hidden;"></textarea>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" onclick="dx();" class="btn" value="保存" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><input name="" type="button" class="btn" value="保存并关闭" "/></li>
 	
 	
 </div>
 <!--
 	作者：javafengyu@163.com
 	时间：2016-07-13
 	描述：多选题开始
 -->
 <div id="d_3" style="display:none">
 	 <li><label>试题描述<b>*</b></label><textarea id="duoxuan" name="duoXuan.questions_DXS" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项A：<b>*</b><input type="checkbox" name="duoxuan" value="A"></label><textarea id="duoxuanA" name="duoXuan.A" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项B：<b>*</b><input type="checkbox" name="duoxuan" value="B"></label><textarea id="duoxuanB" name="duoXuan.B" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项C：<b>*</b><input type="checkbox" name="duoxuan" value="C"></label><textarea id="duoxuanC" name="duoXuan.C" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>选项D：<b>*</b><input type="checkbox" name="duoxuan" value="D"></label><textarea id="duoxuanD" name="duoXuan.D" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
    <li><label>答案解析<b>*</b></label>
    <textarea id="duoxuanAn" name="duoXuan.parse" style="width:700px;height:140px;visibility:hidden;"></textarea>
    </li>
    <li><label>&nbsp;</label><input name="" type="submit" onclick="dxs();" class="btn" value="保存" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><input name="" type="button" class="btn" value="保存并关闭" "/></li>
 	
 	
 </div>
 <!--
 	作者：javafengyu@163.com
 	时间：2016-07-13
 	描述：判断题
 -->
 <div id="d_4" style="display:none">
 	<li><label>试题描述<b>*</b></label><textarea id="panduanA" name="panDuan.questions_PD" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
   
     <li><label>答案</label><cite><input name="panDuan.answer_PD" type="radio" value="1" />对&nbsp;&nbsp;&nbsp;&nbsp;<input name="panDuan.answer_PD" type="radio" value="0" />错</cite></li> 
 <li><label>试题解析<b>*</b></label><textarea id="panduanB" name="panDuan.parse" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
     <li><label>&nbsp;</label><input name="" type="submit" onclick="pd();" class="btn" value="保存" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><input name="" type="button" class="btn" value="保存并关闭" "/></li>
 </div>
 <!--
 	作者：javafengyu@163.com
 	时间：2016-07-13
 	描述：简答题
 -->
 <div id="d_5" style="display:none">
 	<li><label>试题描述<b>*</b></label><textarea id="jiandaA" name="jianDa.questions_JD" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
   
    <li><label>试题答案<b>*</b></label><textarea id="jiandaB" name="jianDa.answer_JD" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
 <li><label>试题解析<b>*</b></label><textarea id="jiandaC" name="jianDa.parse" style="width:700px;height:60px;visibility:hidden;"></textarea></li>   
    </li>
     <li><label>&nbsp;</label><input name="" type="submit" onclick="jd();" class="btn" value="保存" style="width: 80px;"/>&nbsp&nbsp&nbsp&nbsp<label>&nbsp;</label><input name="" type="button" class="btn" value="保存并关闭" "/></li>
 </div>
    </ul>
    
    </div> 
    
    
  
       
	</div> 
 
	<script type="text/javascript"> 
      $("#usual1 ul").idTabs(); 
    </script>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>
    
    

    
    
    </div>
</form>

</body>

</html>
