package com.mashibing.tank;

import com.mashibing.tank.cor.ColliderChain;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/5/21 - 9:14
 */
public class GameModel {
    private static final GameModel INSTANCE = new GameModel();


    public static  GameModel getInstance(){
        return INSTANCE;
    }

    static{
        INSTANCE.init();
    }

    Tank  myTank ;

    ColliderChain chain = new ColliderChain();

    private List<GameObject> objects = new ArrayList<>();

    private  GameModel(){
    };

    public void init(){

        myTank = new Tank(200, 400, Dir.DOWN,Group.GOOD);
        int initTankCount = Integer.parseInt(PropertyMgr.get("initTankCount"));

        //初始化地方坦克
        for (int i =0;i<initTankCount;i++){
            new Tank(50+i*80,200,Dir.DOWN,Group.BAD);
        }

        add(new Wall(150,150,200,50));
        add(new Wall(550,150,200,50));
        add(new Wall(300,300,50,200));
        add(new Wall(550,300,50,200));

    }
    public void add(GameObject go){
        this.objects.add(go);
    }

    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g) {

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        /*g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌方坦克的数量:" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);*/
        g.setColor(c);

        // 如果用foreach循环的话，在其他地方调用bullets集合的remove方法会报错
        // ConcurrentModifyException 因为这种情况只能调用iterator迭代器的remove方法 不能调用集合的remove方法
        myTank.paint(g);

        // 把objects里面的坦克子弹爆炸都画出来
        for (int i=0;i<objects.size();i++) {
            objects.get(i).paint(g);
        }

        //碰撞逻辑
        for (int i = 0; i <objects.size() ; i++) {
            for (int j = i+1; j <objects.size() ; j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

                chain.collide(o1,o2);
            }

        }

        // 碰撞检测
       /* for(int i=0;i<bullets.size();i++){
            for (int  j=0;j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }*/

    }

    public Tank getMainTank() {
        return myTank;
    }
}
