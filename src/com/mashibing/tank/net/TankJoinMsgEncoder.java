package com.mashibing.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @date 2020/6/30 - 8:46
 */
public class TankJoinMsgEncoder extends MessageToByteEncoder<TankJoinMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, TankJoinMsg msg, ByteBuf buf) throws Exception {
        buf.writeBytes(msg.toBytes());
    }
}
