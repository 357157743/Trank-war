package com.mashibing.tank.cor;

/*import com.mashibing.tank.*;*/

import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;

/** 坦克 坦克相撞
 * @date 2020/5/22 - 9:03
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if(t1.getRect().intersects(t2.getRect())){ //intersects 相交
                // 坦克相遇 后退一步
                t1.back();
                t2.back();

                //t1.stop(); 坦克相遇 都停止
            }
        }
            return true;

    }

}
