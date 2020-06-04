package com.mashibing.tank.spring.V01;

/**
 * @date 2020/6/1 - 16:19
 */
public class TimeProxy {

    public void before(){
        System.out.println("method start..." + System.currentTimeMillis());
    };

    public void after(){
        System.out.println("method stop..." + System.currentTimeMillis());
    };
}
