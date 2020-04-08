package com.learn.stack;

import java.util.Scanner;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-08 11:19
 */
public class TestStack {


    public static void main(String[] args) {
        Stack<String> stack = new LinkListStack<>(2);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("s：表示显示栈");
            System.out.println("e：退出程序");
            System.out.println("push：表示将数据添加栈（入栈）");
            System.out.println("pop：表示从栈取出数据（出栈）");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "s":
                    stack.list();
                    break;
                case "push":
                    System.out.println("请输入内容");
                    String val = scanner.next();
                    stack.push(val);
                    break;
                case "pop":
                    String res = stack.pop();
                    System.out.println("出栈的数据为" + res);
                    break;
                case "e":
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}
