<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String basePath = request.getContextPath();
%>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/excellentCourseStyle/editor/kindeditor.js"></script>
<script type="text/javascript">
KE.show({
    id : 'content7',
    cssPath : './index.css'
});
function postType(obj) {
	if(obj.value==-1){
		$("#postType").removeAttr("hidden");
	}else{
		$("#postType").attr("hidden","hidden");
	}
}
</script>
<style>
    form {
        font-size: 12px;
        font-family: Arial;
    }
    .header {
        padding: 10px;
    }
    .header>* {
        display: inline-block;
    }
    input[type='submit'] {
        width: 60px;
        height: 25px;
        background: #64D2F2;
    }
    .button {
        padding: 10px;
        text-align: right;
    }
    select {
        width: 100px;
    }
    dl {
      position:absolute;
      margin: 0px;
      width: 100%;
      padding: 0px;
    }
    
    dl dd {
      height: 20px;
    border-bottom: 1px solid #64D2F2;
    cursor: pointer;
    list-style: none;
    text-align: center;
    background: #dddddd;
    width: 100%;
    padding: 0px;
    margin: 0px;
    }
</style>
 <div><em><s:fielderror cssStyle="color:red;font-size:8pt;"/></em></div>
<form action="bbs_addPost.action" method="post" target="_top">
    <div class="header">
       <label>标题：</label>
       <input type="text" name="title" />
       <label>问题类型：</label>
       <div style="position:relative">
       <select id="postTypeId" name="postTypeId">
       <s:iterator value="#types">
       <option onclick="postType(this);" value="${id}">${name}</option>
       </s:iterator>
       <option onclick="postType(this);" value="-1">其他</option>
       </select>
          <input id="postType"  type="text" name="postTypeName" hidden="hidden"/>
          <dl id="postTypeData"></dl>
       </div>
    </div>
    <div>
        <textarea id="content7" name="content" style="width: 650px; height: 320px; visibility: hidden;"></textarea>
    </div>
    <div class="button">
        <input type="submit" value="发布" />
    </div>
</form>


