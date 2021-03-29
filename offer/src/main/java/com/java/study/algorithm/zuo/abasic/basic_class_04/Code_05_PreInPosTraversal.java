package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 前序。中序，后序打印二叉树
 */
public class Code_05_PreInPosTraversal {
    /**
     * 前序遍历
     */
    public static void preTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        System.out.print(node.value + " ");
        preTraversal(node.left);
        preTraversal(node.right);
    }


    /**
     * 中序
     */
    public static void inTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inTraversal(node.left);
        System.out.print(node.value + " ");
        inTraversal(node.right);
    }

    /**
     * 后续
     */
    public static void posTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        posTraversal(node.left);
        posTraversal(node.right);
        System.out.print(node.value + " ");
    }

    /**
     * 层级遍历
     *
     * @param node
     */
    public static void levelTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        Deque<TreeNode> deque = new LinkedList();
        deque.push(node);

        while (!deque.isEmpty()) {
            TreeNode tempNode = deque.pop();
            if (tempNode.left != null) {
                deque.add(tempNode.left);
            }

            if (tempNode.right != null) {
                deque.add(tempNode.right);
            }
            System.out.print(tempNode.value + " ");

        }
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
//        head.left.left = new TreeNode(2);
//        head.left.right = new TreeNode(4);
//        head.left.left.left = new TreeNode(1);
//        head.right.left = new TreeNode(7);
//        head.right.left.left = new TreeNode(6);
//        head.right.right = new TreeNode(10);
//        head.right.right.left = new TreeNode(9);
//        head.right.right.right = new TreeNode(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preTraversal(head);
        System.out.println();
        System.out.print("pre-order: ");
        Code_05_PreInPosTraversalStock.preUseStock(head);

        System.out.println();
        System.out.print("in-order: ");
        inTraversal(head);
        System.out.println();
        System.out.print("in-order: ");
        Code_05_PreInPosTraversalStock.inUseStack2(head);
        System.out.println();
        System.out.print("pos-order: ");
        posTraversal(head);
        System.out.println();
        System.out.print("pos-order: ");
        Code_05_PreInPosTraversalStock.posUserStack(head);
        System.out.println();
        System.out.println();
        System.out.print("pos-order: ");
        Code_05_PreInPosTraversalStock.posUserStack2(head);
        System.out.println();

        // unrecursive
//        System.out.println("============unrecursive=============");
//        levelTraversal(head);
//        inOrderUnRecur(head);
//        posOrderUnRecur1(head);
//        posOrderUnRecur2(head);

    }


}