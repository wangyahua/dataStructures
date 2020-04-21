package com.learn.recursion;

/**
 * @author 王亚华
 * @Description 八皇后问题 在8*8格的国际象棋上摆放8个皇后，使其不能互相攻击，既：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法？
 * @Date 创建于 2020-04-20 21:53
 */
public class Queen8 {

    private int max = 5;

    private int[] array = new int[max];


    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.chess(0);
    }

    /**
     * 第几个皇后
     *
     * @param n
     */
    public void chess(int n) {
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            array[n] = i; // array[4] = 3
            System.out.printf("array[%d] = %d\n", n, i);
            if (judge(n)) { // 不冲突
                chess(n + 1);
            }
        }
    }


    /**
     * 检测当前的皇后是否与前面的皇后互相攻击
     *
     * @param n 第几个皇后
     * @return true 为不冲突
     */
    private boolean judge(int n) {
        // n = 4
        // 0
        // 1
        // 2
        // 3
        // i = 3
        // 4 - 3 = 1  == array[n] = 2 - array[i] = 1 = 2-1 = 1
        for (int i = 0; i < n; i++) {
            // array[i] == array[n] 判断是否在一列
            // Math.abs(n - i) == Math.abs(array[n] - array[i]) 判断是否在一斜线上
            // 行不用判断，因为皇后都是按照一行放一个的 所以不会冲突
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return false;
            }
        }
        return true;
    }


    private void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
