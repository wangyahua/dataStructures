package com.learn.search;

/**
 * @author 王亚华
 * @Description 线性查找
 * @Date 创建于 2020-04-28 09:46
 */
public class SeqSearch {


    public static void main(String[] args) {
        int[] arr = {1, 9, 10, -1, 2, 3, 6};
        int resIndex = seqSearch(arr, -1);
        if (resIndex != -1) {
            System.out.println("找到的索引为：" + resIndex + "，找到的值为：" + arr[resIndex]);
        } else {
            System.out.println("没有找到");
        }
    }


    /**
     * 实现的线性查找是找到一个满足条件的值，就返回
     *
     * @param arr       数组
     * @param findValue 需要找的值
     * @return
     */
    public static int seqSearch(int[] arr, int findValue) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findValue) {
                return i;
            }
        }
        return -1;
    }


}
