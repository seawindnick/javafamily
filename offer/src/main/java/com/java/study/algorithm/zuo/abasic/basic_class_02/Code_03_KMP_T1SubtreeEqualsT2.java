package com.java.study.algorithm.zuo.abasic.basic_class_02;

/**
 * 给定两个二叉树T1和T2，返回T1的某个子树结构是否与T2的结构相等。
 * 序列化，KMP
 */
public class Code_03_KMP_T1SubtreeEqualsT2 {


    public static boolean T1SubtreeEqualsT2(Node originNode, Node matchNode) {
        if (originNode == null && matchNode == null) {
            return true;
        }

        if (originNode == null || matchNode == null) {
            return false;
        }

        String originSerize = serizes(originNode);
        String matcSerize = serizes(matchNode);

        char[] originArray = originSerize.toCharArray();
        char[] matchArray = matcSerize.toCharArray();

        int[] next = getNext(matchArray);
        int originIndex = 0;
        int matchIndex = 0;

        while (originIndex < originArray.length && matchIndex < matchArray.length) {
            if (originArray[originIndex] == matchArray[matchIndex]) {
                originIndex++;
                matchIndex++;
            } else if (next[matchIndex] < 0) {
                originIndex++;
            } else {
                matchIndex = next[matchIndex];
            }
        }

        return matchIndex == matchArray.length;

    }

    private static int[] getNext(char[] matchArray) {
        if (matchArray.length == 1) {
            return new int[]{-1};
        }

        int[] next = new int[matchArray.length];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int pos = 2;
        while (pos < matchArray.length) {
            if (matchArray[pos - 1] == matchArray[cn]) {
                next[pos++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[pos++] = 0;
            }

        }
        return next;

    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }


    public static String serizes(Node node) {
        if (node == null) {
            return "#!";
        }

        String str = node.value + "!";
        String left = serizes(node.left);
        String right = serizes(node.right);

        return str + left + right;
    }

    public static void main(String[] args) {
        Node t1 = new Node(1);
        t1.left = new Node(2);
        t1.right = new Node(3);
        t1.left.left = new Node(4);
        t1.left.right = new Node(5);
        t1.right.left = new Node(6);
        t1.right.right = new Node(7);
        t1.left.left.right = new Node(8);
        t1.left.right.left = new Node(9);

        Node t2 = new Node(2);
        t2.left = new Node(4);
        t2.left.right = new Node(8);
        t2.right = new Node(5);
        t2.right.left = new Node(9);

        System.out.println(T1SubtreeEqualsT2(t1, t2));

    }
}