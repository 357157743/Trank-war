package com.mashibing.tank;

import java.awt.*;

/** 子弹类
 * @date 2020/4/20 - 10:56
 */
public class Bullet {
    private static final int SPEED = 4;
    public static int WIDTH =ResourceMgr.bulletD.getWidth();
    public static int HEIGHT=ResourceMgr.bulletD.getHeight();
    Rectangle rect  = new Rectangle();   //Rectangle 矩形
    private int x, y;
    private Dir dir;
    private boolean living = true;
    GameModel gm = null;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir,Group group,GameModel gm) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=  group;
        this.gm=gm;

        rect.x = this.x;
        rect.y =  this.y;
        rect.width = WIDTH;
        rect.height= HEIGHT;
        gm.bullets.add(this);
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isLive() {
        return living;
    }

    public void setLive(boolean live) {
        this.living = live;
    }

    public static int getSpeed() {
        return SPEED;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }


    public void paint(Graphics g) {
        if(!living){
            gm.bullets.remove(this);
        }
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
        }

        move();
    }

    private void move() {

        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        // update rect
        rect.x = this.x;
        rect.y = this.y;

        if(x<0|| y<0|| x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT){
            living = false;
        }

    }


    public void collideWith(Tank tank) {
        if(this.group == tank.getGroup())return ;

        //TODO: 用一个rect来记录子弹的位置

        if(rect.intersects(tank.rect)){
            tank.die();
            this.die();

            int ex = tank.getX() + Tank.WIDTH/2-Explode.WIDTH/2;
            int ey = tank.getY() + Tank.HEIGHT/2-Explode.HEIGHT/2;
            gm.explodes.add(new Explode(ex,ey,gm)); // 在坦克中心爆炸
        }
    }

    private void die() {
        this.living=false;
    }
}