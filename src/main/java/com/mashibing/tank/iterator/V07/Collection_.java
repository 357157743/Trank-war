package com.mashibing.tank.iterator.V07;

/**
 * @date 2020/6/2 - 9:09
 */
public interface Collection_ <E>{
    void add(E o);
    int size();

    Iterator_ <E> iterator();
}

