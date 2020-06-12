package com.mashibing.tank.state.V2;

/** state模式
 * @date 2020/6/12 - 10:28
 */
public class MM {
    String name;
    MMState state;

    public static void main(String[] args) {
        MMState ms =  new MMHappyState();
        ms.say();
    }

    public void smile(){
        state.smile();
    }

    public void cry(){
        state.cry();
    }

    public void say(){
        state.say();
    }

}

