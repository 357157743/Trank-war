package com.mashibing.tank.iterator.V04;

/**
 * @date 2020/6/2 - 9:43
 */
public class Main {
    public static void main(String[] args) {
        //Collection_ list = new LinkedList_();
        Collection_ list = new ArrayList_();
        for (int i = 0; i <15 ; i++) {
            list.add(new String("s"+i));
        }
        System.out.println(list.size());


        ArrayList_ al = (ArrayList_) list;
        // 如果用这种方式遍历，就不能实现通用了
        for (int i = 0; i <al.size() ; i++) {

        }
    }
}
