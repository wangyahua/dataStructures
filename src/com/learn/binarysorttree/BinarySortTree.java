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
 * @Date 创建于 2020-05-12 21:22
 */
public class BinarySortTree {

    public Node root;


    public static void main(String[] args) {

        BinarySortTree binarySortTree = new BinarySortTree();

        int[] arr = {7, 2, 5};
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }


        System.out.println("二叉排序树中序遍历~~");
        binarySortTree.infixOrder(); // 1, 3, 5, 7, 9, 10, 12


        binarySortTree.delNode(7);
        System.out.println("删除后的二叉树中序遍历~~");
        binarySortTree.infixOrder();

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


    /**
     * 根据值查找节点
     *
     * @param val
     * @return
     */
    public Node search(int val) {
        if (root != null) {
            return root.search(val);
        }
        return null;
    }


    /**
     * 根据值查找节点的父节点
     *
     * @param val
     * @return
     */
    public Node searchParent(int val) {
        if (root != null) {
            return root.searchParent(val);
        }
        return null;
    }


    /**
     * 根据值删除节点
     *
     * @param val
     */
    public void delNode(int val) {

        if (root == null) {
            return;
        } else {
            Node targetNode = search(val);

            if (targetNode == null) {
                return;
            }
            // 如果这颗树只有一个节点的时候，直接将节点赋值为Null即可，走到这说明以及可以找到要删除的节点 也就是本身
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                return;
            }

            Node parentNode = searchParent(val);

            // 如果要删除的是叶子节点 就是该节点左右子树都为null
            if (targetNode.getLeft() == null && targetNode.getRight() == null) {
                // 确定targetNode是parentNode的左节点还是右节点
                if (parentNode.getLeft() != null && parentNode.getLeft().getVal() == val) { //左子节点
                    parentNode.setLeft(null); // 如果是左子节点  那么将左子节点赋值为null
                }

                if (parentNode.getRight() != null && parentNode.getRight().getVal() == val) { //右子节点
                    parentNode.setRight(null); // 如果是右子节点  那么将有子节点赋值为null
                }
            } else if (targetNode.getLeft() != null && targetNode.getRight() != null) { //该节点有两颗子树的节点情况

                // int minValue = getAndDelTreeMid(targetNode.getRight()); // 右子树中的最小值
                int maxValue = getAndDelTreeMax(targetNode.getLeft()); // 左子树中的最大值
                targetNode.setVal(maxValue);

            } else { // 该节点只有一颗子树的情况
                //targetNode有左子节点
                if (targetNode.getLeft() != null) {
                    if (parentNode != null) {
                        // 如果targetNode是parentNode的左子节点
                        if (parentNode.getLeft().getVal() == val) {
                            parentNode.setLeft(targetNode.getLeft());
                        } else {
                            parentNode.setRight(targetNode.getLeft()); // targetNode是parentNode的右子节点
                        }
                    } else {
                        root = targetNode.getLeft();
                    }

                } else { // 没有左子节点就是右子节点
                    if (parentNode != null) {
                        if (parentNode.getLeft().getVal() == val) {
                            parentNode.setLeft(targetNode.getRight());
                        } else {
                            parentNode.setRight(targetNode.getRight());
                        }
                    } else {
                        root = targetNode.getRight();
                    }
                }
            }
        }

    }


    /**
     * 找到传入这个节点中的最小值 就是向左一直遍历即可 然后删除
     *
     * @param node
     * @return
     */
    public int getAndDelTreeMid(Node node) {
        // 因为基于二叉排序树  左边一直是最小的
        Node temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
        }
        delNode(temp.getVal());
        // 删除该节点
        return temp.getVal();
    }


    /**
     * 找到传入这个节点中的最小值 就是向左一直遍历即可 然后删除
     *
     * @param node
     * @return
     */
    public int getAndDelTreeMax(Node node) {
        // 因为基于二叉排序树  左边一直是最小的
        Node temp = node;
        while (temp.getRight() != null) {
            temp = temp.getRight();
        }
        delNode(temp.getVal());
        // 删除该节点
        return temp.getVal();
    }

}
