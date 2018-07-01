package com.xiao.netty.train.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * @author: luoxiaoxiao
 * @date: 2018-07-01 15:49
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf in = (ByteBuf) msg;
        // 输出到控制台
        /**
         1）duplicate方法：复制当前对象，复制后的对象与前对象共享缓冲区，且维护自己的独立索引
         2）copy方法：复制一份全新的对象，内容和缓冲区都不是共享的
         3）slice方法：获取调用者的子缓冲区，且与原缓冲区共享缓冲区
         in.toString()方法会直接in.release()
         */
        System.err.println(in.copy().toString(CharsetUtil.UTF_8));
//        while (in.isReadable()) {
//            System.out.print((char) in.readByte());
//            System.out.flush();
//        }
        // 回应给发送者
        ctx.writeAndFlush(in);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
