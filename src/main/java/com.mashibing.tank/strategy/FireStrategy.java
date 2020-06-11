package com.mashibing.tank.strategy;

import com.mashibing.tank.Tank;

import java.io.Serializable;

/** 策略模式
 * @date 2020/5/19 - 16:43
 */
public interface FireStrategy extends Serializable {
    void fire(Tank t);
}
