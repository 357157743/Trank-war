package com.mashibing.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @date 2020/6/30 - 8:46
 */
public class TankJoinMsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() <8 ) return; // 消息头 消息长度 都是int类型 一共8个字节
        in.markReaderIndex(); // bytebuf 标记指针开始读的位置

        MsgType msgtype = MsgType.values()[in.readInt()];
        int length = in.readInt();

        if(in.readableBytes() <length){
            in.resetReaderIndex(); // 指针回到初始标记的位置
            return;
        }

        byte[] bytes = new byte[length];
        in.readBytes(bytes);

        switch (msgtype){
            case TankJoin:
                TankJoinMsg msg = new TankJoinMsg();
                msg.parse(bytes);
                out.add(msg);
                break;
            default:
                break;
        }
    }
}
