package com.mashibing.tank.observer.V9;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;

/**
 * @date 2020/5/28 - 10:28
 */
public class TestFrame extends Frame {
    public void launch(){
        Button b = new Button("press me!");
        b.addActionListener(new MyActionListener());
        b.addActionListener(new MyActionListener2());
        this.add(b);
        this.pack();

   //     this.addWindowListener((WindowAdapter) windowClosing(e) -> {System.exit(0);});
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TestFrame().launch();
    }

    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button press");
        }
    }

    private class MyActionListener2 implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("button press2");
        }
    }
}
