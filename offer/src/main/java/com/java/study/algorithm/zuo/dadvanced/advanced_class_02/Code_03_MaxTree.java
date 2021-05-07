package com.java.study.algorithm.zuo.dadvanced.advanced_class_02;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 定义二叉树节点如下:
 * public class Node {
 * public int value;
 * public Node left;
 * public Node right;
 * public Node(int data) {
 * this.value = data;
 * } }
 * 一个数组的MaxTree定义如下。 数组必须没有重复元素。
 * MaxTree是一棵二叉树，数组的每一个值对应一个二叉树节点。
 * 包括MaxTree树在内且在其中的每一棵子树上，值最大的节点都是树的头。
 * 给定一个没有重复元素的数组arr，写出生成这个数组的MaxTree的函数，
 * 要求如果数组长 度为N，则时间复杂度为O(N)、额外空间复杂度为O(N)。
 */
public class Code_03_MaxTree {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node MaxTree(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        //堆排序
        for (int i = 0; i < arr.length; i++) {
            heapfy(arr, i);
        }


        Node node = new Node(arr[0]);
        int curIndex = 0;
        Queue<Node> nodeList = new LinkedList<>();
        nodeList.add(node);

        while (2 * curIndex + 1 < arr.length) {
            Node tempNode = nodeList.poll();
            int leftIndex = 2 * curIndex + 1;
            Node leftNode = new Node(arr[leftIndex]);
            tempNode.left = leftNode;

            nodeList.add(leftNode);

            if (leftIndex + 1 < arr.length) {
                Node rightNode = new Node(arr[leftIndex + 1]);
                tempNode.right = rightNode;
                nodeList.add(rightNode);
            }

            curIndex++;

        }

        return node;
    }

    private static void heapfy(int[] arr, int index) {
        int parentIndex = (index - 1) / 2;
        while (index != 0) {
            if (arr[parentIndex] < arr[index]) {
                int temp = arr[parentIndex];
                arr[parentIndex] = arr[index];
                arr[index] = temp;

                index = parentIndex;
                parentIndex = (index - 1) / 2;

            } else {
                break;
            }
        }

    }

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printPreOrder(head.left);
        System.out.print(head.value + " ");
        printPreOrder(head.right);
    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Node head = MaxTree(arr);
        printPreOrder(head);
        System.out.println();
        printInOrder(head);
        System.out.println();
    }
}