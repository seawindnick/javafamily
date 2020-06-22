package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Objects;

public class FindTree {

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


        TreeNode treeNode2 = new TreeNode();
        treeNode2.setValue(8);


        TreeNode leftNode3 = new TreeNode();
        leftNode3.setValue(7);
        treeNode2.setLeft(leftNode3);


        TreeNode rightNode3 = new TreeNode();
        rightNode3.setValue(16);
        treeNode2.setRight(rightNode3);


        System.out.println(JSONObject.toJSONString(treeNode));
        System.out.println(JSONObject.toJSONString(treeNode2));

        Boolean find = findTree(treeNode,treeNode2);
        System.out.println(find);
    }

    private static Boolean findTree(TreeNode oriTreeNode, TreeNode checkTreeNode) {
        if (Objects.isNull(oriTreeNode) || Objects.isNull(checkTreeNode)){
            return Boolean.FALSE;
        }

        Boolean result = Boolean.FALSE;
        if (oriTreeNode.value == checkTreeNode.value){
            result = doesTreeHasTree2(oriTreeNode,checkTreeNode);
        }
        if (!result){
            result = findTree(oriTreeNode.left,checkTreeNode);
        }
        
        if (!result){
            result =findTree(oriTreeNode.right,checkTreeNode);
        }
        return result;

    }

    private static Boolean doesTreeHasTree2(TreeNode oriTreeNode, TreeNode checkTreeNode) {
        if (checkTreeNode == null){
            return Boolean.TRUE;
        }

        if (oriTreeNode == null){
            return Boolean.FALSE;
        }

        if (oriTreeNode.value != checkTreeNode.value){
            return Boolean.FALSE;
        }

        return doesTreeHasTree2(oriTreeNode.left,checkTreeNode.left)
                && doesTreeHasTree2(oriTreeNode.right,checkTreeNode.right);
    }


    @Data
    public static class TreeNode{
        private int value;
        private TreeNode left;
        private TreeNode right;
    }
}
