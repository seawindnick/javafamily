package com.java.study.algorithm.zuo.dadvanced.advanced_class_04;


import com.java.study.algorithm.zuo.dadvanced.TreeNode;

import java.util.TreeMap;

/**
 * 根据后序数组重建搜索二叉树
 * 【题目】 给定一个整型数组arr，已知其中没有重复值，
 * 判断arr是否可能是节 点值类型为整型的搜索二叉树后序遍历的结果。
 * <p>
 * 进阶:如果整型数组arr中没有重复值，且已知是一棵搜索二叉树的后 序遍历结果，通过数组arr重构二叉树。
 */
public class Code_03_PosArrayToBST {


    public static boolean checkSortTree(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }

        Integer indexValue = treeNode.value;

        if (treeNode.left != null && treeNode.left.value > indexValue) {
            return false;
        }

        if (treeNode.right != null && treeNode.right.value < indexValue) {
            return false;
        }

        return checkSortTree(treeNode.left) && checkSortTree(treeNode.right);
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
        int[] arr = {2, 1, 3, 6, 5, 7, 4};
        System.out.println(checkSortTree(arr, 0, arr.length - 1));

        printTree(rebuildTree(arr));
    }

    private static boolean checkSortTree(int[] arr, int start, int end) {
        if (start >= end || start < 0 || end >= arr.length - 1 || start >= arr.length - 1 || start == end) {
            return true;
        }

        int rootValue = arr[end];


        int index = 0;

        //找到第一个大于 rootValue 的位置，即右子树第一个节点
        while (index < end) {
            if (arr[index] > rootValue) {
                break;
            }
            index++;
        }

        for (int i = index; i < end; i++) {
            if (arr[i] < rootValue) {
                return false;
            }
        }

        return checkSortTree(arr, start, index - 1) && checkSortTree(arr, index, end - 1);

    }


    public static TreeNode rebuildTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        TreeNode treeNode = rebuildTree(arr, 0, arr.length - 1);
        return treeNode;

    }

    private static TreeNode rebuildTree(int[] arr, int start, int end) {
        if (start > end || start < 0 || start >= arr.length || end < 0 || end >= arr.length) {
            return null;
        }

        int rootValue = arr[end];

        int index = 0;

        //找到第一个大于 rootValue 的位置，即右子树第一个节点
        for (; index < end; index++) {
            if (arr[index] > rootValue) {
                break;
            }
        }

        TreeNode left = rebuildTree(arr, start, index - 1);
        TreeNode right = rebuildTree(arr, index, end - 1);

        TreeNode treeNode = new TreeNode(rootValue);
        treeNode.left = left;
        treeNode.right = right;
        return treeNode;
    }

}