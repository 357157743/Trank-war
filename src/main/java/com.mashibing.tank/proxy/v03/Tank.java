package com.mashibing.tank.proxy.v03;

import java.util.Random;

/** 慎用继承 耦合度太高了
 * @date 2020/5/29 - 8:34
 */
public class Tank implements Movable {

    @Override
    public void move() {
        //long start = System.currentTimeMillis();
        System.out.println("Tank moving claclacla.....");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

       /* long end = System.currentTimeMillis();
        System.out.println(end-start);*/
    }

    public static void main(String[] args) {
        new Tank2().move();
    }
}

class Tank2 extends  Tank{

    @Override
    public void move(){
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}

interface  Movable{
    void move();
}