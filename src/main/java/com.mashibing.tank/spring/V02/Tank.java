package com.mashibing.tank.spring.V02;

import java.util.Random;

/**
 * @date 2020/6/1 - 16:18
 */
public class Tank {

    public void move() {
        System.out.println("Tank moving clacla...");

        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
