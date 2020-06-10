package com.mashibing.tank.observer;

/** 观察者模式
 * @date 2020/5/28 - 14:42
 */
public interface TankFireObserver {
    void actionOnFire(TankFireEvent e);
}
