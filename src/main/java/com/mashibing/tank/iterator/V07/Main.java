package com.mashibing.tank.iterator.V07;

/**
 * @date 2020/6/2 - 9:43
 */
public class Main {
    public static void main(String[] args) {
        //Collection_ list = new LinkedList_();
        Collection_ <String> list = new ArrayList_<>();
        for (int i = 0; i <15 ; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());

        Iterator_ <String> it = list.iterator();
        while(it.hasNext()){
            String o = it.next();
            System.out.println(o);
        }
    }
}
