package com.mashibing.tank.state.V2;

/**
 * @date 2020/6/12 - 10:28
 */
public class MMSadState extends MMState{

    @Override
    void smile() {
        System.out.println("sad smile!");
    }

    @Override
    void cry() {
        System.out.println("sad cry!");
    }

    @Override
    void say() {
        System.out.println("sad say!");
    }
}

