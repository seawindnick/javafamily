package com.java.study.zuo.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断一棵树是否是搜索二叉树
 */
public class IsBSTAndCBT {


    /**
     * 判断是否是搜索二叉树
     * 左子树节点都比他小，右子树都比他大
     * <p>
     * 中序遍历结果依次升序
     *
     * @param treeNode
     * @return
     */
    public static Boolean isBST(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        Integer preValue = null;
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                TreeNode tempNode = stack.pop();

                if (preValue != null && preValue > tempNode.getValue()) {
                    return false;
                }
                preValue = tempNode.getValue();

                treeNode = tempNode.right;
            }

        }

        return true;

    }

//    /**
//     * 判断是否是二叉搜索树
//     *
//     * @param treeNode
//     * @return
//     */
//    public static Boolean isBST(TreeNode treeNode) {
//        if (treeNode == null) {
//            return true;
//        }
//
//        boolean leftFlag = true;
//        if (treeNode.left != null) {
//            leftFlag = treeNode.left.value < treeNode.value;
//        }
//
//
//        boolean rightFlag = true;
//        if (treeNode.right != null) {
//            rightFlag = treeNode.right.value > treeNode.value;
//        }
//
//        if (!(leftFlag && rightFlag)) {
//            return false;
//        }
//
//        return isBST(treeNode.left) && isBST(treeNode.right);
//    }


    /**
     * 判断树是否是完全二叉树
     * 层级遍历，遇到一个元素无右节点，那么其后所有元素都应该无左右节点
     *
     *  1。一个节点只有右节点，没有左节点 一定不是完全二叉树
     *  2。 一个节点没有右节点，则其后左右节点都应该无子节点
     *
     * @param treeNode
     * @return
     */
    public static Boolean isCBT(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }

        LinkedList<TreeNode> linkedList = new LinkedList<>();
        boolean subIsNummFlag = false;
        linkedList.add(treeNode);

        while (!linkedList.isEmpty()) {
            TreeNode tempTreeNode = linkedList.pop();

            if(tempTreeNode.right != null &&  tempTreeNode.left == null){
                return false;
            }


            if (subIsNummFlag && (tempTreeNode.left != null || tempTreeNode.right != null)) {
                return false;
            }


            if (tempTreeNode.right == null) {
                subIsNummFlag = true;
            }

            if (tempTreeNode.left != null) {
                linkedList.add(tempTreeNode.getLeft());
            }

            if (tempTreeNode.right != null) {
                linkedList.add(tempTreeNode.getRight());
            }

        }

        return true;
    }

    // for test -- print tree
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4);
        head.left = new TreeNode(2);
        head.right = new TreeNode(6);
        head.left.left = new TreeNode(1);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(7);

        printTree(head);
//        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }


}
