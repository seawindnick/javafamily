package com.java.study.zuo.vedio.advanced.chapter7;

import lombok.Data;

/**
 * <Description>
 * 给定一棵二叉树的头节点head，判断该树是否是平衡二叉树
 *
 * @author hushiye
 * @since 2020-09-24 19:28
 */
public class IsBalancedTree {

    @Data
    public static class Result {
        private int level;
        private Boolean balance;

        public Result(int level, Boolean balance) {
            this.level = level;
            this.balance = balance;
        }
    }


    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Boolean checkBalancedTree(Node headNode) {
        if (headNode == null) {
            return true;
        }

        Result result = checkBalancedTree(headNode, 1);
        return result.balance;

    }

    private static Result checkBalancedTree(Node node, int level) {
        if (node == null) {
            return new Result(level + 1, true);
        }

        Result left = checkBalancedTree(node.left, level + 1);
        Result right = checkBalancedTree(node.right, level + 1);

        int maxLevel = Math.max(left.level, right.level);
        int different = Math.abs(left.level - right.level);
        boolean balance = left.balance && right.balance && (different <= 1);

        return new Result(maxLevel, balance);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.right = new Node(8);

        System.out.println(checkBalancedTree(head));

    }


}
