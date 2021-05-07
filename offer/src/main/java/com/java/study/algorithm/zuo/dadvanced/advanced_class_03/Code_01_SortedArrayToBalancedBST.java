package com.java.study.algorithm.zuo.dadvanced.advanced_class_03;

/**
 * 通过有序数组生成平衡搜索二叉树
 * 【题目】 给定一个有序数组sortArr，已知其中没有重复值，用这个有序 数组生成一棵平衡搜索二叉树，并且该搜索二叉树中序遍历的 结果与sortArr一致。
 */
public class Code_01_SortedArrayToBalancedBST {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static Node sortedArrayToBalancedBST(int[] sortArr) {
        if (sortArr == null || sortArr.length == 0) {
            return null;
        }

        return buildNode(sortArr, 0, sortArr.length - 1);
    }

    private static Node buildNode(int[] sortArr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int midIndex = startIndex + (endIndex - startIndex) / 2;
        Node node = new Node(sortArr[midIndex]);
        Node left = buildNode(sortArr, startIndex, midIndex - 1);
        Node right = buildNode(sortArr, midIndex + 1, endIndex);

        node.left = left;
        node.right = right;

        return node;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7,8,9};
        Node node = sortedArrayToBalancedBST(arr);

        printTree(node);

        com.java.study.answer.zuo.dadvanced.advanced_class_03.Code_01_SortedArrayToBalancedBST.Node tempNode = com.java.study.answer.zuo.dadvanced.advanced_class_03.Code_01_SortedArrayToBalancedBST.generateTree(arr);
        com.java.study.answer.zuo.dadvanced.advanced_class_03.Code_01_SortedArrayToBalancedBST.printTree(tempNode);

    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
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


}