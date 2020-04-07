package com.learn.linklist;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-07 10:16
 */
public class Test2 {


    public static void main(String[] args) {
        UserNode2 userNode1 = new UserNode2(1, 20, "张一");
        UserNode2 userNode2 = new UserNode2(2, 21, "张二");
        UserNode2 userNode3 = new UserNode2(3, 22, "张三");
        UserNode2 userNode4 = new UserNode2(4, 23, "张四");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(userNode1);
        doubleLinkedList.add(userNode2);
        doubleLinkedList.add(userNode3);
        doubleLinkedList.add(userNode4);

        doubleLinkedList.list();

        //修改
        UserNode2 newUserNode = new UserNode2(4, 24, "张四~~");
        doubleLinkedList.update(newUserNode);
        System.out.println("修改后的情况~~");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        doubleLinkedList.del(1);
        doubleLinkedList.del(2);
        doubleLinkedList.del(4);
        System.out.println("删除后的情况~~");
        doubleLinkedList.list();
    }


}
