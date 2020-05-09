package com.learn.tree;

/**
 * @author 王亚华
 * @Description 树节点
 * @Date 创建于 2020-05-09 11:33
 */
public class TreeNode {

    private int id;

    private String name;

    private TreeNode left;

    private TreeNode right;

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }


    /**
     * 前序遍历
     * 先输出当前节点（初始化的时候就是root节点）
     * 如果左子节点不为空，则递归继续前序遍历
     * 如果右子节点不为空，则递归继续前序遍历
     */
    public void preOrder() {

        System.out.println(this);

        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }


    /**
     * 中序遍历
     * 如果左子节点不为空，则递归继续中序遍历
     * 输出当前节点
     * 如果右子节点不为空，则递归继续中序遍历
     */
    public void infixOrder() {

        if (this.left != null) {
            this.left.infixOrder();
        }

        System.out.println(this);

        if (this.right != null) {
            this.right.infixOrder();
        }
    }


    /**
     * 后序遍历
     * 如果左子节点不为空，则递归继续后序遍历
     * 如果有子节点不为空，则递归继续后序遍历
     * 输出当前节点
     */
    public void postOrder() {

        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }

        System.out.println(this);

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }


    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
