package com.java.study.offer.tree;

import lombok.Data;

public class TreeDepth {


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

        TreeNode leftNode2 = new TreeNode();
        leftNode2.setValue(5);
        leftNode1.setLeft(leftNode2);


        TreeNode rightNode1 = new TreeNode();
        rightNode1.setValue(6);
        rightNode.setRight(rightNode1);

        int deepLength = calculateTreeDeepLength(treeNode);
        System.out.println(deepLength);
    }

    private static int calculateTreeDeepLength(TreeNode treeNode) {
        if (treeNode == null){
            return 0;
        }

        int left = calculateTreeDeepLength(treeNode.left);
        int right = calculateTreeDeepLength(treeNode.right);
        return (left > right) ? (left + 1) : (right) + 1;

    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
