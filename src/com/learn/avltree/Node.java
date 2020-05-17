package com.learn.avltree;

/**
 * @author 王亚华
 * @Description
 * @Date 创建于 2020-05-15 13:12
 */
public class Node {

    private int value;

    private Node left;

    private Node right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

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

    public Node(int value) {
        this.value = value;
    }


    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.value < this.value) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {

            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }


        // 当右子树的高度 - 左子树的高度 > 1 那么就需要进行坐旋转  因为右子树高度比左子树高度相差的绝对值大于1了
        if (this.getRightHeight() - this.getLeftHeight() > 1) {
            // 进行左旋
            leftRotate();
        }

        // 当左子树的高度 - 右子树的高度 > 1 那么就需要进行右旋转 因为左子树高度比右子树高度相差的绝对值大于1了
        if (this.getLeftHeight() - this.getRightHeight() > 1) {
            // 进行右旋
            rightRotate();
        }
    }

    /**
     * 获取以该节点为根节点树的高度
     *
     * @return
     */
    public int getHeight() {
        return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
    }

    /**
     * 获取左子树的高度
     *
     * @return
     */
    public int getLeftHeight() {
        if (this.left == null) {
            return 0;
        }
        return this.left.getHeight();
    }

    /**
     * 获取右子树的高度
     *
     * @return
     */
    public int getRightHeight() {
        if (this.right == null) {
            return 0;
        }
        return this.right.getHeight();
    }


    /**
     * 二叉排序树 左旋 -> 平衡二叉树
     * {4, 3, 6, 5, 7, 8}
     *
     *             4
     *          ／   ＼
     *         3      6
     *              ／  ＼
     *              5    7
     *                    ＼
     *                     8
     *
     *  左旋优化为平衡二叉树
     *  1. 创建一个新的节点，以当前的根节点的值创建
     *              4
     *  2. 将新节点的左子树设置为当前节点的左子树
     *              4
     *             ／
     *            3
     *  3. 将新节点的右子树设置为当前节点的右子树的左子树
     *              4
     *            ／  ＼
     *           3     5
     *  4. 将当前节点的值设置为当前节点右子节点的值
     *             6
     *          ／   ＼
     *         3      6
     *              ／  ＼
     *              5    7
     *                    ＼
     *                     8
     *  5. 把当前节点的右子树设置成右子树的右子树
     *             6
     *          ／   ＼
     *         3      7
     *                 ＼
     *                  8
     *  6. 将当前节点的左子树设置为新的节点
     *             6
     *         ／      ＼
     *        4         7
     *      ／  ＼        ＼
     *     3     5         8
     */
    public void leftRotate(){

        // 创建一个新的节点，以当前的根节点的值创建
        Node newNode = new Node(value);

        // 将新节点的左子树设置为当前节点的左子树
        newNode.left = this.left;

        // 将新节点的右子树设置为当前节点的右子树的左子树
        newNode.right = this.right.left;

        // 将当前节点的值设置为当前节点右子节点的值
        this.value = this.right.value;

        // 把当前节点的右子树设置成右子树的右子树
        this.right = this.right.right;

        // 将当前节点的左子树设置为新的节点
        this.left = newNode;

    }


    /**
     * 二叉排序树 右旋 -> 平衡二叉树
     * {10, 12, 8, 9, 7, 6}
     *
     *            10
     *          ／   ＼
     *         8     12
     *       ／ ＼
     *      7    9
     *     ／
     *    6
     *
     * 右旋优化为平衡二叉树
     *
     * 1. 创建一个新的节点，以当前的根节点的值创建
     *           10
     * 2. 将新节点的右子树设置为当前节点的右子树
     *           10
     *            ＼
     *             12
     * 3. 将新节点的左子树设置为当前节点的左子树的右子树
     *           10
     *         ／   ＼
     *        9     12
     * 4. 将当前节点的值设置为当前节点左子节点的值
     *             8
     *          ／   ＼
     *         8     12
     *       ／ ＼
     *      7    9
     *     ／
     *    6
     *  5. 把当前节点的的左子树设置为左子树的的左子树
     *             8
     *          ／   ＼
     *         7     12
     *       ／
     *      6
     *
     *  6. 将当前节点的右子树设置为新节点
     *             8
     *          ／   ＼
     *         7     10
     *       ／     ／  ＼
     *      6      9    12
     */
    public void rightRotate() {

        // 创建一个新的节点，以当前的根节点的值创建
        Node newNode = new Node(value);

        // 将新节点的右子树设置为当前节点的右子树
        newNode.right = this.right;

        // 将新节点的左子树设置为当前节点的左子树的右子树
        newNode.left = this.left.right;

        // 将当前节点的值设置为当前节点左子节点的值
        this.value = this.left.value;

        // 把当前节点的的左子树设置为左子树的的左子树
        this.left = this.left.left;

        // 将当前节点的右子树设置为新节点
        this.right = newNode;

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

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
