package com.mashibing.tank;

import com.mashibing.tank.net.Client;

/**
 * @date 2020/4/17 - 9:11
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {

        TankFrame tf = TankFrame.INSTANCE;
        tf.setVisible(true);

        /*int initTankCount = PropertyMgr.get("initTankCount");

        //初始化地方坦克
        for (int i =0;i<initTankCount;i++){
            tf.tanks.add(new Tank(50+i*80,200,Dir.DOWN,Group.BAD,tf));

        }*/


       new Thread(() -> new Audio("audio/war1.wav").loop()).start();   // 背景音乐

       new Thread( ()->{

           while(true){
               try {
                   Thread.sleep(25);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               tf.repaint();
           }
       }).start();

         Client.INSTANCE.connect();

    }
}
