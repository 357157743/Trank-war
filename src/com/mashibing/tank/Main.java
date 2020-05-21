package com.mashibing.tank;

/**
 * @date 2020/4/17 - 9:11
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf =new TankFrame();



       new Thread(() -> new Audio("audio/war1.wav").loop()).start();   // 背景音乐

        while(true){
            Thread.sleep(25);
            tf.repaint();
        }
    }
}
