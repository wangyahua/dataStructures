package com.learn.stack;

/**
 * @author 王亚华
 * @Description 使用数组模拟栈
 * @Date 创建于 2020-04-08 11:04
 */
public class ArrayStack<E> implements Stack<E> {
    /**
     * 栈的大小
     */
    private int maxSize;

    /**
     * 栈顶的索引
     */
    private int top = -1;

    /**
     * 数组  数组模拟栈  数据放在数组中
     */
    private Object[] stack;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new Object[maxSize];
    }


    @Override
    public boolean isFul() {
        return top == maxSize - 1;
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public void push(Object value) {
        //判断栈是否满
        if (isFul()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    @Override
    public E pop() {
        //判断栈是否为空
        if (isEmpty()) {
            System.out.println("栈空");
            return null;
        }
        E temp = (E) stack[top];
        top--;
        return temp;
    }

    @Override
    public void list() {
        //遍历
        if (isEmpty()) {
            System.out.println("栈空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println("stack[" + i + "]=" + stack[i]);
        }
    }
}
