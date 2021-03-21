package com.java.study.zuo.vedio.advanced.chapter7;

import lombok.Data;

/**
 * <Description>
 * 给定一棵二叉树的头节点head，已知所有节点的值都不一样，求最大 的搜索二叉子树的节点数量。
 *
 * @author hushiye
 * @since 2020-09-24 19:37
 */
public class BiggestSubBSTInTree {


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    @Data
    public static class Result {
        private Node head;
        private int count;
        private int maxValue;
        private int minValue;

        public Result(Node head, int count, int maxValue, int minValue) {
            this.head = head;
            this.count = count;
            this.maxValue = maxValue;
            this.minValue = minValue;
        }
    }

    public static int biggestSubBSTInTree(Node node) {
        if (node == null) {
            return 0;
        }

        Result result = searchBiggestSubBSTInTree(node);
        return result.count;

    }

    private static Result searchBiggestSubBSTInTree(Node node) {
        if (node == null) {
            return new Result(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        int indexValue = node.value;

        Result left = searchBiggestSubBSTInTree(node.left);
        Result right = searchBiggestSubBSTInTree(node.right);

        int maxValue;
        int count;
        Node head;
        int minValue;

        //整体是搜树
        if (node.left == left.head && node.right == right.head && left.maxValue < indexValue && indexValue < right.minValue) {
            head = node;
            maxValue = Math.max(indexValue, Math.max(left.maxValue, right.maxValue));
            minValue = Math.min(indexValue, Math.min(left.minValue, right.minValue));
            count = 1 + left.count + right.count;
            return new Result(head, count, maxValue, minValue);
        }
        return left.count > right.count ? left : right;
    }

//
//    private static Result searchBiggestSubBSTInTree(Node node) {
//        if (node == null) {
//            return new Result(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        }
//
//        int indexValue = node.value;
//
//        Result leftResult = searchBiggestSubBSTInTree(node.left);
//        Result rightResult = searchBiggestSubBSTInTree(node.right);
//
//        int sizeContainsSlef = 0;
//        //整体是搜树
//        if (node.left == leftResult.head && node.right == rightResult.head && leftResult.maxValue < indexValue && indexValue < rightResult.minValue) {
//            sizeContainsSlef = leftResult.count + rightResult.count+1;
//        }
//
//        int leftSize = leftResult.count;
//        int rightSize = rightResult.count;
//        int count = Math.max(sizeContainsSlef,Math.max(leftSize,rightSize));
//
//        Node head = leftSize > rightSize ? leftResult.head : rightResult.head;
//        if (count == sizeContainsSlef){
//            head = node;
//        }
//        int maxValue = Math.max(indexValue,Math.max(leftResult.maxValue,rightResult.maxValue));
//        int minValue = Math.max(indexValue,Math.min(leftResult.maxValue,rightResult.maxValue));
//
//        return new Result(head,count,maxValue,minValue);
//
//    }


    public static Node posOrder(Node head, int[] record) {
        if (head == null) {
            record[0] = 0;
            record[1] = Integer.MAX_VALUE;
            record[2] = Integer.MIN_VALUE;
            return null;
        }
        int value = head.value;
        Node left = head.left;
        Node right = head.right;
        Node lBST = posOrder(left, record);
        int lSize = record[0];
        int lMin = record[1];
        int lMax = record[2];
        Node rBST = posOrder(right, record);
        int rSize = record[0];
        int rMin = record[1];
        int rMax = record[2];
        record[1] = Math.min(rMin, Math.min(lMin, value)); // lmin, value, rmin -> min
        record[2] = Math.max(lMax, Math.max(rMax, value)); // lmax, value, rmax -> max
        if (left == lBST && right == rBST && lMax < value && value < rMin) {
            record[0] = lSize + rSize + 1;
            return head;
        }
        record[0] = Math.max(lSize, rSize);
        return lSize > rSize ? lBST : rBST;
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


    public static Node biggestSubBST(Node head) {
        int[] record = new int[3]; // 0->size, 1->min, 2->max
        return posOrder(head, record);
    }




    public static void main(String[] args) {

        Node head = new Node(6);
        head.left = new Node(1);
        head.left.left = new Node(0);
        head.left.right = new Node(3);
        head.right = new Node(12);
        head.right.left = new Node(13);
        head.right.left.left = new Node(4);
        head.right.left.left.left = new Node(5);
        head.right.left.left.right = new Node(2);
        head.right.left.right = new Node(14);
        head.right.left.right.left = new Node(15);
        head.right.left.right.right = new Node(11);
        head.right.right = new Node(10);
        head.right.right.left = new Node(20);
        head.right.right.right = new Node(9);
        head.right.right.right.right = new Node(8);

        printTree(head);
        Node bst = biggestSubBST(head);
        printTree(bst);

        System.out.println(biggestSubBSTInTree(head));

    }
}
