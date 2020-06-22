package com.java.study.offer.tree;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Objects;

public class RebuildTree2 {

    public static void main(String[] args) {
        int[] preArray = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inArray = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        Node node = rebuildNode(preArray, 0, preArray.length - 1, inArray, 0, inArray.length - 1);

        System.out.println(JSONObject.toJSONString(node));
    }

    /**
     * @param preArray      前序遍历结果
     * @param preStartIndex 重建二叉树前序遍历结果开始角标
     * @param preEndIndex   重建二叉树前序遍历结果结束角标
     * @param inArray       中序遍历结果
     * @param inStartIndex  重建二叉树中序遍历结果开始角标
     * @param inEndIndex    重建二叉树中序遍历结果结束角标
     * @return
     */
    private static Node rebuildNode(int[] preArray, int preStartIndex, int preEndIndex, int[] inArray, int inStartIndex, int inEndIndex) {
        if (Objects.isNull(preArray) || Objects.isNull(inArray) || preArray.length != inArray.length) {
            throw new RuntimeException("输入信息错误");
        }

        if (preStartIndex > preEndIndex) {
            return null;
        }

        int rootValue = preArray[preStartIndex];
        int rootAtInArrayIndex = inStartIndex;
        while (rootValue != inArray[rootAtInArrayIndex]) {
            rootAtInArrayIndex++;
        }

        if (rootValue != inArray[rootAtInArrayIndex]) {
            throw new RuntimeException("中序遍历结果没有查询到根节点");
        }

        Node node = new Node();
        node.setValue(rootValue);

        Node leftNode = rebuildNode(preArray, preStartIndex + 1, preStartIndex + (rootAtInArrayIndex - inStartIndex), inArray, inStartIndex, rootAtInArrayIndex - 1);
        Node rigthNode = rebuildNode(preArray, preStartIndex + (rootAtInArrayIndex - inStartIndex) + 1, preEndIndex, inArray, rootAtInArrayIndex + 1, inEndIndex);
        node.setLeft(leftNode);
        node.setRight(rigthNode);
        return node;
    }


    @Data
    private static class Node {
        private int value;
        private Node left;
        private Node right;
    }
}
