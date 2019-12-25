function setMenuInfo(open,data){
    for(var i in data){
        if(data[i].children==null){
            open +="<li><a _href="+data[i].url+"><i class='iconfont'>&#xe6a7;</i><cite>"+data[i].title+"</cite></a>";
        }else if(data[i].children!=null){
            open +="<li><a href='javascript:;'><cite>"+data[i].title+"</cite><i class='iconfont nav_right'>&#xe6a7;</i></a>" +
                "<ul class='sub-menu'>";
            open = setMenuInfo(open,data[i].children)+"</ul>";

        }
        open +="</li>";
    }
    return open;
}
var cateIds = [];
function getCateId(cateId) {
    $("tbody tr[fid="+cateId+"]").each(function(index, el) {
        id = $(el).attr('cate-id');
        cateIds.push(id);
        getCateId(id);
    });
}

/*弹出层*/
/*
    参数解释：
    title   标题
    url     请求的url
    id      需要操作的数据id
    w       弹出层宽度（缺省调默认值）
    h       弹出层高度（缺省调默认值）
*/
function x_admin_show(title,url,w,h){
    if (title == null || title == '') {
        title=false;
    };
    if (url == null || url == '') {
        url="404.html";
    };
    if (w == null || w == '') {
        w=($(window).width()*0.9);
    };
    if (h == null || h == '') {
        h=($(window).height() - 50);
    };
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        maxmin: true,
        shadeClose: true,
        shade:0.4,
        title: title,
        content: url
    });
}

/*关闭弹出框口*/
function x_admin_close(){
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.close(index);
}


