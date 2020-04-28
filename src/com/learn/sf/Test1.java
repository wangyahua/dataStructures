package com.learn.sf;

import java.util.List;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-27 18:56
 */
public class Test1 {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        oddEvenList(head);

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;//如果该链表内节点数在两个及以下直接返回头节点
        ListNode odd = head;//奇节点的第一个

        ListNode even = head.next;//偶节点的第一个

        ListNode cur = even;
        int index = 2;
        while (cur.next != null){
            ListNode temp = cur;

            if(index % 2 == 0){


            }else{
                odd.next = cur;
                odd = cur;
            }


            index++;
            cur = cur.next;

        }






        return head;
    }


}


class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val + "}";
    }
}
