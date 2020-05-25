package com.mashibing.tank.cor;

import com.mashibing.tank.*;

/** 子弹 坦克相撞
 * @date 2020/5/22 - 9:03
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            // todo
            if(b.collideWith(t)){

               return false ;
            }

            } else if( o2 instanceof Bullet && o1 instanceof Tank){
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
