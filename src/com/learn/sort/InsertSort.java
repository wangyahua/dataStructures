package com.learn.sort;

import java.text.ParseException;
import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 插入排序 预排序的元素以插入的方式找寻改元素的适当位置，以达到排序的目的
 * @Date 创建于 2020-04-19 22:06
 */
public class InsertSort {


    public static void main(String[] args) throws ParseException {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 分析
     * 原始数组：[101, 34, 119, 1]
     * 插入排序的思想：把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含n - 1个元素，排序过程中每次从无序
     * 表中取出第一个元素，将它的排序码一次与有序元素的数据进行比较，将它插入到有序表中的适当位置，成为新的有序表。
     * 排序思路图：
     *
     *          arr[0]   arr[1]  arr[2]  arr[3]
     * 初始状态  (101)     34       119     1
     *                    |
     *            ________|
     *            |
     * 第一次插入 (34      101)     119     1
     *                             |
     *                             |
     * 第二次插入 (34      101      119)    1
     *                                    |
     *           _________________________|
     *           |
     * 第三次插入 (1       34       101     119)
     *
     * 目前这个数组的有序数组为 [101]
     * 无序数组为 [34, 119, 1]， 但是遍历这个数组不需要拆分为两个数组 一个即可实现：如下：
     *
     * 定义要待插入的数据值：
     * int insertValue = arr[1]; // arr[1] 就是无序表中的第一个值，也就是要插入有序数组中的值
     * int beforeIndex = 1 - 1;  // 待插入值的上一个索引
     *
     * 过程：
     * [101, 34, 119, 1]
     * [101, 101, 119, 1]
     * [34, 101, 119, 119]
     * [34, 101, 119, 119]
     * [34, 34, 101, 119]
     * [1, 34, 101, 119]
     *
     *
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        int insertValue; // 待插入的值
        int beforeIndex; // 待插入值的上一个索引
        // i为1 因为插入排序需要有一个有序  那么定义第一个就是一个有序的 （因为只有一个，所以是有序的）
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            beforeIndex = i - 1;
            // beforeIndex >= 0  遍历中有-- 为了防止数组越界
            // insertValue < arr[beforeIndex] 判断要插入的值 是否与前边的值小 如果小就将上一个值往后移动
            System.out.println(Arrays.toString(arr));
            while (beforeIndex >= 0 && insertValue < arr[beforeIndex]) {
                arr[beforeIndex + 1] = arr[beforeIndex];
                System.out.println(Arrays.toString(arr));
                beforeIndex--;
            }
            if (i != beforeIndex) {
                // 当退出循环时，说明插入的索引找到，将待插入的值插入到指定索引中
                arr[beforeIndex + 1] = insertValue;
            }
        }

        /* *//**
         * 第一轮排序
         *//*
        // 待插入的数据
        int insertValue = arr[1];
        // 待插入的索引
        int insertIndex = 1 - 1;

        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertValue;

        System.out.println("第一轮排序：" + Arrays.toString(arr));


        insertValue = arr[2];
        // 待插入的索引
        insertIndex = 2 - 1;

        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }

        arr[insertIndex + 1] = insertValue;

        System.out.println("第二轮排序：" + Arrays.toString(arr));

        // [34, 101, 119, 1]
        insertValue = arr[3]; // 1
        // 待插入的索引
        insertIndex = 3 - 1; // 2

        // 第一次遍历 （insertIndex = 2）  1 < 119  那么就进行 arr[insertIndex + 1] = arr[insertIndex]   arr[3] = 119 [34, 101, 119, 119]
        // 第二次遍历  (insertIndex = 1)  1 < 101  那么就进行 arr[insertIndex + 1] = arr[insertIndex]  arr[2] = 101  [34, 101, 101, 119]
        // 第三次遍历  (insertIndex = 0)  条件是 >= 0 所以还可以继续遍历  1 < 34 那么就执行 arr[insertIndex + 1] = arr[insertIndex] arr[1] = 34  [34, 34, 101, 119]
        // 第四次 insertIndex = -1  所以就结束遍历

        while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
            arr[insertIndex + 1] = arr[insertIndex];
            insertIndex--;
        }
        // 将要插入的值插入到执行的位置
        arr[insertIndex + 1] = insertValue;

        System.out.println("第三轮排序：" + Arrays.toString(arr));*/

    }


}
