package com.learn.recursion;

/**
 * @author 王亚华
 * @Description 八皇后问题 在8*8格的国际象棋上摆放8个皇后，使其不能互相攻击，既：任意两个皇后都不能处于同一行、同一列或同一斜线上，问有多少种摆法？
 * @Date 创建于 2020-04-20 21:53
 */
public class Queen8 {

    private int max = 4;

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
            array[n] = i;
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
        for (int i = 0; i < n; i++) {
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
