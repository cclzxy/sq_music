package com.example.demo.Controller;

import com.example.demo.Service.AnnounceService.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公告控制层
 * Author ccl
 */
@Controller
public class AnnounceController {
    @Autowired
    AnnounceService announceService;

    /**
     * 更改一个公告
     */
    @ResponseBody
    @RequestMapping("/showannounce")
    public String Findannounce(String contents) {
        //更改公告内容，id为1,数据库修改
        announceService.updateannounce(contents);
        return "ok";
    }

    /**
     * 展示公告去班牌上
     */
    @ResponseBody
    @RequestMapping(value = "/findaanounce", method = RequestMethod.GET)
    public String findaanounce() {
        //获取公告内容，以字符串的类型返回给前端
        return announceService.findannounce().getContents();
    }

    /**
     * 班牌展示
     */
    @ResponseBody
    @RequestMapping("/showpai")
    public String showpai() {
        //班牌在线展示界面，预览班牌
        return "班牌展示";
    }
}
