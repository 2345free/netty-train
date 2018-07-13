package com.xiao.netty.train.chat.app.controller;

import com.alibaba.fastjson.JSON;
import com.xiao.netty.train.chat.app.common.ChatConstants;
import com.xiao.netty.train.chat.app.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/chat")
public class ChatController {

    /**
     * 跳转到交谈聊天页面
     *
     * @param token
     * @param model
     * @return
     */
    @GetMapping(value = "list")
    public String talk(String token, Model model) {
        model.addAttribute("token", token);
        return "chat";
    }

    @ResponseBody
    @RequestMapping(value = "users", produces = {"application/json; charset=UTF-8", "text/plain"})
    public String users(String token) {
        Map<String, UserInfo> onlines = ChatConstants.onlines;
        UserInfo cur = onlines.get(token);

        Map<String, Object> map = new HashMap<>(2);
        map.put("curName", cur != null ? cur.getCode() : "");
        map.put("users", onlines);
        return JSON.toJSONString(map);
    }
}
