package com.mashibing.tank.observer.V3;

/**
 * @date 2020/5/28 - 8:37
 */

class Child{
    private boolean cry =false;
    private Dad d = new Dad();

    public boolean isCry(){ return cry;}

    public void wakeUp(){
        cry=true;
        d.feed();
    }

}

class Dad{
    public void feed(){
        System.out.println("dad feeding.....");
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();

        c.wakeUp();
    }
}
