package com.learn.linklist;

/**
 * @author 王亚华
 * @Description 用户信息节点
 * @Date 创建于 2020-03-31 15:05
 */
public class UserNode2 {

    /**
     * 编号
     */
    private int id;

    /**
     * 年龄
     */
    private int age;


    /**
     * 姓名
     */
    private String name;


    /**
     * 当前节点的下一个节点
     */
    private UserNode2 next;


    private UserNode2 prev;


    public UserNode2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public UserNode2 getNext() {
        return next;
    }

    public void setNext(UserNode2 next) {
        this.next = next;
    }


    public UserNode2 getPrev() {
        return prev;
    }

    public void setPrev(UserNode2 prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", age=" + age + ", name='" + name + ']';
    }
}
