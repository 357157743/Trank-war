package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/**
 * @date 2020/5/27 - 14:22
 */
public class RectDecorator extends GoDecorator  {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c =g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(super.go.x,super.go.y,getWidth()+2,getHeight()+2);
        g.setColor(c);
    }


    @Override
    public int getWidth() {
        return  super.go.getWidth();
    }

    @Override
    public int  getHeight() {
        return super.go.getHeight();
    }
}
