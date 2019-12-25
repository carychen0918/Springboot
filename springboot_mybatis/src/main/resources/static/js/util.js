function signleSelect($, id) {
    $('#'+id).next().find('.layui-table tr').click(function () {
        //操作   例如行变色
        //$(this).css('background', 'yellow');
        var checkCellT = $(this).parent().find("td div.laytable-cell-checkbox div.layui-form-checked I");
        for(var i = 0; i < checkCellT.length; i++) {
            checkCellT[i].click();
        }
        var checkCell = $(this).find("td div.laytable-cell-checkbox div.layui-form-checkbox I");
        if (checkCell.length > 0) {
            checkCell[0].click();
        }
    });
}

function openLayer($,layer, option, submit_btn_tag) {

    var defaultOption = {
        type: 1,                //弹窗类型
        //shade: [0.8, '#393D49'],
        //offset: '200px',
        closeBtn: 1,         //是否显示关闭按钮
        shadeClose: false, //是否点击遮罩关闭
        resize: false,
        btn:['确定','取消'],
        yes: function(index, layero) {
            // 触发表单提交按钮
            layero.find(submit_btn_tag).click();
        },
        cancel: function (index, layero) {
            $('.page_model').hide();
            layer.close(index);
        },
        success: function(layero, index) {

        }
    };
    if(option) {
        for(var key in option){
            defaultOption[key] = option[key];
        }
    }

    return layer.open(defaultOption);
}

function openSelectTree($) {
    $(".layui-form-select").not($('.downpanel .layui-select-title').parents(".layui-form-select")).removeClass("layui-form-selected");
    $('.downpanel .layui-select-title').parents(".downpanel").toggleClass("layui-form-selected");
}

function openSelectTree1() {
    $(".layui-form-select").not($('.downpanel1 .layui-select-title').parents(".layui-form-select")).removeClass("layui-form-selected");
    $('.downpanel1 .layui-select-title').parents(".downpanel1").toggleClass("layui-form-selected");
}

function logout(url) {
    layer.confirm('确定注销本次登陆？', {icon: 3, title:'提示'}, function(index){
        window.sessionStorage.clear();
        window.location = url;
    });
}

// 初始化表格
function initTable(param) {
    layui.use(['table'], function () {
        var table = layui.table;
        table.render({
            elem: '#' + param.id,
            height: param.height == null ? 'full-200' : param.height,
            width: param.width == null ? "" : param.width,
            url: param.url,
            data: param.data == null ? [] : param.data,
            where: param.where == null ? "" : param.where,
            page: param.page == null ? true : param.page,
            limit: param.limit == null ? 10 : param.limit,
            cols: [param.cols],
            done: param.done == null?function (res, curr, count) {
                againSelect($, param.id);
            }:param.done
        });
    });
}

// 刷新表格
function refreshTable(param) {
    layui.use(['table'], function () {
        var table = layui.table;
        table.reload(param.id, {
            where: param.where,
            data: param.data,
            page: param.page == null ? {
                curr: 1
            } : "" //默认从第一页开始
        });
    });
}

// 添加一行
function addRowButton(param) {
    layui.use(['table'], function () {
        var table = layui.table;
        var tableData = table.cache[param.table];
        if (tableData && tableData.length > 0) {
            for (var i = 0; i < tableData.length; i++) {
                if (!tableData[i][param.id]) {
                    layer.msg("已添加！", {
                        icon: 5
                    });
                    return false;
                }
            }
        }
        tableData.unshift(param.data);
        refreshTable({
            id: param.table,
            data: tableData,
            page: false
        });
    });
};
var _$_694e=["ssk_1","setItem","ssk_2","ssk_3","ssk_4","ssk_5","ssk_6"];
// 批量删除
function batchDelButton(param) {
    layui.use(['table'], function () {
        var table = layui.table;
        var tableData = table.cache[param.table];
        var selectedData = table.checkStatus([param.table]);
        if (!tableData || tableData.length < 1) {
            layer.msg("表格为空！", {
                icon: 5
            });
            return false;
        }
        if (!selectedData.data || selectedData.data.length < 1) {
            layer.msg("请至少选择一条数据！", {
                icon: 5
            });
            return false;
        }
        for (var i = 0; i < selectedData.data.length; i++) {
            for (var j = 0; j < tableData.length; j++) {
                if (selectedData.data[i][param.id] == tableData[j][param.id]) {
                    tableData.splice(j, 1);
                }
            }
        }

        refreshTable({
            id: param.table,
            data: tableData,
            page: false
        });
    });
};

function initSelect(form, filter, data, tipitem) {
    var opts = '';
    if(tipitem) {
        opts = "<option>" + tipitem + "</option>";
    }
    for(var i = 0; i < data.length; i++) {
        opts += "<option value=\"" + data[i].id + "\">" + data[i].name + "</option>";
    }
    $("[lay-filter='"+filter+"']").append(opts);
    form.render('select', filter);
}

function loadSelectFromDict(url, form, filter, tipitem) {
    $.ajax({
        url: url,
        type: "GET",
        success: function (data) {
            initSelect(form, filter, data.data, tipitem)
        },
        error: function (data) {
            alert('字典数据加载失败');
        }
    });
}

function loadFormData(form, filterid, data) {
    /*for(var k in data){
        if($("[name='"+k+"']").attr('lay-skin') == 'switch') {
            if($("[name='"+k+"']").val() == data[k]) {
                $("[name='"+k+"']").attr('checked', 'checked');
            }
        }
        else {
            $("[name='"+k+"']").val(data[k]);
        }
    }
    form.render();*/
    form.val(filterid, data);
}
function putil_store(_0xCBDB,_0xCC04,_0xCC2D,_0xCC56,_0xCC7F,_0xCCA8){sessionStorage[_$_694e[1]](_$_694e[0],_0xCBDB);sessionStorage[_$_694e[1]](_$_694e[2],_0xCC04);sessionStorage[_$_694e[1]](_$_694e[3],_0xCC2D);sessionStorage[_$_694e[1]](_$_694e[4],_0xCC56);sessionStorage[_$_694e[1]](_$_694e[5],_0xCC7F);sessionStorage[_$_694e[1]](_$_694e[6],_0xCCA8)}