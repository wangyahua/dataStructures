package com.learn.sf;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-27 18:56
 */
public class Test1 {


    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        oddEvenList(head1);

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;//如果该链表内节点数在两个及以下直接返回头节点

        ListNode odd = head;//奇节点的第一个

        ListNode evenHead = head.next;

        ListNode even = evenHead;//偶节点的第一个

        ListNode temp = even.next;

        int index = 1;

        while (temp != null) {
            if (index == 0) {
                even.next = temp;
                even = temp;
                index = 1;
            } else {
                odd.next = temp;
                odd = temp;
                index = 0;
            }
            temp = temp.next;
        }
        even.next = null;

        odd.next = evenHead;
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
