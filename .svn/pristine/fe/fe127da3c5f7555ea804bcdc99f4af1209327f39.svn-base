<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%>
<%
    String basePath = request.getContextPath();
%>
<style>
form {
    margin: 0;
}

textarea {
    display: block;
}
</style>
<link rel="stylesheet" href="<%=basePath%>/kindeditor-4.1.10/themes/default/default.css" />
<script charset="utf-8" src="<%=basePath%>/kindeditor-4.1.10/kindeditor.js"></script>
<script charset="utf-8" src="<%=basePath%>/kindeditor-4.1.10/lang/zh_CN.js"></script>
<script>
    var editor;
    KindEditor.ready(function(K) {
        editor = K.create('textarea[name="content"]', {
            uploadJson : '<%=basePath%>/jsp/upload_json.jsp',
            allowFileManager : true,
            resizeType : 1,
            allowPreviewEmoticons : false,
            allowImageUpload : false,
            items : [ 'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor',
                    'bold', 'italic', 'underline', 'removeforma', '|',
                    'justifyleft', 'justifycenter', 'justifyright',
                    'insertorderedlist', 'insertunorderedlist', '|',
                    'emoticons', 'image', 'link', 'table','baidumap' ]
        });
    });
</script>
