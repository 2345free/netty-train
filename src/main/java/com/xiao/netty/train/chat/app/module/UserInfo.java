package com.xiao.netty.train.chat.app.module;

import com.xiao.netty.train.chat.app.common.ChatConstants;
import lombok.*;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 3562768188264006800L;
    public static Map<String, UserInfo> map = new ConcurrentHashMap<>();

    private Long id;

    private String phone;

    private String password;

    private String code;

    private String headImg;

    public UserInfo() {

    }

    public UserInfo(String phone) {
        this.phone = phone;
        this.headImg = ChatConstants.headImg();
        this.code = ChatConstants.code();
        this.id = System.currentTimeMillis();
    }

}
