/**
 * 分页的三个必要全局参数
 */
let pagenum;                         //初始化页数
let pagesize = 9;                    //初始化每页的个数
let page = 0;                        //控制页数用到的参数

/**
 * 页面加载时执行方法
 */
window.onload = function () {        //方法开始----*
    loadmusic(1);               //获取首页音乐列表，并自动渲染页面
    getses();                        //获取session,判断是否已经登陆
};                                   //方法结束----*

/**
 * 显示隐藏公告修改蒙层
 */
function commentsshow() {            //方法开始commentsshow()----*
    app.comalert = !app.comalert;    //点击修改公告，显示隐藏div
}                                    //方法结束commentsshow()----*


/**
 * 提交修改公告
 * @returns {boolean}
 */
function updcomment() {              //方法开始updcomment()----*
    let contents = document.getElementById("txarea").value;       //获取公告内容
    if (contents === "") {           //判断公告内容是否为空,为空就返回false,结束方法
        return false;                //返回false
    }
    $.ajax({                         //ajax异步提交后台
        url: "showannounce",         //请求的url
        type: "post",                //请求方式
        data: {"contents": contents} //要传到后台数据
    }).done(() => {                  //回调函数
        app.comalert = false;        //公告修改完成后隐藏修改蒙层
    })                               //ajax结束
}                                    //方法结束updcomment()----*

/**
 * 隐藏展示留言
 */
function showmsg() {                 //方法开始showmsg()----*
    app.main = !app.main;            //显示隐藏评论div，v-show控制
    $.ajax({                         //ajax异步提交后台
        url: "findallcomment",       //后台url
        type: "post",                //请求方式
    }).done((resp) => {              //回调函数
        app.msgs = resp;             //评论列表展示,页面自动渲染
    })                               //ajax结束
}                                    //方法结束showmsg()----*

/**
 * 网页展示班牌预览
 */
function showpai() {                  //方法开始showpai()----*
    location.href = "/showpai";       //页面跳转,交给后台处理跳转
}                                     //方法结束showpai()----*

/**
 * 分页或首页，用that区分首页、上一页、下一页
 */
function loadmusic(that) {            //方法开始loadmusic()----*
    if (that === 1) {                 //首页 that===1
        pagenum = 0;
    } else if (that === 2) {
        pagenum = (page - 1) * pagesize;
        if (page > 0) {               //上一页that===2
            page--;
        }
    } else if (that === 3) {          //下一页that===3
        pagenum = (page + 1) * pagesize;
        page++;
    } else if (that === 4) {

    }
    $.ajax({                          //ajax异步提交
        url: "pageup",                //后台url
        type: "post",                 //请求方式post
        dataType: "json",             //返回数据类型为json
        data: {"pagenum": pagenum, "pagesize": pagesize},
        success: (d) => {             //请求成功执行
            app.jsonarray = d;        //后台数据请求成功后，将请求过来的数据赋值给jsonarray，页面自动渲染
        },
        error: () => {                //请求失败报错
            alert("error");
        }
    })                                //ajax结束
}                                     //方法结束loadmusic()----*



