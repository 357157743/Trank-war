package com.mashibing.tank.observer.V4;

/** 加入多个观察者
 * @date 2020/5/28 - 8:37
 */

class Child{
    private boolean cry =false;
    private Dad dad = new Dad();
    private Mum mum = new Mum();
    private Dog dog = new Dog();

    public boolean isCry(){ return cry;}

    public void wakeUp(){
        cry=true;
        dad.feed();
        mum.hug();
        dog.wang();
    }

}

class Dad{
    public void feed(){
        System.out.println("dad feeding.....");
    }
}

class Mum{
    public void hug(){
        System.out.println("mum hugging.....");
    }
}

class Dog{
    public void wang(){
        System.out.println("dog wangwang.....");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();

        c.wakeUp();
    }
}
