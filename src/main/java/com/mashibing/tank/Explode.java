package com.mashibing.tank;

import java.awt.*;

/** 爆炸类
 * @date 2020/4/26 - 13:16
 */
public class Explode  extends GameObject {
    public static int WIDTH =ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT=ResourceMgr.explodes[0].getHeight();

    private int step =0;

    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audio/explode.wav").play()).start(); // 加爆炸声音
        GameModel.getInstance().add(this);
    }

    @Override
    public void paint(Graphics g){

        //if(step< ResourceMgr.explodes.length){   }

            g.drawImage(ResourceMgr.explodes[step++], x, y,null);
            if(step >= ResourceMgr.explodes.length ){
                GameModel.getInstance().remove(this);
            }

    }

    @Override
    public int getWidth() {
        return  WIDTH;
    }

    @Override
    public int  getHeight() {
        return HEIGHT;
    }
}
