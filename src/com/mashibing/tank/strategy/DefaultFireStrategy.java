package com.mashibing.tank.strategy;

import com.mashibing.tank.*;
import com.mashibing.tank.decorator.RectDecorator;
import com.mashibing.tank.decorator.TailDecorator;

/**
 * @date 2020/5/14 - 15:36
 */
public class DefaultFireStrategy implements FireStrategy {
    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH/2- Bullet.WIDTH/2;
        int by = t.y + Tank.HEIGHT/2-Bullet.HEIGHT/2;

        // bug ? new bullet把自己又加了一遍
        GameModel.getInstance().add(
                new RectDecorator(
                        new TailDecorator(
                        new Bullet(bx,by,t.dir,t.group))));

        if(t.group == Group.GOOD) new Thread(()->{ new Audio("audio/tank_fire.wav").play();}).start();
    }
}