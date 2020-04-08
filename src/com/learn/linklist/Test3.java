package com.learn.linklist;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-07 11:06
 */
public class Test3 {


    public static void main(String[] args) {

        Number number1 = new Number(1);
        Number number2 = new Number(2);
        Number number3 = new Number(3);
        Number number4 = new Number(4);
        Number number5 = new Number(5);

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        /*circleSingleLinkedList.add(number1);
        circleSingleLinkedList.add(number2);
        circleSingleLinkedList.add(number3);
        circleSingleLinkedList.add(number4);
        circleSingleLinkedList.add(number5);

        circleSingleLinkedList.list();*/

        circleSingleLinkedList.josephus(5, 2, 2);

    }

}
