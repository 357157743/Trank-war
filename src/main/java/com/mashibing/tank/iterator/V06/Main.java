package com.mashibing.tank.iterator.V06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @date 2020/6/2 - 10:39
 */
public class Main {
    public static void main(String[] args) {
        Collection c = new ArrayList();
        for (int i = 0; i < 15 ; i++) {
            c.add(new String("s"+i));
        }

        Iterator it = c.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
