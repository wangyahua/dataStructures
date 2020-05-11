package com.learn.tree;

/**
 * @author 王亚华
 * @Description 线索二叉树
 * <p>
 * 1. n个节点的二叉链表中含有n+1 【公式 2n - (n - 1) = n + 1】个空指针域。利用二叉链表中的空指针域，存放指向该节点在某种遍历次序下的前驱和后继节点的指针（附加的指针称为"线索"）
 * 2. 加上了线索的二叉链表树称为线索链表，相应的二叉树称为线索二叉树。根据线索性质的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树、后序线索二叉树三种
 * 3. 一个节点的前一个节点，称为前驱节点
 * 3. 一个节点的后一个节点，称为后继节点
 * @Date 创建于 2020-05-11 12:56
 */
public class ThreadedBinaryTree {


    private TreeNode preNode = null;


    public static void main(String[] args) {

        TreeNode root = new TreeNode(1, "张三");
        TreeNode node2 = new TreeNode(3, "张四");
        TreeNode node3 = new TreeNode(6, "张五");
        TreeNode node4 = new TreeNode(8, "张六");
        TreeNode node5 = new TreeNode(10, "张七");
        TreeNode node6 = new TreeNode(14, "张八");

        root.setLeft(node2);
        root.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);


        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.threadedNodes(root);
        // 测试10号节点
        TreeNode leftNode = node5.getLeft(); // 3
        TreeNode rightNode = node5.getRight(); // 1

        System.out.println("10号节点 leftNode = " + leftNode);
        System.out.println("10号节点 rightNode = " + rightNode);

        System.out.println("使用线索化的方式遍历");
        threadedBinaryTree.infixOrderThreadedList(root);
    }


    /**
     * 变为线索化二叉树
     * @param node
     */
    public void threadedNodes(TreeNode node) {
        if (node == null) {
            return;
        }
        // 线索化左子树
        threadedNodes(node.getLeft());
        // 线索化当前节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(preNode);
            // 修改当前节点的左指针类型，指向前驱节点
            node.setLeftType(1);
        }
        // 处理后继节点
        if (preNode != null && preNode.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            preNode.setRight(node);
            preNode.setRightType(1);
        }
        preNode = node;
        // 线索化右子树
        threadedNodes(node.getRight());
    }


    /**
     * 遍历线索二叉树 中序遍历
     *
     * @param root
     */
    public void infixOrderThreadedList(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            //先从左子树查看  当leftType == 1的时候，说明该节点是按照线索化的
            // 处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 第一个就是线索化要输出的
            System.out.println(node);

            // 如果当前节点的右指针指向的是后继节点，就一直输出
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }


}
