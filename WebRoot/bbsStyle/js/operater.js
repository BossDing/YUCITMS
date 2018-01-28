//弹窗
function confirm(title, src, width, height, type) {
    $.layer({
        type : type,
        title : [ title, true ],
        iframe : {
            src : src,
            scrolling : 'true'
        },
        area : [ width, height ],
        offset : [ '50px', '' ]
    });
}

// 删除
function confirmDel(id, src, jumpUrl) {
    var flag = false;
    layer.confirm("删除操作不可恢复，您确认要删除吗？", function(index) {
        layer.close(index);
        var url = src + '?id=' + id;
        $.ajax({
            type : "get",
            url : url,
            dataType : 'text',
            success : function(data) {
                if (data.indexOf('ok') >= 0) {
                    $.layer({
                        area : [ 'auto', 'auto' ],
                        dialog : {
                            btns : 1,
                            btn : [ '确定' ],
                            type : 1,
                            msg : '删除成功！',
                            yes : function(index) {
                                urlJump(jumpUrl);
                            }
                        },
                        close : function(index) {
                            urlJump(jumpUrl);
                        }
                    });
                } else {
                    $.layer({
                        area : [ 'auto', 'auto' ],
                        dialog : {
                            btns : 1,
                            btn : [ '确定' ],
                            type : 3,
                            msg : '删除失败！',
                            yes : function(index) {
                                urlJump(jumpUrl);
                            }
                        },
                        close : function(index) {
                            urlJump(jumpUrl);
                        }
                    });
                }
            }
        });
    }, "提示", function(index) {
        layer.close(index);
        flag = false;
    });
    return flag;
}
// 刷新
function refresh() {
    location.reload(true);
}
// 路径跳转
function urlJump(url) {
    location.href = url;
}

// 批量删除
function deleteById(src, jumpUrl) {
    var flag = false;
    var checked = false;
    var ids = document.getElementsByName("id");
    var url = src + '?';
    for (var i = 0; i < ids.length; i++) {
        // 判断顶上那个checkbox框的选中状态
        if (ids[i].checked) {
            checked = true;
            url = url + '&id=' + ids[i].value;
        }
    }
    if (checked) {
        layer.confirm("删除操作不可恢复，您确认要删除吗？", function(index) {
            layer.close(index);
            var url = src + '?';
            for (var i = 0; i < ids.length; i++) {
                // 判断顶上那个checkbox框的选中状态
                if (ids[i].checked) {
                    url = url + '&id=' + ids[i].value;
                }
            }
            $.ajax({
                type : "post",
                url : url,
                dataType : 'text',
                success : function(data) {
                    if (data.indexOf('ok') >= 0) {
                        $.layer({
                            area : [ 'auto', 'auto' ],
                            dialog : {
                                btns : 1,
                                btn : [ '确定' ],
                                type : 1,
                                msg : '删除成功！',
                                yes : function(index) {
                                    urlJump(jumpUrl);
                                }
                            },
                            close : function(index) {
                                urlJump(jumpUrl);
                            }
                        });
                    } else {
                        $.layer({
                            area : [ 'auto', 'auto' ],
                            dialog : {
                                btns : 1,
                                btn : [ '确定' ],
                                type : 3,
                                msg : '删除失败！',
                                yes : function(index) {
                                    urlJump(jumpUrl);
                                }
                            },
                            close : function(index) {
                                urlJump(jumpUrl);
                            }
                        });
                    }
                }
            });
        }, "提示", function(index) {
            layer.close(index);
            flag = false;
        });
    } else {
        layer.alert('请至少选中一个项！');
    }
    return flag;
}
