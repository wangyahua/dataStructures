package com.learn.sparsearray;

/**
 * @author 王亚华
 * @Description 稀疏数据的实现
 * @Date 创建于 2020-03-26 13:08
 */
public class SparseArray {

    public static void main(String[] args) {
        // 创建一个原始的二维数组
        // 0代表没有棋子  1代表黑子  2代表白子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        System.out.println("--------原始数组--------");
        for (int[] row : chessArr1) {
            for (int row2 : row) {
                System.out.printf("%d \t", row2);
            }
            System.out.println();
        }
        /**
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	1 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	2 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         * 0 	0 	0 	0 	0 	0 	0 	0 	0 	0 	0
         */
        // 开始转为稀疏数组

        //1. 需要知道有多少行
        int rowNum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    rowNum++;
                }
            }
        }
        // 几行3列的数据
        int[][] sparseArr = new int[rowNum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = rowNum;
        // 将有效的值放到稀疏数组中
        int index = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if (chessArr1[i][j] != 0) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = chessArr1[i][j];
                }
            }
        }
        System.out.println("--------稀疏数组--------");
        for (int[] row : sparseArr) {
            for (int row2 : row) {
                System.out.printf("%d \t", row2);
            }
            System.out.println();
        }
        /**
         * --------稀疏数组--------
         * 11 	11 	3
         * 1 	2 	1
         * 2 	3 	2
         * 4 	6 	1
         */
        // 将稀疏数据转换为原始数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];


        //将稀疏数组中有效的值赋值给原始数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("--------稀疏数组转为原始数组--------");
        for (int[] row : chessArr2) {
            for (int row2 : row) {
                System.out.printf("%d \t", row2);
            }
            System.out.println();
        }
    }
}
