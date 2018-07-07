package com.xiao.netty.train.time;

import com.xiao.netty.train.pojo.UnixTime;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author: luoxiaoxiao
 * @date: 2018-07-07 12:49
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
//        ByteBuf m = (ByteBuf) msg;
//        try {
//            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
//            Date currentTime = new Date(currentTimeMillis);
//            System.err.format("Default Date Format: %s", currentTime.toString());
//
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String dateString = formatter.format(currentTime);
//            // 转换一下成中国人的时间格式
//            System.out.println();
//            System.err.format("Date Format: %s", dateString);
//
//            ctx.close();
//        } finally {
//            m.release();
//        }

        // 使用pojo代替ByteBuf
        UnixTime m = (UnixTime) msg;
        System.err.println(m);
        ctx.close();

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
