package com.mashibing.tank.observer;

import com.mashibing.tank.Tank;

/**
 * @date 2020/5/28 - 14:38
 */
public class TankFireEvent {
    Tank tank;

    public Tank getSource(){
        return tank;
    }

    public TankFireEvent(Tank tank) {
        this.tank = tank;
    }
}
