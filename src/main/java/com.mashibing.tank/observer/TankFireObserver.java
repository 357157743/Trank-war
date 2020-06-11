package com.mashibing.tank.observer;

import java.io.Serializable;

/** 观察者模式
 * @date 2020/5/28 - 14:42
 */
public interface TankFireObserver extends Serializable{
    void actionOnFire(TankFireEvent e);
}
