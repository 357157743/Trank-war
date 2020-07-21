package com.mashibing.tank.net;

import com.mashibing.tank.TankFrame;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @date 2020/6/15 - 10:25
 */
public class Client {

    public static Client INSTANCE = new Client() ;
    private Channel channel = null;

    private Client(){};
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

    public void send(Msg msg){
       channel.writeAndFlush(msg);
    }


    public void closeConnect(){
       // this.send("_bye_");

    }
}

class ClientChannelInitializer extends  ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline()
                .addLast(new TankJoinMsgEncoder())
                .addLast(new TankJoinMsgDecoder())
                .addLast(new CilentHandler());
    }
}

class CilentHandler extends SimpleChannelInboundHandler<Msg>{


    @Override
    public void channelRead0(ChannelHandlerContext ctx, Msg msg) throws Exception {
        msg.handle();

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // channel第一次连接上 可用写出一个字符串directory memory
       // ByteBuf buf = Unpooled.copiedBuffer("hello".getBytes());
        ctx.writeAndFlush(new TankJoinMsg(TankFrame.INSTANCE.getMainTank()));
    }


}