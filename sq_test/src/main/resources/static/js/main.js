//数组下标
let index = -1;
//播放状态 单曲循环：0 列表循环：1 随机播放：2
let playState = 1;
//排行前10音乐列表
let myMusics;

/**
 * 排行前十音乐
 */
$.ajax({
    type: "POST",
    url: '/findallmusics',
    success: (top) => {
        myMusics = top;
    }
}).complete((d) => {
    $("#left_content").append(createBox());
});

/**
 * 获取系统当前日期
 * @type {Date}
 */
function gettime() {
    let ddd = new Date();
    let day = ddd.getDate();
    let month;
    if (ddd.getMonth() < 10) {
        month = "0" + (ddd.getMonth() + 1);
    }
    if (ddd.getDate() < 10) {
        day = "0" + ddd.getDate();
    }
    let datew = ddd.getFullYear() + "-" + month + "-" + day;
    let d = datew.toString();
    $("#mudate").val(d);
}


/**
 * 图片文件上传
 */
function upimage(src, imgname, lastname) {
    const type = "file";              //后台接收时需要的参数名称，自定义即可
    const id = "imagesrc";            //即input的id，用来寻找值
    const formData = new FormData();  //创建一个文件对象
    formData.append(type, $("#" + id)[0].files[0]);    //生成一对表单属性
    formData.append('imgname', imgname);
    formData.append('lastname', lastname);

    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/upimage',         //对应的后台处理类的地址
        data: formData,
        processData: false,
        contentType: false,
        success: (data) => {
            alert(data);
            app.to4();
        }
    });
}

/**
 * 新增音乐，且在文件上传前进行
 */
let myDate = new Date();
let timesrc = myDate.getFullYear() + "_" + myDate.getMonth() + 1 + "_" + myDate.getDate() + "_" + myDate.getTime();

function intosql() {
    if ($('#musicname').val() === "") {
        alert("您没有输入标题！");
        $('#musicname').focus();
        return false;
    } else if ($('#cert').val() === "") {
        alert("您没有上传录音文件！");
        return false;
    } else if ($('#muauthor').val() === "") {
        alert("您没有选择年级！");
        $('#muauthor').focus();
        return false;
    } else if ($('#musictype').val() === "") {
        alert("您没有选择朗读类型！");
        $('#musictype').focus();
        return false;
    } else if ($('#musicdescribe').val() === "") {
        alert("请添加描述！");
        $('#musicdescribe').focus();
        return false;
    }
    let srcn = timesrc;
    let musicname = $('#musicname').val();//标题
    let musicsrc = "/musics/" + document.getElementById('cert').files[0].name;//音乐路径String
    let author = $('#muauthor').val();//年级
    let musicdate = $('#mudate').val();//日期
    let imagesrc;
    if ($('#imagesrc').val() === "") {
        imagesrc = "";
    } else {
        let filename = $('#imagesrc').val();
        let index1 = filename.lastIndexOf(".");
        let index2 = filename.length;
        postf = filename.substring(index1, index2);//后缀名
        imagesrc = "images/" + srcn + postf;//图片路径String
    }
    let musictype = $('#musictype').val();//类型
    let musicdescribe = $('#musicdescribe').val();//描述
    $.ajax({
        url: "/upsql",
        type: "post",
        data: {
            "musicname": musicname,
            "musicsrc": musicsrc,
            "author": author,
            "musicdate": musicdate,
            "imagesrc": imagesrc,
            "musictype": musictype,
            "musicdescribe": musicdescribe
        },
        success: function (d) {
            let elid = "imagesrc";
            upmusic();//上传音乐
            upimage(elid, srcn, postf);//上传图片
        }
    })
}

//播放音乐
function onloadmusic(that) {
    let musicsrc = $(that).parent().prev().prev().prev().prev().prev().prev().prev().prev().text();
    $("#musictitle").text("正在朗诵:" + musicsrc);
    $.ajax({
        url: "onloadmusic",
        type: "post",
        data: {"musicsrc": musicsrc},
        success: (musicname) => {
            //给audio添加src并自动播放
            $("#music").attr("src", musicname);
        }
    });
}

//删除音乐
function delone(musicid) {
    let ansswer = confirm("确认删除吗?");
    if (ansswer) {
        $.ajax({
            url: "delmusic",
            type: "post",
            data: {"musicid": musicid},
            success: (data) => {
                app.jsonarray = data;
                loadmusic(4);
            }
        });
    }
}

// 音乐文件上传
function upmusic() {
    let type = "file";          //后台接收时需要的参数名称，自定义即可
    let id = "cert";            //即input的id，用来寻找值
    let formData = new FormData();
    formData.append(type, $("#" + id)[0].files[0]);    //生成一对表单属性
    $.ajax({
        type: "POST",           //因为是传输文件，所以必须是post
        url: '/upmusic',         //对应的后台处理类的地址
        data: formData,
        processData: false,
        contentType: false,
        success: (d) => {
        }
    });
}

//图片预览
function changeImg(obj) {
    // let pic = document.getElementById('inputimg');

    let file = obj.files[0];
    //file.size 单位为byte  可以做上传大小控制
    console.log("file.size = " + file.size);
    let reader = new FileReader();
    //读取文件过程方法
    reader.onloadstart = function (e) {
        console.log("开始读取....");
    };
    reader.onprogress = function (e) {
        console.log("正在读取中....");
    };
    reader.onabort = function (e) {
        console.log("中断读取....");
    };
    reader.onerror = function (e) {
        console.log("读取异常....");
    };
    reader.onload = function (e) {
        console.log("成功读取....");
        let img = document.getElementById("inputimg");
        img.src = e.target.result;
        //或者 img.src = this.result;  //e.target == this
    };
    reader.readAsDataURL(file)
}

//创建音乐排行前10列表
function createBox() {
    let html = "";
    for (let i = 0; i < myMusics.length; i++) {
        html += "<li style='list-style: none;text-align:center;font-size: 1.5em;'>" + (i + 1) + "." + "<a style='color:black;text-decoration: none;font-size: 1.1em' href='javascript:clickName(" + i + ");'>" + myMusics[i].musicsrc + "<div style='float: right;margin-right: 0.4em;color: red;font-size: 1em'>" + myMusics[i].musiclike + '</div>' + "</a></li>"
    }
    return html;
}

//点击名字播放音乐
function clickName(i) {
    index = i;
    //修改audio资源路径
    document.getElementById("music").src = myMusics[index].musicname;
    document.getElementById("music").play();
    //显示音乐名称
    $("#musictitle").text('正在朗诵:' + myMusics[index].musicsrc);
}
//搜索
function findmusics() {
    $.ajax({
        url: "findmusicname",
        type: "post",
        data: {"musicname": document.getElementById("sousuo").value},
        success: (data) => {
            app.jsonarray = data;
        }
    });
}