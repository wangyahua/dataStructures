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

    /**
     * 线索二叉树使用  0代表左节点为左子树  1代表指向的就是前驱节点
     */
    private int leftType;

    /**
     * 线索二叉树使用  0代表右节点为右子树  1代表指向的就是后继节点
     */
    private int rightType;

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


    /**
     * 前序遍历查找
     *
     * @param id 要查找的id值
     * @return
     */
    public TreeNode preOrderSearch(int id) {
        if (this.id == id) {
            return this;
        }

        // 判断当前左子节点是否为空，不为空则递归查找
        TreeNode treeNode = null;

        if (this.left != null) {
            treeNode = this.left.preOrderSearch(id);
        }

        // 如果treeNode不为null，说明已经找到，如果为null，则判断当前节点右子节点是否为空，不为空则递归查找

        if (treeNode != null) {
            return treeNode;
        }

        if (this.right != null) {
            treeNode = this.right.preOrderSearch(id);
        }
        return treeNode;
    }


    /**
     * 中序遍历查找
     *
     * @param id 要查找的id值
     * @return
     */
    public TreeNode infixOrderSearch(int id) {

        TreeNode treeNode = null;

        // 判断当前节点的左子节点是否为空，不为空则递归查找
        if (this.left != null) {
            treeNode = this.left.infixOrderSearch(id);
        }

        if (treeNode != null) {
            return treeNode;
        }

        if (this.id == id) {
            return this;
        }

        if (this.right != null) {
            treeNode = this.right.infixOrderSearch(id);
        }

        return treeNode;
    }


    /**
     * 后续遍历查找
     *
     * @param id 要查找的id值
     * @return
     */
    public TreeNode postOrderSearch(int id) {
        TreeNode treeNode = null;
        if (this.left != null) {
            treeNode = this.left.postOrderSearch(id);
        }
        if (treeNode != null) {
            return treeNode;
        }
        if (this.right != null) {
            treeNode = this.right.postOrderSearch(id);
        }
        if (treeNode != null) {
            return treeNode;
        }
        if (this.id == id) {
            return this;
        }
        return treeNode;
    }


    public void delNode(int id) {


        if (this.left != null && this.left.id == id) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.id == id) {
            this.right = null;
            return;
        }
        if (this.left != null) {
            this.left.delNode(id);
        }

        if (this.right != null) {
            this.right.delNode(id);
        }
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


    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
