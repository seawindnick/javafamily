package com.java.study.zuo.tree;

import lombok.Data;

/**
 * 判断一棵二叉树是否是平衡二叉树
 * <p>
 * 左右两个子树高度相差 <= 1
 * <p>
 * <p>
 * 递归，计算树的深度信息
 */
public class IsBalancedTree {

    public static Boolean isBalancedTree2(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }

        boolean[] result = new boolean[1];
        result[0] = true;
        int length = calculateDeep(treeNode, result);

        return result[0];
    }

    private static int calculateDeep(TreeNode treeNode, boolean[] result) {
        if (treeNode == null) {
            return 0;
        }


        int leftlength = calculateDeep(treeNode.left, result);
        if (!result[0]) {
            return leftlength;
        }

        int rightLength = calculateDeep(treeNode.getRight(), result);
        if (!result[0]) {
            return rightLength;
        }

        if (Math.abs(leftlength - rightLength) > 1) {
            result[0] = false;
        }

        return Math.max(leftlength, rightLength) + 1;


    }


    public static Boolean isBalancedTree(TreeNode treeNode) {
        if (treeNode == null) {
            return false;
        }

        Result result = checkIsBalancedTree(treeNode);
        return result.isBalance;
    }

    private static Result checkIsBalancedTree(TreeNode treeNode) {
        Result result = new Result();
        if (treeNode == null) {
            result.setIsBalance(true);
            result.setLength(0);
            return result;
        }

        Result leftResult = checkIsBalancedTree(treeNode.left);
        if (!leftResult.isBalance) {
            result.setIsBalance(false);
            result.setLength(0);
            return result;
        }

        Result rightResult = checkIsBalancedTree(treeNode.getRight());
        if (!rightResult.isBalance) {
            result.setIsBalance(false);
            result.setLength(0);
            return result;
        }

        if (Math.abs(leftResult.length - rightResult.length) > 1) {
            result.setIsBalance(false);
            result.setLength(0);
            return result;
        }
        result.setIsBalance(true);
        result.setLength(Math.max(leftResult.length, rightResult.length) + 1);
        return result;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.right = new TreeNode(8);
        head.right.right.right.right = new TreeNode(9);

        System.out.println(isBalancedTree2(head));

    }


    @Data
    public static class Result {
        private Boolean isBalance;
        private int length;

    }

}
