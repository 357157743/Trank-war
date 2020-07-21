package com.mashibing.tank.net;

/**
 * @date 2020/7/13 - 14:40
 */
public abstract class Msg {
    public  abstract void handle();
    public  abstract byte[] toBytes();
    public  abstract void parse(byte[] bytes);
    public  abstract MsgType getMsgType();
}
