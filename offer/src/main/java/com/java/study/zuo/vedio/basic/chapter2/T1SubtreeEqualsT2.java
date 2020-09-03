package com.java.study.zuo.vedio.basic.chapter2;

import lombok.Data;

/**
 * <Description>
 * 判断一个树是否是另外一棵树的子树
 * 使用序列化，值前后使用特殊字符进行标记
 *
 * @author hushiye
 * @since 2020-08-19 09:03
 */
public class T1SubtreeEqualsT2 {


    public static Boolean checkT1SubtreeEqualsT2(Node node1, Node node2) {
        if (node1 == null || node2 == null) {
            return Boolean.FALSE;
        }


        String node1Serializ = getNode1Serializ(node1);
        String node2Serializ = getNode1Serializ(node2);
        int[] node2Next = getNext(node2Serializ);

        int firstIndex = 0;
        int secondIndex = 0;
        while (firstIndex < node1Serializ.length() && secondIndex < node2Serializ.length()){
            if (node1Serializ.charAt(firstIndex) == node2Serializ.charAt(secondIndex)){
                firstIndex++;
                secondIndex++;
            }else{
                secondIndex = node2Next[secondIndex];
                if (secondIndex == -1){
                    secondIndex = 0;
                    firstIndex++;
                }
            }
        }

        return secondIndex == node2Serializ.length();
    }

    private static int[] getNext(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }

        int[] next = new int[str.length()];
        next[0] = -1;
        next[1] = 0;

        int curIndex = 2;
        int cn = 0;
        while (curIndex < str.length()) {
            if (str.charAt(curIndex - 1) == str.charAt(cn)) {
                next[curIndex++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[curIndex++] = 0;
            }
        }
        return next;

    }

    private static String getNode1Serializ(Node node) {
        if (node == null) {
            return "#!";
        }

        /**
         *
         *    如果value前后不添加特殊字符会存在
         *    12           2
         *   /  \    与   / \ 一致的情况
         *  4    5       4  5
         *
         *
         */
        String value = "$"+node.value + "$!";
        String left = getNode1Serializ(node.left);
        String right = getNode1Serializ(node.right);
        return value + left + right;
    }


    @Data
    private static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
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

        System.out.println(checkT1SubtreeEqualsT2(t1, t2));

    }
}
