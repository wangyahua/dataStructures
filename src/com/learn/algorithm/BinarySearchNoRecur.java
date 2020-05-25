package com.learn.algorithm;

/**
 * @author 王亚华
 * @Description 二分法查找算法  不使用递归
 * @Date 创建于 2020-05-25 10:35
 */
public class BinarySearchNoRecur {


    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 67, 100};
        System.out.println(binarySearch(arr, 1000));
    }

    /**
     * @param arr
     * @param target
     * @return
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        // 如果左边小于或等于右边 那么就继续遍历查找
        while (left <= right) {
            // 向右移动一位  相当于除以2
            int mid = (left + right) >> 1;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // 向左查找
                right = mid - 1;
            } else {
                // 向右查找
                left = mid + 1;
            }
        }
        return -1;
    }
}
