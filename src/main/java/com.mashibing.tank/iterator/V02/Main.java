package com.mashibing.tank.iterator.V02;


import org.w3c.dom.Node;

/**
 * @date 2020/6/2 - 8:02
 */
public class Main {
    public static void main(String[] args) {
        LikeList_ list = new LikeList_();
        for (int i = 0; i <15 ; i++) {
            list.add(new String("s"+ i ));
        }
    }
}

class LikeList_{
    Node head = null; // 头结点
    Node tail = null; // 尾结点
    // 目前容器中有多少个元素
    private  int size= 0;

    public void add(Object o){
        Node n = new Node(o);
        n.next = null;

        if(head==null){
            head=n;
            tail=n;
        }

        tail.next=n;
        tail=n;
        size++;
    }

    private class Node{
        private Object o; // 真正数据
        Node next; // 指向下一个节点的数据

        public Node(Object o) {
            this.o = o;
        }
        public int size(){
            return size;
        }
    }
}