<%@page import="com.yucitms.config.Config"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link
	href="${pageContext.request.contextPath}/excellentCourseStyle/css/style.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/excellentCourseStyle/css/dialog.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath}/excellentCourseStyle/css/normalize.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jsapi.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/format+zh_CN,default,corechart.I.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.gvChart-1.0.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/excellentCourseStyle/js/jquery.ba-resize.min.js"></script>
<script
	src="${pageContext.request.contextPath}/excellentCourseStyle/layer/layer.js"></script>

<script type="text/javascript">
	gvChartInit();
	jQuery(document).ready(function() {

		jQuery('#myTable5').gvChart({
			chartType : 'PieChart',
			gvSettings : {
				vAxis : {
					title : 'No of players'
				},
				hAxis : {
					title : 'Month'
				},
				width : 650,
				height : 250
			}
		});
	});
	function dialog(url, name, jobTitle, text, id) {
		$(".tip").fadeIn(200);

		$(".tiptop a").click(function() {
			$(".tip").fadeOut(200);
		});

		$(".sure").click(function() {
			$(".tip").fadeOut(100);
			//  window.location.href="excellentTeacher_updateExcellentTeacherPage.action?id="+id; 
		});

		$(".cancel").click(function() {
			$(".tip").fadeOut(100);
			//  window.location.href="excellentTeacher_deleteExcellentTeacherPage.action?id="+id; 
		});
		img1.src = url;
		p1.innerHTML = name + "-" + jobTitle;
		cite1.innerHTML = text;
		/*   $(".update").click(function(){
			 
		  });
		  $(".del").click(function(){
			 
		  }); */
	}

	function dialogtext(text) {
		layer.open({
			type : 1,
			skin : 'layui-layer-rim', //加上边框
			area : [ '420px', '240px' ], //宽高
			content : text
		});
	}

	function book(url, name, jobTitle, text) {
		layer.open({
			type : 1,
			area : [ '600px', '360px' ],
			shadeClose : true, //点击遮罩关闭
			content : '\<\div style="padding:20px;">\<\/div>'
		});
	}
	function tishi(text, id) {
		layer.tips(text, "#" + id);
	}
	function video(url) {
		layer.open({
			type : 2,
			title : false,
			area : [ '830px', '660px' ],
			shade : 0.8,
			closeBtn : 1,
			shadeClose : true,
			content : url
		});

	}
	function img() {
		layer.photos({
		    photos: '#layer-photos-demo' ,
		    area:['700px','auto'],       
	    	closeBtn:1,

		  });
	}
</script>
</head>


<body>

	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="course_getCourseList.action">首页</a></li>
			<li><a href="#">工作台</a></li>
		</ul>
	</div>


	<div class="mainbox">

		<div class="mainleft">


			<div class="leftinfo">
				<div class="listtitle">
					<a href="#" class="more1"></a>教学进度
				</div>

				<div class="newlist">${scheduling}</div>

			</div>
			<!--leftinfo end-->


			<div class="leftinfos">


				<div class="infoleft">

					<div class="listtitle">
						<%-- <a href="difficulty_addDifficultyGuidancePage.action?courseId=${id}" >添加</a> --%>
						<a
							href="difficulty_getDifficultyGuidanceList.action?courseId=${id}"
							class="more1">更多</a>重难点指导
					</div>
					<ul class="newlist">
						<s:if test="guidances.size()<=7">
							<s:iterator value="%{guidances.toArray()}">
								<li><a id="${id}" onclick="tishi('${diffScheme}','${id}')">${diffName}</a><b><s:date
											name="createDate" format="yyyy-MM-dd" /></b><b><a
										href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${attachmentsPath}"
										target="_blank">预览附件</a></b></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{guidances.toArray()}" begin="0" end="6">
								<li><a id="${id}" onclick="tishi('${diffScheme}','${id}')">${diffName}</a><b><s:date
											name="createDate" format="yyyy-MM-dd" /></b><b><a
										href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${attachmentsPath}"
										target="_blank">预览附件</a></b></li>
							</s:iterator>
						</s:else>
					</ul>

				</div>


				<div class="inforight">
					<div class="listtitle">
						<a
							href="excellentTeacher_getExcellentTeacherList.action?courseId=${id}"
							class="more1" onclick="load();">更多</a>教师团队
					</div>

					<ul class="tooli">
						<!-- %{new ArrayList(%{teachers})} -->
						<s:if test="teachers.size()<=4">
							<s:iterator value="%{teachers.toArray()}">
								<li><a
									onclick="dialog('<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}','${teacherName}','${jobTitle}','${content}','${id}');"><span><img
											src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"
											height="80px" width="80px" /></span>
									<p>${teacherName}</p></a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{teachers.toArray()}" begin="0" end="3">
								<li><a
									onclick="dialog('<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}','${teacherName}','${jobTitle}','${content}','${id}');"><span><img
											src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"
											height="80px" width="80px" /></span>
									<p>${teacherName}</p></a></li>
							</s:iterator>
						</s:else>

					</ul>

				</div>


			</div>


		</div>


		<!--mainleft end-->


		<div class="mainright">


			<div class="dflist">
				<div class="listtitle">
					<a href="#" class="more1"></a>课程介绍
				</div>
				<ul class="newlist">
					<li onclick="dialogtext('${fn:escapeXml(teachingThought)}');">教学思想<label
						style="color: red;">（点击查看详情）</label></li>
					<li onclick="dialogtext('${fn:escapeXml(teachingContent)}');">教学内容<label
						style="color: red;">（点击查看详情）</label></li>
					<li onclick="dialogtext('${fn:escapeXml(courseParsing)}');">课程解析<label
						style="color: red;">（点击查看详情）</label></li>
				</ul>
			</div>


			<div class="dflist1">
				<div class="listtitle">
					<a href="#" class="more1"></a>教学大纲
				</div>
				<ul class="newlist">
					<li onclick="dialogtext('${fn:escapeXml(teachingAim)}');">教学目的<label
						style="color: red;">（点击查看详情）</label></li>
					<li onclick="dialogtext('${fn:escapeXml(teachingRequire)}');">教学要求<label
						style="color: red;">（点击查看详情）</label></li>
					<li onclick="dialogtext('${fn:escapeXml(practice)}');">实习<label
						style="color: red;">（点击查看详情）</label></li>
					<li onclick="dialogtext('${fn:escapeXml(work)}');">作业<label
						style="color: red;">（点击查看详情）</label></li>
				</ul>
			</div>
		</div>
		<!--mainright end-->
	</div>


	<!-- 第二排-->
	<div class="mainbox">
		<div class="mainleft">
			<!--leftinfo end-->
			<div class="leftinfos">
				<div class="infoleft">
					<div class="listtitle">
						<a href="video_getExcellentVideoList.action?courseId=${id}"
							class="more1">更多</a>教学视频
					</div>
					<ul class="newlist">
						<s:if test="videos.size()<=7">
							<s:iterator value="%{videos.toArray()}">
								<li><a id="v${id}" onclick="tishi('${videoName}','v${id}')">${videoName}</a><b><s:date
											name="createDate" format="yyyy-MM-dd" /></b><b><a
										onclick="video('<%=Config.EXCELLENTCOURSE_VideoPath%>/${videoPath}');">预览视频</a></b></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{videos.toArray()}" begin="0" end="6">
								<li><a id="v${id}" onclick="tishi('${videoName}','v${id}')">${videoName}</a><b><s:date
											name="createDate" format="yyyy-MM-dd" /></b><b><a
										onclick="video('<%=Config.EXCELLENTCOURSE_VideoPath%>/${videoPath}');">预览视频</a></b></li>
							</s:iterator>
						</s:else>
					</ul>

				</div>


				<div class="inforight">
					<div class="listtitle">
						<a href="book_getLessonBookList.action?courseId=${id}"
							class="more1">更多</a>图书
					</div>

					<ul class="tooli">
						<!-- %{new ArrayList(%{teachers})} -->
						<s:if test="books.size()<=4">
							<s:iterator value="%{books.toArray()}">
								<li><a
									onclick="dialog('<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}','${bookName}','${author}','${publishingHouse}<br>${bookCode}','${id}');"><span><img
											src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"
											height="80px" width="80px" /></span>
									<p>
											<s:if test="%{bookName.length()>7}">
     ${fn:substring(bookName, 0, 7)}...
    </s:if>
											<s:else>
    ${bookName}
    </s:else>

										</p></a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{books.toArray()}" begin="0" end="3">

								<%-- <%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath},${name},${jobTitle},${content} --%>
								<li><a
									onclick="dialog('<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}','${bookName}','${author}','${publishingHouse}<br>${bookCode}','${id}');"><span><img
											src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"
											height="80px" width="80px" /></span>
									<p>
											<s:if test="%{bookName.length()>6}">
     ${fn:substring(bookName, 0, 6)}
    </s:if>
											<s:else>
    ${bookName}
    </s:else>
										</p></a></li>
							</s:iterator>
						</s:else>
					</ul>

				</div>


			</div>


		</div>


		<!--mainleft end-->


		<div class="mainright">

			<div class="dflist1">
				<div class="listtitle">
					<a href="data_getReferenceDataList.action?courseId=${id}"
						class="more1">更多</a>参考资料
				</div>
				<ul class="newlist">
					<s:if test="datas.size()<=7">
						<s:iterator value="%{datas.toArray()}">
							<li><a>${referenceName}</a><b><s:date name="createDate"
										format="yyyy-MM-dd" /></b><b><a
									href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${pdfPath}"
									target="_blank">预览附件</a></b></li>
						</s:iterator>
					</s:if>
					<s:else>
						<s:iterator value="%{datas.toArray()}" begin="0" end="6">
							<li><a>${referenceName}</a><b><s:date name="createDate"
										format="yyyy-MM-dd" /></b><b><a
									href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${pdfPath}"
									target="_blank">预览附件</a></b></li>
						</s:iterator>
					</s:else>
				</ul>
			</div>
		</div>
		<!--mainright end-->
	</div>


	<!--第三排  -->
	<div class="mainbox">

		<div class="mainleft">



			<!--leftinfo end-->


			<div class="leftinfos">


				<div class="infoleft">

					<div class="listtitle">
						<a
							href="expandApplication_getExpandApplicationList.action?courseId=${id}"
							class="more1">更多</a>扩展应用
					</div>
					<ul class="newlist">
						<s:if test="applications.size()<=7">
							<s:iterator value="%{applications.toArray()}">
								<li><a>${name}</a><b><s:date name="createDate"
											format="yyyy-MM-dd" /></b><b><a
										href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${filePath}"
										target="_blank">预览附件</a></b></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{applications.toArray()}" begin="0" end="6">
								<li><a>${name}</a><b><s:date name="createDate"
											format="yyyy-MM-dd" /></b><b><a
										href="read_readSwf.action?filePath=<%=Config.EXCELLENTCOURSE_FilePath%>/${filePath}"
										target="_blank">预览附件</a></b></li>
							</s:iterator>
						</s:else>
					</ul>

				</div>


				<div class="inforight">
					<div class="listtitle">
						<a href="case_getExperimentCaseList.action?courseId=${id}"
							class="more1">更多</a>实训案例
					</div>

					<ul class="newlist">
						<!-- %{new ArrayList(%{teachers})} -->
						<s:if test="applications.size()<=7">
							<s:iterator value="%{experimentCases.toArray()}">
								<li><a>${name}</a><b><s:date name="createDate"
											format="yyyy-MM-dd" /></b><b></b></li>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{experimentCases.toArray()}" begin="0"
								end="6">
								<li><a>${name}</a><b><s:date name="createDate"
											format="yyyy-MM-dd" /></b><b></b></li>
							</s:iterator>
						</s:else>
					</ul>

				</div>


			</div>


		</div>


		<!--mainleft end-->


		<div class="mainright">

			<div class="dflist1">
				<div class="listtitle">
					<a href="#" class="more1">更多</a>信息统计
				</div>
				<ul class="newlist">
					<li><i>书籍：</a></i>${books.size()}</li>
					<li><i>教师：</a></i>${teachers.size()}</li>
					<li><i>重难点：</a></i>${guidances.size()}</li>
					<li><i>拓展应用：</a></i>${applications.size()}</li>
					<li><i>实训案例：</a></i>${experimentCases.size()}</li>
					<li><i>参考资料：</a></i>${datas.size()}</li>
					<li><i>视频：</a></i>${videos.size()}</li>
				</ul>
			</div>





		</div>
		<!--mainright end-->

	</div>
	<!--第四排  -->
	<div class="mainbox">

		<div class="mainleft">



			<!--leftinfo end-->


			<div class="leftinfos">


				<div class="infoleft">

					<div class="listtitle">
						<a href="img_getImgCarouselList.action?courseId=${id}"
							class="more1">更多</a>图片轮播
					</div>
					<div class="layer-photos-demo" id="layer-photos-demo">
						<s:if test="imgCarousels.size()<=3">
							<s:iterator value="%{imgCarousels.toArray()}">
								<img onclick="img();" src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"	height="170px" width="170px" 
layer-pid="${id}" layer-src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"  alt="${imgExplain}"/>
							</s:iterator>
						</s:if>
						<s:else>
							<s:iterator value="%{imgCarousels.toArray()}" begin="0" end="2">
<img onclick="img();" src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"	height="170px" width="170px" 
layer-pid="${id}" layer-src="<%=Config.EXCELLENTCOURSE_ImgPath%>/${imgPath}"  alt="${imgExplain}"/>
							</s:iterator>
						</s:else>
					</div>

				</div>


				<%--  <div class="inforight">
    <div class="listtitle"><a href="case_getExperimentCaseList.action?courseId=${id}" class="more1">更多</a>实训案例</div>
    
    <ul class="newlist"><!-- %{new ArrayList(%{teachers})} -->
    <s:if test="applications.size()<=7">
       <s:iterator value="%{experimentCases.toArray()}">
       <li><a>${name}</a><b><s:date name="createDate" format="yyyy-MM-dd"/></b><b></b></li>
      </s:iterator>
     </s:if>
     <s:else>
       <s:iterator value="%{experimentCases.toArray()}" begin="0" end="6">
      <li><a>${name}</a><b><s:date name="createDate" format="yyyy-MM-dd"/></b><b></b></li>
    </s:iterator>
     </s:else>
    </ul>
    
    </div> --%>


			</div>


		</div>


		<!--mainleft end-->


		<!--mainright end-->

	</div>

	<!--对话框  -->
	<div class="tip" style="position:absolute; height:400px; overflow:auto">
		<div class="tiptop">
			<span>详细信息</span><a></a>
		</div>
		<div class="tipinfo">
			<span><img src="" id="img1" height="80px" width="80px" /></span>
			<div class="tipright">
				<p id="p1"></p>
				<cite id="cite1"></cite>
			</div>
		</div>
		<!-- <div class="tipbtn">
        <input  type="button" id="update" class="sure" value="修改" />&nbsp;
        <input  type="button"  id="del" class="cancel" value="删除" />
        </div> -->
	</div>


</body>
<script type="text/javascript">
	setWidth();
	$(window).resize(function(){
		setWidth();	
	});
	function setWidth(){
		var width = ($('.leftinfos').width()-12)/2;
		$('.infoleft,.inforight').width(width);
	}
</script>
</html>
