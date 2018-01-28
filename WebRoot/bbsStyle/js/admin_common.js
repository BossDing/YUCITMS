//定义全局变量msgAarry数组存储字符串
var entityArray, totalCount = 0;
var search_order = 0;

function closeWindow(data) {
    layer.closeAll();
    showMsg(data);
    /* location.reload(); */
}

var FormatDate = function(date) {
    return date.getFullYear() + "-" + (date.getMonth() + 1) + "-"
            + date.getDay();
}

function showIntro(intro, elem) {
    layer.tips(intro, elem, {
        guide : 1,
        time : 2,
        style : [ 'background-color:#F5FFFA; color:#2F4F4F', '#F26C4F' ],
        maxWidth : 240
    });
}

// Ajax获取后台数据
var getOptionList = function(requestUrl, addun) {// autofocus id='searchText'
                                                    // style='width:130px'
    var dataStr = "<select autofocus id=\"searchText\" style=\"width:130px\" >";
    $.ajax({
        url : requestUrl,
        async : false,
        type : 'post',
        dataType : 'json',
        success : function(data) {
            $.each(data, function(index, item) {
                dataStr = dataStr + "<option value=" + item[0] + ">" + item[1]
                        + "</option>";
            });
        }
    });
    if (addun == 1)
        return dataStr + "<option value=0 >未知</option></select>";
    if (addun == 0)
        return dataStr + "</select>";
}

function validateCount(elements) {
    for (var i = 0; i < elements.length; i++)
        if (elements[i].value <= 0)
            return false;
    return true;
}

function isSelected(data) {
    if (data.checked)
        $(data).parent().parent().attr("class", "selected");
    else
        $(data).parent().parent().removeAttr("class");
}

function importBackResult(data, url) {
    layer.close(layer.index);
    if (data == "existList") {
        $.layer({
            type : 2,
            title : false,
            maxmin : false,
            offset : [ '10', '' ],
            area : [ '700', '450' ],
            border : [ 1, 0.7, '#33CCFF' ],
            shade : [ 0.8, '#CCFFEE' ],
            closeBtn : [ 0, true ],
            fix : true,
            iframe : {
                src : url,
                scrolling : 'true'
            }
        });
    } else {
        layer.alert(data, 1, function() {
            location.reload();
        });
    }
}
/*
 * function getFocus(){ if($("#selectId").val()==2){ var
 * target=$("#searchText"); // target.attr("readOnly",true); //
 * $("#searchText").addClass("laydate-icon"); laydate(); }else{
 * $("#searchText").removeClass("laydate-icon"); } }
 */

var deleteEntity = function(url, data, msg) {
    var index = layer.confirm(msg, function() {
        jQuery.post(url, data, function(responseData) {
            layer.msg(responseData, 1, 1);
            location.reload();
        });
    });
}
//
var deleteEty = function(url, data, msg) {
    var index = layer.confirm(msg, function() {
        jQuery.post(url, data);
    });
}

function arrayToStr(array) {
    var str = ""
    for (var i = 0; i < array.length; i++)
        str += array[i] + ":";
    return str;

}

/* 根据参数类型删除指定行 */
function deleteTr(data) {
    if (data.constructor == String) {
        $("tr[id='" + data + "']").remove();
    } else if (data.constructor == Array) {
        $("tr.selected").remove();
        location.reload();
    }
    // location.reload();
}

function info(data, type) {
    layer.alert(data, type);
}

function configFrame(title, area, shade, url, closeBtn) {
    var index = $.layer({
        type : 2,
        title : title,
        maxmin : false,
        offset : [ '15', '' ],
        area : area,
        border : [ 0 ],
        shade : [ 0.6, "#CCCCFF" ],
        closeBtn : closeBtn,
        fix : true,
        iframe : {
            src : url,
            scrolling : "no"
        }
    });

}

// 设置setInterval传参数
/*
 * var __sto = setInterval;
 * 
 * window.setInterval = function(callback,timeout,param){ var args =
 * Array.prototype.slice.call(arguments,2); var _cb = function(){
 * callback.apply(null,args); } __sto(_cb,timeout); }
 */

// 进度条

// 关闭当前窗口
function closeCurWin() {
    layer.close(layer.index);
}
// 上传excel文件格式验证

function submitForm(value) {
    var lastPoint = value.lastIndexOf(".");
    var ext = value.substring(lastPoint, value.length).toUpperCase();
    if (value.length > 0) {
        if (ext == ".XLS" || ext == ".XLSX")
            return true;
        else {
            $("#tishi").html("提示：上传文件格式不正确！");
            return false;
        }
    } else {
        $("#tishi").html("提示：上传文件不能为空！");
        return false;
    }
}

function getFileSize(ele) {
    var size = 0;
    try {
        if ($.browser.msie) {// ie旧版浏览器
            var fileMgr = new ActiveXObject("Scripting.FileSystemObject");
            var filePath = ele.value;
            var fileObj = fileMgr.getFile(filePath);
            size = fileObj.size; // byte
        } else {// 其它浏览器
            size = $(ele)[0].files[0].size;// byte
        }
    } catch (e) {
        alert("错误：" + e);
    }

    return size;
}

// 上传视频格式验证
function uploadMvValidate(obj) {
    var value = obj.value;
    var lastPoint = value.lastIndexOf(".");
    var ext = value.substring(lastPoint, value.length).toUpperCase();
    if (value.length > 0) {
        if (ext == ".FLV" || ext == ".MP4" || ext == ".RMVB") {
            var size = getFileSize(obj);
            if (size > 1073742000)
                obj.value = "";
        } else
            obj.value = "";

    }
}

function play(url, data) {
    $.layer({
        type : 2,
        title : false,
        maxmin : false,
        offset : [ '10', '' ],
        area : [ '420', '330' ],
        border : [ 5, 0.5, '#33CCFF' ],
        shade : [ 0.7, '#CCFFEE' ],
        closeBtn : [ 1, true ],
        fix : true,
        iframe : {
            src : url + "?" + data,
            scrolling : 'no'
        }
    });
}

function editEty(url, data, areaSize) {
	$.layer({
    	
        type : 2,
        title : false,
        maxmin : false,
        offset : [ '10', '' ],
        area : areaSize,
        border : [ 5, 0.5, '#33CCFF' ],
        shade : [ 0.7, '#2F4F4F' ],
        closeBtn : [ 1, true ],
        fix : true,
        iframe : {
            src : url + "?" + data,
            scrolling : 'no'
        }
    });
}

function Clock() {
    var date = new Date();
    this.year = date.getFullYear();
    this.month = date.getMonth() + 1;
    this.date = date.getDate();
    this.day = new Array("星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六")[date
            .getDay()];
    this.hour = date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
    this.minute = date.getMinutes() < 10 ? "0" + date.getMinutes() : date
            .getMinutes();
    this.second = date.getSeconds() < 10 ? "0" + date.getSeconds() : date
            .getSeconds();

    this.toString = function() {
        return "现在是:" + this.year + "年" + this.month + "月" + this.date + "日 "
                + this.hour + ":" + this.minute + ":" + this.second + " "
                + this.day;
    };

    this.toSimpleDate = function() {
        return this.year + "-" + this.month + "-" + this.date;
    };

    this.toDetailDate = function() {
        return this.year + "-" + this.month + "-" + this.date + " " + this.hour
                + ":" + this.minute + ":" + this.second;
    };

    this.display = function(ele) {
        var clock = new Clock();
        ele.innerHTML = clock.toString();
        window.setTimeout(function() {
            clock.display(ele);
        }, 1000);
    };
}
function showMsg(data) {
    $.layer({
        type : 0,
        title : false,
        closeBtn : false,
        maxmin : false,
        area : [ '100', '150' ],
        border : [ 3, 0.5, '#33CCFF' ],
        shade : [ 0.7, '#AAAAAA' ],
        fix : true,
        time : 1,
        dialog : {
            type : 1,
            msg : data
        },
        end : function() {
            location.reload();
        }
    });
}

// 获取信息列表并实现分页
function getEntityList(url) {
    var infostr;
    totalCount = 0; // 清空原始总数
    $.ajax({
        dataType : "json",
        type : "post",
        url : url,
        async : false,
        success : function(data) {
            infostr = data;
        }
    });
    return infostr;
}

// 分页技术实现起始索引位置为零

function getPageByOrder(order) {
    if (window.entityArray) {
        if (entityArray.constructor == Array) {
            if (order >= 0 && order < entityArray.length) {
                $("table tr:gt(0)").remove();
                $("#entity_content").append(entityArray[order]);
                $("#totalRecords").text(totalCount);
                $("#currentPage").text(order + 1);
                $("#totalPages").text(entityArray.length);
            } else {
                if (order >= entityArray.length)
                    search_order = entityArray.length - 1;
                if (order < 0)
                    search_order = 0;
            }
        }
    } else {
        $("table tr:gt(0)").remove();
        $("#entity_content")
                .append(
                        "<tr><td colspan=\"6\" style=\"color:red;\" ><em>查询数据为空！</em></td></tr>");
    }
}
