package com.mashibing.tank.iterator.V04;

/**
 * @date 2020/6/2 - 9:09
 */
public class ArrayList_ implements Collection_ {
    Object[] objects = new Object[10];
    private int index = 0;

    public void add(Object o){
        if(index == objects.length){
            Object[] newObjects = new Object[objects.length*2];
            System.arraycopy(objects,0,newObjects,0,objects.length);
            objects = newObjects;
        }
        objects[index]=o;
        index++;
    }
    public int size(){return index;}
}
