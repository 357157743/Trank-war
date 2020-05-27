package com.mashibing.tank;

import com.mashibing.tank.strategy.DefaultFireStrategy;
import com.mashibing.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/** 坦克类
 * @date 2020/4/20 - 10:20
 */
public class  Tank extends GameObject{

    public int oldX,oldY; //相交前的x y
    public  Dir dir = Dir.DOWN;
    public static  final int SPEED =2;

    public static int WIDTH =ResourceMgr.goodTankD.getWidth();
    public static int HEIGHT=ResourceMgr.goodTankD.getHeight();
    public boolean moving = true;
    public boolean living = true;
    public Random random = new Random();
    public Group group = Group.BAD;
    public Rectangle rect  = new Rectangle();   //Rectangle 矩形
    FireStrategy fs;


    public Tank(int x, int y, Dir dir,Group group) {
        super();
        this.x = x;
        this.y = y;
        this.group=group;
        this.dir = dir;

        rect.x = this.x;
        rect.y =  this.y;
        rect.width = WIDTH;
        rect.height= HEIGHT;

        if(group == Group.GOOD) {
            String goodFSName = (String)PropertyMgr.get("goodFS");

            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            fs = new DefaultFireStrategy();
        }
         GameModel.getInstance().add(this);
    }

    public void fire() {
        fs.fire(this);
    }

    @Override
    public void paint(Graphics g) {
        if(!living) GameModel.getInstance().remove(this);

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

    @Override
    public int getWidth() {
        return  WIDTH;
    }

    @Override
    public int  getHeight() {
        return HEIGHT;
    }

    public void back(){
        x=oldX;
        y=oldY;
    }

    private void move(){
        //记录移动之前的位置
        oldX =x;
        oldY=y;

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

    public void die() {
    this.living=false;
    }

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

    public void stop(){
        moving=false;
    }
}
