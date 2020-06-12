package com.mashibing.tank.TemplateMethod;

/** TemplateMethod 模版方法 也叫钩子函数 回调函数
 * @date 2020/6/12 - 10:16
 */
public class main {

    public static void main(String[] args) {
         F f = new C1();
         f.m();
    }
}

abstract  class F{
    void m(){
        op1();
        op2();
    }

    abstract void op1();
    abstract void op2();
}

class C1 extends F{

    @Override
    void op1() {
        System.out.println("op1");
    }

    @Override
    void op2() {
        System.out.println("op2");
    }
}
