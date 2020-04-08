package com.learn.linklist;

/**
 * @author 王亚华
 * @Description 环形链表
 * @Date 创建于 2020-04-07 10:51
 */
public class CircleSingleLinkedList {

    private Number first;

    private Number last;


    public void add(Number number) {
        if (first == null) {
            first = number;
            first.setNext(first);
            last = first;
        } else {
            last.setNext(number);
            number.setNext(first);
            last = number;
        }
    }


    /**
     * Josephus问题：设编号为1,2,....n的n个人围坐在一起，约定编号为k(1 <= k <= n)的人从1开始报数，数到m的那个人出列，它的下一位又从1开始报数，
     * 数到m的那个人又出列，以此类推，知道所有人出列为止，由此产生出一个出队编号的序列。
     *
     * 设：
     * n = 5; 5个人围坐一圈，编号以此为1,2,3,4,5
     * k = 1; 从第一个开始报数
     * m = 2; 数2下后这个就出列
     *
     * 第一次：
     * 1,2,3,4,5  从1开始数，数2个 1，2 那么2进行出列
     * 第二次：
     * 1,3,4,5 从3开始数，因为2的下一位是3，再数2个：3，4 那么4进行出列
     * 第三次：
     * 1,3,5  从5开始数，因为4的下一位是5，再数2个：5，1 那么1进行出列
     * 第四次：
     * 3,5  从3开始数，因为1的下一位是3，再数2个：3，5 那么5进行出列
     * 第五次：
     * 3  从3开始数，最后一个  那么3出列
     *
     * 得到的结果为 2->4->1->5->3
     *
     */

    /**
     * 出队编号
     *
     * @param n 共有多少个编号  从1开始
     * @param k 表示从第几个编号开始数
     * @param m 表示数几次出队
     */
    public void josephus(int n, int k, int m) {
        for (int j = 1; j <= n; j++) {
            add(new Number(j));
        }
        System.out.println("打印数据~~~");
        list();

        // 需要先校验一下参数
        if (first == null) {
            System.out.println("无数据");
            return;
        }
        if (n < 1 || k > n) {
            System.out.println("参数有误");
            return;
        }
        // 处理k参数  从第几个编号开始 那么其实就是变化first的引用
        for (int i = 0; i < k - 1; i++) {
            first = first.getNext();
            last = last.getNext();
        }

        System.out.printf("编号出队顺序");
        while (true) {
            // 在first与last相等的时候  那么就是最后一个节点 进行跳出循环
            if (first == last) {
                break;
            }
            // 需要根据m次找到要出队的节点
            for (int i = 0; i < m - 1; i++) {
                first = first.getNext();
                last = last.getNext();
            }
            // 这个时候first指向的节点就是要出队的接地那
            System.out.printf("%d->", first.getNum());
            // 这时候需要将这个节点删除
            first = first.getNext();
            last.setNext(first);
        }
        // 最后一个节点出队
        System.out.println(first.getNum());
    }


    /**
     * 遍历
     */
    public void list() {
        if (first == null) {
            System.out.println("没有数据");
            return;
        }
        Number curNum = first;
        while (true) {
            System.out.printf("序号为%d\n", curNum.getNum());
            // 判断是否已经到了最后  如果是最后跳出循环
            if (curNum == last) {
                break;
            }
            curNum = curNum.getNext();
        }
    }


}
