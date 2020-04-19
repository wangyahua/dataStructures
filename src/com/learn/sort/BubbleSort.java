package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 冒泡排序
 * @Date 创建于 2020-04-17 15:37
 */
public class BubbleSort {


    public static void main(String[] args) {
        int[] arr = {3, 9, -1, 10, -2};
        doublesSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 分析：
     * 原始数组：
     * [3,9,-1,10,-2]
     * <p>
     * 第一轮排序： [3,9,-1,10,-2]
     * 1. 索引指向 3与9进行比较，3 < 9 所以不进行位置交换 [3,9,-1,10,-2]
     * 2. 索引指向 9与-1进行比较，9 > -1 所以需要进行位置交换 [3,-1,9,10,-2]
     * 3. 索引指向 9与10进行比较，9 > 10 所以不需要进行位置交换 [3,-1,9,10,-2]
     * 4. 索引指向 10与-2进行比较 10 > -2 所以需要进行位置交换 [3,-1,9,-2,10]
     * ---------------------------------------------------------------- 第一轮得到了最后一个数就是本次数组最大的值
     * 第二轮排序：[3,-1,9,-2,10]
     * 1. 索引指向 3与-1进行比较，3 > -1 所以进行位置交换 [-1,3,9,-2,10]
     * 2. 索引指向 3与9进行比较，3 < 9 所以不进行位置交换 [-1,3,9,-2,10]
     * 3. 索引指向 9与-2进行比较 9 > -2 所以进行位置交换 [-1,3,-2,9,10]
     * ---------------------------------------------------------------- 第二轮不需要遍历数组最后一个数据，因为第一轮已知是最大的。
     * 第三轮排序：[-1,3,-2,9,10]
     * 1. 索引指向 -1与3进行比较 -1 < 3 所以不进行位置交换 [-1,3,-2,9,10]
     * 2. 索引指向 3与-2进行比较 3 > -2 所以进行位置交换 [-1,-2,3,9,10]
     * ---------------------------------------------------------------- 第三轮不需要遍历数组最后两个数据，因为第一、二轮已知是最大的。
     * 第四轮排序：[-1,-2,3,9,10]
     * 1. 索引指向 -1与-2进行标胶  -1 > -2 所以进行位置交换 [-2,-1,3,9,10]
     * <p>
     * <p>
     * 优化：如果存在第二轮的时候顺序已经确定，那么就不需要往后再循环的操作了。
     *
     * @param arr
     */
    public static void doublesSort(int[] arr) {
        int temp;
        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 判断是否需要进行位置交换 比大小 如果符合条件 那么就进行位置交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) { // 如果在一轮排序中没有进行交换位置，那么就不需要再执行下次的循环了，因为数组已经是一个有序的了
                break;
            } else {
                flag = false;
            }
        }

        /**
         * 第一轮排序
         */
        /*
        for (int j = 0; j < arr.length - 1; j++) {
            // 判断是否需要进行位置交换 比大小 如果符合条件 那么就进行位置交换
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        *//**
         * 第二轮排序 再-1是因为第一轮排序最后一个数据已经是最大的，所以就不需要再次参加比较了
         *//*
        for (int j = 0; j < arr.length - 1 - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        *//**
         * 第三轮排序 与第二轮同理
         *//*

        for (int j = 0; j < arr.length - 1 - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));

        *//**
         * 第四轮排序
         *//*
        for (int j = 0; j < arr.length - 1 - 3; j++) {
            if (arr[j] > arr[j + 1]) {
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        System.out.println(Arrays.toString(arr));*/
    }
}
