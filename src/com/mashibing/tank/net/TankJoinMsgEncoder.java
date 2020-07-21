package com.mashibing.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @date 2020/6/30 - 8:46
 */
public class TankJoinMsgEncoder extends MessageToByteEncoder<Msg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Msg msg, ByteBuf buf) throws Exception {
        buf.writeInt(msg.getMsgType().ordinal()); // 消息类型
        byte[] bytes = msg.toBytes();
        buf.writeInt(bytes.length); // 消息长度
        buf.writeBytes(bytes);
    }
}
