package com.learn.binarysorttree;

/**
 * @author 王亚华
 * @Description 二叉排序树 BST（Binary Sort Tree），对于二叉排序树的任何一个非叶子节点，要求左子节点值比当前节点值小，
 * 右子节点值比当前节点的值大。
 * 特别说明：如果有相同的值，可以将该节点放在左子节点或右子节点
 * <p>
 * [7, 3, 10, 12, 5, 1, 9]
 * 对应的二叉排序树：
 * <p>
 *        7
 *     ／   ＼
 *    3     10
 *  ／ ＼   ／ ＼
 *  1  5   9  12
 *
 * @Date 创建于 2020-05-12 21:22
 */
public class BinarySortTree {

    public Node root;


    public static void main(String[] args) {

        BinarySortTree binarySortTree = new BinarySortTree();

        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }


        System.out.println("二叉排序树中序遍历~~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12

    }


    /**
     * 添加节点
     *
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        } else {
            root.add(node);
        }
    }


    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

}
