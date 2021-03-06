package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 希尔排序  记录按下标的一定增量分组，对每组使用直接插入排序算法排序。当组分组为1时，算法终止。
 * @Date 创建于 2020-04-22 06:33
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        // shellSort(arr); 交换法
        shellSort2(arr); // 插入法
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 思路分析：
     * [8,9,1,7,2,3,5,4,6,0]
     * 分组：arr.length / 2 = 10 / 2 = 5 分为五组如下，所对应的下一个值都是 +5 的索引值
     * [8,3] [9,5] [1,4] [7,6] [2,0]
     * <p>
     * 1. 进行每个分组内的排序进行交换位置：
     * 第一个分组：8 > 3 要交换位置 [3,9,1,7,2,8,5,4,6,0]
     * 第二个分组：9 > 5 要交换位置 [3,5,1,7,2,8,9,4,6,0]
     * 第三个分组：1 < 4 不交换位置 [3,5,1,7,2,8,9,4,6,0]
     * 第四个分组：7 > 6 要交换位置 [3,5,1,6,2,8,9,4,7,0]
     * 第五个分组：2 > 0 要交换位置 [3,5,1,6,0,8,9,4,7,2]
     * <p>
     * 2. 继续分组再排序，上一次排序分组得到为5，根据5再分组  5 / 2 = 2，所对应的下一个值都是 +2 的索引值
     * 分组结果：[3,1,0,9,7] [5,6,8,4,2]
     * 进行每个分组内的排序交换位置：
     * 1. 第一个组内 3 > 1 要交换位置：[1,5,3,6,0,8,9,4,7,2]
     * 组内元素变化：[1,3,0,9,7] [5,6,8,4,2]
     * <p>
     * 2. 第二个组内：5 < 6 所以交换位置 [1,5,3,6,0,8,9,4,7,2]
     * 组内元素变化：[1,3,0,9,7] [5,6,8,4,2]
     * <p>
     * 3. 第一个组内：3 > 0 要交换位置  [1,5,0,6,3,8,9,4,7,2]
     * 组内元素变化：[1,0,3,9,7] [5,6,8,4,2]
     * 3.1：组内继续向前遍历对比，1 > 0 要交换位置 [0,5,1,6,3,8,9,4,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,8,4,2]
     * <p>
     * 4. 第二个组内 6 < 8 不需要交换位置 [0,5,1,6,3,8,9,4,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,8,4,2]
     * 4.1：组内继续向前遍历对比 5 < 6 不需要交换位置 [0,5,1,6,3,8,9,4,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,8,4,2]
     * <p>
     * 5. 第一个组内：3 < 9 不需要交换位置 [0,5,1,6,3,8,9,4,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,8,4,2]
     * 5.1：组内继续向前遍历对比 1 < 3 不需要交换位置 -> [0,5,1,6,3,8,9,4,7,2]
     * 5.2：组内继续向前遍历对比 0 < 1 不需要交换位置 -> [0,5,1,6,3,8,9,4,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,8,4,2]
     * <p>
     * 6. 第二个组内：8 > 4 要交换位置 [0,5,1,6,3,4,9,8,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,6,4,8,2]
     * 6.1：组内继续向前遍历 6 > 4 要交换位置 [0,5,1,4,3,6,9,8,7,2]
     * 组内元素变化：[0,1,3,9,7] [5,4,6,8,2]
     * 6.2：组内继续向前遍历 5 > 4 要交换位置 [0,4,1,5,3,6,9,8,7,2]
     * 组内元素变化：[0,1,3,9,7] [4,5,6,8,2]
     * <p>
     * 7. 第一个组内：9 > 7 要交换位置 [0,4,1,5,3,6,7,8,9,2]
     * 组内元素变化：[0,1,3,7,9] [4,5,6,8,2]
     * 7.1：组内继续向前遍历 3 < 7 不需要交换位置 [0,4,1,5,3,6,7,8,9,2]
     * 7.2：组内继续向前遍历 1 < 3 不需要交换位置 [0,4,1,5,3,6,7,8,9,2]
     * 7.3：组内继续向前遍历 0 < 1 不需要交换位置 [0,4,1,5,3,6,7,8,9,2]
     * <p>
     * 8. 第二个组内 8 > 2 要交换位置 [0,4,1,5,3,6,7,2,9,8]
     * 组内元素变化：[0,1,3,7,9] [4,5,6,2,8]
     * 8.1：组内继续向前遍历 6 > 2 要交换位置 [0,4,1,5,3,2,7,6,9,8]
     * 组内元素变化：[0,1,3,7,9] [4,5,2,6,8]
     * 8.2：组内继续向前遍历 5 > 2 要交换位置 [0,4,1,2,3,5,7,6,9,8]
     * 组内元素变化：[0,1,3,7,9] [4,2,5,6,8]
     * 8.2：组内继续向前遍历 4 > 2 要交换位置 [0,2,1,4,3,5,7,6,9,8]
     * 组内元素变化：[0,1,3,7,9] [2,4,5,6,8]
     * <p>
     * 第二次按照2分组得到结果 [0,2,1,4,3,5,7,6,9,8]
     * <p>
     * 3. 继续分组再排序，上一次排序分组得到为2，根据2再分组  2 / 2 = 1，所对应的下一个值都是 +1 的索引值
     * 分组结果：[0,2,1,4,3,5,7,6,9,8]
     * 进行分组内的排序交换位置：
     * 1. 0 < 2 不需要交换位置 ->  [0,2,1,4,3,5,7,6,9,8]
     * 2. 2 > 1 需要交换位置 ->  [0,1,2,4,3,5,7,6,9,8]
     * 3. 2 < 4 不需要交换位置 ->  [0,1,2,4,3,5,7,6,9,8]
     * 4. 4 > 3 需要交换位置 ->  [0,1,2,3,4,5,7,6,9,8]
     * 5. 4 < 5 不需要交换位置 ->  [0,1,2,3,4,5,7,6,9,8]
     * 6. 5 < 7 不需要交换位置 ->  [0,1,2,3,4,5,7,6,9,8]
     * 7. 7 > 6 需要交换位置 ->  [0,1,2,3,4,5,6,7,9,8]
     * 8. 7 < 9 不需要交换位置 ->  [0,1,2,3,4,5,6,7,9,8]
     * 9. 9 > 8 需要交换位置 ->  [0,1,2,3,4,5,6,7,8,9]
     * <p>
     * 最后排序得到的结果为 :  [0,1,2,3,4,5,6,7,8,9]
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {

        /**
         * 交换法
         */
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }

        /*for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j -= 5) {
                if (arr[j] > arr[j + 5]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));


        for (int i = 2; i < arr.length; i++) {
            for (int j = i - 2; j >= 0; j -= 2) {
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));


        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j -= 1) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));*/

    }


    public static void shellSort2(int[] arr) {

        /**
         * 插入法 优势：每次只更改一个值 找到待插入的位置插入即可，而交换法需要每次都要按个交换，效率低
         */
        int insertIndex;
        int insertValue;

        int gap = arr.length / 2;
        for (; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {

                insertIndex = i;
                insertValue = arr[insertIndex];

                while (insertIndex - gap >= 0 && insertValue < arr[insertIndex - gap]) {

                    arr[insertIndex] = arr[insertIndex - gap];

                    insertIndex -= gap;
                }

                // while循环退出就得到了要将待插入的value插入大指定位置
                arr[insertIndex] = insertValue;

            }
        }

    }


}
