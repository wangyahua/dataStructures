package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 归并排序 采用经典的分治策略（分治法是将问题分成一些小的问题然后递归求解），治的阶段则将分的阶段得到的各答案"修补"在一起
 * 即分而治之
 * @Date 创建于 2020-04-23 21:47
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] arr = {8, 4, 5, 7, 1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }


    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            // 向左递归进行分解
            System.out.println("左部分索引位置：" + left + "，" + mid);
            mergeSort(arr, left, mid, temp);
            // 向右递归进行分解
            System.out.println("右部分索引位置：" + (mid + 1) + "，" + right);
            mergeSort(arr, (mid + 1), right, temp);

            merge(arr, left, mid, right, temp);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int tempIndex = 0;
        // i = 0 mid = 4 j = 5 right = 8
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[tempIndex] = arr[i];
                tempIndex++;
                i++;
            } else {
                temp[tempIndex] = arr[j];
                tempIndex++;
                j++;
            }
        }
        while (i <= mid) {
            temp[tempIndex] = arr[i];
            tempIndex++;
            i++;
        }
        while (j <= right) {
            temp[tempIndex] = arr[j];
            tempIndex++;
            j++;
        }
        // 将数据拷贝到arr中
        // 第一次合并 tempLeft = 0 right = 1
        // 第二次合并 tempLeft = 2 right = 3
        // 第三次合并 tempLeft = 0 right = 3
        // 第四次合并 tempLeft = 4 right = 5
        // 第五次合并 tempLeft = 6 right = 7
        // 第六次合并 tempLeft = 4 right = 7
        // 第七次合并 tempLeft = 0 right = 7
        tempIndex = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempLeft++;
            tempIndex++;
        }
    }
}
