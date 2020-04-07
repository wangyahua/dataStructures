package com.learn.linklist;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-07 10:53
 */
public class Number {

    private int num;

    private Number next;

    public Number(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Number getNext() {
        return next;
    }

    public void setNext(Number next) {
        this.next = next;
    }
}
