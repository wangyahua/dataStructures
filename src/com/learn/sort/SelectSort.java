package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 选择排序 是预排序数据中，按照指定的规则选出某一个元素，再依据规定交换位置后达到排序的目的。
 * @Date 创建于 2020-04-19 20:54
 */
public class SelectSort {


    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 分析：
     * 原始数据：101,34,119,1
     * 先选择数组中的某一个元素，暂定这个元素为最小值，后续遍历数据再更改。
     * minValue = arr[0] = 101 选择数组中一个元素作为一个假设值
     * <p>
     * 1. 从索引1开始遍历找到最小的值（比较minValue）
     * 101 > 34 那么此时 minValue = 34，继续遍历
     * 34 > 34 那么此时依旧是 minValue = 34，继续遍历
     * 34 > 119 那么此时依旧是 minValue = 34，继续遍历
     * 34 > 1 那么此时 minValue = 1， 结束遍历。
     * 如果minValue != arr[0] 的时候 那么就进行交换位置 [1,34,119,101]
     * <p>
     * minValue = arr[1] = 34 选择数组中的第二个元素  因为第一个元素上一次对比已知是最小值了
     * 2. 从索引2开始遍历找到最小值（比较minValue）
     * 34 > 119 那么此时依旧是minValue = 34，继续遍历
     * 34 > 101 那么此时依旧是minValue = 34，结束遍历。
     * 如果minValue != arr[1] 的时候，那么就进行交换位置，这次是相等的，所以条件不成立，所以不进行交换 [1,34,119,101]
     * <p>
     * minValue = arr[2] = 119
     * 2. 从索引3开始遍历找到最小值（比较minValue）
     * 119 > 101 那么此时minValue = 101，遍历结束
     * 如果minValue != arr[2] 的时候，那么就进行交换位置 [1,34,119,101]
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[minIndex];
            for (int j = 1 + i; j < arr.length; j++) {
                if (min > arr[j]) {
                    minIndex = j;
                    min = arr[j];
                }
            }
            if (min != arr[i]) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
        /*int minIndex = 0;
        int min = arr[minIndex];
        *//**
         * 第一轮排序
         *//*
        for (int j = 1; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (min != arr[0]) {
            arr[minIndex] = arr[0];
            arr[0] = min;
            System.out.println(Arrays.toString(arr));
        }


        minIndex = 1;
        min = arr[minIndex];
        for (int j = 1 + 1; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (min != arr[1]) {
            arr[minIndex] = arr[1];
            arr[1] = min;
            System.out.println(Arrays.toString(arr));
        }


        minIndex = 2;
        min = arr[minIndex];
        for (int j = 1 + 2; j < arr.length; j++) {
            if (min > arr[j]) {
                min = arr[j];
                minIndex = j;
            }
        }
        if (min != arr[2]) {
            arr[minIndex] = arr[2];
            arr[2] = min;
            System.out.println(Arrays.toString(arr));
        }*/
    }


}
