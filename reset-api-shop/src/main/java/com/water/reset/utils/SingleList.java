package com.water.reset.utils;

import static sun.plugin2.os.windows.OSVERSIONINFOA.size;

public class SingleList<T> {

    private Node head; //头结点

    /**
     * 单链表结点类
     */
    public class Node<T> {

        T value; //数据域
        Node next; //指针域

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    /**
     * 添加结点至链表头部
     *
     * @param value
     */
    public void addHeadNode(T value) {
        Node newNode = new Node(value);
        //头结点不存在，新结点成为头结点
        if (head == null) {
            head = newNode;
            return;
        }
        //新结点next直接指向当前头结点
        newNode.next = head;
        //新结点成为新的头结点
        head = newNode;
    }

    /**
     * 添加结点至链表尾部
     *
     * @param value
     */
    public void addTailNode(T value) {
        Node newNode = new Node(value);
        //头结点不存在，新结点成为头结点
        if (head == null) {
            head = newNode;
            return;
        }
        //找到最后一个结点
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        //新结点插入到链表尾部
        last.next = newNode;
    }

    /**
     * 结点插入至指定位置
     *
     * @param value 结点数据
     * @param index 插入位置
     */
    public void addNodeAtIndex(T value, int index) {
        if (index < 0 || index > size()) { //注意index是可以等于size()的
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        if (index == 0) {  //插入到头部
            addHeadNode(value);
        } else if (index == size()) {  //插入到尾部
            addTailNode(value);
        } else {  //插到某个中间位置
            Node newNode = new Node(value);
            int position = 0;
            Node cur = head;  //标记当前结点
            Node pre = null;  //记录前置结点
            while (cur != null) {
                if (position == index) {
                    newNode.next = cur;
                    pre.next = newNode;
                    return;
                }
                pre = cur;
                cur = cur.next;
                position++;
            }
        }
    }

    /**
     * 删除指定位置的结点
     *
     * @param index 指定位置
     */
    public void deleteNodeAtIndex(int index) {
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
        }
        if (index == 0) { //删除头
            head = head.next;
            return;
        }
        int position = 0;  //记录当前位置
        Node cur = head;  //标记当前结点
        Node pre = null;  //记录前置结点
        while (cur != null) {
            if (position == index) {
                pre.next = cur.next;
                cur.next = null;  //断开cur与链表的连接
                return;
            }
            pre = cur;
            cur = cur.next;
            position++;
        }

    }
}
