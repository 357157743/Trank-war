package com.mashibing.tank.proxy.v10;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/** 使用jdk动态代理
 * @date 2020/5/29 - 8:34
 */
public class Tank implements Movable {

    @Override
    public void move() {
        System.out.println("Tank moving claclacla.....111");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGenerate dFiles","true");

        Movable m = (Movable) Proxy.newProxyInstance( Tank.class.getClassLoader(),
                new Class[]{Movable.class}, // tank.class.getInterfaces
                new TimeProxy(tank) );
        m.move();
    }
}


class TimeProxy implements InvocationHandler {
   Movable m;

    public TimeProxy(Movable m) {
        this.m = m;
    }

    public void before(){ System.out.println("method start..."); }

    public void after(){
        System.out.println("method stop");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object o =method.invoke(m,args);
        after();
        return o;
    }
}


interface  Movable{
    void move();
}