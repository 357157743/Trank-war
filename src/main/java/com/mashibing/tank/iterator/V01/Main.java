package com.mashibing.tank.iterator.V01;

import java.util.ArrayList;

/**
 * @date 2020/6/2 - 8:02
 */
public class Main {
    public static void main(String[] args) {
        ArrayList_ list = new ArrayList_();
        for (int i = 0; i <15 ; i++) {
            list.add(new String("s" + i));
            System.out.println(list.toString());
        }
        System.out.println("list="+list.size());
    }
}

// 不用考虑边界问题，可以自己动态扩展
class ArrayList_{
    Object[] objects = new Object[10];
    private int index = 0;
    public void add(Object o){
        if(index ==objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
         }

        objects[index] = o;
        index++;
    }
    public int size(){
        return  index;
    }
}