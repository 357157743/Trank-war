package com.mashibing.tank.observer.V2;

/**
 * @date 2020/5/28 - 8:26
 */
 class Child {
    private boolean cry=false;

    public boolean isCry(){ return cry;}

    public void wakeUp(){
        System.out.println("waked up! wuwuwuwuwuuw");
    }
}

public  class Main{
    public static void main(String[] args) {
        Child child = new Child();
        while(! child.isCry()){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("observing......");
        }
    }
}
