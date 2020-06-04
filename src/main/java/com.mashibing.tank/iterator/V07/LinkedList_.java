package com.mashibing.tank.iterator.V07;


/**
 * @date 2020/6/2 - 9:42
 */
public class LinkedList_  implements Collection_ {
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
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator_ {

        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }
    }
}
