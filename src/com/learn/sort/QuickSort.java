package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 快速排序   是对冒泡排序的一种改进。通过一趟排序将要排序的数据分割成独立的两个部，其中一部分的所有数据都比另外一部门的所有数据都要效，然后再按照
 * 此方法对这两部分数据分别进行排序，整个排序过程可以使用递归进行。
 * @Date 创建于 2020-04-22 22:31
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 10, 8, 22, 7, 5, 12, 21, 11};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路分析：
     * 原始数组：[2,10,8,22,7,5,12,21,11]
     * 约定一个数字，按照这个数字进行排序分类： 该数字左边是小于它的，右边是大于它的，依次递归左边与右边的数据。
     * 约定中间一个数
     *
     * [2,10,8,22,7,5,12,21,11]
     * 思路图：
     *          -----
     *    2, 5  | 7 | 10,8,22,12,21,11
     *          -----
     *      |               |
     *     -----               ------
     *   2 | 5 |       10,8,11 | 12 | 22,21
     *     -----               ------
     *                    |             |
     *                  -----         ------
     *                  | 8 | 10, 11  | 21 | 22
     *                  -----         ------
     *                           |
     *                         ------
     *                      10 | 11 |
     *                         ------
     *  结果值：[2,5,7,8,10,11,21,22]
     *
     * 1. 怎样来进行分类约定的这个数字左边为小于它的，右边是大于它的，采用交换的位置进行分类，思路：找到约定中间数字左边大于它的一个数，再找到右边小于它的一个数，进行这两个数据位置互换。
     * 设定两个索引值
     * int left = 0;
     * int right = array.length - 1 = 8;
     * int middle = arr[(left + right) / 2] = arr[8 / 2] = arr[4] = 7;
     *
     * left     middle      right
     *  |         |          |
     * [2,10,8,22,7,5,12,21,11]

     * 1. 遍历找到7左边位置大于它的，遍历找到7右边位置小于它的，然后进行两个位置的交换
     *
     * 2. 遍历左边，找到大于7的位置 (left += 1)
     * 2.1：2 < 7 不交换位置，继续遍历  此时left = 0
     * 2.2: 10 > 7 交换位置，此时left = 1 找到需要交换的位置，退出遍历
     *
     * 3. 遍历右边，找到小于7的位置 (right -= 1)
     * 3.1: 11 > 7 不交换位置  此时right = 8
     * 3.2: 21 > 7 不交换位置  此时right = 7
     * 3.3: 12 > 7 不交换位置  此时right = 6
     * 3.4: 5 < 7 交换位置  此时right = 5，找打需要交换的位置，退出遍历
     *
     * 4. 交换位置：
     *    left     right
     *     |        |
     * [2,10,8,22,7,5,12,21,11]
     * 将left索引为 1的与right索引为5的进行交换：[2,5,8,22,7,10,12,21,11]
     *
     *     left right
     *      |    |
     * [2,5,8,22,7,10,12,21,11]
     *
     * 1. 开始遍历左边：
     * 1.1 8 > 7 交换位置 此时left = 2 退出遍历
     *
     * 2. 开始遍历右边
     * 2.1 7 > 7 不交换位置 退出遍历  此时right = 4
     *
     * 将left索引为 2的与right索引为4的进行交换：[2,5,7,22,8,10,12,21,11]
     *
     *     left right
     *      |    |
     * [2,5,7,22,8,10,12,21,11]
     *
     * 1. 开始遍历左边:
     * 1.1 7 < 7 不交换位置  left = 2
     *
     * 2. 开始遍历右边:
     * 2.1 22 > 7 不交换位置  right = 3
     *
     * 将left索引为3的与right索引为3的进行交换：[2,5,7,22,8,10,12,21,11]
     *
     *
     *
     * <p>
     * 以11为
     *
     * @param arr
     */
    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int middle = arr[(left + right) / 2];
        int temp;
        while (l < r) {
            // 遍历左边，直到找到大于等于middle退出  最坏跳出循环的就是遍历大本身  本身<本身为false 跳出循环
            while (arr[l] < middle) {
                l++;
            }
            //遍历右边，直到找到小于等于middle退出
            while (arr[r] > middle) {
                r--;
            }
            // 如果左边索引遍历大于等于右边索引，那么约定值的左边就是小于它的，右边就是大于它的。
            if (l >= r) {
                break;
            }
            // 进行交换位置
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            /**
             * 如果左边等于当前的约定值，那么交换的位置相当于将约定的值进行了交换，这样右边交换的那个值就是原来7左边的值，所以就不需要再次对比，直接将right索引上线推一个再比较
             *      * 1. 开始遍历左边：
             *      * 1.1 8 > 7 交换位置 left = 2 退出遍历
             *      *
             *      * 2. 开始遍历右边
             *      * 2.1 7 > 7 不交换位置 退出遍历  right = 4
             *      *
             *      * 将left索引为 2的与right索引为4的进行交换：[2,5,7,22,8,10,12,21,11]
             *
             */
            if (arr[l] == middle) {
                r--;
            }

            /**
             * 右边等同于左边
             */
            if (arr[r] == middle) {
                l++;
            }
        }
        // 如果相等，那么需要操作值，防止栈溢出
        if (l == r) {
            l++;
            r--;
        }

        // 左边的数据再递归执行上述操作 依次类推
        if (left < r) {
            quickSort(arr, left, r);
        }

        // 右边的数据再递归执行上传操作 依次类推
        if (right > l) {
            quickSort(arr, l, right);
        }

    }

}
