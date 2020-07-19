package com.java.study.offer.tree;

import lombok.Data;

public class CheckBalanceTree {

    private static Boolean isBalance = Boolean.TRUE;


    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        treeNode.setValue(10);


        TreeNode leftNode = new TreeNode();
        leftNode.setValue(9);
        treeNode.setLeft(leftNode);


        TreeNode rightNode = new TreeNode();
        rightNode.setValue(8);
        treeNode.setRight(rightNode);


        TreeNode leftNode1 = new TreeNode();
        leftNode1.setValue(7);
        rightNode.setLeft(leftNode1);

        TreeNode rightNode1 = new TreeNode();
        rightNode1.setValue(6);
        leftNode1.setRight(rightNode1);

        Boolean deepLength = checkBalanceTree(treeNode);
        System.out.println(deepLength);
    }

    private static Boolean checkBalanceTree(TreeNode treeNode) {
        calculateTreeDeepLengthAndCheckIsBalance(treeNode);
        return isBalance;
    }

    private static int calculateTreeDeepLengthAndCheckIsBalance(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }

        int left = calculateTreeDeepLengthAndCheckIsBalance(treeNode.left);
        int right = calculateTreeDeepLengthAndCheckIsBalance(treeNode.right);

        if (Math.abs(left- right) > 1 ){
            isBalance = Boolean.FALSE;
        }

        return (left > right) ? (left + 1) : (right) + 1;
    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
