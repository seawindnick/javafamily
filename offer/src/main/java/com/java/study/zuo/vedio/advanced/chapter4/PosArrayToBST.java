package com.java.study.zuo.vedio.advanced.chapter4;

/**
 * <Description>
 *
 * @author hushiye
 * @since 2020-09-09 14:43
 */
public class PosArrayToBST {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static boolean checkIsBST(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return Boolean.TRUE;
        }

        return checkIsBST(arr, 0, arr.length - 1);

    }

    private static boolean checkIsBST(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return Boolean.TRUE;
        }

        int endValue = arr[endIndex];
        int leftIndex = startIndex - 1;
        int rightIndex = endIndex;

        //使用小于 跟节点的最后一个位置与大于跟节点的第一个元素位置进行比较，正常情况下， 两个元素相邻
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < endValue) {
                leftIndex = i;
            }
            if (arr[i] > endValue && rightIndex == endIndex) {
                rightIndex = i;
            }
        }

        if (leftIndex > rightIndex) {
            return Boolean.FALSE;
        }

        if (leftIndex == startIndex - 1 || rightIndex == endIndex) {
            return checkIsBST(arr, startIndex, endIndex - 1);
        }

        return checkIsBST(arr, startIndex, leftIndex) && checkIsBST(arr, rightIndex, endIndex - 1);

    }

    private static Node posArrayToBST(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        return rebuildTree(arr, 0, arr.length - 1);

    }

    private static Node rebuildTree(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        }

        int endValue = arr[endIndex];
        Node node = new Node(endValue);

        int lessRight = startIndex - 1;
        int moreLeft = endIndex;
        for (int i = startIndex; i < endIndex; i++) {
            if (arr[i] < endValue) {
                lessRight = i;
            }

            if (arr[i] > endValue && moreLeft == endIndex) {
                moreLeft = i;
            }
        }


        node.left = rebuildTree(arr, startIndex, lessRight);

        node.right = rebuildTree(arr, moreLeft, endIndex - 1);
        return node;
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


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 6, 5, 7, 4};
        System.out.println(checkIsBST(arr));
        printTree(posArrayToBST(arr));
    }


}
