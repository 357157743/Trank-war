package com.mashibing.tank;

import java.awt.*;
import java.util.Random;

/** 坦克类
 * @date 2020/4/20 - 10:20
 */
public class Tank {

    private int x , y;
    private  Dir dir = Dir.DOWN;
    private static  final int SPEED =2;

    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT=ResourceMgr.goodTankD.getHeight();
    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;
    private Random random = new Random();
    private Group group = Group.BAD;
    Rectangle rect  = new Rectangle();   //Rectangle 矩形

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
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

    public static int getSPEED() {
        return SPEED;
    }

    public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
        super();
        this.x = x;
        this.y = y;
        this.group=group;
        this.dir = dir;
        this.tf=tf;

        rect.x = this.x;
        rect.y =  this.y;
        rect.width = WIDTH;
        rect.height= HEIGHT;
    }

    public void paint(Graphics g) {
        if(!living) tf.tanks.remove(this);

        switch (dir){
            case LEFT:
                g.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankL :ResourceMgr.badTankL,x,y,null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankU :ResourceMgr.badTankU,x,y,null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankR :ResourceMgr.badTankR,x,y,null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ?ResourceMgr.goodTankD :ResourceMgr.badTankD,x,y,null);
                break;
        }

        move();
    }

    private void move(){
        if(!moving) return;

        switch (dir){
            case LEFT:
                x -=SPEED;
                break;
            case UP:
                y -=SPEED;
                break;
            case RIGHT:
                x +=SPEED;
                break;
            case DOWN:
                y +=SPEED;
                break;
        }

        // 坏坦克 随机开火
        if(this.group == Group.BAD && random.nextInt(100) >95){
            this.fire();
        }

        //坏坦克 随机移动
        if(this.group == Group.BAD && random.nextInt(100)>95) {
            randomDir();
        }
        //坦克移动边界检测
        boundsCheck();

        // update rect
        rect.x = this.x;
        rect.y = this.y;
    }

    private void boundsCheck() {
        if(this.x <2) x=2;
        if(this.y<28) y=28;
        if(x > TankFrame.GAME_WIDTH - Tank.WIDTH-2) x=TankFrame.GAME_WIDTH- Tank.WIDTH-2;
        if(y> TankFrame.GAME_HEIGHT - Tank.HEIGHT-2) y=TankFrame.GAME_HEIGHT - Tank.HEIGHT-2;

    }

    private void randomDir() {
            this.dir = Dir.values()[random.nextInt(4)];
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2-Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2-Bullet.HEIGHT/2;
        tf.bullets.add(new Bullet(bx,by,this.dir,this.group,this.tf)) ;

    }

    public void die() {
    this.living=false;
    }
}
