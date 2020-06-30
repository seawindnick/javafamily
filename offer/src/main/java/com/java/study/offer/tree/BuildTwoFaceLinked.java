package com.java.study.offer.tree;


import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.LinkedList;
import java.util.Objects;

/**
 * 根据树 构建双向链表
 */
public class BuildTwoFaceLinked {


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


        TreeNode newTreeNode = buildTwoFaceLinked(tenNode);
        while (newTreeNode != null){
            System.out.println(newTreeNode.value);
            newTreeNode = newTreeNode.right;
        }

    }

    private static TreeNode buildTwoFaceLinked(TreeNode treeNode) {
        TreeNode lastTreeNode = covertNode(treeNode,null);

        TreeNode heardTreeNode = lastTreeNode;
        while (heardTreeNode != null && heardTreeNode.left != null){
            heardTreeNode = heardTreeNode.left;
        }
        return heardTreeNode;

    }

    private static TreeNode covertNode(TreeNode treeNode, TreeNode lastTreeNode) {
        if (treeNode == null){
            return null;
        }

        TreeNode currentNode = treeNode;

        if (currentNode.left != null){
            lastTreeNode = covertNode(treeNode.left,lastTreeNode);
        }
        currentNode.left = lastTreeNode;

        if (lastTreeNode != null){
            lastTreeNode.right = currentNode;
        }

        lastTreeNode = currentNode;
        if (currentNode.right != null){
            lastTreeNode = covertNode(currentNode.right,lastTreeNode);
        }
        return lastTreeNode;
    }


//    private static TreeNode buildTwoFaceLinked(TreeNode treeNode) {
//
//        LinkedList<TreeNode> linkedList = new LinkedList();
//        buildLinkedList(treeNode, linkedList);
//
//
//        TreeNode newTreeNode = null;
//        TreeNode preNode = null;
//        for (TreeNode node : linkedList) {
//            if (newTreeNode == null) {
//                node.setLeft(null);
//                newTreeNode = node;
//                preNode = node;
//                continue;
//            } else {
//                preNode.setRight(node);
//                node.setLeft(preNode);
//                preNode = node;
//            }
//        }
//        return newTreeNode;
//    }
//
//    private static void buildLinkedList(TreeNode treeNode, LinkedList linkedList) {
//
//        if (Objects.isNull(treeNode)) {
//            return;
//        }
//        buildLinkedList(treeNode.left, linkedList);
//        linkedList.add(treeNode);
//        buildLinkedList(treeNode.right, linkedList);
//    }


    @Data
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

    }

}
