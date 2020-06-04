package com.mashibing.tank.proxy.V02;

import java.util.Random;

/**
 * @date 2020/5/29 - 8:34
 */
public class Tank implements Movable {

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("Tank moving claclacla.....");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}


interface  Movable{
    void move();
}