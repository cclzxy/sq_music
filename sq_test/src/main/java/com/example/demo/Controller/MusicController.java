package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.example.demo.Mapper.MusicJpaMapper;
import com.example.demo.Pogo.Musiclist;
import com.example.demo.Service.MusicService.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * ccl
 */
@Controller
public class MusicController {
    @Autowired
    MusicService musicService;
    @Autowired
    MusicJpaMapper musicJpaMapper;

    /**
     * 模糊查询
     */
    @ResponseBody
    @RequestMapping("findmusicname")
    public JSONArray Findmusicbudate(String musicname) {
        List<Musiclist> musiclists = musicJpaMapper.findByMusicsrcLike("%" + musicname + "%");
        String jsonA = com.alibaba.fastjson.JSONArray.toJSONString(musiclists);
        return JSONArray.parseArray(jsonA);
    }

    /**
     * 排行榜前十
     */
    @ResponseBody
    @RequestMapping("/findallmusics")
    public JSONArray upfile() {
        List<Musiclist> musiclists = musicService.FindTopmusic();
        String jsonA = com.alibaba.fastjson.JSONArray.toJSONString(musiclists);
        JSONArray jsonArray = JSONArray.parseArray(jsonA);
        return jsonArray;
    }

    /**
     * 音乐上传
     */
    @ResponseBody
    @RequestMapping("/upmusic")
    public String upfile(@RequestParam("file") MultipartFile file) {
        String fileName = file.getOriginalFilename();//获取mp3名称
        String filePath = "C:\\musics\\";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();//如果不存在，则创建目录文件
        }
        FileOutputStream out = null;//创建输出流对象
        try {
            out = new FileOutputStream(filePath + fileName);
            out.write(file.getBytes());//将MP3写入输出流
            out.flush();//开始输出文件
            out.close();//关闭输出流
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功！";
    }

    /**
     * 图片上传
     */
    @ResponseBody
    @RequestMapping("/upimage")
    public String upimage(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
        String fileName = request.getParameter("imgname") + request.getParameter("lastname");
        String filePath = "C:\\images\\";
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(filePath + fileName);
            out.write(file.getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "成功上传!";
    }

    /**
     * 新增一条信息上传数据库
     */
    @ResponseBody
    @RequestMapping("/upsql")
    public String upsql(String musicname, String musicsrc, String author, String musicdate, String imagesrc, String musictype, String musicdescribe) {
        int a = musicService.intosql(musicname, musicsrc, author, musicdate, imagesrc, musictype, musicdescribe);
        if (a == 1) {
            return "信息更新成功！";
        } else {
            return "信息更新失败！";
        }
    }

    /**
     * 删除歌曲
     */
    @ResponseBody
    @RequestMapping("/delmusic")
    public JSONArray delmusic(int musicid) {
        musicService.delmusic(musicid);//删除
        return JSONArray.parseArray(com.alibaba.fastjson.JSONArray.toJSONString(musicService.FindAllmusic()));
    }

    /**
     * 播放歌曲
     */
    @ResponseBody
    @RequestMapping("/onloadmusic")
    public String upsql(String musicsrc) {
        return musicService.findamusic(musicsrc);
    }


    /**
     * 分页
     */
    @ResponseBody
    @RequestMapping("/pageup")
    public JSONArray pageup(int pagenum, int pagesize) {
        return JSON.parseArray(JSON.toJSONString(musicService.findmusicbypage(pagenum, pagesize)));
    }

    /**
     * 评论功能
     */
    @ResponseBody
    @RequestMapping("/comment")
    public String addcomment(int commentid, String comment) {//传入 音乐名称对应的编号 和 评论内容
        String a = "qwq";
        musicService.addcomment(commentid, comment, a, a, a, a, a, a, a);
        return "music";
    }

    /**
     * 评论展示功能
     */
    @ResponseBody
    @RequestMapping("/findallcomment")
    public JSONArray findAllcoment() {
        return JSON.parseArray(JSON.toJSONString(musicService.findAllcomment()));
    }


}
