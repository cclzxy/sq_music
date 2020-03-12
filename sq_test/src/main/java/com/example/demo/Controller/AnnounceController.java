package com.example.demo.Controller;

import com.example.demo.Service.AnnounceService.AnnounceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ccl
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
        announceService.updateannounce(contents);
        return "ok";
    }

    /**
     * 展示公告去班牌上
     */
    @ResponseBody
    @RequestMapping(value = "/findaanounce", method = RequestMethod.GET)
    public String findaanounce() {
        return announceService.findannounce().getContents();
    }

    /**
     * 班牌展示
     */
    @RequestMapping("/showpai")
    public String showpai() {
        return "pai";
    }
}
