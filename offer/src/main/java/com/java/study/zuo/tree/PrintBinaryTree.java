package com.java.study.zuo.tree;

public class PrintBinaryTree {


    public static void printBinaryTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        printBinaryTree(1, treeNode.getRight(), "vv");
        System.out.println("hh" + treeNode.getValue() + "hh");
        printBinaryTree(1, treeNode.left, "^^");
    }

    /**
     * 中序遍历
     *
     * @param level
     * @param treeNode
     */
    private static void printBinaryTree(int level, TreeNode treeNode, String suffix) {
        if (treeNode == null) {
            return;
        }

        printBinaryTree(level + 1, treeNode.getRight(), "vv");
        String prifix = buildPrifix(level);
        System.out.println(prifix + suffix + treeNode.getValue() + suffix);
        printBinaryTree(level + 1, treeNode.getLeft(), "^^");
    }

    private static String buildPrifix(int level) {
        String str = "                ";
        int i = 0;
        StringBuilder builder = new StringBuilder();
        while (i < level) {
            builder.append(str);
            i++;
        }
        return builder.toString();
    }


    public static void main(String[] args) {

        SuccessorNode.Node head = new SuccessorNode.Node(6);
        head.parent = null;
        head.left = new SuccessorNode.Node(3);
        head.left.parent = head;
        head.left.left = new SuccessorNode.Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new SuccessorNode.Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new SuccessorNode.Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new SuccessorNode.Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new SuccessorNode.Node(9);
        head.right.parent = head;
        head.right.left = new SuccessorNode.Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new SuccessorNode.Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new SuccessorNode.Node(10);
        head.right.right.parent = head.right;

//
//        TreeNode head = new TreeNode(1);
//        head.left = new TreeNode(-222222222);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(Integer.MIN_VALUE);
//        head.right.left = new TreeNode(55555555);
//        head.right.right = new TreeNode(66);
//        head.left.left.right = new TreeNode(777);
//        printBinaryTree(head);
//
//        head = new TreeNode(1);
//        head.left = new TreeNode(2);
//        head.right = new TreeNode(3);
//        head.left.left = new TreeNode(4);
//        head.right.left = new TreeNode(5);
//        head.right.right = new TreeNode(6);
//        head.left.left.right = new TreeNode(7);
//        printBinaryTree(head);
//
//        head = new TreeNode(1);
//        head.left = new TreeNode(1);
//        head.right = new TreeNode(1);
//        head.left.left = new TreeNode(1);
//        head.right.left = new TreeNode(1);
//        head.right.right = new TreeNode(1);
//        head.left.left.right = new TreeNode(1);
//        printBinaryTree(head);

    }

//    public static void main(String[] args) {
//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(3);
//        head.right = new TreeNode(8);
//        head.left.left = new TreeNode(2);
//        head.left.right = new TreeNode(4);
//        head.left.left.left = new TreeNode(1);
//        head.right.left = new TreeNode(7);
//        head.right.left.left = new TreeNode(6);
//        head.right.right = new TreeNode(10);
//        head.right.right.left = new TreeNode(9);
//        head.right.right.right = new TreeNode(11);
//        printBinaryTree(head);
//
//    }


}
