package com.learn.sort;

import java.util.Arrays;

/**
 * @author 王亚华
 * @Description 基数排序  将所有待比较的数值都统一为相同位数长度，位数较短的数前面补0。然后从最低位（个位）开始依次排序，这样从最低位排序一直到
 * 最高位排序完成后，就会变成一个有序序列。
 * @Date 创建于 2020-04-25 18:30
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 基数排序
     *
     * @param arr
     */
    public static void radixSort(int[] arr) {
        // 定义桶 二维数组  一维的索引代表每个桶，二维是每个桶的数据
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶中的数据个数
        int[] bucketElementCount = new int[10];
        // 找到最长的位数
        int max = arr[1];
        for (int a = 1; a < arr.length; a++) {
            if (arr[a] > max) max = arr[a];
        }
        int maxDigit = (max + "").length();
        for (int d = 0, divisor = 1; d < maxDigit; d++, divisor *= 10) {
            for (int i = 0; i < arr.length; i++) {
                // 取个位数
                int num = (arr[i] / divisor) % 10;
                // 将对应的数据放入对应的桶中
                bucket[num][bucketElementCount[num]] = arr[i];
                // 将对应的桶中的数据累加，得到这个桶中的个数
                bucketElementCount[num]++;
            }
            int index = 0;
            // 将桶中的数据取出 放入到原数组
            for (int k = 0; k < bucket.length; k++) {
                // 判断桶中是否有数据，如果没有 那么不需要取出
                if (bucketElementCount[k] != 0) {
                    for (int j = 0; j < bucketElementCount[k]; j++) {
                        arr[index++] = bucket[k][j];
                    }
                }
                // 放入到原数组中以后，那么记录桶中的个数需要清空 以便下次排序继续再次记录，不然后续获取就是乱的。
                bucketElementCount[k] = 0;
            }
            // System.out.println("第" + d + "轮排序：" + Arrays.toString(arr));
        }


       /* //第1轮排序  针对每个元素的个位数进行排序处理
        for (int i = 0; i < arr.length; i++) {
            // 取个位数
            int num = arr[i] % 10;
            // 将对应的数据放入对应的桶中
            bucket[num][bucketElementCount[num]] = arr[i];
            // 将对应的桶中的数据累加，得到这个桶中的个数
            bucketElementCount[num]++;
        }
        int index = 0;
        // 将桶中的数据取出 放入到原数组
        for (int k = 0; k < bucket.length; k++) {
            // 判断桶中是否有数据，如果没有 那么不需要取出
            if (bucketElementCount[k] != 0) {
                for (int j = 0; j < bucketElementCount[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            // 放入到原数组中以后，那么记录桶中的个数需要清空 以便下次排序继续再次记录，不然后续获取就是乱的。
            bucketElementCount[k] = 0;
        }

        System.out.println("第一轮排序：" + Arrays.toString(arr));


        //第1轮排序  针对每个元素的十位数进行排序处理
        for (int i = 0; i < arr.length; i++) {
            // 取十位数
            int num = arr[i] / 10 % 10;
            // 将对应的数据放入对应的桶中
            bucket[num][bucketElementCount[num]] = arr[i];
            // 将对应的桶中的数据累加，得到这个桶中的个数
            bucketElementCount[num]++;
        }
        index = 0;
        // 将桶中的数据取出 放入到原数组
        for (int k = 0; k < bucket.length; k++) {
            // 判断桶中是否有数据，如果没有 那么不需要取出
            if (bucketElementCount[k] != 0) {
                for (int j = 0; j < bucketElementCount[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            // 放入到原数组中以后，那么记录桶中的个数需要清空 以便下次排序继续再次记录，不然后续获取就是乱的。
            bucketElementCount[k] = 0;
        }

        System.out.println("第二轮排序：" + Arrays.toString(arr));


        //第1轮排序  针对每个元素的十位数进行排序处理
        for (int i = 0; i < arr.length; i++) {
            // 取十位数
            int num = arr[i] / 100 % 10;
            // 将对应的数据放入对应的桶中
            bucket[num][bucketElementCount[num]] = arr[i];
            // 将对应的桶中的数据累加，得到这个桶中的个数
            bucketElementCount[num]++;
        }
        index = 0;
        // 将桶中的数据取出 放入到原数组
        for (int k = 0; k < bucket.length; k++) {
            // 判断桶中是否有数据，如果没有 那么不需要取出
            if (bucketElementCount[k] != 0) {
                for (int j = 0; j < bucketElementCount[k]; j++) {
                    arr[index++] = bucket[k][j];
                }
            }
            // 放入到原数组中以后，那么记录桶中的个数需要清空 以便下次排序继续再次记录，不然后续获取就是乱的。
            bucketElementCount[k] = 0;
        }

        System.out.println("第三轮排序：" + Arrays.toString(arr));*/


    }


}
