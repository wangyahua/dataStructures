package com.learn.queue;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-03-30 17:54
 */
public interface Queue {


    public void addQueue(int n);


    public int getQueue();


    boolean isFull();


    boolean isEmpty();


    public void showQueue();


    /**
     * 获取队列头数据 头指针不变
     *
     * @return
     */
    public int headQueue();


}
