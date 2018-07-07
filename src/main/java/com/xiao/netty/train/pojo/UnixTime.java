package com.xiao.netty.train.pojo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: luoxiaoxiao
 * @date: 2018-07-07 13:58
 */
public class UnixTime {

    private final long value;

    public UnixTime() {
        this(System.currentTimeMillis() / 1000L + 2208988800L);
    }

    public UnixTime(long value) {
        this.value = value;
    }

    public long value() {
        return value;
    }

    @Override
    public String toString() {
        Date date = new Date((value() - 2208988800L) * 1000L);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }
}
