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
        int[] arr = {8, 4, 5, 7 ,1, 3, 6, 2};
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路分析：
     * 原始数组：[8, 4, 5, 7 ,1, 3, 6, 2]
     *
     * 排序图
     *            [8, 4, 5, 7 ,1, 3, 6, 2]
     *               ／                ＼
     *              ／                  ＼
     *        [8, 4, 5, 7]         [1, 3, 6, 2]
     *          ／     ＼              ／     ＼
     *         ／       ＼            ／       ＼
     *      [8, 4]     [5, 7]      [1, 3]    [6, 2]
     *       ／           ＼          ／        ＼
     *      ／             ＼        ／          ＼
     *   [8] [4]        [5] [7]   [1] [3]     [6] [2]
     * --------------------------------------------------------- 上图为分，下图为治
     *    ＼               ／        ＼           ／
     *     ＼             ／          ＼         ／
     *   [4, 8]        [5, 7]      [1, 3]     [2, 6]
     *       ＼        ／             ＼        ／
     *        ＼      ／               ＼      ／
     *      [4, 5, 7 , 8]            [1, 2, 3, 6]
     *           ＼                     ／
     *            ＼                   ／
     *           [1, 2, 3, 4, 5, 6, 7, 8]
     *
     * 治的阶段需要将两个已经有序的子序列合并成一个有序的序列
     * 如果上图中的最后一次合并（前边还有6次的合并，举例举的是最后一次合并的分析图），将[4, 5, 7 , 8]与[1, 2, 3, 6]两个有序的子序列
     * 合并为一个有序序列[1, 2, 3, 4, 5, 6, 7, 8]，实现步骤：
     *
     *
     * 设定两个索引，指向两个子序列的初始化，一个是i,一个是j，然后获取值进行对比
     *
     *
     * 1 < 4 将1填入temp数组中,j右移动            temp
     * [4, 5, 7 , 8,| 1, 2, 3, 6]               [1]
     *  ↑             ⇡  ↑
     *  i             j  j
     *                右移
     *
     * 2 < 4 将2填入temp数组中,j右移动            temp
     * [4, 5, 7 , 8, | 1, 2, 3, 6]              [1, 2]
     *  ↑                 ⇡  ↑
     *  i                 j  j
     *                    右移
     *
     * 3 < 4 将3填入temp数组中,j右移动            temp
     * [4, 5, 7 , 8, | 1, 2, 3, 6]              [1, 2, 3]
     *  ↑                    ⇡  ↑
     *  i                    j  j
     *                       右移
     *
     * 4 < 6 将4填入temp数组中,i右移动            temp
     * [4, 5, 7 , 8, | 1, 2, 3, 6]              [1, 2, 3, 4]
     *  ⇡  ↑                    ↑
     *  i  i                    j
     *  右移
     *
     * 5 < 6 将5填入temp数组中,i右移动            temp
     * [4, 5, 7 , 8, | 1, 2, 3, 6]              [1, 2, 3, 4, 5]
     *     ⇡  ↑                 ↑
     *     i  i                 j
     *
     *
     * 6 < 7 将6填入temp数组中,j右移动,此时j移动出去，下次就不会再遍历了               temp
     * [4, 5, 7 , 8, | 1, 2, 3, 6]                                          [1, 2, 3, 4, 5, 6]
     *     ⇡  ↑                    ↑
     *     i  i                    j
     *
     *
     *
     * 因右边有序子序列遍历完成，那么就不需要再遍历了，让左边没有遍历完成的，直接加入进去即可
     * 因为没有值进行比较，并且都是有序子序列，所以直接填入temp数组中即可
     *                                                                      temp
     * [4, 5, 𝟟, 𝟠, | 1, 2, 3, 6]                                          [1, 2, 3, 4, 5, 6, 7, 8]
     *        ↑                   ↑
     *        i                   j
     *
     * 最后将temp中的数据copy到原始数组中，排序完成。
     *
     *
     *
     */


    /**
     * left = 0 ; right = 8  if(0 < 8 = true) 进入
     * int mid = (left + right) / 2 = (0 + 7) / 2 = 3
     * 递归进入：
     * mergeSort(arr, 0, 3, temp);
     *
     * left = 0 ; right = 3  if(0 < 3 = true) 进入
     * int mid = (left + right) / 2 = (0 + 3) / 2 = 1
     * 递归进入：
     * mergeSort(arr, 0, 1, temp);
     *
     * left = 0 ; right = 1  if(0 < 1 = true) 进入
     * int mid = (left + right) / 2 = (0 + 1) / 2 = 0
     *
     * 递归进入：
     * mergeSort(arr, 0, 1, temp);
     *
     * left = 0 ; right = 0  if(0 < 0 = false) 进入
     */

    /**
     *
     * @param arr  要排序的数组
     * @param left 左边有序序列索引的初始值
     * @param right 右边索引结束值
     * @param temp 中转临时数组
     */
    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        // 递归是按照栈的数据结构执行的。先进后出
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
        // i = 0 mid = 4 j = 5 right = 7
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
        System.out.println("left="+tempLeft + "; right="+right);
        while (tempLeft <= right) {
            arr[tempLeft] = temp[tempIndex];
            tempLeft++;
            tempIndex++;
        }
    }
}
