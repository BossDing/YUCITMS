<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<form action="paper_search.action" method="post">
     <ul class="seachform">
    
    <li><label>试题编号</label><s:textfield name="id" type="text" id="zhu" cssClass="scinput" /></li>
    <li><label>试题难度</label>  
    <div class="vocation">
     <s:select list="difficulties" cssClass="select2" name="difficultyId" listKey="id" listValue="difficulty"
    />
    </div>
    </li>
    
    <li><label>试题来源</label>  
    <div class="vocation">
    <s:select list="sources" cssClass="select2" name="sourceId" listKey="id" listValue="source"
    />
    </div>
    </li>
    
    <li><label>试题分类</label>  
    <div class="vocation">
    <s:select list="classifies" cssClass="select2" name="classifyId" listKey="id" listValue="classify"
    />
    </div>
    </li>
    
    
    
    </ul>
      <ul class="seachform" style="float: left;">
    
    <li><label>试题内容</label><s:textfield name="questionContent" type="text" cssClass="scinput" /></li>
    <li><label>题型</label>  
    <div class="vocation">
    <select class="select3" id="select3" name="questionType">
    <s:if test="%{qtype=='tiankong'}">
    <option value="tiankong" selected="selected">填空题</option>
    </s:if><s:else>
     <option value="tiankong">填空题</option>
    </s:else>
    
    <s:if test="%{qtype=='danxuan'}">
  <option value="danxuan" selected="selected">单选题</option>
    </s:if><s:else>
     <option value="danxuan">单选题</option>
    </s:else>
    
    <s:if test="%{qtype=='duoxuan'}">
  <option value="duoxuan" selected="selected">多选题</option>
    </s:if><s:else>
     <option value="duoxuan">多选题</option>
    </s:else>
    
    <s:if test="%{qtype=='panduan'}">
  <option value="panduan" selected="selected">判断题</option>
    </s:if><s:else>
     <option value="panduan">判断题</option>
    </s:else>
    
    <s:if test="%{qtype=='jianda'}">
  <option value="jianda" selected="selected">简答题</option>
    </s:if><s:else>
     <option value="jianda">简答题</option>
    </s:else>
 </select>
    </div>
    </li>
 <li><label>创建人</label><input name="" type="text" class="scinput" /></li>
    <li><label>&nbsp;</label><input name="" type="submit" class="scbtn" value="搜索"/></li>
    <li><label>&nbsp;</label><input name="" type="reset" class="scbtn" value="重置"/></li>
    
    </ul>
 </form>
   <div class="tools">
        <ul class="toolbar1">
        <a href="paper_getTKquestionList.action?qgroupingId=${qgroupingId}"><li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>填空题</li></a>
        <a href="paper_getPDquestionList.action?qgroupingId=${qgroupingId}"><li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>判断题</li></a>
        <a href="paper_getDXquestionList.action?qgroupingId=${qgroupingId}"><li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>单选题</li></a>
       <a href="paper_getDXSquestionList.action?qgroupingId=${qgroupingId}"><li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>多选题</li></a>
        <a href="paper_getJDquestionList.action?qgroupingId=${qgroupingId}"><li><span><img src="${pageContext.request.contextPath}/excellentCourseStyle/images/t05.png" /></span>简答题</li></a>
       </ul>
    
    </div>