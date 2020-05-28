package com.mashibing.tank.decorator;

import com.mashibing.tank.GameObject;

import java.awt.*;

/** 装饰者模式
 * @date 2020/5/27 - 14:19
 */
public abstract class GoDecorator extends GameObject {

    GameObject go;

    public GoDecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);


}
