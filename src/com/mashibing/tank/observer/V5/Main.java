package com.mashibing.tank.observer.V5;

import java.util.ArrayList;
import java.util.List;

/** 加入多个观察者
 * @date 2020/5/28 - 8:37
 */

class Child{
    private boolean cry =false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mum());
        observers.add(new Dog());
    }

    public boolean isCry(){ return cry;}

    public void wakeUp(){
        cry=true;
        for (Observer o:observers) {
            o.actionOnWakeUp();
        }
    }
}

interface Observer{
    void actionOnWakeUp();
}

class Dad implements Observer {

    public void feed(){
        System.out.println("dad feeding.....");
    }
    @Override
    public void actionOnWakeUp(){feed();}
}

class Mum implements Observer{
    public void hug(){
        System.out.println("mum hugging.....");
    }
    @Override
    public void actionOnWakeUp(){hug();}
}

class Dog implements Observer{
    public void wang(){
        System.out.println("dog wangwang.....");
    }
    @Override
    public void actionOnWakeUp(){wang();}
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();

        c.wakeUp();
    }
}
