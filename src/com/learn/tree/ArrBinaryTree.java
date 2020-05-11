package com.learn.tree;

/**
 * @author 王亚华
 * @Description 顺序二叉树  从数据存储来看，数组存储方式和树的存储方式可以相互转换，即数组可以转换成树，树也可以转换成数组。
 *
 *        1
 *      ／  ＼
 *     2      3
 *   ／ ＼   ／ ＼
 *   4  5   6   7
 *       |
 *       |
 *       |
 *       |
 *   [1, 2, 3, 4, 5, 6, 7]
 *
 *   顺序二叉树的特点：
 *   1. 顺序二叉树通常只考虑完全二叉树。
 *   2. 第n个元素的左子节点为 2 * n + 1
 *   3. 第n个元素的右子节点为 2 * n + 2
 *   4. 第n个元素的父节点为：(n - 1) / 2
 *   5. n：表示二叉树中的第几个元素 （按照0开始）
 *
 *
 * @Date 创建于 2020-05-10 21:57
 */
public class ArrBinaryTree {

    /**
     * 存储数据节点的数组
     */
    private int[] arr;


    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }


    public static void main(String[] args) {

        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});

        System.out.println("前序遍历~~~");
        arrBinaryTree.preOrder(0); // 1, 2, 4, 5, 3, 6, 7

        System.out.println("中序遍历~~~");
        arrBinaryTree.infixOrder(0);

        System.out.println("后序遍历~~~");
        arrBinaryTree.postOrder(0);

    }


    /**
     * 顺序二叉树的前序遍历
     *
     * @param index 数据下标
     */
    public void preOrder(int index) {

        // 如果数组为空 那么无法遍历
        if (this.arr == null || this.arr.length <= 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }


        System.out.println(this.arr[index]);

        if ((index * 2) + 1 < this.arr.length) {
            preOrder((index * 2) + 1);
        }

        if ((index * 2) + 2 < this.arr.length) {
            preOrder((index * 2) + 2);
        }

    }


    public void infixOrder(int index) {
        // 如果数组为空 那么无法遍历
        if (this.arr == null || this.arr.length <= 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if ((index * 2) + 1 < this.arr.length) {
            infixOrder((index * 2) + 1);
        }

        System.out.println(this.arr[index]);

        if ((index * 2) + 2 < this.arr.length) {
            infixOrder((index * 2) + 2);
        }
    }


    public void postOrder(int index) {
        // 如果数组为空 那么无法遍历
        if (this.arr == null || this.arr.length <= 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }

        if ((index * 2) + 1 < this.arr.length) {
            infixOrder((index * 2) + 1);
        }

        if ((index * 2) + 2 < this.arr.length) {
            infixOrder((index * 2) + 2);
        }

        System.out.println(this.arr[index]);

    }

}
