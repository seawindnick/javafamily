package com.java.study.algorithm.zuo.abasic.basic_class_04;

import java.util.Objects;

/**
 * 较为直观的打印二叉树
 */
public class Code_06_PrintBinaryTree {

    private static final String str = "    ";


    public static void printBinaryTree2(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        System.out.println("PrintBinaryTree ===== ");
        printBinaryTree(treeNode, 0, "H", 17);

    }


    private static void printBinaryTree(TreeNode treeNode, int level, String prefix, int len) {
        if (treeNode == null) {
            return;
        }
        //先打印右子树
        printBinaryTree(treeNode.right, level + 1, "v", len);

        String space = getSpace(level);
        System.out.println(space + prefix + treeNode.value + prefix);


        //再打印左子树
        printBinaryTree(treeNode.left, level + 1, "v", len);

    }

    //    public static void printInOrder(Node head, int height, String to, int len) {
//        if (head == null) {
//            return;
//        }
//        printInOrder(head.right, height + 1, "v", len);
//        String val = to + head.value + to;
//        int lenM = val.length();
//        int lenL = (len - lenM) / 2;
//        int lenR = len - lenM - lenL;
//        val = getSpace(lenL) + val + getSpace(lenR);
//        System.out.println(getSpace(height * len) + val);
//        printInOrder(head.left, height + 1, "^", len);
//    }
//
//    public static String getSpace(int num) {
//        String space = " ";
//        StringBuffer buf = new StringBuffer("");
//        for (int i = 0; i < num; i++) {
//            buf.append(space);
//        }
//        return buf.toString();
//    }


    private static String getSpace(int level) {
        String str = "    ";
        String prefix = str;
        for (int i = 0; i < level; i++) {
            prefix += str;
        }
        return prefix;
    }


    public static void printBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }


        Boolean flag = null;
        String space = "";
        printBinaryTree(treeNode, flag, space);

    }

    private static void printBinaryTree(TreeNode treeNode, Boolean flag, String space) {
        if (treeNode == null) {
            return;
        }

        String tempSpace = space;
        space = space + str + str;
        printBinaryTree(treeNode.right, true, space);

        if (flag == null) {
            System.out.println(tempSpace + "H" + treeNode.value + "H");
        } else {
            String prefix = Objects.equals(flag, Boolean.TRUE) ? "v" : "^";
            System.out.println(tempSpace + prefix + treeNode.value + prefix);

        }

        printBinaryTree(treeNode.left, false, space);
    }


//    public static void printTree(Node head) {
//        System.out.println("Binary Tree:");
//        printInOrder(head, 0, "H", 17);
//        System.out.println();
//    }
//

//        v11v
//                v10v
//                           ^9^
//       v8v
//                ^7^
//                        ^6^
//    H5H
//            v4v
//        ^3^
//                ^2^
//                ^1^

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(-222222222);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(Integer.MIN_VALUE);
        head.right.left = new TreeNode(55555555);
        head.right.right = new TreeNode(66);
        head.left.left.right = new TreeNode(777);
        printBinaryTree(head);
        System.out.println();
        System.out.println();
        System.out.println();
        head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.right.left = new TreeNode(5);
        head.right.right = new TreeNode(6);
        head.left.left.right = new TreeNode(7);
        printBinaryTree(head);

        System.out.println();
        System.out.println();
        System.out.println();

        head = new TreeNode(1);
        head.left = new TreeNode(1);
        head.right = new TreeNode(1);
        head.left.left = new TreeNode(1);
        head.right.left = new TreeNode(1);
        head.right.right = new TreeNode(1);
        head.left.left.right = new TreeNode(1);
        printBinaryTree(head);

    }





}