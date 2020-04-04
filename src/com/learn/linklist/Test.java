package com.learn.linklist;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-03-31 17:21
 */
public class Test {


    public static void main(String[] args) {

        UserNode userNode1 = new UserNode(1, 20, "张一");
        UserNode userNode2 = new UserNode(2, 21, "张二");
        UserNode userNode3 = new UserNode(3, 22, "张三");
        UserNode userNode4 = new UserNode(4, 23, "张四");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(userNode1);
        singleLinkedList.add(userNode2);
        singleLinkedList.add(userNode3);
        singleLinkedList.add(userNode4);

        System.out.println("单链表有线个数：" + SingleLinkedList.getLength(singleLinkedList.getHead()));

        //singleLinkedList.list();

        //System.out.println("开始获取倒数k个节点的数据：");
        //System.out.println(SingleLinkedList.findLastIndexNode(singleLinkedList.getHead(), 1));

        //SingleLinkedList.reverseList(singleLinkedList.getHead());
        //singleLinkedList.list();

        SingleLinkedList.reversePrint(singleLinkedList.getHead());

        /*singleLinkedList.addByOrder(userNode1);
        singleLinkedList.addByOrder(userNode3);
        singleLinkedList.addByOrder(userNode3);
        singleLinkedList.addByOrder(userNode2);
        singleLinkedList.addByOrder(userNode4);


        System.out.println("修改后的链表数据-----");
        singleLinkedList.update(new UserNode(2, 22, "张二~~"));
        singleLinkedList.list();

        System.out.println("删除后的链表数据-----");
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        singleLinkedList.del(2);
        singleLinkedList.del(3);
        singleLinkedList.list();*/

    }

}
