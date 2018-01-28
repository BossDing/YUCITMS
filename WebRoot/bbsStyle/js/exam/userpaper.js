var maxtime = 0;

// 获得用户答案
function getUserKey(n) {
    var Check = "";
    var checkedObj = $("[name='" + n + "'][@checked]");
    checkedObj.each(function() {
        var isCheck = this.value + "";
        Check += isCheck;
    });
    return Check;
}

// 填空题都填写了
function BlankQuestionAllFilled(n) {
    var len = $("input[name='" + n + "']").length;
    var mylen = 0;
    $("input[name='" + n + "']").each(function() {
        if ($(this).val() != null && $(this).val() != "") {
            mylen++;
        }
    });
    return len == mylen;
}

// 试卷检查
function checkPaper() {
    var theForm = document.getElementById("userpaperform");
    var formcheck = Validator.Validate(theForm, 3);
    if (formcheck) {
        var exrsid = $("form").attr("exrsid");
        $("form").attr("action", "exam_postPaper.asp?ids=" + exrsid);
        $("form").submit();
    } else {
        return false;
    }
}

// 倒计时时钟
var showclock = true;
var msg = "";
function CountDown() {
    if (maxtime >= 0) {
        minutes = Math.floor(maxtime / 60);
        seconds = Math.floor(maxtime % 60);

        if (showclock) {
            msg = "<span>剩余<span class='label'>" + minutes
                    + "</span>分<span class='label'>" + seconds
                    + "</span>秒</span>";
        } else {
            msg = "<a href='javascript:;' onclick='showcloseclock()'>展开</a>";
        }

        $("#div_processor_timer").html(msg);
        if (maxtime == 5 * 60)
            alert('注意，还有5分钟!\n考试结束后，如您没有交卷，试卷将自动提交。');
        --maxtime;

    } else {
        var exrsid = $("form").attr("exrsid");
        clearInterval(timer);
        alert("考试时间到，试卷将自动提交!");
        $("form").attr("action", "exam_postPaper.asp?ids=" + exrsid);
        $("form").submit();
    }
}

timer = setInterval("CountDown()", 1000);

// 从服务器获取剩余时间
function getLeftTime() {
    $.ajax({
        type : "POST",
        url : "exam_getLeftTime.asp",
        data : {
            "paper.id" : ipid
        },
        success : function(data) {
            maxtime = parseInt(data);
        }
    });
}

// 页面加载
$(function() {
    // 获取剩余时间
    getLeftTime();
    // 快速跳转的生成
    var n = 1;
    var html = '';
    html += "<div>快速跳转：</div>";
    $(".qk").each(
            function(i) {
                var td_key_id = $(this).attr("id");
                var question_id = td_key_id.substring(3, td_key_id.length - 2);
                html += '<a href="javascript:;" id="fastto_question_'
                        + question_id + '" onclick="moveto('
                        + $(this).parent().parent().offset().top + ')">' + n
                        + '</a>';
                n++;
            });

    // 小面板
    $("#div_processor_fastto").html(html);
    $("#div_processor_timer").html('即将开始计时..');
    $("#div_processor_ops")
            .html(
                    '<input type="button" value="提交试卷" class="btn" onclick="checkPaper();" /><br/><br/>');

    // 单选复选的快速标示
    $(".qclazz").click(function() {
        var thename = $(this).attr("name");
        if (getUserKey(thename) != '') {
            $("#fastto_" + thename).attr("class", "finished");
        } else {
            $("#fastto_" + thename).attr("class", "");
        }
    });

    // 文本框的快速标示
    $("textarea.qclazz").keyup(function() {
        var thename = $(this).attr("name");
        if ($(this).val() != null && $(this).val() != "") {
            $("#fastto_" + thename).attr("class", "finished");
        } else {
            $("#fastto_" + thename).attr("class", "");
        }
    });

    // 填空题的快速提示
    $(".qinfo .qclazz").keyup(function() {
        var thename = $(this).attr("name");
        if (BlankQuestionAllFilled(thename)) {
            $("#fastto_" + thename).attr("class", "finished");
        } else {
            $("#fastto_" + thename).attr("class", "");
        }
    });

    // 设置必选
    $(".qoptions").each(function() {
        var lastoption = $(this).children("input.qclazz:last");
        lastoption.attr("dataType", "Group");
        lastoption.attr("msg", "未选择");

        lastoption = $(this).children("textarea.qclazz:last");
        lastoption.attr("dataType", "LimitB");
        lastoption.attr("min", "1");
        lastoption.attr("max", "400");
        lastoption.attr("msg", "1--400字以内");
    });
    alert("已经开始计时,请开始答题...");
    // timer_lis = setInterval("main_listener()",3*60*1000);
});

// 跳转到目标试题
function moveto(thetop) {
    $("html:not(:animated),body:not(:animated)").animate({
        scrollTop : thetop
    }, 1000);
}
