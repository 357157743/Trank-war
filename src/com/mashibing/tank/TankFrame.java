package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

/**
 * @date 2020/4/17 - 9:27
 */
public class TankFrame extends Frame {

    public static  final  TankFrame INSTANCE = new TankFrame();
    Tank myTank = new Tank(200, 400, Dir.DOWN,Group.GOOD,this);
    List<Bullet> bullets = new ArrayList<>();
    Map<UUID,Tank> tanks = new HashMap<>();
    List<Explode> explodes = new ArrayList<>();
    static final int GAME_WIDTH = 1080, GAME_HEIGHT = 735;


    public TankFrame() {

        // 窗口可见
        this.setVisible(true);
        //窗口大小
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
        //窗口是否可以改变大小
        this.setResizable(false);
        this.setTitle(" trank war....");
        // 添加键盘监听处理类
        this.addKeyListener(new MyKeyListener());
        // 添加窗口监听
        this.addWindowListener(new WindowAdapter() {
            @Override   // 点红叉  关闭窗口
            public void windowClosing(WindowEvent e) {
                System.exit(0);// 系统退出
            }
        });
    }


    Image offScreenImage = null;

    @Override // 双缓存 取消屏幕闪烁
    public void update(Graphics g) {
        if (offScreenImage == null) {  // 图片定义到内存里面，画完了才一次性刷新到屏幕
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }

        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen); // 调用paint方法把坦克和子弹画到内存里
        g.drawImage(offScreenImage, 0, 0, null);  // 最后调用系统画笔 把内存中的图片一次性画出来
    }

    // 如何画
    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
        g.drawString("敌方坦克的数量:" + tanks.size(), 10, 80);
        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);

        // 如果用foreach循环的话，在其他地方调用bullets集合的remove方法会报错
        // ConcurrentModifyException 因为这种情况只能调用iterator迭代器的remove方法 不能调用集合的remove方法
        myTank.paint(g);

        // 画子弹
        for (int i=0;i<bullets.size();i++) {
            bullets.get(i).paint(g);
        }

        //画坦克
        for (int i=0;i<tanks.size();i++) {
            tanks.get(i).paint(g);
        }

        // 画爆炸
        for (int i=0;i<explodes.size();i++) {
            explodes.get(i).paint(g);
        }

        // 碰撞检测
        for(int i=0;i<bullets.size();i++){
            for (int  j=0;j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }

    }

    public Tank getMainTank() {
        return  this.myTank;
    }

    class MyKeyListener extends KeyAdapter {
        Boolean bL = false;
        Boolean bR = false;
        Boolean bU = false;
        Boolean bD = false;

        @Override // 键盘按下去
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode(); // 得到key按键的代码
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;

                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;

                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;

                default:
                    break;
            }

            setMainTankDir();
        }

        @Override //键盘抬起来
        public void keyReleased(KeyEvent e) {

            int key = e.getKeyCode(); // 得到key按键的代码
            switch (key) {
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;

                case KeyEvent.VK_CONTROL:
                    myTank.fire();
                    break;

                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {

            if (!bL && !bR && !bU && !bD) {

                myTank.setMoving(false);
            } else {

                myTank.setMoving(true);
                if (bL) myTank.setDir(Dir.LEFT);
                if (bU) myTank.setDir(Dir.UP);
                if (bR) myTank.setDir(Dir.RIGHT);
                if (bD) myTank.setDir(Dir.DOWN);
            }
        }
    }
}