package com.learn.search;

/**
 * @author 王亚华
 * @Description 插值查找  类似于二分法查找，不同的是插值查找每次从自适应mid处开始查找 将要查找的数参与到mid运算当中。
 * @Date 创建于 2020-04-28 11:07
 */
public class InsertValueSearch {


    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1234};

        System.out.println(insertValueSearch(arr, 0, arr.length - 1, 8));

    }


    /**
     * 插值查找算法的举例说明：
     * 数组：arr = [1, 2, 3, ....., 100]
     * <p>
     * 如果需要查找的值为1
     * 使用二分法查找需要多次递归才能找到1。
     * <p>
     * 使用插值查找算法：
     * <p>
     * int mid = left + (right - left) * (findValue - arr[left] / arr[right] - arr[left])
     * <p>
     * int mid = 0 + (99 - 0) * ((1 - 1) / (100 - 1)) = 0 + 99 * (0) = 0
     * 所以直接可以得到arr[mid] == 1 的值
     * <p>
     * 如果查找的值为100
     * <p>
     * int mid = 0 + (99 - 0) * ((100 - 1) / (100 - 1)) = 0 + 99 * (99 / 99) = 0 + 99 * 1 = 99
     * 所以直接可以得到arr[mid] == 100
     *
     * 注意事项：
     * 1. 关于数据量较大，关键字分布比较均匀的查找表来说，采用插值查找，速度较快。
     * 2. 关键字分布不均匀的情况下，该方法不一定比二分法查找要好。
     *
     * @param arr       数组
     * @param left      左边索引
     * @param right     右边索引
     * @param findValue 要查找的值
     * @return
     */
    public static int insertValueSearch(int[] arr, int left, int right, int findValue) {

        // findValue < arr[0] || findValue > arr[arr.length -1] 需要判断  findValue参与运算 如果超过整个数组 那么有可能会数组越界
        if (left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        // 二分法查找获取的mid 公式  (left + right) / 2
        //int mid = (left + right) >> 2;

        // 插值查找公式 查找的值参与运算 left + (right - left) * (findValue - arr[left] / arr[right] - arr[left])
        int mid = left + (right - left) * (findValue - arr[left] / arr[right] - arr[left]);

        if (findValue < arr[mid]) {

            return insertValueSearch(arr, left, mid - 1, findValue);

        } else if (findValue > arr[mid]) {

            return insertValueSearch(arr, mid + 1, right, findValue);
        } else {

            return mid;
        }
    }


}
