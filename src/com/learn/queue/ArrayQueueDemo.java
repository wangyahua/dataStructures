package com.learn.queue;

import java.util.Scanner;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-03-27 14:16
 */
public class ArrayQueueDemo {


    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        Scanner scanner = new Scanner(System.in);
        char key = ' '; // 接收用户输入的值
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("a(add)：往队列添加数据");
            System.out.println("g(get)：获取队列头数据");
            System.out.println("h(head)：查看队列头数据");
            System.out.println("e(exit)：程序退出");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int n = scanner.nextInt();
                    arrayQueue.addQueue(n);
                    break;
                case 'g':
                    try {
                        System.out.println("获取的数据为：" + arrayQueue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        System.out.println("获取的数据为：" + arrayQueue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
