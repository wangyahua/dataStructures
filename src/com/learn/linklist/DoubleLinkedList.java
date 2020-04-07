package com.learn.linklist;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-07 09:51
 */
public class DoubleLinkedList {


    private UserNode2 head = new UserNode2(0, 0, "");

    public UserNode2 getHead() {
        return head;
    }

    /**
     * 遍历链表
     */
    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        UserNode2 temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }


    /**
     * 添加元素
     *
     * @param userNode
     */
    public void add(UserNode2 userNode) {
        // head为头结点，所以不能动  那么找一个临时的变量代替
        UserNode2 temp = head;
        // 通过遍历查找最后一个节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        // 找到最后一个节点后  将最后一个节点的next设置为userNode  那么userNode的prev设置为temp
        if (temp.equals(userNode)) {
            System.out.println("节点已存在，请确认后再添加");
            return;
        }
        temp.setNext(userNode);
        userNode.setPrev(temp);
    }


    public void update(UserNode2 userNode2) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        UserNode2 temp = head.getNext();
        while (temp != null) {
            if (temp.getId() == userNode2.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setAge(userNode2.getAge());
            temp.setName(userNode2.getName());
        } else {
            System.out.printf("编号ID为%d不存在", userNode2.getId());
        }
    }


    public void del(int id) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        UserNode2 temp = head.getNext();
        while (temp != null) {
            if (temp.getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        // temp就是要删除的节点  那么删除自身  就需要将next于prev指向别处    temp.prev.next = temp.next;      temp.next.prev = temp.prev;
        if (flag) {
            temp.getPrev().setNext(temp.getNext());
            if (temp.getNext() != null) {
                temp.getNext().setPrev(temp.getPrev());
            }
        } else {
            System.out.printf("删除的编号ID%d未找到", id);
        }
    }


}
