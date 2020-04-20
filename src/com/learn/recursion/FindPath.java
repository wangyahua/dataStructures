package com.learn.recursion;

/**
 * @author 王亚华
 * @Description 使用递归找路径
 * @Date 创建于 2020-04-20 21:14
 */
public class FindPath {


    public static void main(String[] args) {
        /**
         * 找路径描述
         * 1 1 1 1 1 1 1
         * 1 * 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 1 1 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 0 1
         * 1 0 0 0 0 ? 1
         * 1 1 1 1 1 1 1
         *
         * 此时有一个二维数组，1代表的是墙壁，比如从*的位置开始走，直到到了?的点停止
         * 如下：2代表走的路线点
         *
         * 1 1 1 1 1 1 1
         * 1 2 0 0 0 0 1
         * 1 2 2 2 0 0 1
         * 1 1 1 2 0 0 1
         * 1 0 0 2 0 0 1
         * 1 0 0 2 0 0 1
         * 1 0 0 2 2 2 1
         * 1 1 1 1 1 1 1
         *
         * 分析：从开始点找，需要有一个策略，开始点找要从上下左右这几个方向走，那么就定义一个策略 -》 下->右->上->左
         * 如果这个策略有任意一个走通，那么就设置为2，如果没有走通，那么设置为3  约定2为走通，3位走过，但是没有走通的含义
         * 知道?的点为2 那么就结束
         */

        int[][] map = new int[8][7];
        // 1表示墙壁  在数组的外围设置为1
        // 设置上下墙壁
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 设置左右墙壁
        for (int i = 1; i < 7; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        printArr(map);
        findPath(map, 1, 1);
        System.out.println("------------------------------");
        printArr(map);
    }


    /**
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean findPath(int[][] map, int i, int j) {
        // 约定： 1表示墙壁  2表示此路可以通过 3表示改点已经走过并走不通
        // 如果此点的位置是2 那么就找到了终点的位置i
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { // 代表此点还没有走过
                // 按照策略走  下->右->上->左
                map[i][j] = 2; //目前先假设改点可以走通
                if (findPath(map, i + 1, j)) {
                    return true;
                } else if (findPath(map, i, j + 1)) {
                    return true;
                } else if (findPath(map, i - 1, j)) {
                    return true;
                } else if (findPath(map, i, j - 1)) {
                    return true;
                } else { // 说明此路不通 节点的上右下左都走了
                    map[i][j] = 3;
                    return false;
                }
            } else { // 不等于0 那么可能是1,2,3
                return false;
            }
        }
    }

    /**
     * @param map
     * @param i
     * @param j
     * @return
     */
    public static boolean findPath2(int[][] map, int i, int j) {
        // 约定： 1表示墙壁  2表示此路可以通过 3表示改点已经走过并走不通
        // 如果此点的位置是2 那么就找到了终点的位置i
        if (map[6][5] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) { // 代表此点还没有走过
                // 按照策略走  上->右->下->左
                map[i][j] = 2; //目前先假设改点可以走通
                if (findPath2(map, i - 1, j)) {
                    return true;
                } else if (findPath2(map, i, j + 1)) {
                    return true;
                } else if (findPath2(map, i + 1, j)) {
                    return true;
                } else if (findPath2(map, i, j - 1)) {
                    return true;
                } else { // 说明此路不通 节点的上右下左都走了
                    map[i][j] = 3;
                    return false;
                }
            } else { // 不等于0 那么可能是1,2,3
                return false;
            }
        }
    }


    private static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}
