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
            while (beforeIndex >= 0 && insertValue < arr[beforeIndex]) {
                arr[beforeIndex + 1] = arr[beforeIndex];
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
