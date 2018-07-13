package com.xiao.netty.train.chat.app.controller;

import com.xiao.netty.train.chat.app.module.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    /**
     * 跳转登录页面
     *
     * @return
     */
    @GetMapping(value = {"", "/", "index"})
    public String index() {
        return "index";
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping(value = "login")
    public String doLogin(UserInfo user) {
        UserInfo.map.put(user.getPhone(), user);
        //return "redirect:/msg/list?token="+user.getPhone();
        return "redirect:/chat/list?token=" + user.getPhone();
    }
}