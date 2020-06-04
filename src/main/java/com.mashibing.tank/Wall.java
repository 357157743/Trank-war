package com.mashibing.tank;

import java.awt.*;

/**
 * @date 2020/5/27 - 8:27
 */
public class Wall extends  GameObject {
    int w,h;

    // 方块模型 检测是否会和别的对象碰撞
    public Rectangle rect;

    public Wall(int x, int y,int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rect = new Rectangle(x,y,w,h);
    }


    @Override
    public int getWidth() {
        return  w;
    }

    @Override
    public int  getHeight() {
        return h;
    }

    @Override
    public void paint(Graphics g) {
        Color c= g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }
}
