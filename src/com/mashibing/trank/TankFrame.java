package com.mashibing.trank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @date 2020/4/17 - 9:27
 */
public class TankFrame extends Frame {

    GameModel gm = new GameModel();

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
        gm.paint(g);

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
                    gm.getMainTank().fire();
                    break;

                default:
                    break;
            }

            setMainTankDir();
        }

        private void setMainTankDir() {

            if (!bL && !bR && !bU && !bD) {

                gm.getMainTank().setMoving(false);
            } else {

                gm.getMainTank().setMoving(true);
                if (bL) gm.getMainTank().setDir(Dir.LEFT);
                if (bU) gm.getMainTank().setDir(Dir.UP);
                if (bR) gm.getMainTank().setDir(Dir.RIGHT);
                if (bD) gm.getMainTank().setDir(Dir.DOWN);
            }
        }
    }
}