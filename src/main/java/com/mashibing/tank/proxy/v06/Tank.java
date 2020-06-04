package com.mashibing.tank.proxy.v06;

import java.util.Random;

/** 静态代理
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
            new TankLogProxy(
                    new TankTimeProxy(
                            new Tank()
                    )
            ).move();
        }
    }

class TankTimeProxy implements Movable {

    Movable m; // 把tank聚合到这个类里面 作为Tank2的一个属性

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    public void move(){
        long start = System.currentTimeMillis();
        System.out.println("TankTimeProxy-111");
        m.move();
        long end = System.currentTimeMillis();
        System.out.println("TankTimeProxy-222");
        System.out.println(end-start);
    }

}


class TankLogProxy implements Movable {

    Movable m; // 把tank聚合到这个类里面 作为Tank2的一个属性

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    public void move(){
        System.out.println("Tank start moving....");
        m.move();
        System.out.println("Tank stop moving.....");
    }

}

interface  Movable{
    void move();
}