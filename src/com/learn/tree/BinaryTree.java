package com.learn.tree;

/**
 * @author 王亚华
 * @Description 二叉树
 * @Date 创建于 2020-05-09 11:34
 */
public class BinaryTree {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, "宋江");

        TreeNode node1 = new TreeNode(2, "吴用");
        TreeNode node2 = new TreeNode(3, "卢俊义");
        TreeNode node3 = new TreeNode(4, "林冲");
        TreeNode node4 = new TreeNode(5, "关胜");

        root.setLeft(node1);
        root.setRight(node2);
        node2.setLeft(node3);
        node2.setRight(node4);

        BinaryTree binaryTree = new BinaryTree();

        System.out.println("前序遍历~~~");
        binaryTree.preOrder(root);


        System.out.println("中序遍历~~~");
        binaryTree.infixOrder(root);


        System.out.println("后续遍历~~~");
        binaryTree.postOrder(root);
    }


    /**
     * 前序遍历
     *
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }


    /**
     * 中序遍历
     *
     * @param root
     */
    public void infixOrder(TreeNode root) {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }


    /**
     * 后序遍历
     *
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空，不能遍历");
        }
    }

}
