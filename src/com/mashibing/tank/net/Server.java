package com.mashibing.tank.net;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.GlobalEventExecutor;


/**
 * @date 2020/6/16 - 9:51
 */
public class Server {
    public static ChannelGroup clients = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public void serverStart() {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1); //bossGroup 迎客
        EventLoopGroup workerGroup = new NioEventLoopGroup(2); // workerGroup 服务员点菜

        try {
            ServerBootstrap b = new ServerBootstrap();
            ChannelFuture f = b.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pl = ch.pipeline();
                            pl.addLast(new TankJoinMsgDecoder())
                              .addLast(new ServerChildHandler());
                        }
                    })
                    .bind(8888)
                    .sync();

            ServerFrame.INSTANCE.updateServerMsg("server started!");

            f.channel().closeFuture().sync(); //阻塞方法 如果没人调用close方法的话 closeFuture一直等待
        } catch (InterruptedException e) {
            e.printStackTrace();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

}

class ServerChildHandler  extends ChannelInboundHandlerAdapter  {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Server.clients.add(ctx.channel());
    }

    /*    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(Thread.currentThread().getId());
    }*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Server.clients.writeAndFlush(msg);


        /*System.out.println("channelRaed");

        try {
            TankJoinMsg tm  = (TankJoinMsg) msg;

            System.out.println(tm);
        } finally {
            ReferenceCountUtil.release(msg);
        }*/

     /*   ByteBuf buf = null;
        try {
            buf = (ByteBuf) msg;
            byte[] bytes = new  byte[buf.readableBytes()];
            buf.getBytes(buf.readerIndex(),bytes);
            String  s = new String(bytes);

            ServerFrame.INSTANCE.updateClientMsg(s);

            if(("_bye_").equals(s)){
                ServerFrame.INSTANCE.updateServerMsg("客户端要求退出!");
                Server.clients.remove(ctx.channel());
                ctx.close();
            }else{
                Server.clients.writeAndFlush(msg);
            }

            *//*System.out.println(buf);
            System.out.println(buf.refCnt());*//*
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
           // if(buf != null)ReferenceCountUtil.release(buf);
            //System.out.println(buf.refCnt());
        }*/
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        //产出出现异常的客户端channel 并关闭连接
        Server.clients.remove(ctx.channel());
        ctx.close();
    }
}