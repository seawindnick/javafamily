package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Objects;

public class Traversal {

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

        System.out.println(JSONObject.toJSONString(treeNode));

        praversalPrint(treeNode);

    }

    private static void praversalPrint(TreeNode treeNode) {

        if (Objects.isNull(treeNode)){
            return;
        }

        if (Objects.nonNull(treeNode.left)){
            praversalPrint(treeNode.left);
        }

        if (Objects.nonNull(treeNode.right)){
            praversalPrint(treeNode.right);
        }
        System.out.println(treeNode.value);

    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
