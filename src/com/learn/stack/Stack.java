package com.learn.stack;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-08 11:02
 */
public interface Stack<E> {


    /**
     * 栈是否满
     * @return
     */
    boolean isFul();


    /**
     * 栈是否空
     * @return
     */
    boolean isEmpty();


    /**
     * 入栈
     * @param value
     */
    void push(E value);


    /**
     * 出战
     * @return
     */
    E pop();


    /**
     * 打印栈
     */
    void list();
}
