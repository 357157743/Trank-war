package com.mashibing.tank.state.V2;

/**
 * @date 2020/6/12 - 10:28
 */
public class MMNervousState extends MMState{

    @Override
    void smile() {
        System.out.println("nervous smile!");
    }

    @Override
    void cry() {
        System.out.println("nervous cry!");
    }

    @Override
    void say() {
        System.out.println("nervous say!");
    }
}

