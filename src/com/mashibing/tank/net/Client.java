package com.mashibing.tank.net;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.ReferenceCountUtil;

/**
 * @date 2020/6/15 - 10:25
 */
public class Client {

    private Channel channel = null;

    public void connect() {
        // 线程池
        EventLoopGroup group = new NioEventLoopGroup(); //不传参数 默认是核数的2倍 线程
        // 辅助启动类
        Bootstrap b = new Bootstrap();
        try {
              // 开启客户端 netty里面所有的方法都是异步的
             ChannelFuture f = b.group(group)
                    .channel(NioSocketChannel.class) // NioSocketChannel 非阻塞版 也可以写阻塞版SocketChannel
                    .handler(new ClientChannelInitializer())
                    .connect("localhost",8888) //connect 是异步方法
                    ;

             f.addListener(new ChannelFutureListener() {
                 @Override
                 public void operationComplete(ChannelFuture future) throws Exception {
                     if(! future.isSuccess()){
                         System.out.println("not success!");
                     }else{
                         System.out.println("connected!");
                         channel =future.channel();
                     }
                 }
             });

             f.sync();
            System.out.println(".....");

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully(); // 关闭客户端
        }
    }

    public void send(String msg){
        ByteBuf buf = Unpooled.copiedBuffer(msg.getBytes());
        channel.writeAndFlush(buf);
    }

    public static void main(String[] args) {
        Client c = new Client();
        c.connect();
    }

    public void closeConnect(){
        this.send("_bye_");

    }
}


class ClientChannelInitializer extends  ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new TankMsgEncoder())
                .addLast(new CilentHandler());
    }
}

class CilentHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = null;
        try {
            buf = (ByteBuf) msg;
            byte[] bytes = new  byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(),bytes);
            String msgAccepted = new String(bytes);
           // TankFrame.INSTANCE.updateText(msgAccepted);
            //System.out.println(new String(bytes));

            /*System.out.println(buf);
            System.out.println(buf.refCnt());*/
        /*} catch (Exception e) {
            e.printStackTrace();*/
        }finally {
            if(buf != null) ReferenceCountUtil.release(buf);
            /*System.out.println(buf.refCnt());*/
        }

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // channel第一次连接上 可用写出一个字符串directory memory
       // ByteBuf buf = Unpooled.copiedBuffer("hello".getBytes());
        ctx.writeAndFlush(new TankMsg(5,8));
    }


}