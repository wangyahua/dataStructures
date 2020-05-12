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

}
