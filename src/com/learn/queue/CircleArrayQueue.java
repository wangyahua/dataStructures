package com.learn.queue;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 环形数组队列实现
 * @Date 创建于 2020-03-30 13:20
 */
public class CircleArrayQueue implements Queue {


    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;


    public CircleArrayQueue(int maxSize) {
        maxSize = maxSize + 1;
        this.maxSize = maxSize;
        front = 0;
        rear = 0;
        arr = new int[maxSize];
    }


    public void addQueue(int n) {
        // 判断队列是否已经满了 如果满了就不能再添加了
        if (isFull()) {
            System.out.println("队列已经满了，不能添加了");
            return;
        }
        arr[rear] = n;
        System.out.println("addQueue ---> " + rear + " + 1" + "%" + maxSize + ";" + front);
        rear = (rear + 1) % maxSize;
    }


    public int getQueue() {
        // 判断是否为空  如果为空  那么就获取不到数据了
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据~");
        }
        int tempValue = arr[front];
        System.out.println("front--->" + front);
        System.out.printf("front + 1 取模 maxSize = (%d + 1) 取模 %d \n", front, maxSize);
        front = (front + 1) % maxSize;
        System.out.println("front--->" + front);
        return tempValue;
    }


    public boolean isFull() {
        System.out.println("isFull ---> " + rear + " + 1" + "%" + maxSize + ";" + front);
        return (rear + 1) % maxSize == front;
    }


    public boolean isEmpty() {
        return rear == front;
    }


    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // 思路：从front开始遍历  遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }


    public int size() {
        // rear = 1
        // front = 0
        // maxSize = 4
        // (1 + 4 - 0) % 4 = 5 % 4 = 1
        return (rear + maxSize - front) % maxSize;
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
        return arr[front];
    }

}
