let app = new Vue({
    el: "#App",
    data: {
        jsonarray: '',//页面要展示的音乐数据
        ifaddmusic: false,
        ifaddmusic2: true,
        comalert: false,//公告显示隐藏
        imgalert: false,//图片点击查看
        msgs: '',//评论
        main: true,//中间大div
        btnplay: true,//显示隐藏播放按钮
        addmusic: 0,
    },
    methods: {
        delmusic(index) {
            return delone(this.jsonarray[index].musicid);
        },
        showimg(index) {
            this.imgalert = !this.imgalert;
            document.getElementById("show").src = this.jsonarray[index].imagesrc;
        }, hideimg() {
            this.imgalert = false;
        },to1(){
            this.addmusic=1;
        },to2(){
            this.addmusic=2;
        },to3(){
            this.addmusic=3;
        },to4(){
            // if (intosql()){
                 this.addmusic=4;
                setTimeout(()=> {
                    location.reload();
                },2000)
            // }

        }
    },
    computed: {}
});

// 显示隐藏添加音乐div
function addmusic() {
    gettime();
    app.main = true;
    // app.ifaddmusic = !app.ifaddmusic;//显示隐藏新增音乐
    if (app.addmusic >= 1) {
        app.addmusic = 0;
    } else {
        app.addmusic = 1;
    }
    app.ifaddmusic2 = !app.ifaddmusic2;//显示隐藏所有数据页面
}

//session
function getses() {
    let n = document.getElementById("uname").innerText;
    if (n === "") {
        alert("登陆已过期，请您重新登陆！");
        location.href = "index.html";
    }
}