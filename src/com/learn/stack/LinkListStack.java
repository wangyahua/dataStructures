package com.learn.stack;

/**
 * @author 王亚华
 * @Description 使用链表模拟栈
 * @Date 创建于 2020-04-08 11:30
 */
public class LinkListStack<E> implements Stack<E> {

    /**
     * 头节点
     */
    private Node<E> first;

    /**
     * 尾节点
     */
    private Node<E> last;

    /**
     * 最大存放数量  使用链表形式存储
     */
    private int maxSize;

    /**
     * 计算有效个数
     */
    private int size;


    public LinkListStack() {

    }


    public LinkListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    /**
     * 普通的链表添加
     *
     * @param e
     */
    public void add(E e) {
        Node<E> newNode = new Node<>(e, null);
        if (first == null) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
        }
    }


    @Override
    public boolean isFul() {
        if (maxSize <= 0) {
            return false;
        } else {
            return size == maxSize;
        }
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void push(Object value) {
        if (isFul()) {
            System.out.println("栈满了");
            return;
        }
        /**
         * 需要遵循栈的先进后出的原则  所以需要将链表进行反转的一个操作，在linklist中做过单链表反转的功能，由此：
         * 相当于addFirst
         *
         *
         */
        if (first == null) {
            first = new Node<>((E) value, null);
            last = first;
        } else {
            first = new Node<>((E) value, first);
        }
        size++;
    }


    @Override
    public E pop() {
        /**
         * 取出数据
         */
        if (isEmpty()) {
            System.out.println("栈空");
            return null;
        }
        E temp = first.item;
        first = first.next;
        size--;
        return temp;
    }


    public E peek(){
        if(isEmpty()){
            System.out.println("栈空");
            return null;
        }
        return first.item;
    }


    public void list() {
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        Node<E> temp = first;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }


    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }


}
