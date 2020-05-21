package com.mashibing.trank;

import java.awt.*;

/** 爆炸类
 * @date 2020/4/26 - 13:16
 */
public class Explode {
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();

    private int x ,y;
    GameModel gm = null;
    private int step =0;

    public Explode(int x, int y, GameModel gm) {
        this.x = x;
        this.y = y;
        this.gm = gm;

        new Thread(() -> new Audio("audio/explode.wav").play()).start(); // 加爆炸声音
    }

    public void paint(Graphics g){

        //if(step< ResourceMgr.explodes.length){   }

            g.drawImage(ResourceMgr.explodes[step++], x, y,null);
            if(step >= ResourceMgr.explodes.length ){
                gm.explodes.remove(this);
            }

    }

}
