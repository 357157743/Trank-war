package com.mashibing.tank.spring.V02;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @date 2020/6/1 - 16:19
 */
@Aspect
public class TimeProxy {

    @Before("execution(void com.mashibing.tank.spring.V02.Tank.move())")
    public void before(){
        System.out.println("method start..." + System.currentTimeMillis());
    };

    @After("execution(void com.mashibing.tank.spring.V02.Tank.move())")
    public void after(){
        System.out.println("method stop..." + System.currentTimeMillis());
    };
}
