package com.learn.linklist;

/**
 * @author 王亚华
 * @Description 环形链表
 * @Date 创建于 2020-04-07 10:51
 */
public class CircleSingleLinkedList {

    private Number first;


    public void add(Number number) {
        if (first == null) {
            first = number;
            first.setNext(first);
        } else {
            // 获取最后一个节点
            Number temp = first;
            while (temp.getNext() != first) {
                temp = temp.getNext();
            }
            temp.setNext(number);
            number.setNext(first);
        }
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
            if (curNum.getNext() == first) {
                break;
            }
            curNum = curNum.getNext();
        }
    }


}
