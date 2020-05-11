package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 堆排序 堆是具有以下性质的完全二叉树：每个节点的值都大于或等于其左右孩子的节点值，称为大顶堆。注：没有要求左右孩子节点值的大小关系。
 * 每个节点的值都小于或等于其左右孩子的节点值，称为小顶堆
 * @Date 创建于 2020-05-12 06:45
 */
public class HeapSort {


    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};
        /*adjustHead(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));

        adjustHead(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));*/
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 堆排序
     * @param arr 排序的数组
     */
    public static void heapSort(int[] arr) {
        // 将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHead(arr, i, arr.length);
        }

        // 将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端
        // 然后重新调整结构，使其满足大顶堆的d定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整
        int temp;
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHead(arr, 0, j);
        }
    }


    /**
     * 完成将以i对应的非叶子节点的树调整成大顶堆
     * @param arr 待调整的数组
     * @param i 表示非叶子节点数组的索引
     * @param length 表示对多少个元素调整，逐渐在减少
     */
    public static void adjustHead(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = i * 2 + 1) {
            //比较当前节点的左右节点 说明左子节点的值小于右子节点的值
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++; // 指向右子接地那
            }
            if (arr[k] > temp) { // 如果子节点大于父节点  进行位置交换
                arr[i] = arr[k]; // 把大的值赋值给当前节点的值
                i = k;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }


}
