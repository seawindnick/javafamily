package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

public class MirrorTree {

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
        rightNode.setRight(rightNode1);


        System.out.println(JSONObject.toJSONString(treeNode));
        mirrorTree(treeNode);
        System.out.println(JSONObject.toJSONString(treeNode));


    }

    private static void mirrorTree(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }

        TreeNode leftNode = treeNode.left;
        treeNode.setLeft(treeNode.right);
        treeNode.setRight(leftNode);

        mirrorTree(treeNode.left);
        mirrorTree(treeNode.right);
    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }

}
