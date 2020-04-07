package com.learn.linklist;

import java.util.Stack;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-03-31 15:09
 */
public class SingleLinkedList {

    private UserNode head = new UserNode(0, 0, "");

    public UserNode getHead() {
        return head;
    }

    public void add(UserNode userNode) {
        // head为头结点，所以不能动  那么找一个临时的变量代替
        UserNode temp = head;
        // 通过遍历查找最后一个节点
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        //找到最后一个节点  temp遍历后就是最后一个节点，将最后一个节点的next设置为当前加入的节点
        temp.setNext(userNode);
    }


    /**
     * 根据id添加有序链表
     * @param userNode
     */
    public void addByOrder(UserNode userNode) {
        UserNode temp = head;
        boolean flag = false;
        while (true) {
            // 说明链表已经在最后了
            if (temp.getNext() == null) {
                break;
            }
            // 如果下一个节点的数据大于当前节点的数据 那么就跳出循环  temp就是要插入的节点
            if (temp.getNext().getId() > userNode.getId()) {
                break;
            } else if (temp.getNext().getId() == userNode.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            System.out.printf("编号ID为%d已存在，不能添加\n", userNode.getId());
        } else {
            userNode.setNext(temp.getNext());
            temp.setNext(userNode);
        }
    }


    /**
     * 合并两个链表 合并后的链表依然有序
     * @param userNode
     * @param userNode1
     */
    public void mergeByOrder(UserNode userNode, UserNode userNode1){

    }


    /**
     * 更新节点
     * @param userNode
     */
    public void update(UserNode userNode) {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        boolean flag = false;
        UserNode temp = head.getNext();
        while (temp.getNext() != null) {
            if (temp.getId() == userNode.getId()) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setAge(userNode.getAge());
            temp.setName(userNode.getName());
        } else {
            System.out.printf("没有找到编号ID为%d的数据", userNode.getId());
        }

    }


    /**
     * @param id
     */
    public void del(int id) {
        UserNode temp = head;
        boolean flag = false;
        while (true) {
            // 已经到了链表的最后 退出循环
            if (temp.getNext() == null) {
                break;
            }
            //特别注意  是next下的id  这样才能是要删除节点的上一个节点
            if (temp.getNext().getId() == id) {
                flag = true;
                break;
            }
            temp = temp.getNext();
        }
        if (flag) {
            temp.setNext(temp.getNext().getNext());
        } else {
            System.out.printf("没有找到编号ID为%d的，删除失败", id);
        }
    }


    /**
     * 获取单链表的有效个数
     * @param head
     * @return
     */
    public static int getLength(UserNode head) {
        if (head.getNext() == null) {
            return 0;
        }
        int length = 0;
        UserNode cur = head.getNext();
        while (cur != null) {
            length++;
            cur = cur.getNext();
        }
        return length;
    }


    /**
     * 查找单链表中的倒数第k个节点
     *
     * @param head
     * @param index
     * @return
     */
    public static UserNode findLastIndexNode(UserNode head, int index) {
        if (head.getNext() == null) {
            return null;
        }
        // 需要知道有效节点的个数
        int length = getLength(head);
        if (index <= 0 || index > length) {
            return null;
        }
        UserNode cur = head.getNext();
        //从0开始遍历，遍历的结束的是最长有效个数减去要找到的第k个节点  那么最后一个就是那个节点
        for (int i = 0; i < (length - index); i++) {
            cur = cur.getNext();
        }
        return cur;
    }


    /**
     * 将单链表反转
     *
     * @param head
     */
    public static void reverseList(UserNode head) {
        /**
         * 思路：
         * 1. 创建一个新的newUserNode的头节点。
         * 2. 遍历head下的所有的节点，没遍历一个节点赋值到新的newUserNode的节点上。
         * 3. 遍历赋值的时候需要设置指针的引用  需要先保存一下下一个节点的引用，因为后边会重新设置，所以要先保存一下 ,当前的node.next = newUserNode.next  那么newUserNode.next = node
         * 4. 最后让head.next = newUserNode.next
         */
        // 校验数据
        if (head.getNext() == null || head.getNext().getNext() == null) {
            return;
        }
        // 得到当前的节点
        UserNode cur = head.getNext();
        UserNode next;
        //需要有一个新的头结点
        UserNode newUserNode = new UserNode(0, 0, "");
        while (cur != null) {
            next = cur.getNext();
            cur.setNext(newUserNode.getNext());
            newUserNode.setNext(cur);
            cur = next;
        }
        head.setNext(newUserNode.getNext());
    }


    /**
     * 单链表的逆序打印
     */
    public static void reversePrint(UserNode head) {
        /**
         * 可以使用栈的数据结构，将各个节点压入到栈中，然后利用栈的先进后出的特点就实现了逆序打印。
         */
        if (head.getNext() == null) {
            return;
        }
        //创建一个栈
        Stack<UserNode> stack = new Stack<>();
        // 遍历单链表，将左右的数据压入到栈中
        UserNode cur = head.getNext();
        while (cur != null) {
            stack.push(cur);
            cur = cur.getNext();
        }
        //将栈中的数据进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop()); // 栈的特点就是先进后出的
        }
    }





    public void list() {
        if (head.getNext() == null) {
            System.out.println("链表为空");
            return;
        }
        UserNode temp = head.getNext();
        while (temp != null) {
            System.out.println(temp);
            temp = temp.getNext();
        }
    }


}
