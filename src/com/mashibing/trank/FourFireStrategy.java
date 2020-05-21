package com.mashibing.trank;

/**
 * @date 2020/5/14 - 15:36
 */
public class FourFireStrategy implements FireStrategy {
    /*   private static final DefaultFireStrategy INSTANCE = new DefaultFireStrategy();
       private DefaultFireStrategy(){};
       public static DefaultFireStrategy getInstance(){return INSTANCE;};
   */
    @Override
    public void fire(Tank t) {
        int bx = t.x + Tank.WIDTH/2- Bullet.WIDTH/2;
        int by = t.y + Tank.HEIGHT/2-Bullet.HEIGHT/2;

        Dir[] dirs = Dir.values();
        for (Dir dir:dirs) {
            new Bullet(bx,by,dir,t.group,t.gm);
        }

        if(t.group == Group.GOOD) new Thread(()->{ new Audio("audio/tank_fire.wav").play();}).start();
    }
}