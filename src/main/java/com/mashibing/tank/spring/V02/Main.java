package com.mashibing.tank.spring.V02;

import com.mashibing.tank.spring.V02.Tank;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @date 2020/6/1 - 16:09
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("app_auto.xml");
        Tank t = (Tank) context.getBean("tank");
        t.move();
    }
}
