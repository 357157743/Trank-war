package com.mashibing.tank.cor;

import com.mashibing.tank.GameModel;
import com.mashibing.tank.GameObject;

/**
 * @date 2020/5/22 - 8:59
 */
public interface Collider {
    void collide(GameObject o1, GameObject o2, GameModel gm);
}
