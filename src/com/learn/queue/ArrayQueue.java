package com.learn.queue;

import java.util.Stack;

/**
 * @author 王亚华
 * @Description 数组模拟队列
 * @Date 创建于 2020-03-27 12:57
 */
public class ArrayQueue implements Queue{


    private int front; // 队列头部

    private int rear; // 队列尾部

    private int maxSize; // 队列最大数量

    private int[] arr; // 存放数据的数组


    /**
     * 初始胡数据
     *
     * @param maxQueueSize 最大队列数量
     */
    public ArrayQueue(int maxQueueSize) {
        this.arr = new int[maxQueueSize];
        this.maxSize = maxQueueSize;
        this.front = -1; // 队列的头部，代表的是队列头部的前一个位置
        this.rear = -1;
    }


    /**
     * 判断队列是否满
     *
     * @return 是否满
     */
    public boolean isFull() {
        // 比如最大队列为2   那么添加一个 rear++  0 rear++ 1   那么 1 == (2-1)
        return rear == maxSize - 1;
    }

    /**
     * 判断队列是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return front == rear;
    }


    /**
     * 往队列中添加数据
     *
     * @param n 数据
     */
    public void addQueue(int n) {
        // 判断队列是否已经满了 如果满了就不能再添加了
        if (isFull()) {
            System.out.println("队列已经满了，不能添加了");
            return;
        }
        // 添加到队列中  队列尾部的指针向后移动
        rear++;
        arr[rear] = n;
    }


    /**
     * 获取队列头数据
     *
     * @return
     */
    public int getQueue() {
        // 判断是否为空  如果为空  那么就获取不到数据了
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~");
        }
        return arr[++front];
    }


    /**
     * 展示队列中的数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据展示~");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }


    /**
     * 获取队列头数据 头指针不变
     *
     * @return
     */
    public int headQueue() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~");
        }
        return arr[front + 1];
    }

}
