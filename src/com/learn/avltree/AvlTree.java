package com.learn.avltree;


/**
 * @author 王亚华
 * @Description 平衡二叉树ßå
 * 平衡二叉树的由来：
 * 在二叉排序树有一个问题，例如数据 {1, 2, 3, 4, 5, 6}，那么二叉排序树就为：
 *              1
 *              ＼
 *               2
 *               ＼
 *                3
 *                ＼
 *                 4
 *                 ＼
 *                  5
 *                  ＼
 *                   6
 *
 * 存在的问题：左子树全部为空，从形式上看，更像一个链表。插入没有问题，但是查询速度明显降低（因为需要依次比较），不能发挥出BST的树结构的优势
 * 因为每次都要查询比较左子树，但是左子树为空，所以出现了平衡二叉树
 *
 * 平衡二叉树也叫平衡二叉搜索树（Self-balancing binary search tree）又被称为AVL树，可以保存查询效率较高。
 * 平衡二叉树有一下特点：
 * 1. 它是一颗空树或它的左右两个子树的高度差的绝对值不超过1.
 * 2. 它的左右两个子树都是一颗平衡二叉树
 *
 *
 *
 * @Date 创建于 2020-05-15 13:12
 */
public class AvlTree {

    public Node root;

    public static void main(String[] args) {


        int[] arr = {10, 12, 8, 9, 7, 6};

        AvlTree avlTree = new AvlTree();

        for (int i = 0; i < arr.length; i++){
            avlTree.add(new Node(arr[i]));
        }

        System.out.println("二叉排序树遍历~~~");
        avlTree.infixOrder();

        System.out.println("二叉树的高度 : " + avlTree.root.getHeight());
        System.out.println("二叉树左子树的高度 : "+ avlTree.root.getLeftHeight());
        System.out.println("二叉树右子树的高度 : " + avlTree.root.getRightHeight());
        System.out.println("二叉树当前的根节点为 : " + avlTree.root);

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
