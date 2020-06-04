package com.mashibing.tank.proxy.v07;

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
        System.out.println("Tank moving claclacla.....2222");
    }

    public static void main(String[] args) {
        Tank tank = new Tank();

        Movable m = (Movable) Proxy.newProxyInstance( Tank.class.getClassLoader(),
                new Class[]{Movable.class}, // tank.class.getInterfaces
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("method "+method.getName() +"start");
                        Object o = method.invoke(tank,args);
                        System.out.println("method "+method.getName() +"end");
                        return o;
                    }
                }
        );
        m.move();
    }
}

class TankTimeProxy implements Movable{
    Movable m;
    public TankTimeProxy(Movable m){this.m=m;}

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end =System.currentTimeMillis();
        System.out.println(end - start);
    }
}


class TankLogProxy implements Movable{
    Movable m;
    public TankLogProxy(Movable m){this.m=m;}

    @Override
    public void move() {
        System.out.println("start moving...");
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("stopped");
    }
}


interface  Movable{
    void move();
}