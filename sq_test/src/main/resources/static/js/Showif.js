let pagenum;
let pagesize = 9;
let page = 0;
//显示隐藏公告修改
function commentsshow() {
    app.comalert = !app.comalert;
}

//修改公告
function updcomment() {
    let contents = document.getElementById("txarea").value;
    if (contents===""){
        return false;
    }
    $.ajax({
        url: "showannounce",
        type: "post",
        data: {"contents": contents}
    }).done(() => {
        app.comalert = false;
    })
}

//隐藏展示留言
function showmsg() {
    app.main = !app.main;//显示隐藏评论div，v-show控制
    $.ajax({
        url: "findallcomment",
        type: "post",
    }).done((resp) => {
        app.msgs = resp;//评论列表展示
    })
}
//展示班牌
function showpai() {
    location.href="/showpai";
}
// 分页或首页
function loadmusic(that) {
    if (that === 1) {
        pagenum = 0;
    } else if (that === 2) {
        pagenum = (page - 1) * pagesize;
        if (page > 0) {
            page--;
        }
    } else if (that === 3) {
        pagenum = (page + 1) * pagesize;
        page++;
    } else if (that === 4) {

    }
    $.ajax({
        url: "pageup",
        type: "post",
        dataType: "json",
        data: {"pagenum": pagenum, "pagesize": pagesize},
        success: (d) => {
            app.jsonarray = d;
        },
        error:()=>{

        }
    })
}

window.onload=function(){
    loadmusic(1);
    getses();
};


