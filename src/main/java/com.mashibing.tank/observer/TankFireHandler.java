package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

/**
 * @date 2020/5/28 - 14:40
 */
public class TankFireHandler implements TankFireObserver {

    @Override
    public void actionOnFire(TankFireEvent e){
        Tank t = e.getSource();
        t.fire();
    }
}
