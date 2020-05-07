package com.learn.hash;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-30 13:34
 */
public class EmpLinkedList {

    private Emp head;

    private Emp last;


    /**
     * 添加
     *
     * @param emp
     */
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            last = head;
        } else {
            last.setNext(emp);
            last = emp;
        }
    }


    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp cur = head;
        while (cur != null) {
            // 如果等于id  那么退出循环 说明当前的cur就是需要找的
            if (cur.getId() == id) {
                break;
            }
            cur = cur.getNext();
        }
        return cur;
    }


    /**
     * 遍历链表
     */
    public void list(int n) {
        if (head == null) {
            System.out.println("链表为空");
            return;
        }
        System.out.print("第"+n+"个链表的信息为：");
        Emp temp = head;
        while (temp != null) {
            System.out.printf("ID:%d,name:%s,address:%s \t", temp.getId(), temp.getName(), temp.getAddress());
            temp = temp.getNext();
        }
        System.out.println();
    }

}
