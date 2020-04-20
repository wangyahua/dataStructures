package com.learn.recursion;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-04-17 10:17
 */
public class RecursionTest {


    public static void main(String[] args) {
        System.out.println(test(4));
    }


    public static int test(int n) {
        if (n > 2) {
            return test(n - 1) + n;
        } else {
            return n;
        }
    }

}
