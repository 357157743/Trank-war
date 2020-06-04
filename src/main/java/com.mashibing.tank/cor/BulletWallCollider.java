package com.mashibing.tank.cor;

import com.mashibing.tank.Bullet;
import com.mashibing.tank.GameObject;
import com.mashibing.tank.Tank;
import com.mashibing.tank.Wall;

/** 子弹 墙相撞
 * @date 2020/5/22 - 9:03
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;

            if(b.rect.intersects(w.rect)){
                b.die();
            }

        } else if( o2 instanceof Bullet && o1 instanceof Wall){
            return collide(o2,o1);

        }
            return true;
    }

 /*   public void collideWith(Bullet b,Tank tank) {
        if(b.group == tank.getGroup())return ;

        //TODO: 用一个rect来记录子弹的位置

        if(b.rect.intersects(tank.getRect())){
            tank.die();
            b.die();
            int ex = tank.getX() + Tank.WIDTH/2- Explode.WIDTH/2;
            int ey = tank.getY() + Tank.HEIGHT/2-Explode.HEIGHT/2;
            gm.add(new Explode(ex,ey,gm)); // 在坦克中心爆炸
        }
    }*/

}
