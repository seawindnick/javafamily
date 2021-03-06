package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.*;

public class PrintTree {

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

        printTree(treeNode);

    }

    private static void printTree(TreeNode treeNode) {
        if (Objects.isNull(treeNode)){
            return;
        }

        LinkedList<TreeNode> linkedList = new LinkedList();
        linkedList.add(treeNode);
        while (!linkedList.isEmpty()){
            TreeNode node = linkedList.pop();
            System.out.println(node.value);
            if (Objects.nonNull(node.left)){
                linkedList.add(node.left);
            }
            if (Objects.nonNull(node.right)){
                linkedList.add(node.right);
            }
        }
    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
