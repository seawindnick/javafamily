package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONArray;
import lombok.Data;

import java.util.Objects;
import java.util.Stack;

public class FindTreeSum {


    public static void main(String[] args) {

        TreeNode tenNode = new TreeNode();
        tenNode.setValue(10);


        TreeNode fiveNode = new TreeNode();
        fiveNode.setValue(5);

        TreeNode fourNode = new TreeNode();
        fourNode.setValue(4);

        TreeNode sevenNode = new TreeNode();
        sevenNode.setValue(7);

        TreeNode node_12 = new TreeNode();
        node_12.setValue(12);

        tenNode.setLeft(fiveNode);
        tenNode.setRight(node_12);

        fiveNode.setLeft(fourNode);
        fiveNode.setRight(sevenNode);


        int targetValue = 22;
        int indexTotal = 0;
        Stack<Integer> stack = new Stack();
        calculate(tenNode, targetValue, indexTotal, stack);
    }

    private static void calculate(TreeNode treeNode, int targetValue, int indexTotal, Stack<Integer> stack) {

        if (treeNode == null) {
            return;
        }

        stack.push(treeNode.value);
        indexTotal = indexTotal + treeNode.value;
        try {

            Boolean isLeaf = treeNode.left == null && treeNode.right == null;
            if (isLeaf && indexTotal == targetValue) {
                System.out.println(JSONArray.toJSONString(stack));
                return;
            }

            if (indexTotal > targetValue) {
                return;
            }

            if (Objects.nonNull(treeNode.left)) {
                calculate(treeNode.left, targetValue, indexTotal, stack);
            }
            if (Objects.nonNull(treeNode.right)) {
                calculate(treeNode.right, targetValue, indexTotal, stack);
            }

        } finally {
            stack.pop();
        }
    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }

}
