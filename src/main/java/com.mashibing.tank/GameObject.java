package com.mashibing.tank;

import java.awt.*;
import java.io.Serializable;

/**
 * @date 2020/5/22 - 8:21
 */
public abstract class  GameObject  implements Serializable{
    public int x,y;
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
