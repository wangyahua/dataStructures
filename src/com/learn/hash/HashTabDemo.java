package com.learn.hash;

import java.util.Scanner;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-30 13:51
 */
public class HashTabDemo {


    public static void main(String[] args) {
        HashTab hashTab = new HashTab(3);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add -> 添加用户信息");
            System.out.println("list -> 显示用户信息");
            System.out.println("find -> 查找用户信息");
            System.out.println("exit -> 退出系统");
            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名");
                    String name = scanner.next();
                    System.out.println("输入地址");
                    String address = scanner.next();
                    Emp emp = new Emp(id, name, address);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("输入要查找的ID");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }


}
