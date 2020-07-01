package com.mashibing.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @date 2020/6/30 - 8:46
 */
public class TankMsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

        if(in.readableBytes() <8 ) return; // TCP拆包 粘包的问题

        //in.markReaderIndex();

        int x =in.readInt();
        int y = in.readInt();

        out.add(new TankMsg(x,y));
    }
}
