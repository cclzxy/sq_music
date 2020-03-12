package com.example.demo.Controller;

import com.example.demo.Pogo.SqxxUsers;
import com.example.demo.Service.MusicService.MusicService;
import com.example.demo.Service.User.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

/**
 * ccl
 */
@Controller
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    MusicService musicService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JSONObject login(String username, String pwd, HttpServletRequest request) throws NoSuchAlgorithmException {
        String msg1 = "{msg:'账号错误'}";
        String msg2 = "{msg:'密码错误'}";
        String msg3 = "{msg:''}";
        String msg4 = "{msg:'请输入密码'}";
        JSONObject object1 = JSONObject.fromObject(msg1);
        JSONObject object2 = JSONObject.fromObject(msg2);
        JSONObject object3 = JSONObject.fromObject(msg3);
        JSONObject object4 = JSONObject.fromObject(msg4);
        SqxxUsers sqxxUsers = userService.FindAuser(username);
        if (sqxxUsers == null) {
            return object1;
        } else if (pwd.equals("")) {
            return object4;
        } else if (!sqxxUsers.getUserpassword().equals(pwd)) {
            return object2;
        } else {
            HttpSession session=request.getSession();//获取session并将userName存入session对象
            //确定计算方法MD5加密
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5.digest(pwd.getBytes(StandardCharsets.UTF_8)));
            session.setAttribute("username", username);
            session.setAttribute("pwd", newstr);
            return object3;
        }
    }

    /**
     * 登陆成功(返回数据)
     */
    @RequestMapping("logintest")
    public String logintest() {
        return "music";
    }

    /**
     * 查看所有用户
     */
    @RequestMapping("findallusers")
    public String FindAllusers(Model model) {
        List<SqxxUsers> allusers = userService.FindAllUsers();
        model.addAttribute("allusers", allusers);
        return "test";
    }
}
