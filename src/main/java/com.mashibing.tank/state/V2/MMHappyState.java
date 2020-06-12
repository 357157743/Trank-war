package com.mashibing.tank.state.V2;

/**
 * @date 2020/6/12 - 10:28
 */
public class MMHappyState  extends MMState{

    @Override
    void smile() {
        System.out.println("happy smile!");
    }

    @Override
    void cry() {
        System.out.println("happy cry!");
    }

    @Override
    void say() {
        System.out.println("happy say!");
    }
}

