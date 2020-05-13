package com.learn.binarysorttree;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-05-12 21:30
 */
public class Node {

    private int val;

    private Node left;

    private Node right;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                '}';
    }


    /**
     * 添加接地那
     *
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        // 判断添加的节点是否小于当前节点的值  如果小于  那么添加到左子节点
        if (node.val < this.val) {
            // 如果左子节点为空 那么直接赋值
            if (this.left == null) {
                this.left = node;
            } else { // 如果不为空 那么进行左子节点递归再执行，再判断添加
                this.left.add(node);
            }
        } else {
            // 如果右子节点为空 那么直接赋值
            if (this.right == null) {
                this.right = node;
            } else { // 如果不为空，那么进行右子节点递归在执行，再判断添加
                this.right.add(node);
            }
        }
    }


    /**
     * 中序遍历
     * 先遍历左子节点  再遍历父节点  再遍历右子节点
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
     * 根据值查找到当前的节点
     *
     * @param val
     * @return
     */
    public Node search(int val) {
        if (this.val == val) {
            return this;
        } else if (val < this.val) { // 如果查找的值小于当前节点，那么向左子树递归查找
            if (this.left == null) {
                return null;
            }
            return this.left.search(val);
        } else { // 如果查找的值大于当前节点，那么向右子树递归查找
            if (this.right == null) {
                return null;
            }
            return this.right.search(val);
        }
    }


    /**
     * 根据值查找节点的父节点
     *
     * @param val
     * @return
     */
    public Node searchParent(int val) {
        // 如果当前节点的左子节点或者右子节点等于查找的值，那么当前节点就是父节点
        if ((this.left != null && this.left.val == val) || (this.right != null && this.right.val == val)) {
            return this;
        } else if (val < this.val && this.left != null) {
            return this.left.searchParent(val); // 向左子树递归查找
        } else if (val >= this.val && this.right != null) {
            return this.right.searchParent(val); // 向右子树递归查找
        } else {
            return null;
        }
    }

}
