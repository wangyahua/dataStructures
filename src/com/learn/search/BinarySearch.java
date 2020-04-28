package com.learn.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 王亚华
 * @Description 二分查找  注：二分查找必须是有序的
 * @Date 创建于 2020-04-28 10:06
 */
public class BinarySearch {


    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        // int resIndex = binarySearch(arr, 0, arr.length - 1, 4);
        // System.out.println("查找到的索引值为：" + resIndex);

        int[] arr = {1, 8, 10, 3, 100, 100, 1234};
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 100);
        System.out.println(resIndexList);
    }


    /**
     * 二分法查找算法
     *
     * @param arr       需要查找的数组 (有序数组)
     * @param left      左边的索引
     * @param right     右边的索引
     * @param findValue 要查找的值
     * @return
     */
    public static int binarySearch(int[] arr, int left, int right, int findValue) {
        // 如果左边的索引大于的了右边的索引，那么说明整个数组都已经查询完成了，所以需要退出，防止栈溢出
        if (left > right) {
            return -1;
        }
        // 位运算，右移1位，相当于除以2  找到中间的值
        // 例如 7 的二进制为  00000111  向右移动一位   00000011 得到的值转换为十进制为 2^1 + 2^0 = 2 + 1 = 3
        int mid = (left + right) >> 1;
        // 判断如果查找的值等于mid中的值，那么直接返回
        // 如果查找的值小于mid 那么就继续查找左边的数据，因为是有序的，小于mid就从左边找即可
        // 如果查找的值大于mid 那么就继续查找右边的数据，因为是有序的，大于mid就从右边找即可
        if (findValue < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findValue);
        } else if (findValue > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findValue);
        } else {
            return mid;
        }
    }


    /**
     * {1, 8, 10, 3, 100, 100, 1234}
     * 二分法查找，如果数组中有多个相同的数值时，将所有的数组的下标找到 比如 100
     *
     * @param arr
     * @param left
     * @param right
     * @param findValue
     * @return
     */
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findValue) {
        if (left > right) {
            return new ArrayList<>();
        }
        int mid = (left + right) >> 1;
        // 判断如果查找的值等于mid中的值，那么直接返回
        // 如果查找的值小于mid 那么就继续查找左边的数据，因为是有序的，小于mid就从左边找即可
        // 如果查找的值大于mid 那么就继续查找右边的数据，因为是有序的，大于mid就从右边找即可
        if (findValue < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, findValue);
        } else if (findValue > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, findValue);
        } else {
            List<Integer> result = new ArrayList<>();
            // 向mid左边扫表，将与findValue相等的下标加入到List中
            int temp = mid - 1;
            while (temp > 0 && arr[temp] == findValue) {
                result.add(temp);
                temp--;
            }
            // 将相等的mid在左边加入完成后再加入
            result.add(mid);
            // 向mid右扫表，将与findValue相等的下标加入到List中
            temp = mid + 1;
            while (temp < arr.length - 1 && arr[temp] == findValue) {
                result.add(temp);
                temp++;
            }
            return result;
        }
    }


}
